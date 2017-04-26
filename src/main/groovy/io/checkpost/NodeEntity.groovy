package io.checkpost

import org.springframework.data.repository.CrudRepository


abstract class NodeEntity<T> {

    CrudRepository<T, Long> crudRepository;

    Long gid;

}
