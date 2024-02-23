package com.altimetrik.cms.controller;

import com.altimetrik.cms.service.CustomerServiceImple;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

//import static java.nio.file.Paths.get;
import static org.junit.jupiter.api.Assertions.*;

@WebMvcTest
class CustomerControllerTest {

//    @BeforeEach
//    void setUp() {
//    }
//
//    @AfterEach
//    void tearDown() {
//    }

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerServiceImple customerServiceImple;

    @Test
    void createCustomer() {
    }

    @Test
    void getAllCustomer() {
//        mockMvc.perform(get("/customers"));
    }

    @Test
    void getCustomerById() {
    }

    @Test
    void deleteCustomerById() {
    }

    @Test
    void updateById() {
    }

    @Test
    void findProductByName() {
    }
}