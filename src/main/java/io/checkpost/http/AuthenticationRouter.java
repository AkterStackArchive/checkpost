package io.checkpost.http;


import io.vertace.http.HttpRestRouter;

public class AuthenticationRouter extends HttpRestRouter<AuthenticationRouter> {

    {
        get("/login", (req, res) -> {
            res.done("sdfsdf");
        });
    }

}
