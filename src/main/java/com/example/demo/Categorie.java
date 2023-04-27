package com.example.demo;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "SCOPFCAT")
@IdClass(CategorieId.class)
@Getter
@Setter
public class Categorie {
    @Id
    @Column(name = "SOC_CODE")
    private String codeSociete;

    @Id
    @Column(name = "CAT_CODE")
    private String code;

    @Column(name = "PAI_CODE")
    @Convert(converter = SpaceToNullConverter.class)
    private String codeModePaiement;

    @Column(name = "ACT_CODE1")
    private String codeActivite1;

    @Column(name = "ACT_CODE2")
    private String codeActivite2;

    @Column(name = "ACT_CODE3")
    private String codeActivite3;

    @Column(name = "ACT_CODE4")
    private String codeActivite4;

    @Column(name = "ACT_CODE5")
    private String codeActivite5;

    @Column(name = "CAT_LIBC")
    private String libc;

    @Column(name = "PRL_CODE")
    private String codeProfilRelance;

    @Column(name = "CLC_CODE")
    private String codeSolvabilite;

    @Column(name = "DIS_CODE")
    private String codeDistribution;

    @Column(name = "RFI_CODE")
    private String codeRegimeFiscal;

    @Column(name = "CAT_EDREM")
    private Boolean editionRemise = true;

    @Column(name = "CAT_DMA", precision = 15, scale = 3)
    private BigDecimal dma = BigDecimal.ZERO;

    @Column(name = "CAT_DELAIDMA")
    private Integer nombreMoisDelaiDma;

    @Column(name = "CAT_NBEXFAC")
    private Integer nombreExemplairesFactures;

    @Column(name = "CAT_NEGO")
    private Integer modeNego = 1;

    @Column(name = "CAT_PJ")
    private Boolean pieceJointe = true;

    @Column(name = "CAT_NBJREL")
    private Integer seuilRelanceDegresJours = 0;

    @Column(name = "CAT_ASSUREUR")
    private String assureur;

    @Column(name = "TGA_CODE")
    private String codeTypeGarantie;

    @Column(name = "MTI_CODE")
    private String codeMetier;

    @Column(name = "CTI_CODE")
    private String codeClasseTipp;

    @Column(name = "CAT_VALORISE")
    private Integer valorise;

    @Column(name = "CAT_GEOLOC_AUTO")
    private Boolean geolocalisationAutoSite;

    @Column(name = "CAT_COEFCONSO", precision = 5, scale = 2)
    private BigDecimal coefficientConsommation;

    @Column(name = "CAT_INTRAGROUPE")
    private Integer intraGroupe;

    @Column(name = "CAT_TYPPAR")
    private Integer typeParticulier;

    @Column(name = "TAR_CODE")
    private String codeZoneTarifaire;

    @Column(name = "CAT_ACONSOLIDE")
    private Integer aconsolider;

    @Column(name = "CAT_MTASSUR")
    private Boolean montantAssureObligatoire;

    @Column(name = "CAT_CTRLTEL")
    private Boolean confrontationTelephonique;

    @ManyToOne(fetch = FetchType.EAGER)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumns({
            @JoinColumn(
                    name = "SOC_CODE",
                    referencedColumnName = "SOC_CODE",
                    insertable = false,
                    updatable = false),
            @JoinColumn(
                    name = "PAI_CODE",
                    referencedColumnName = "PAI_CODE",
                    insertable = false,
                    updatable = false)
    })
    private ModePaiement modePaiement;
}
