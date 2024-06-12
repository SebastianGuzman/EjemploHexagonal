package com.cbastian90.resources.adapter.out.microservicedb.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface ClientRepository extends JpaRepository<ClientEntity,Long> {

    @Transactional
    ClientEntity save(ClientEntity clientEntity);

    Optional<ClientEntity> findById(Long id);
}
