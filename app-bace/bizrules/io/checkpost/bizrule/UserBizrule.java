package io.checkpost.bizrule;

import io.checkpost.node.User;

public class UserBizrule {

    public User newUser() {
        blocking("");
        return null;
    }

    public void save(String username) {
        blocking(username);
    }

    public void update(Integer id, String username) {

    }


    private void blocking(String msg) {
        try {
            System.out.println(msg);
            Thread.sleep(5000);
        } catch(InterruptedException e) {
            e.printStackTrace();
        }
    }
}
