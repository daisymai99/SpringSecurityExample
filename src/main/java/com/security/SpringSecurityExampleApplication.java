package com.security;

import com.security.model.Account;
import com.security.model.Product;
import com.security.repo.AccountRepository;
import com.security.repo.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



@SpringBootApplication

public class SpringSecurityExampleApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(SpringSecurityExampleApplication.class, args);
    }

    @Autowired
    ProductRepository repository;

    @Autowired
    AccountRepository accountRepository;



    @Override
    public void run(String... args) throws Exception {
        for(int i=0; i<10; i++){
            Account account = new Account();
            account.setUssername("mai"+i);
            account.setPassword(""+i);
            account.setRole("READ");
            accountRepository.save(account);

            Product product = new Product();
            product.setName("product"+1);
            product.setPrice(4000+i);
            repository.save(product);

        }
    }


}
