package io.bace.http;

import io.vertx.core.Vertx;
import io.vertx.core.http.HttpServerResponse;
import io.vertx.ext.web.Router;

public class HttpServer {

    private io.vertx.core.http.HttpServer vertxHttpServer;

    private HttpServer(Vertx vertx, Router router, int port) {
        vertxHttpServer = vertx.createHttpServer();
        vertxHttpServer.requestHandler(request -> {
            HttpServerResponse response = request.response();
            response.putHeader("content-type", "text/plain");
            response.end("Hello World!");
        });
        vertxHttpServer.requestHandler(router::accept).listen(port);
    }

    public static HttpServer start(Vertx vertx, Router router, Integer port) {
        HttpServer server = new HttpServer(vertx, router, port == null ? 8080 : port);
        return server;
    }

    public io.vertx.core.http.HttpServer getVertxHttpServer() {
        return vertxHttpServer;
    }
}
