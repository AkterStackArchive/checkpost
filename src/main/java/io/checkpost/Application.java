package io.checkpost;

import io.vertace.Vertace;
import io.vertace.core.LifecycleType;
import io.vertace.core.Lifecycle;
import io.vertace.core.VertaceVerticle;

import java.util.Arrays;
import java.util.List;


public class Application extends Vertace {

    public static void main(String[] args) {
        Vertace.run(Application.class, args);
    }

    //TODO: also load verticles from appconf
    @Override
    public void onLoadVerticles(List<Class<? extends VertaceVerticle>> loadedVerticles) {
        loadedVerticles.add(AppHttpServer.class);
    }

}
