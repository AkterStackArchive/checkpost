package io.dbean.core;


public abstract class DBean<D extends DBean> {

    public D create() {
        return null;
    }

    public D update() {
        return null;
    }

    public D delete() {
        return null;
    }

    public D save() {
        D dbean = (D)this;
        System.out.println(dbean);
        return null;
    }

}
