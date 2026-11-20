package com.lockstock.lockstockbackend.entity;

import com.lockstock.lockstockbackend.entity.enums.PoliticaDistribuzione;
import com.lockstock.lockstockbackend.entity.enums.Replica;
import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDate;

@Entity
@Table(name="m_etf")
@PrimaryKeyJoinColumn(name="id")
public class Etf extends Titolo{

    @Column(name="ter", precision = 4, scale=2)
    private BigDecimal ter;

    @Enumerated(EnumType.STRING)
    @Column(name="politica_distribuzione")
    private PoliticaDistribuzione politicaDistribuzione;

    @Enumerated(EnumType.STRING)
    @Column(name="replica")
    private Replica replica;

    @Column(name="emittente", length = 100)
    private String emittente;

    @Column(name="dimensione_fondo", precision = 15, scale=2)
    private BigDecimal dimensioneFondo;

    @Column(name="data_lancio")
    private LocalDate dataLancio;

    @Column(name="partecipazione")
    private Integer partecipazione;

    protected Etf(){}


    public void setTer(BigDecimal ter) {
        this.ter = ter;
    }

    public void setPoliticaDistribuzione(PoliticaDistribuzione politicaDistribuzione) {
        this.politicaDistribuzione = politicaDistribuzione;
    }

    public void setReplica(Replica replica) {
        this.replica = replica;
    }

    public void setEmittente(String emittente) {
        this.emittente = emittente;
    }

    public void setDimensioneFondo(BigDecimal dimensioneFondo) {
        this.dimensioneFondo = dimensioneFondo;
    }

    public void setDataLancio(LocalDate dataLancio) {
        this.dataLancio = dataLancio;
    }

    public void setPartecipazione(Integer partecipazione) {
        this.partecipazione = partecipazione;
    }

    public BigDecimal getTer() {
        return ter;
    }

    public PoliticaDistribuzione getPoliticaDistribuzione() {
        return politicaDistribuzione;
    }

    public Replica getReplica() {
        return replica;
    }

    public String getEmittente() {
        return emittente;
    }

    public BigDecimal getDimensioneFondo() {
        return dimensioneFondo;
    }

    public LocalDate getDataLancio() {
        return dataLancio;
    }

    public Integer getPartecipazione() {
        return partecipazione;
    }
}
