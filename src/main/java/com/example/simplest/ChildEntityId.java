package com.example.simplest;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
public class ChildEntityId implements Serializable {

    private String tenantId;

    private String childId;

    public ChildEntityId(String tenantId, String childId) {
        this.tenantId = tenantId;
        this.childId = childId;
    }

    public ChildEntityId() {
    }
}
