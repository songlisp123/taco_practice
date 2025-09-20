package com.tacho.applacation.inteface;

import com.tacho.applacation.entity.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository
        extends CrudRepository<TacoOrder,Long> {
}
