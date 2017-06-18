package io.checkpost.user

import io.vertace.EbusRouter
import io.vertace.VertaceFlow
import io.vertx.core.eventbus.Message


class UserEbusRouter extends EbusRouter {

    Message<User> getUser() {

    }

}
