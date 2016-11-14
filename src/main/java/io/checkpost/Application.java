package io.checkpost;

import io.vertace.PackageScope;
import io.vertace.Vertace;
import io.vertace.VertaceWeb;
import io.vertx.core.Vertx;

@PackageScope("io.checkpost")
public class Application extends VertaceWeb {

    public static void main(String... args) {
        Vertace.deploy(new Application());

    }

}
