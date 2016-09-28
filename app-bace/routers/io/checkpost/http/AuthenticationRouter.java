package io.checkpost.http;

import io.bace.http.HttpRouter;

public class AuthenticationRouter extends HttpRouter<AuthenticationRouter> {

    {
        subRouteOf("/auth");

        get("/login", (req, res) -> {
            res.header("content-type", "text/plain");
            res.end("Hello so!");
        });

        post("/login", (rctx) -> {

        });
    }

}
