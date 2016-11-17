package io.checkpost;

import io.vertace.PackageScope;
import io.vertace.Vertace;
import io.vertace.VertaceWeb;

@PackageScope("io.checkpost")
public class CheckPostApplication extends VertaceWeb {

    public static void main(String... args) {
        Vertace.deploy(new CheckPostApplication());
    }

    @Override
    public int port() {
        return 7007;
    }
}
