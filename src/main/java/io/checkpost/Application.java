package io.checkpost;

import io.vertace.Vertace;
import io.vertace.core.VertaceVerticle;

import java.util.Arrays;
import java.util.List;


public class Application extends Vertace {

    public static void main(String[] args) {
        Vertace.run(Application.class, args);
    }

    //TODO: also load verticles from appconf
    @Override
    public List<Class<? extends VertaceVerticle>> registerVerticles() {
        return Arrays.asList(
                AppHttpServer.class
        );
    }

}
