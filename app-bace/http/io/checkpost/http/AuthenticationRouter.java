package io.checkpost.http;

import io.bace.http.HttpRouter;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationRouter extends HttpRouter {

    {
        subRouteOf("/auth");

        get("/login", (req, res) -> {

        });

        post("/login", (req, res) -> {

        });


    }

    static {
        register(AuthenticationRouter.class);
    }

}
