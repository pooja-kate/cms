package com.altimetrik.cms.controller;

import com.altimetrik.cms.entity.Customer;
import com.altimetrik.cms.exceptionhandler.CustomerIdNotFound;
import com.altimetrik.cms.service.CustomerInter;
import jakarta.validation.Valid;
import org.apache.tomcat.util.net.jsse.JSSEUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
//
//Replace =
// @controller by @ Restconstroller
// @RequestMapping by @GetMapping
// Remove @Responsbody as Rest controller will take care of that.
//Replace by Restcontroller
//@Controller
@RestController
// When you're building a web application with a front-end that makes API requests
// to a back-end server, you may need to configure CORS to allow or restrict
// cross-origin requests. The @CrossOrigin annotation helps you define these CORS
// settings in your Spring Boot application.
// Port Number : 9090
@CrossOrigin
@RequestMapping("/customer-api")
public class CustomerController {
    @Autowired
    // Injecting Interface from Serivice to achieve abstraction
    private CustomerInter customerInter;

//    @RequestMapping(path = "/customer", method = RequestMethod.POST)
// @PostMapping
    //@ResponseBody /// Eliminated
    @PostMapping(path = "/customer")
    // Valid is Most neccessory to mapping in POJO class annotations.
    public Customer createCustomer(@RequestBody @Valid  Customer customer){
// throws execption showing not valid data has been passed.
        System.out.println("customer deleted successfully...");
        return customerInter.createCustomer(customer);
    }
    //
//    @RequestMapping(path = "/customers", method = RequestMethod.GET)
    // @GetMapping Replaced to requestMapping
//    @ResponseBody
    @GetMapping(path = "/customers")
    public List<Customer> getAllCustomer(){
        System.out.println("Got All Customer From DB");
        return customerInter.getAllCustomer();
    }

//    @RequestMapping(path="/customer/{id}", method = RequestMethod.GET)
//    // GetMapping
//    @ResponseBody
    @GetMapping(path = "/customer/{id}")
    public Customer getCustomerById(@PathVariable("id") int id)throws CustomerIdNotFound{
        if(customerInter.getCustomerById(id)==null){
            throw new CustomerIdNotFound("Id not found exception");
        }

        return customerInter.getCustomerById(id);
    }

    //DELETE
//    @RequestMapping(path="customer/{id}",method = RequestMethod.DELETE)
//    // DeleteMapping
//    @ResponseBody
    @DeleteMapping(path = "/customer/{id}")
    public Customer deleteCustomerById(@PathVariable("id") int id){
//        customerInter.deleteCustomer(id);
      return customerInter.deleteCustomer(id).get();
    }

    //UPDATE
//    @RequestMapping(path = "customer", method = RequestMethod.PUT)
//    // @PutMapping
//    @ResponseBody
    @PutMapping(path = "/customer")
    public Customer updateById(@RequestBody Customer customer){
        return customerInter.updateCustomer(customer);
    }
    @GetMapping(path = "/customers/{Name}")
    public Optional<Customer> findProductByName(@PathVariable("Name") String name) {
        return customerInter.findByCustomerName(name);
    }
}
