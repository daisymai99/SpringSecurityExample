package com.security.controller;

import com.security.model.Product;
import com.security.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1")
public class ProductController {

    @Autowired
    ProductService productService;

    @PostMapping("/post")
    public Product create(@RequestBody Product product){
        return productService.create(product);
    }

    @GetMapping
    public List<Product> findAll(){
        return (List<Product>) productService.findAll();
    }


    @DeleteMapping("/delete/{id}")
    public void delete(@PathVariable("id") Long id){
        productService.delete(id);
    }

    @PutMapping("/update/{id}")
    public Product update(@RequestBody Product product, @PathVariable("id") Long id){
        return productService.update(id,product);
    }

}
