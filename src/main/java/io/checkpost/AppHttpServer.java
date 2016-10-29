package io.checkpost;

import io.vertace.PackageScope;
import io.vertace.http.HttpServerVerticle;

@PackageScope("io.checkpost")
public class AppHttpServer extends HttpServerVerticle {

    @Override
    public Integer port() {
        return 8070; //TODO: read it from appconf
    }

}
