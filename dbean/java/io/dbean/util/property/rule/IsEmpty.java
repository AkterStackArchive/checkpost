package io.dbean.util.property.rule;

import io.dbean.validator.PropertyRule;

public class IsEmpty implements PropertyRule<String, Boolean> {
    @Override
    public boolean validate(String value, Boolean context) {
        return false;
    }
}
