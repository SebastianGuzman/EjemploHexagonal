package com.cbastian90.resources.adapter.out.microservicedb.client;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRespository extends JpaRepository<PersonEntity, Long> {

}
