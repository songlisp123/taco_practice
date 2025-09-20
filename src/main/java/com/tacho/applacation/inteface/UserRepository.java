package com.tacho.applacation.inteface;

import com.tacho.applacation.entity.Customer;
import org.springframework.data.repository.CrudRepository;

/**
 * 这个呢是与jdbc的连接的业务层，用来执行sql查询语句
 */
public interface UserRepository extends CrudRepository<Customer,Long> {

    Customer findByUsername(String username);
}
