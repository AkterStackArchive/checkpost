package io.dbean.validator;

public interface PropertyRule<V, C> {

    boolean validate(V v, C c);

}
