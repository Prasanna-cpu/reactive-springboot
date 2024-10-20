package com.spring.ReactiveProgramming.DAO;


import com.spring.ReactiveProgramming.DTO.Customer;
import lombok.SneakyThrows;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.Objects;
import java.util.function.IntConsumer;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Component
public class CustomerDAO {

    @SneakyThrows
    private static void sleepExecution(){
        Thread.sleep(1000);
    }

    @SneakyThrows
    public List<Customer> getCustomer() {
        return IntStream
                .rangeClosed(1,50)
                .peek(i->sleepExecution())
                .peek(i->System.out.println("Processing Count:"+i))
                .mapToObj(i->new Customer(i,"customer"+i))
                .collect(Collectors.toList());
    }

    public Flux<Customer> getAllCustomers(){
        return Flux.range(1,50)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i->System.out.println("processing count: "+i))
                .map(i->new Customer(i,"customer"+i));
    }

    public Flux<Customer> getAllCustomersWithoutDelay(){
        return Flux.range(1,50)
                .doOnNext(i->System.out.println("processing count: "+i))
                .map(i->new Customer(i,"customer"+i));
    }



}
