package io.checkpost.http;

import io.bace.http.HttpRouter;
import io.bace.http.context.HttpParamContext;
import io.bace.http.handler.HttpParamHandler;
import io.bace.http.handler.HttpRoutingContextHandler;
import io.checkpost.bizrule.UserBizrule;
import io.vertx.ext.web.RoutingContext;

import java.util.Map;

public class AuthenticationRouter extends HttpRouter<AuthenticationRouter> {

    {
        subRouteOf("/auth");
        //accept("application/json");
        //generate("application/json");

        get("/login", (req, res) -> {
            res.header("content-type", "text/plain");
            System.out.println();
            UserBizrule userBizrule = new UserBizrule();
            userBizrule.newUser();
            res.done("Hello so!");
        });

    }

}
