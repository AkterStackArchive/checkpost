package io.checkpost;

import io.vertace.PackageScope;
import io.vertace.Vertace;
import io.vertace.http.VertaceHttpServer;

@PackageScope("io.checkpost")
public class CheckPostHttpServer extends VertaceHttpServer {

    public static void main(String[] args) {
        Vertace.run(CheckPostHttpServer.class, args);
    }

    @Override
    public Integer port() {
        return 8070; //TODO: read it from appconf
    }
}
