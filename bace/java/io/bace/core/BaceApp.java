package io.bace.core;

import io.bace.http.HttpServer;
import io.vertx.core.AbstractVerticle;

import java.lang.reflect.Constructor;

public abstract class BaceApp extends AbstractVerticle {

    private static final Integer DEFAULT_HTTP_PORT = 7007;

    private static Class<? extends BaceApp> baceAppClass;
    private static BaceApp baceApp;

    private HttpServer httpServer;

    @Override
    public void start() {
        httpServer = new HttpServer(vertx);
    }

    @Override
    public void stop() {

    }

    public static void run(Class<? extends BaceApp> _baceAppClass, String[] args) throws Exception {
        baceAppClass = _baceAppClass;
        Constructor<? extends BaceApp> appConstructor = baceAppClass.getConstructor();
        baceApp = appConstructor.newInstance();
        baceApp.httpServer.start(DEFAULT_HTTP_PORT); //TODO: resolve port from external
    }

}
