package io.bace.http;

import java.util.ArrayList;
import java.util.List;

/**
 * url mappings
 */
public class HttpRouter {

    private static List<Class<? extends HttpRouter>> listOfHttpRouter = new ArrayList<>();

    private static String mountPoint;

    public void subRouteOf(String _mountPoint) {
        mountPoint = _mountPoint;
    }

    public void get(String path, HttpReqResHandler handler) {

    }

    public void post(String path, HttpReqResHandler handler) {

    }

    private void addRoute() {}

    public static void register(Class<? extends HttpRouter> httpRouterClass) {
        listOfHttpRouter.add(httpRouterClass);
    }
}
