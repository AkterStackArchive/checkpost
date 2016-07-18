package io.bace.core;

import io.bace.core.factory.HttpRouteFactory;

import java.util.HashMap;
import java.util.Map;

public class Bace {

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

    }

    public static BaceApp app() {
        return app;
    }

    public static HttpRouteFactory routeFactory() {
        return httpRouteFactory;
    }

}
