package io.dbean.validator;

public class Length implements PropertyRule<String, Integer[]> {
    @Override
    public boolean validate(String value, Integer[] context) {
        return false;
    }
}
