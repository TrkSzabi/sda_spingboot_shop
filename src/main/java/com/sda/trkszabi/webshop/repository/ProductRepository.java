package com.sda.trkszabi.webshop.repository;

import com.sda.trkszabi.webshop.model.Product;
import org.springframework.data.repository.CrudRepository;

public interface ProductRepository extends CrudRepository<Product, Long> {
}
