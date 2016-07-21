package io.dbean.core;


public abstract class Dbean<D extends Dbean> {



    public D save() {
        D dbean = (D)this;
        System.out.println(dbean);
        return null;
    }

    public D create() {
        return null;
    }

    public D update() {
        return null;
    }

    public D delete() {
        return null;
    }

}
