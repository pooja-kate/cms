package com.altimetrik.cms.service;

import com.altimetrik.cms.entity.Customer;
import com.altimetrik.cms.exceptionhandler.CustomerIdNotFound;
import com.altimetrik.cms.repository.ICustomerRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.sql.Date;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doNothing;

@ExtendWith(MockitoExtension.class)
class CustomerServiceImpleTest {

    @Mock
   private ICustomerRepository customerRepository;

    @InjectMocks
   private CustomerServiceImple customerServiceImple;
//    @BeforeEach
//    void setUp() {
//    }
//    @AfterEach
//    void tearDown() {
//    }
    @Test
    void createCustomer() {
        Customer c1 =
                new Customer(1,"pooja",new Date(System.currentTimeMillis()),true);
        Mockito.when(customerRepository.save(c1)).thenReturn(c1);
        assertEquals(c1,customerServiceImple.createCustomer(c1));

    }
    @Test
    void getAllCustomer() {
        Customer c1 =
                new Customer(1,"pooja",new Date(System.currentTimeMillis()),true);
        Customer c2 =
                new Customer(2,"namrata",new Date(System.currentTimeMillis()),true);
        List<Customer> list = Arrays.asList(c1,c2);
        Mockito.when(customerRepository.findAll()).thenReturn(list);
//        CustomerInter ci = new Cust?ceImple();
        assertEquals(2,customerServiceImple.getAllCustomer().size());
    }

    @Test
    void getCustomerById() throws CustomerIdNotFound {
        Customer c1 =
                new Customer(1,"pooja",new Date(System.currentTimeMillis()),true);
        Mockito.when(customerRepository.findById(1)).thenReturn(Optional.of(c1));
        assertEquals(c1,customerServiceImple.getCustomerById(1));
    }

    @Test
    void updateCustomer() {
    }

    @Test
    void deleteCustomer() {
//        int custId=1;
//        doNothing().when(customerRepository).deleteById(custId);
//        Customer c1 =
//                new Customer(1,"pooja",new Date(System.currentTimeMillis()),true);
//        customerServiceImple.deleteCustomer(custId);
//        Mockito.when(customerRepository.deleteById(1));

        assertEquals(null,customerServiceImple.deleteCustomer(1));
    }

    @Test
    void findByCustomerName() {
    }
}