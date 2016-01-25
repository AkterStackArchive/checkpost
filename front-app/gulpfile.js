var gulp = require('gulp'),
    gutil = require('gulp-util'),
    watch = require('gulp-watch'),
    polymer = require('./gulp-polymer.js');

var src = 'src',
    dest = '../src/main/webapp',
    bower_components = 'bower_components',
    dir = {
        script: src + '/scripts',
        style: src + '/styles',
        templates: src + '/templates',
        css: dest + '/css',
        js: dest + '/js',
        lib: dest + '/lib',
        template: dest + '/template'
    };

gulp.task('sync-styles', function() {
    gulp.src(dir.style + '/**')
        .pipe(watch(dir.style + '/**'))
        .pipe(gulp.dest(dir.css));
});

gulp.task('sync-scripts', function() {
    gulp.src(dir.script + '/**')
        .pipe(watch(dir.script + '/**'))
        .pipe(gulp.dest(dir.js));
});

gulp.task('sync-lib', function() {
    gulp.src('bower_components/**')
        .pipe(watch('bower_components/**'))
        .pipe(gulp.dest(dir.lib));
});

gulp.task('sync-templates', function() {
    var dir2path = function(elem, href) {
        if(href.indexOf(dir.templates) != -1) {
            return href.substr(href.indexOf(dir.templates) + dir.templates.length)
                .replace(/^/, '/template');
        } else if(href.indexOf(bower_components) != -1) {
            return href.substr(href.indexOf(bower_components) + bower_components.length)
                .replace(/^/, '/lib');
        }
    };

    var watcher = watch(dir.templates + '/**')
        .on('change', function(filepath, filestat) {
            gutil.log(gutil.colors.cyan('syncing...'), gutil.colors.green(filepath));
            gulp.src(filepath)
                .pipe(polymer.imports(dir2path))
                .pipe(gulp.dest(dir.template));
        });
    gulp.src(dir.templates + '/**')
        .pipe(watcher)
        .pipe(polymer.imports(dir2path))
        .pipe(gulp.dest(dir.template));
});

gulp.task('default', ['sync-scripts', 'sync-styles', 'sync-templates', 'sync-lib']);