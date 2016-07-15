package io.bace.http;

import io.bace.core.Bace;
import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;
import io.vertx.ext.web.RoutingContext;

import java.lang.reflect.Constructor;
import java.util.Map;

/**
 * url mappings
 */
public class HttpRouter {

    private HttpRequest request;
    private HttpResponse response;
    private Map<String, Object> params;
    private RoutingContext routingContext;

    public void get(String path, HttpReqResHandler handler) {

    }

    public static void register(Class<HttpRouter> httpRouteHandlerClass) throws Exception {
        Constructor<HttpRouter> constructor = httpRouteHandlerClass.getConstructor();
        Bace.routeFactory().register(vertxRouter, constructor.newInstance());
    }
}
