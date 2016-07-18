package io.bace.http;

import io.vertx.core.http.HttpServerRequest;
import io.vertx.core.http.HttpServerResponse;

public interface HttpReqResHandler extends HttpRouteHandler {

    void handle(HttpServerRequest req, HttpServerResponse res);

}
