package io.bace.core;

import io.bace.core.factory.HttpRouteFactory;
import io.bace.http.HttpServer;

public class Bace {

    private static final Integer DEFAULT_HTTP_PORT = 7007;

    private static Class<? extends BaceApp> baceAppClass;
    private static HttpRouteFactory httpRouteFactory;
    private static BaceApp app;

    public static void initialize(Class<? extends BaceApp> _baceAppClass, String[] args) {
        baceAppClass = _baceAppClass;
        httpRouteFactory = new HttpRouteFactory();

        try {
            app = baceAppClass.newInstance();
        } catch(InstantiationException e) {
            //TODO
        } catch(IllegalAccessException e) {
            //TODO
        }

        app.httpServer(new HttpServer(DEFAULT_HTTP_PORT)); //TODO: default port should be modifiable

    }

    public static BaceApp app() {
        return app;
    }

    public static HttpRouteFactory routeFactory() {
        return httpRouteFactory;
    }

}
