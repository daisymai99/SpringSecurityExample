package com.security.service;

import com.security.model.Product;
import com.security.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService implements ProductServiceInterface{

    @Autowired
    ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    @Override
    public Iterable<Product> findAll() {
        return repository.findAll();
    }

    @Override
    public Product create(Product product) {
        if(product.getName() == null){
            return null;
        }
        return repository.save(product);
    }

    @Override
    public Product update(long id, Product product) {
        Product old = repository.findById(product.getId()).orElse(null);
        if(old ==null){
            return null;
        }

        old.setName(product.getName());
        old.setId(product.getId());
        old.setPrice(product.getPrice());
        return repository.save(product);
    }

    @Override
    public void delete(long id) {
        repository.deleteById(id);
    }

    @Override
    public Optional<Product> findById(long id) {
        return repository.findById(id);
    }
}
