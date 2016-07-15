package io.bace.core;

import io.bace.core.factory.HttpRouteFactory;

public class Bace {

    private static HttpRouteFactory httpRouteFactory;

    public static HttpRouteFactory routeFactory() {
        if(httpRouteFactory == null)
            new HttpRouteFactory();
        return httpRouteFactory;
    }

}
