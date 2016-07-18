package io.bace.core;

import io.bace.core.factory.HttpRouterFactory;
import io.bace.http.HttpServer;

public final class Bace {

    private static final Integer DEFAULT_HTTP_PORT = 7007;
    private static Bace self;

    private Class<? extends BaceApp> baceAppClass;
    private HttpRouterFactory httpRouterFactory;
    private BaceApp app;

    private Bace() {}

    private void test(){}

    private void initializeFactories() {
        self.httpRouterFactory = new HttpRouterFactory();
    }

    private void initializeBaceApp() {
        try {
            app = baceAppClass.newInstance();
            routerFactory().initialize();
        } catch(InstantiationException e) {
            //TODO
        } catch(IllegalAccessException e) {
            //TODO
        }
    }

    public static void initialize(Class<? extends BaceApp> _baceAppClass, String[] args) {
        self = new Bace();

        self.baceAppClass = _baceAppClass;

        /* lifecycle */
        self.initializeFactories();
        self.initializeBaceApp();

        self.app.httpServer(new HttpServer(DEFAULT_HTTP_PORT)); //TODO: default port should be modifiable

    }

    public static void testInitialization() {
        try {
            self.test();
        } catch(NullPointerException e) {
            e.printStackTrace();
            throw new RuntimeException("Failed to initialize Bace");
        }
    }

    public static BaceApp app() {
        testInitialization();
        return self.app;
    }

    public static HttpRouterFactory routerFactory() {
        testInitialization();
        return self.httpRouterFactory;
    }

}
