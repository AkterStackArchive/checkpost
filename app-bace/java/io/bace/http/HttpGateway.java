package io.bace.http;

import io.vertx.ext.web.Router;

/** most like concept of interceptor */
public abstract class HttpGateway {

    private Router router = Router.router();

}
