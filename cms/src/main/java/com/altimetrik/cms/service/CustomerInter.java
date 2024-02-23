package com.altimetrik.cms.service;

import com.altimetrik.cms.entity.Customer;
import com.altimetrik.cms.exceptionhandler.CustomerIdNotFound;
import org.springframework.context.annotation.Lazy;

import java.util.List;
import java.util.Optional;
@Lazy
public interface CustomerInter {
    public Customer createCustomer(Customer customer);
    public List<Customer> getAllCustomer();
    public Customer getCustomerById(int customerId) throws CustomerIdNotFound;
    public Customer updateCustomer(Customer customer);
    public Optional<Customer> deleteCustomer(int customerId);

   public Optional<Customer> findByCustomerName(String customerName);
   //From Java 8
    // We are allowed write default and static methods with their implementations
   public default void project(){
       System.out.println("customer management system");
   }
   public static int getNumber(){
       return 1;
   }
}
