package com.example.demo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
public class ClientGeneralId implements Serializable {
    private String codeSociete;
    private Long code;

    public ClientGeneralId(String codeSociete, Long code) {
        this.codeSociete = codeSociete;
        this.code = code;
    }

    public ClientGeneralId() {
    }
}