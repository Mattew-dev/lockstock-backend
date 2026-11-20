package com.lockstock.lockstockbackend.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;
import jakarta.persistence.Table;

import java.math.BigDecimal;

@Entity
@Table(name="m_azione")
@PrimaryKeyJoinColumn(name="id")
public class Azione extends Titolo{

    @Column(name="capitalizzazione", precision = 15, scale = 2)
    private BigDecimal capitalizzazione;

    @Column(name="paese", length = 50)
    private String paese;

    @Column(name="settore", length = 50)
    private String settore;

    @Column(name="dividendo_yield", precision = 5, scale = 2)
    private BigDecimal dividendoYield;

    protected Azione(){}


    public void setCapitalizzazione(BigDecimal capitalizzazione) {
        this.capitalizzazione = capitalizzazione;
    }

    public void setPaese(String paese) {
        this.paese = paese;
    }

    public void setSettore(String settore) {
        this.settore = settore;
    }

    public void setDividendoYield(BigDecimal dividendoYield) {
        this.dividendoYield = dividendoYield;
    }

    public BigDecimal getCapitalizzazione() {
        return capitalizzazione;
    }

    public String getPaese() {
        return paese;
    }

    public String getSettore() {
        return settore;
    }

    public BigDecimal getDividendoYield() {
        return dividendoYield;
    }
}
