package com.spring.ReactiveProgramming.Service;


import com.spring.ReactiveProgramming.DAO.CustomerDAO;
import com.spring.ReactiveProgramming.DTO.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CustomerService {



    private final CustomerDAO customerDAO;

    public List<Customer> loadAllCustomers(){
        long start=System.currentTimeMillis();
        List<Customer> customers=customerDAO.getCustomer();
        long end=System.currentTimeMillis();
        System.out.println("Time Difference:"+(end-start));
        return customers;
    }


    public Flux<Customer> loadAllCustomerFlux(){
        long start=System.currentTimeMillis();
        Flux<Customer> customers=customerDAO.getAllCustomers();
        long end=System.currentTimeMillis();
        System.out.println("Time Difference:"+(end-start));
        return customers;
    }
}
