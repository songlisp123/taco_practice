package com.tacho.applacation.Base;

import org.springframework.data.repository.CrudRepository;

public interface OrderRepository
        extends CrudRepository<TacoOrder,Long> {
}
