package io.bace.http;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class HttpServer {

    private static Vertx vertx;
    private static io.vertx.core.http.HttpServer vertxHttpServer;
    private static Router vertxRouter;

    public HttpServer(Vertx _vertx) {
        vertx = _vertx;
        vertxRouter = Router.router(vertx);
        vertxHttpServer = vertx.createHttpServer();
        vertxHttpServer.requestHandler(vertxRouter::accept);

    }

    public HttpServer start(Integer port) {
        HttpServer server = new HttpServer(vertx);
        vertxHttpServer.listen(port);
        return server;
    }

    public io.vertx.core.http.HttpServer getVertxHttpServer() {
        return vertxHttpServer;
    }


    public Router vertxRouter() {
        return vertxRouter;
    }
}
