package io.checkpost.http;

import io.bace.http.HttpRouter;
import io.bace.http.context.HttpParamContext;
import io.bace.http.handler.HttpParamHandler;
import io.bace.http.handler.HttpRoutingContextHandler;
import io.vertx.ext.web.RoutingContext;

import java.util.Map;

public class AuthenticationRouter extends HttpRouter<AuthenticationRouter> {

    {
        subRouteOf("/auth");

        get("/login", (req, res) -> {
            //res.putHeader("content-type", "text/plain");
            System.out.println();
            //res.end("Hello so!");
        });

        get("/login", (HttpParamContext params) -> {



        });
    }

}
