package com.cbastian90.resources.adapter.out.microservicedb.client.mapper;

import com.cbastian90.resources.adapter.out.microservicedb.client.ClientEntity;
import com.cbastian90.resources.kernel.domain.util.models.Client;
import com.cbastian90.resources.kernel.domain.util.models.Person;
import lombok.experimental.UtilityClass;

@UtilityClass
public class ClientMapper {
    public static Client entityToClient(ClientEntity entity) {
        return Client.builder()
                .clientId(Math.toIntExact(entity.getId()))
                .password("******")
                .clientId(Math.toIntExact(entity.getPerson().getId()))
                .estado(entity.getState())
                .person(Person
                        .builder()
                        .personId(Math.toIntExact(entity.getPerson().getId()))
                        .name(entity.getPerson().getName())
                        .age(entity.getPerson().getAge())
                        .phone(entity.getPerson().getPhone())
                        .identification(entity.getPerson().getIdentification())
                        .gender(entity.getPerson().getGender())
                        .address(entity.getPerson().getAddress())
                        .build())
                .build();
    }
}
