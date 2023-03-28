package com.example.simplest;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ParentEntityRepository extends JpaRepository<ParentEntity, ParentEntityId> {
}
