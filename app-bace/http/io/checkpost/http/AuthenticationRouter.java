package io.checkpost.http;

import io.bace.http.HttpRouteHandler;
import io.bace.http.HttpRouter;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationRouter extends HttpRouter {

    {
        Map map = new HashMap();

        get("", (req, res) -> {

        });
    }

    public AuthenticationRouter(){}

    static {
        register(AuthenticationRouter.class);
    }

}
