package io.checkpost.dbean;

import io.checkpost.properties.Name;
import io.checkpost.properties.Title;
import io.dbean.core.DBean;

public class Resource extends DBean<Resource> {

    private final Class[] properties = new Class[] {
            Name.class,
            Title.class
    };

    private final Class[] outgoing = new Class[]{};

    private final Class[] incoming = new Class[]{};

}
