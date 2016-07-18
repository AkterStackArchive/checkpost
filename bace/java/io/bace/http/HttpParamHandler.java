package io.bace.http;

import io.bace.core.HttpRequestParam;

public interface HttpParamHandler extends HttpRouteHandler {

    void handle(HttpRequestParam param);

}
