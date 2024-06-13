package com.cbastian90.resources.adapter.out.microservicedb.credit.mapper;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Repository
public interface AccountRepository extends JpaRepository<AccountEntity,Long> {

    @Transactional
    AccountEntity save(AccountEntity accountEntity);

    Optional<AccountEntity> findById(Long id);
}
