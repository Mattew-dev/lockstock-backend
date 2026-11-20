package com.lockstock.lockstockbackend.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="m_posizione",
    uniqueConstraints = @UniqueConstraint(
            name = "uk_posizione_portafoglio_titolo",
            columnNames = {"fk_portafoglio", "fk_titolo"}
    )
)
public class Posizione {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="fk_portafoglio", nullable = false)
    private Portafoglio portafoglio;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name="fk_titolo", nullable = false)
    private Titolo titolo;

    @Column(name="quantita_totale", nullable = false)
    private Integer quantitaTotale=0;

    @Column(name="prezzo_medio_carico", nullable = false, precision = 9, scale = 2)
    private BigDecimal prezzoMedioCarico;

    @Column(name="data_ultimo_aggiornamento", nullable = false)
    private LocalDateTime dataUltimoAggiornamento;

    protected Posizione(){}

    public Posizione(Portafoglio portafoglio, Titolo titolo, Integer quantitaTotale, BigDecimal prezzoMedioCarico){
        this.portafoglio=portafoglio;
        this.titolo=titolo;
        this.quantitaTotale=quantitaTotale;
        this.prezzoMedioCarico=prezzoMedioCarico;
    }

    @PrePersist
    @PreUpdate
    void aggiornaData(){
        dataUltimoAggiornamento=LocalDateTime.now();
    }

    public void setQuantitaTotale(Integer quantitaTotale) {
        this.quantitaTotale = quantitaTotale;
    }

    public void setPrezzoMedioCarico(BigDecimal prezzoMedioCarico) {
        this.prezzoMedioCarico = prezzoMedioCarico;
    }

    public Long getId() {
        return id;
    }

    public Portafoglio getPortafoglio() {
        return portafoglio;
    }

    public Titolo getTitolo() {
        return titolo;
    }

    public Integer getQuantitaTotale() {
        return quantitaTotale;
    }

    public BigDecimal getPrezzoMedioCarico() {
        return prezzoMedioCarico;
    }

    public LocalDateTime getDataUltimoAggiornamento() {
        return dataUltimoAggiornamento;
    }
}
