package io.dbean.util.property;

import io.dbean.util.validator.MaxLength;

public @interface Title {

    String  maxLength() default "ddd";

}
