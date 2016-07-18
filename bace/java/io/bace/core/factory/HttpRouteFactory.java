package io.bace.core.factory;

import io.bace.http.HttpRouter;

import java.util.HashMap;
import java.util.Map;

public class HttpRouteFactory {

    private static Map<Class<? extends HttpRouter>, HttpRouter> mapOfHttpRouters = new HashMap<>();

    public HttpRouter register(Class<? extends HttpRouter> httpRouterClass) {
        HttpRouter httpRouter = null;
        try {
            httpRouter = httpRouterClass.newInstance();
        } catch(Exception e) {
            //TODO:
        }
        mapOfHttpRouters.put(httpRouterClass, httpRouter);
        return httpRouter;
    }

    public HttpRouter instanceOf(Class<? extends HttpRouter> httpRouterClass) {
        return mapOfHttpRouters.get(httpRouterClass);
    }

}
