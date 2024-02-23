package com.altimetrik.cms.service;

import com.altimetrik.cms.entity.Customer;
import com.altimetrik.cms.exceptionhandler.CustomerIdNotFound;
import com.altimetrik.cms.repository.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImple implements CustomerInter {
    @Autowired
    private ICustomerRepository customerRepository;
    @Override
    public Customer createCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public List<Customer> getAllCustomer() {
        return customerRepository.findAll();
    }

    @Override
    public Customer getCustomerById(int customerId) throws CustomerIdNotFound {
        Optional<Customer>opt = customerRepository.findById(customerId);
        Customer c = null;
        if(opt.isPresent()){
            c = opt.get();
        }
        else{
            throw new CustomerIdNotFound("Customer Id Not Found"+customerId);
        }
        return c;
        //return customerRepository.findById(customerId).get();
    }



    @Override
    public Customer updateCustomer(Customer customer) {

        return customerRepository.save(customer);
    }

    @Override
    public Optional<Customer> deleteCustomer(int customerId) {
       customerRepository.deleteById(customerId);
        return customerRepository.findById(customerId);
      // return Optional.empty();
    }
    @Override
    public Optional<Customer> findByCustomerName(String custopmerName){

        return customerRepository.findByCustomerName(custopmerName);
    }
}
