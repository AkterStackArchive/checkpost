package io.bace.core;

import io.bace.http.HttpRouter;
import io.bace.http.HttpServer;
import io.vertx.core.AbstractVerticle;

public abstract class BaceApp extends AbstractVerticle {

    private Class appClazz;
    private HttpServer httpServer;
    private HttpRouter httpRouter;

    public BaceApp() {

    }

    public BaceApp(Class appClazz) {
        this.appClazz = appClazz;
        this.httpRouter = HttpRouter.instance(vertx);
        this.httpServer = HttpServer.start(vertx, httpRouter, 8080);
    }

}
