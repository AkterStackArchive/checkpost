package io.bace.http;

import io.vertx.core.AbstractVerticle;
import io.vertx.ext.web.Router;

public class HttpServer extends AbstractVerticle {

    private Integer port;
    private Router vertxRouter;
    private io.vertx.core.http.HttpServer vertxHttpServer;

    public HttpServer(Integer port) {
        this.port = port;
    }

    @Override
    public void start() {
        vertxHttpServer = vertx.createHttpServer();
        vertxRouter = Router.router(vertx);
        vertxHttpServer.requestHandler(vertxRouter::accept);
        vertxHttpServer.listen(port);
    }

    public io.vertx.core.http.HttpServer getVertxHttpServer() {
        return vertxHttpServer;
    }

    public Router router() {
        return vertxRouter;
    }
}
