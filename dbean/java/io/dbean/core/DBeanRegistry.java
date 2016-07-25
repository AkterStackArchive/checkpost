package io.dbean.core;

import io.dbean.validator.PropertyRule;

import java.util.HashMap;
import java.util.Map;

public class DBeanRegistry {

    private static Map<String, PropertyRule> mapOfPropertyRules = new HashMap<>();

    public static void registerPropertyRule(Class<? extends PropertyRule> propertyRuleClass) {
        mapOfPropertyRules.put(DBeanUtil.lowerCamelCase(propertyRuleClass.getSimpleName()),
                propertyRuleClass.newInstance());
    }

    public static PropertyRule propertyRuleOf(String name) {
        return mapOfPropertyRules.get(name);
    }

}
