package io.checkpost;

import io.vertace.PackageScope;
import io.vertace.http.VertaceHttpServer;

@PackageScope("io.checkpost")
public class CheckPostHttpServer extends VertaceHttpServer {

    @Override
    public Integer port() {
        return 8070; //TODO: read it from appconf
    }

}
