const gulp = require('gulp'),
    gutil = require('gulp-util'),
    cheerio = require('cheerio'),
    fs = require('fs'),
    path = require('path'),
    through2 = require('through2');

var htmlElements = ["a", "abbr", "acronym", "address", "applet", "area", "article", "aside", "audio", "b", "base", "basefont", "bdi", "bdo", "bgsound", "big", "blink", "blockquote", "body", "br", "button", "canvas", "caption", "center", "cite", "code", "col", "colgroup", "content", "data", "datalist", "dd", "decorator", "del", "details", "dfn", "dir", "div", "dl", "dt", "em", "embed", "fieldset", "figcaption", "figure", "font", "footer", "form", "frame", "frameset", "h1", "h2", "h3", "h4", "h5", "h6", "head", "header", "hgroup", "hr", "html", "i", "iframe", "img", "input", "ins", "isindex", "kbd", "keygen", "label", "legend", "li", "link", "listing", "main", "map", "mark", "marquee", "menu", "menuitem", "meta", "meter", "nav", "nobr", "noframes", "noscript", "object", "ol", "optgroup", "option", "output", "p", "param", "plaintext", "pre", "progress", "q", "rp", "rt", "ruby", "s", "samp", "script", "section", "select", "shadow", "small", "source", "spacer", "span", "strike", "strong", "style", "sub", "summary", "sup", "table", "tbody", "td", "template", "textarea", "tfoot", "th", "thead", "time", "title", "tr", "track", "tt", "u", "ul", "var", "video", "wbr", "xmp"],
    genv = gutil['env'],
    mapfile = 'elements.map.json',
    dir = {
        src: 'src/templates',
        lib: 'bower_components',
        bower_components: 'bower_components',
        build: 'build/polymer',
        dest: '../src/main/webapp/template'
    };

var map = function(handler) {
    var mapping = {},
        bufferStream = function(file, enc, next) {
            /** ignore directory & empty file */
            if(file.isNull()) {
                next();
                return;
            }
            /** streams not supported yet */
            if(file.isStream()) {
                this.emit('error', new gutil.PluginError('gulp-polymer', 'Streaming not supported'));
                next();
                return;
            }
            var $ = cheerio.load(file.contents.toString());
            $('dom-module').each(function(idx, dom) {
                if($(dom).attr('id')) {
                    mapping[$(dom).attr('id')] = typeof handler == 'function' ? handler($(dom).attr('id'), file.path, file) : file.path;
                }
            });
            next();
        },
        endStream = function(next) {
            this.push(new gutil.File({
                path: mapfile,
                contents: new Buffer(JSON.stringify(mapping))
            }));
            next();
        };
    return through2.obj(bufferStream, endStream);
};

var fun = function(mapping, file, next, handler) {
    var self = this,
        $ = cheerio.load(file.contents.toString()),
        parse = function(children, toImport) {
            for(var idx in children) {
                var child = children[idx];
                if(child.type == 'tag'
                    && toImport.indexOf(child.name) == -1) {
                    if(htmlElements.indexOf(child.name.toLowerCase()) == -1)
                        toImport.push(child.name);
                    parse(child.children, toImport)
                }
            }
        };
    $('dom-module').each(function(idx, domModule) {
        var toImport = [];

        $(domModule).find('template').each(function(idx, template) {
            parse(template.children, toImport);
        });

        for(var idx in toImport) {
            var elem = toImport[idx],
                href = mapping[elem];

            if(!href) {
                var log = 'Element not found for <' + elem + '> in ' + file.path;
                gutil.log(gutil.colors.cyan('gulp-polymer:'), gutil.colors.red(log));
                gutil.beep();
                $(domModule).before('<!--<link rel="import" href="' + log + '">-->\n')
            } else {
                href = typeof handler == 'function' ? handler(elem, href) : href;
                $(domModule).before('<link rel="import" href="' + href + '">\n')
            }
        }
        var pushFile = new gutil.File(file);
        pushFile.contents = new Buffer($.html());
        self.push(pushFile);
    });
    next();
};

var imports = function(handler) {
    var mapping,
        bufferStream = function(file, enc, next) {
            /** ignore directory & empty file */
            if(file.isNull()) {
                next();
                return;
            }
            /** streams not supported yet */
            if(file.isStream()) {
                this.emit('error', new gutil.PluginError('gulp-polymer', 'Streaming not supported'));
                next();
                return;
            }

            var self = this;
            if(mapping) {
                fun.call(self, mapping, file, next, handler);
            } else {
                fs.readFile(path.resolve(dir.build, mapfile), function(err, buffer) {
                    mapping = JSON.parse(buffer.toString());
                    fun.call(self, mapping, file, next, handler);
                });
            }
        };
    return through2.obj(bufferStream);
};

gulp.task('polymer.map', function() {
    return gulp.src([dir.bower_components + '/**', dir.src + '/**'])
        .pipe(map(function(elem, path) {
            return path.replace(/\\/g, '/');
        }))
        .pipe(gulp.dest(dir.build));
});

gulp.task('polymer.import', function() {
    return gulp.src([dir.src + '/**'])
        .pipe(imports(function(elem, href) {
            if(href.indexOf(dir.src) != -1) {
                return href.substr(href.indexOf(dir.src) + dir.src.length)
                    .replace(/^/, '/template');
            } else if(href.indexOf(dir.bower_components) != -1) {
                return href.substr(href.indexOf(dir.bower_components) + dir.bower_components.length)
                    .replace(/^/, '/lib');
            }
        }))
        .pipe(gulp.dest(dir.dest));
});

module.exports.map = map;
module.exports.imports = imports;