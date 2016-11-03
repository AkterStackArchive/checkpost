package io.checkpost;

import io.vertace.PackageScope;
import io.vertace.Vertace;

@PackageScope("io.checkpost")
public class CheckPostApplication extends Vertace {

    public static void main(String[] args) {
        Vertace.run(CheckPostApplication.class, args);
    }

}
