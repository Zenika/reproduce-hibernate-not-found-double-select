package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "SCOPFMTC")
@IdClass(MotifCreationClientId.class)
@Getter
@Setter
@ToString
public class MotifCreationClient {
    @Id
    @Column(name = "SOC_CODE")
    private String codeSociete;
    @Id
    @Column(name = "MTC_CODE")
    private String code;
    @Column(name = "MTC_LIBC")
    private String libc;
    @Column(name = "MTC_CLIENT")
    private Boolean motifClient;
}