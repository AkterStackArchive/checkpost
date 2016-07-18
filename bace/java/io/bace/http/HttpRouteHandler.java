package io.bace.http;

import io.vertx.ext.web.RoutingContext;

public interface HttpRouteHandler {

    void handle(RoutingContext rctx);

}
