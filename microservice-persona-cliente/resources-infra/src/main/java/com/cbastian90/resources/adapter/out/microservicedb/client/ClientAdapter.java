package com.cbastian90.resources.adapter.out.microservicedb.client;

import com.cbastian90.resources.adapter.out.microservicedb.client.mapper.ClientMapper;
import com.cbastian90.resources.kernel.domain.util.models.Client;
import com.cbastian90.resources.ports.database.microservicesdb.client.ClientPort;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import reactor.core.publisher.Mono;

import java.util.Optional;


@RequiredArgsConstructor
@Slf4j
public class ClientAdapter implements ClientPort {

    @Autowired
    ClientRepository clientRepository;

    private static final String CONSUMO_EXITOSO="consumo exitoso";
    private static final String ERROR_CREAR_TRANSACCION = "Error, no se creó transaccion";

    private static final String DATA_NOT_FOUND = "no se encontraron datos, por favor intente mas tarde";

    private static final String CLIENT_NOT_FOUND = "Cliente no encontrado";

    @Override
    public Mono<Client> createClient( String password,
                                      String estado,
                                      String name,
                                      String gender,
                                      String identification,
                                      Integer age,
                                      String phone,
                                      String address) {
        return Mono.fromSupplier( ()->
                clientRepository.save( ClientEntity
                                        .builder()
                                                .state(estado)
                                                .password(password)
                                                .person(PersonEntity
                                                        .builder()
                                                        .name(name)
                                                        .gender(gender)
                                                        .identification(identification)
                                                        .age(age)
                                                        .phone(phone)
                                                        .address(address)
                                                        .build()
                                                )
                                        .build()
                    )
                )
                .map(ClientMapper::entityToClient)
                .doOnSuccess(m -> log.info(CONSUMO_EXITOSO))
                .onErrorResume(e -> {
                    log.error(ERROR_CREAR_TRANSACCION);
                    return Mono.error(new RuntimeException(e.getMessage()));
                })
                .switchIfEmpty(Mono.error(new RuntimeException(ERROR_CREAR_TRANSACCION)));


    }

    @Override
    public Mono<Client> readClient(Long clientId) {
        return Mono.just(
                clientRepository.findById(clientId)
                )
                .filter(Optional::isPresent)
                .map(Optional::get)
                .map(ClientMapper::entityToClient)
                .switchIfEmpty(Mono.error(new RuntimeException(CLIENT_NOT_FOUND)));
    }
}
