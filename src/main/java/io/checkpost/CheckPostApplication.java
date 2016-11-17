package io.checkpost;

import io.vertace.PackageScope;
import io.vertace.Vertace;
import io.vertace.VertaceWeb;
import io.vertace.core.VertaceException;

@PackageScope("io.checkpost")
public class CheckPostApplication extends VertaceWeb {

    public static void main(String... args) throws VertaceException {
        Vertace.deploy(new CheckPostApplication());
    }

    @Override
    public int port() {
        return 7007;
    }
}
