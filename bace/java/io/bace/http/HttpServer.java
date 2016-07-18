package io.bace.http;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;

public class HttpServer extends AbstractVerticle {

    private Integer port;
    private Router vertxRouter;
    private io.vertx.core.http.HttpServer self;

    public HttpServer(Integer port) {
        this.port = port;
    }

    @Override
    public void start() {
        self = vertx.createHttpServer();
        vertxRouter = Router.router(vertx);
        self.requestHandler(vertxRouter::accept);
        self.listen(port);
    }

    public io.vertx.core.http.HttpServer getVertxHttpServer() {
        return self;
    }

    public Router vertxRouter() {
        return vertxRouter;
    }
}
