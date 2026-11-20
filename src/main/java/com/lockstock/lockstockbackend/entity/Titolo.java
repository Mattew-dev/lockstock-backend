package com.lockstock.lockstockbackend.entity;

import com.lockstock.lockstockbackend.entity.enums.Valuta;
import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name="m_titolo")
@Inheritance(strategy= InheritanceType.JOINED)
public abstract class Titolo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome", nullable = false, length = 100)
    private String nome;

    @Column(name="descrizione", nullable = true, length = 1000)
    private String descrizione;

    @Column(name="isin", nullable = false, unique = true, columnDefinition = "CHAR(12)")
    private String isin;

    @Column(name="ticker", nullable = false, unique = true, length = 10)
    private String ticker;

    @Enumerated(EnumType.STRING)
    @Column(name="valuta", nullable = false)
    private Valuta valuta;

    @Column(name="quotazione", nullable = false, precision = 9, scale = 2)
    private BigDecimal quotazione;

    @Column(name="quantita_disponibile", nullable = false)
    private Integer quantitaDisponibile=0;

    protected Titolo(){}

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }

    public void setIsin(String isin) {
        this.isin = isin;
    }

    public void setTicker(String ticker) {
        this.ticker = ticker;
    }

    public void setValuta(Valuta valuta) {
        this.valuta = valuta;
    }

    public void setQuotazione(BigDecimal quotazione) {
        this.quotazione = quotazione;
    }

    public void setQuantitaDisponibile(Integer quantitaDisponibile) {
        this.quantitaDisponibile = quantitaDisponibile;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public String getIsin() {
        return isin;
    }

    public String getTicker() {
        return ticker;
    }

    public Valuta getValuta() {
        return valuta;
    }

    public BigDecimal getQuotazione() {
        return quotazione;
    }

    public Integer getQuantitaDisponibile() {
        return quantitaDisponibile;
    }
}
