package com.spring.ReactiveProgramming.Controller;


import com.spring.ReactiveProgramming.DTO.Customer;
import com.spring.ReactiveProgramming.Service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.awt.*;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/customers")
public class CustomerController {

    private final CustomerService customerService;

    @GetMapping("/")
    public List<Customer> getAllCustomers(){
        return customerService.loadAllCustomers();
    }


    @GetMapping(value = "/flux",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Customer> getAllCustomersStream(){
        return customerService.loadAllCustomerFlux();
    }



}
