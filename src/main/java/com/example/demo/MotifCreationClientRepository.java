package com.example.demo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
interface MotifCreationClientRepository extends CrudRepository<MotifCreationClient, MotifCreationClientId> {
}