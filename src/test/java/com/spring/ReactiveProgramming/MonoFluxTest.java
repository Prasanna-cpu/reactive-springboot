package com.spring.ReactiveProgramming;

import org.junit.jupiter.api.Test;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;



public class MonoFluxTest {

    @Test
    public void testMono(){
        Mono<?> monoString=Mono.just("God")
                .then(Mono.error(new RuntimeException("Sample exception")))
                .log();
        monoString.subscribe(System.out::println,(e)->System.out.println(e.getMessage()));
    }


    @Test
    public void testFlux(){
        Flux<?> fluxString=Flux.just("Java","Python","GoLang")
                .concatWithValues("Javascript")
                .concatWith(Flux.error(new RuntimeException("Sample exception")))
                .log() ;
        fluxString.subscribe(System.out::println,(e)->System.err.println(e.getMessage()));
    }

}
