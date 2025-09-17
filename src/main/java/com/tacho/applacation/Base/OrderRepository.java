package com.tacho.applacation.Base;

import com.tacho.applacation.entity.TacoOrder;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository
        extends CrudRepository<TacoOrder,Long> {
}
