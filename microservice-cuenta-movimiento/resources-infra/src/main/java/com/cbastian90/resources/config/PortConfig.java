package com.cbastian90.resources.config;

import com.cbastian90.resources.adapter.out.microservicedb.credit.AccountAdapter;
import com.cbastian90.resources.ports.database.microservicesdb.client.AccountPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PortConfig {
    @Bean
    AccountPort clientPort() {
        return new AccountAdapter();
    }
}
