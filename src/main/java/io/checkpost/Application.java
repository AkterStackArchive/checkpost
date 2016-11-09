package io.checkpost;

import io.vertace.PackageScope;
import io.vertace.VertaceWeb;

@PackageScope("io.checkpost")
public class Application extends VertaceWeb {

    public static void main(String... args) {
        new Application().run(args);
    }

}
