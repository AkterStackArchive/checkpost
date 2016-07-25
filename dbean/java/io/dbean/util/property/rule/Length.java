package io.dbean.util.property.rule;

import io.dbean.validator.PropertyRule;

public class Length implements PropertyRule<String, Integer[]> {
    @Override
    public boolean validate(String value, Integer[] context) {
        return false;
    }
}
