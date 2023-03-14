package com.example.demo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "SCOPFPAI")
@IdClass(ModePaiementId.class)
@Getter
@Setter
public class ModePaiement {
    @Id
    @Column(name = "SOC_CODE")
    private String codeSociete;

    @Id
    @Column(name = "PAI_CODE")
    private String code;

    @Column(name = "PAI_LIBC")
    private String libc;

    @Column(name = "PAI_REGLGESTION")
    private Integer autoriseEnGestion = 1;

    @Column(name = "PAI_RIB")
    private Integer ribObligatoire = 0;

    @Column(name = "PAI_DIFFERE")
    private Boolean differe;
}
