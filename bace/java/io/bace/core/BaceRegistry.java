package io.bace.core;

import io.bace.http.HttpRouter;

import java.util.LinkedList;
import java.util.List;

public class BaceRegistry {

    private static List<Class<? extends HttpRouter>> listOfHttpRouterClass = new LinkedList<>();

    public static void registerHttpRouter(Class<? extends HttpRouter> httpRouterClass) {
        listOfHttpRouterClass.add(httpRouterClass);
    }

    public static List<Class<? extends HttpRouter>> listOfHttpRouterClass() {
        return new LinkedList<>(listOfHttpRouterClass); //immutable
    }

}
