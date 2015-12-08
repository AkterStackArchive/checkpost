package io.checkpost

import io.checkpost.constant.Status

class Permission {

    String name
    Integer status = Status.INACTIVE.value()

    static constraints = {
    }
}
