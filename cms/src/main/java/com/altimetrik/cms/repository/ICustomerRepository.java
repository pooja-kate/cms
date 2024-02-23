package com.altimetrik.cms.repository;

import com.altimetrik.cms.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ICustomerRepository extends JpaRepository<Customer, Integer> {


   Optional<Customer> findByCustomerName(String customerName);
}
