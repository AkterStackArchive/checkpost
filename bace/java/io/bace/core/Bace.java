package io.bace.core;

import io.bace.core.factory.HttpRouteFactory;

import java.lang.reflect.Constructor;
import java.util.HashMap;
import java.util.Map;

public class Bace {

    private static HttpRouteFactory httpRouteFactory;
    private static Map<Class<? extends BaceApp>, BaceApp> baceAppCache = new HashMap<>();

    public static void createBaceApp(Class<? extends BaceApp> baceAppClass) {
        try {
            Constructor<? extends BaceApp> appConstructor = baceAppClass.getConstructor();
            BaceApp baceApp = appConstructor.newInstance();
            baceAppCache.put(baceAppClass, baceApp);
        } catch(Exception e) {
            //TODO handle exception
        }
    }

    public static HttpRouteFactory routeFactory() {
        if(httpRouteFactory == null)
            new HttpRouteFactory();
        return httpRouteFactory;
    }

}
