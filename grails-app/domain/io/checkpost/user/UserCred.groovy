package io.checkpost.user

class UserCred {

    String username
    String password

    static constraints = {
        username unique: true
    }
}
