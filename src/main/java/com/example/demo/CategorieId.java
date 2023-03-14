package com.example.demo;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@EqualsAndHashCode
@Getter
@Setter
public class CategorieId implements Serializable {
    private String codeSociete;
    private String code;

    public CategorieId(String codeSociete, String code) {
        this.codeSociete = codeSociete;
        this.code = code;
    }

    public CategorieId() {}
}
