package com.example.simplest;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
public class ParentEntityId implements Serializable {
    private String tenantId;
    private String parentId;

    public ParentEntityId(String tenantId, String parentId) {
        this.tenantId = tenantId;
        this.parentId = parentId;
    }

    public ParentEntityId() {
    }
}
