package com.example.simplest;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootTest
public class DoubleSelectTest {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Autowired
    ParentEntityRepository parentEntityRepository;

    @Autowired
    QueryCountInterceptor queryCountInterceptor;

    @Test
    void givenParentHasValidForeignKeyThenHibernateReadsBothWithOneSelect() {
        jdbcTemplate.execute("""
                insert into child (tenant_id, child_id) values ('tenant1', 'child1');
                insert into parent (tenant_id, parent_id, child_id) values ('tenant1', 'parent1', 'child1');
                """);
        queryCountInterceptor.reset();
        var parent = parentEntityRepository.findById(new ParentEntityId("tenant1", "parent1"));
        Assertions.assertTrue(parent.isPresent());
        Assertions.assertNotNull(parent.get().getChildEntity());
        Assertions.assertEquals(1, queryCountInterceptor.getCount());
    }


    @Test
    void givenParentHasInvalidForeignKeyThenHibernateReadsBothWithOneSelect() {
        jdbcTemplate.execute("""
                insert into parent (tenant_id, parent_id, child_id) values ('tenant1', 'parent2', ' ');
                """);
        queryCountInterceptor.reset();
        var parent = parentEntityRepository.findById(new ParentEntityId("tenant1", "parent2"));
        Assertions.assertTrue(parent.isPresent());
        Assertions.assertNull(parent.get().getChildEntity());
        Assertions.assertEquals(1, queryCountInterceptor.getCount());
    }
}
