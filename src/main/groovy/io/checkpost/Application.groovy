package io.checkpost

import io.vertace.Vertace
import io.vertace.http.VertaceWeb


class Application extends VertaceWeb {

    static void main(String... args) {
        Vertace.deploy(new Application(args))
    }

}
