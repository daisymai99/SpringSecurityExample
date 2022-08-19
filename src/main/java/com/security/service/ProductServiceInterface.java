package com.security.service;

import com.security.model.Product;

import java.util.Optional;

public interface ProductServiceInterface {

    Iterable<Product> findAll();

    Product create(Product product);

    Product update(long id, Product product);

    void delete(long id);

    Optional<Product> findById(long id);


}
