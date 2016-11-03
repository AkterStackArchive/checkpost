package io.checkpost;

import io.vertace.http.VertaceHttpServer;

public class CheckPostHttpServer extends VertaceHttpServer {

    @Override
    public Integer port() {
        return 8070; //TODO: read it from appconf
    }

}
