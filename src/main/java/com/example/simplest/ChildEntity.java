package com.example.simplest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "child")
@IdClass(ChildEntityId.class)
@Getter
@Setter
@ToString
public class ChildEntity {

    @Id
    @Column(name = "tenant_id")
    private String tenantId;

    @Id
    @Column(name = "child_id")
    private String childId;
}
