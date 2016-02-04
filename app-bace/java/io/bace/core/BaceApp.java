package io.bace.core;

import io.bace.http.HttpRouter;
import io.bace.http.HttpServer;
import io.vertx.core.AbstractVerticle;

public abstract class BaceApp extends AbstractVerticle {

    private Class appClazz;
    private HttpServer httpServer;
    private HttpRouter httpRouter;

    public BaceApp(){}

    public BaceApp(Class appClazz) {
        this.appClazz = appClazz;
    }

    @Override
    public void start() {
        httpRouter = HttpRouter.instance(vertx);
        httpServer = HttpServer.start(vertx, httpRouter, 8080);
    }

    @Override
    public void stop() {

    }

}
