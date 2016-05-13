package io.bace.http;

import io.netty.handler.codec.http.HttpRequest;
import io.netty.handler.codec.http.HttpResponse;
import io.vertx.ext.web.RoutingContext;

import java.util.Map;

/** similar of controller layer */
public abstract class HttpRouteHandler {

    private HttpRequest request;
    private HttpResponse response;
    private Map<String, Object> params;
    private RoutingContext routingContext;

}
