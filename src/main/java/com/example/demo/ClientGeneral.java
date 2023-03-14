package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;

@Entity
@Table(name = "SCOGFCLG")
@IdClass(ClientGeneralId.class)
@Getter
@Setter
@ToString()
public class ClientGeneral {

    @Id
    @Column(name = "SOC_CODE")
    private String codeSociete;
    @Id
    @Column(name = "CLG_CODE")
    private Long code;
    @Column(name = "CAT_CODE")
    private String codeCategorie;
    @Column(name = "MTC_CODE")
    private String codeMotifCreationClient;

    @NotFound(action = NotFoundAction.IGNORE)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumns({@JoinColumn(name = "SOC_CODE", referencedColumnName = "SOC_CODE", insertable = false, updatable = false), @JoinColumn(name = "MTC_CODE", referencedColumnName = "MTC_CODE", insertable = false, updatable = false)})
    private MotifCreationClient motifCreationClient;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
            @JoinColumn(
                    name = "SOC_CODE",
                    referencedColumnName = "SOC_CODE",
                    insertable = false,
                    updatable = false),
            @JoinColumn(
                    name = "CAT_CODE",
                    referencedColumnName = "CAT_CODE",
                    insertable = false,
                    updatable = false)
    })
    private Categorie categorie;
}