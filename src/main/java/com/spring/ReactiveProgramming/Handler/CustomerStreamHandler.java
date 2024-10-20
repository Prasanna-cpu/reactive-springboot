package com.spring.ReactiveProgramming.Handler;


import com.spring.ReactiveProgramming.DAO.CustomerDAO;
import com.spring.ReactiveProgramming.DTO.Customer;
import io.netty.handler.flush.FlushConsolidationHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class CustomerStreamHandler {

    private final CustomerDAO customerDAO;

    public Mono<ServerResponse> getCustomers(ServerRequest request){
        Flux<Customer> customerStream=customerDAO.getAllCustomers();
        return ServerResponse.ok().body(customerStream,Customer.class);
    }
}
