package com.sda.trkszabi.webshop.repository;

import com.sda.trkszabi.webshop.model.Customer;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<Customer, Long> {
}
