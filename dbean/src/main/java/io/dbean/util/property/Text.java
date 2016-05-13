package io.dbean.util.property;

import io.dbean.util.validator.MaxLength;

public class Text implements MaxLength<Text> {


    @Override
    public Text maxLength(int length) {
        return null;
    }
}
