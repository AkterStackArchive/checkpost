package io.checkpost;

import io.vertace.Vertace;
import io.vertace.core.VertaceVerticle;

import java.util.List;


public class CheckPostApplication extends Vertace {

    public static void main(String[] args) {
        Vertace.run(CheckPostApplication.class, args);
    }

    @Override
    public void onRegisterVerticles(List<Class<? extends VertaceVerticle>> loadedVerticles) {
        loadedVerticles.add(AppHttpServer.class);
    }

}
