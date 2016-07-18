package io.bace.core;

import io.bace.http.HttpServer;
import io.vertx.core.AbstractVerticle;

public abstract class BaceApp extends AbstractVerticle {

    private static final Integer DEFAULT_HTTP_PORT = 7007;

    private HttpServer httpServer;

    @Override
    public void start() {
        httpServer = new HttpServer(vertx);
    }

    @Override
    public void stop() {

    }

    public static void run(Class<? extends BaceApp> _baceAppClass, String[] args) throws Exception {
        Bace.initialize(_baceAppClass, args);
        Bace.app().httpServer.start(DEFAULT_HTTP_PORT); //TODO: resolve port from external
    }

}
