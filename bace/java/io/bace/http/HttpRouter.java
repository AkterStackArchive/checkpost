package io.bace.http;

import java.util.LinkedList;
import java.util.List;

@SuppressWarnings("unchecked")
public class HttpRouter<R> {

    private static List<Class<? extends HttpRouter>> listOfHttpRouterClass = new LinkedList<>();

    private static String mountPoint;

    public R subRouteOf(String _mountPoint) {
        mountPoint = _mountPoint;
        return (R)this;
    }

    public R get(String path, HttpReqResHandler handler) {

        return (R)this;
    }

    public R post(String path, HttpReqResHandler handler) {

        return (R)this;
    }

    private R route() {

        return (R)this;
    }

    public static void register(Class<? extends HttpRouter> httpRouterClass) {
        listOfHttpRouterClass.add(httpRouterClass);
    }
}
