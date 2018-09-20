package com.example.jpasql.repository;


import com.example.jpasql.model.Account;
import org.springframework.data.repository.CrudRepository;

public interface AccountDao extends CrudRepository<Account,Long> {

    /**
     * This method will find an User instance in the database by its email.
     * Note that this method is not implemented and its working code will be
     * automagically generated from its signature by Spring Data JPA.
     */
 Account findByUsername(String username);

}
