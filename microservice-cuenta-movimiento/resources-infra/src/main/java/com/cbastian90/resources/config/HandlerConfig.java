package com.cbastian90.resources.config;


import com.cbastian90.resources.handler.createaccount.CreateAccountHandler;
import com.cbastian90.resources.handler.example.ExampleHandler;
import com.cbastian90.resources.usecase.createaccount.CreateAccountUseCase;
import com.cbastian90.resources.usecase.example.ExampleUseCase;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HandlerConfig {


    @Bean
    public ExampleHandler getAccountListInformationHandler(final ExampleUseCase useCase) {
        return new ExampleHandler(useCase);
    }

    @Bean
    public CreateAccountHandler getCreateAccountHandler(final CreateAccountUseCase useCase) {
        return new CreateAccountHandler(useCase);
    }

}
