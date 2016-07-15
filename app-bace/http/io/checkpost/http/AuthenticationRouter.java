package io.checkpost.http;

import io.bace.http.HttpRouter;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationRouter extends HttpRouter {

    {
        get("", (req, res) -> {

        });
    }

    static {
        register(AuthenticationRouter.class);
    }

}
