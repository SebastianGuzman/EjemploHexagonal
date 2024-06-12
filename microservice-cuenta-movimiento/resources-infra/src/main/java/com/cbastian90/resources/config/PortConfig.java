package com.cbastian90.resources.config;

import com.cbastian90.resources.adapter.out.microservicedb.client.ClientAdapter;
import com.cbastian90.resources.ports.database.microservicesdb.client.ClientPort;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PortConfig {
    @Bean
    ClientPort clientPort() {
        return new ClientAdapter();
    }
}
