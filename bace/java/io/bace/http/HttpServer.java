package io.bace.http;

import io.vertx.core.AbstractVerticle;
import io.vertx.core.http.HttpServerResponse;
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
        //doroute();
    }

    private void doroute() {
        vertxRouter.route().handler(routingContext -> {

            // This handler will be called for every request
            HttpServerResponse response = routingContext.response();
            response.putHeader("content-type", "text/plain");

            // Write to the response and end it
            response.end("Hello World from Vert.x-!");
        });
    }

    public io.vertx.core.http.HttpServer getVertxHttpServer() {
        return vertxHttpServer;
    }

    public Router router() {
        return vertxRouter;
    }
}
