package com.example.demo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
public class MotifCreationClientId implements Serializable {
    private String codeSociete;
    private String code;

    public MotifCreationClientId(String codeSociete, String code) {
        this.codeSociete = codeSociete;
        this.code = code;
    }

    public MotifCreationClientId() {
    }
}
