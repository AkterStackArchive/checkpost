package io.checkpost.user

import io.checkpost.NodeEntity

@org.neo4j.ogm.annotation.NodeEntity(label = "User")
class UserEntity extends NodeEntity<UserEntity> {

    String username
    String password

}
