package io.checkpost.dbean;

import io.dbean.core.DBean;

public class User extends DBean<User> {

    private Long id;
    private String username;
    private String password;

    public Long id() {
        return id;
    }

    public Long id(Long id) {
        return this.id = id;
    }

    public String username() {
        return username;
    }

    public String username(String username) {
        return this.username = username;
    }

    public String password() {
        return password;
    }

    public String password(String password) {
        return this.password = password;
    }

    @Override
    public String toString() {
        return id + ":" + username +":" + password;
    }
}
