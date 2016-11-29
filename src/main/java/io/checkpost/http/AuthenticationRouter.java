package io.checkpost.http;


import io.vertace.http.HttpRestRouter;

public class AuthenticationRouter extends HttpRestRouter {

    {
        get("/login", (req, res) -> {
            res.done("sdfsdf");
        });
    }

}
