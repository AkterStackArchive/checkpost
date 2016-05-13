package io.dbean.util.validator;

import io.dbean.core.Validator;

public interface MaxLength<V> extends Validator {

    @Override
    default boolean validate(Object value) {
        return true;
    }

    V maxLength(int length);

}
