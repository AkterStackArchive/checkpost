package io.checkpost.property;

import io.dbean.core.Property;
import io.dbean.core.Validatable;
import io.dbean.core.Validator;

public class Title implements Property, Validatable {


    @Override
    public Validator validator() {
        return null;
    }
}
