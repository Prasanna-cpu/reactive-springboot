package com.spring.ReactiveProgramming.Handler;


import com.spring.ReactiveProgramming.DAO.CustomerDAO;
import com.spring.ReactiveProgramming.DTO.Customer;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
@Service
public class CustomerHandler {

    private final CustomerDAO customerDAO;

    public Mono<ServerResponse> loadCustomers(ServerRequest request){
        Flux<Customer> customerList=customerDAO.getAllCustomersWithoutDelay();
        return ServerResponse.ok().body(customerList,Customer.class);
    }



}
