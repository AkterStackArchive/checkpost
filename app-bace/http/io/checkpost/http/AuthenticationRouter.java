package io.checkpost.http;

import io.bace.http.HttpRouter;

public class AuthenticationRouter extends HttpRouter<AuthenticationRouter> {

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
