package io.bace.core.factory;

import io.bace.http.HttpRouter;
import io.vertx.ext.web.Router;

import java.lang.reflect.Constructor;
import java.util.ArrayList;
import java.util.List;

public class HttpRouteFactory {

    private static List<HttpRouter> httpRouterList = new ArrayList<>();

    public List<HttpRouter> register(Router vertxRouter, Class<? extends HttpRouter> httpRouterClass) {
        httpRouterList.add(createHttpRouter(httpRouterClass));
        return httpRouterList;
    }

    public HttpRouter createHttpRouter(Class<? extends HttpRouter> httpRouterClass) {
        HttpRouter httpRouter = null;
        try {
            Constructor<?> constructor = httpRouterClass.getConstructor();
            httpRouter = (HttpRouter)constructor.newInstance();
        } catch(Exception e) {
            //TODO:
        }
        return httpRouter;
    }

}
