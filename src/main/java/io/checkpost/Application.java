package io.checkpost;

import io.vertace.PackageScope;
import io.vertace.Vertace;

@PackageScope("io.checkpost")
public class Application extends Vertace {

    public static void main(String... args) {
        Vertace.run(Application.class, args);
    }

}
