package io.bace.core;

import io.bace.http.HttpRouter;
import io.bace.http.HttpServer;
import io.vertx.core.AbstractVerticle;

public abstract class BaceApp extends AbstractVerticle {

    private static final Integer DEFAULT_HTTP_PORT = 7007;

    private Class appClazz;
    private HttpServer httpServer;
    private HttpRouter httpRouter;

    public BaceApp(){}

    public BaceApp(Class appClazz) {
        this.appClazz = appClazz;
    }

    public static void run(Class baceAppClass, String[] args) {

    }

    @Override
    public void start() {
        httpRouter = HttpRouter.instance(vertx);
        httpServer = HttpServer.start(vertx, httpRouter, DEFAULT_HTTP_PORT);
    }

    @Override
    public void stop() {

    }

}
