package com.sda.trkszabi.webshop.repository;

import com.sda.trkszabi.webshop.model.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
