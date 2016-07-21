package io.checkpost.dbean;

import io.dbean.core.Dbean;

public class User extends Dbean<User> {

    private Long id;
    private String username;
    private String password;

    public User() {
        id = 1l; username ="username"; password="password";
    }

    @Override
    public String toString() {
        return id + ":" + username +":" + password;
    }
}
