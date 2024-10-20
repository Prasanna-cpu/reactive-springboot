package com.spring.ReactiveProgramming.Router;

import com.spring.ReactiveProgramming.Handler.CustomerHandler;
import com.spring.ReactiveProgramming.Handler.CustomerStreamHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.RouterFunctions;
import org.springframework.web.reactive.function.server.ServerResponse;


@Configuration
@RequiredArgsConstructor
public class RouterConfig {


    private final CustomerHandler customerHandler;

    private final CustomerStreamHandler customerStreamHandler;

    @Bean
    public RouterFunction<ServerResponse> routerFunctionStream(){
        return RouterFunctions
                .route()
                .GET("/router/customers/stream",customerStreamHandler::getCustomers)
                .build();
    }


    @Bean
    public RouterFunction<ServerResponse> routerFunction(){
        return RouterFunctions
                .route()
                .GET("/router/customers",customerHandler::loadCustomers)
                .build();
    }


}
