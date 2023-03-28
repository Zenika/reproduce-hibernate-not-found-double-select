package com.example.simplest;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "parent")
@IdClass(ParentEntityId.class)
@Getter
@Setter
@ToString()
public class ParentEntity {

    @Id
    @Column(name = "tenant_id")
    private String tenantId;

    @Id
    @Column(name = "parent_id")
    private String parentId;

    @Column(name = "child_id")
    private String childId;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({
            @JoinColumn(
                    name = "tenant_id",
                    referencedColumnName = "tenant_id",
                    insertable = false,
                    updatable = false
            ),
            @JoinColumn(
                    name = "child_id",
                    referencedColumnName = "child_id",
                    insertable = false,
                    updatable = false
            )
    })
    ChildEntity childEntity;
}
