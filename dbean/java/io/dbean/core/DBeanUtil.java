package io.dbean.core;

public class DBeanUtil {

    public static String lowerCamelCase(String source) {
        return source.substring(0, 1).toLowerCase() + source.substring(1);
    }

}
