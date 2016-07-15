package io.checkpost.http;

import io.bace.http.HttpRouter;

import java.util.HashMap;
import java.util.Map;

public class AuthenticationRouter extends HttpRouter {

    {
        Map map = new HashMap();

        get("", (req, res) -> {

        });
    }

    static {
        register(AuthenticationRouter.class);
    }

}
