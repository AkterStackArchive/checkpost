package io.bace.core;

import io.bace.http.HttpServer;
import io.vertx.core.AbstractVerticle;

import java.lang.reflect.Constructor;

public abstract class BaceApp extends AbstractVerticle {

    private static final Integer DEFAULT_HTTP_PORT = 7007;

    private Class<BaceApp> appClazz;
    private HttpServer httpServer;

    @Override
    public void start() {
        httpServer = new HttpServer(vertx);
    }

    @Override
    public void stop() {

    }

    public static void run(Class baceAppClass, String[] args) throws Exception {
        Constructor<BaceApp> appConstructor = baceAppClass.getConstructor();
        BaceApp baceApp = appConstructor.newInstance();
        baceApp.httpServer.start(DEFAULT_HTTP_PORT); //TODO: resolve port from external
    }

}
