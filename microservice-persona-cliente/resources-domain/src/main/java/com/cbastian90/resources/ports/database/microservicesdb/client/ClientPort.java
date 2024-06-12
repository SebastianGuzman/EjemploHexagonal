package com.cbastian90.resources.ports.database.microservicesdb.client;

import com.cbastian90.resources.kernel.domain.util.models.Client;
import reactor.core.publisher.Mono;

public interface ClientPort {
    Mono<Client> createClient (
            String password,
            String estado,
            String name,
            String gender,
            String identification,
            Integer age,
            String phone,
            String address
    );

    Mono<Client> readClient(Long clientId);
}
