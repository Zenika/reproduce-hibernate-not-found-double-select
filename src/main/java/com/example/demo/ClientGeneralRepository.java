package com.example.demo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.Optional;

@Repository
public interface ClientGeneralRepository extends CrudRepository<ClientGeneral, ClientGeneralId> {
    @Query("select c from ClientGeneral c join fetch c.motifCreationClient where c.codeSociete = ?1 and c.code = ?2")
    @Transactional
    Optional<ClientGeneral> findByCodeSocieteAndCode(String codeSociete, Long code);
}