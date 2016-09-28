package io.checkpost.node;

import io.edgenode.Node;
import io.edgenode.annotation.Property;

public class User extends Node<User> {

    @Property
    private String username;
    @Property
    private String password;

}
