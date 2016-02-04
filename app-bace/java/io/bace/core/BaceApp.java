package io.bace.core;

import io.bace.http.HttpRouter;
import io.bace.http.HttpServer;
import io.vertx.core.AbstractVerticle;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

public class BaceApp extends AbstractVerticle {

    private Vertx baceVertx;
    private Class appClazz;
    private HttpServer httpServer;
    private HttpRouter httpRouter;

    private BaceApp(Class appClazz) {
        this.baceVertx = vertx;
        this.appClazz = appClazz;
        this.httpRouter = Router.router(vertx);
        this.httpServer = HttpServer.start(baceVertx, 8080);
    }

    public static BaceApp run(Class appClazz, String... args) {
        return new BaceApp(appClazz);
    }

}
