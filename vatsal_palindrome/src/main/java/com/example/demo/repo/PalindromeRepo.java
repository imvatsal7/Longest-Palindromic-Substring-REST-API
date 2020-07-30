package com.example.demo.repo;

import com.example.demo.model.PalindromeMapping;
import org.springframework.data.mongodb.repository.MongoRepository;

/*
We just have to provide the interface itself and spring boot will provide us with all
the basic CRUD operations we need, there is no need to explicitly provide implementation for
these methods.
 */
public interface PalindromeRepo extends MongoRepository<PalindromeMapping,String> {

}
