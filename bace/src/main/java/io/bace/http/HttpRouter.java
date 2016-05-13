package io.bace.http;

import io.vertx.core.Vertx;
import io.vertx.ext.web.Router;

/**
 * url mappings
 */
public class HttpRouter {

    private static HttpRouter self;
    private Router vertxRouter;

    private HttpRouter(Vertx vertx) {
        vertxRouter = Router.router(vertx);
    }

    public Router vertexRouter() {
        return vertxRouter;
    }

    public static HttpRouter instance(Vertx vertx) {
        if(self == null) {
            self = new HttpRouter(vertx);
        }
        return self;
    }
}
