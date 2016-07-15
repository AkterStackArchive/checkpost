package io.bace.core.factory;

import io.bace.http.HttpRouter;
import io.vertx.ext.web.Router;

import java.util.ArrayList;
import java.util.List;

public class HttpRouteFactory {

    private static List<HttpRouter> httpRouterList = new ArrayList<>();

    public List<HttpRouter> register(Router vertxRouter, HttpRouter httpRouter) {
        return httpRouterList;
    }

}
