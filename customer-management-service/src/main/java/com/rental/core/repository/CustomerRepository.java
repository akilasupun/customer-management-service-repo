package com.rental.core.repository;

import org.springframework.data.repository.CrudRepository;

import com.rental.core.model.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long> {

}
