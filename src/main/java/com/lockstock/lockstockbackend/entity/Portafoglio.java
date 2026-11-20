package com.lockstock.lockstockbackend.entity;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name="m_portafoglio")
public class Portafoglio {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome", nullable = true, length = 100)
    private String nome;

    @Column(name="numero", nullable = false, length = 20, unique = true)
    private String numero;

    @Column(name="saldo", nullable = false, precision = 9, scale = 2)
    private BigDecimal saldo = BigDecimal.ZERO;

    @Column(name="created", nullable = false, updatable = false)
    private LocalDateTime created;

    @ManyToOne(fetch=FetchType.LAZY, optional = false)
    @JoinColumn(name="fk_utente", nullable = false)
    private Utente utente;

    protected Portafoglio(){}

    public Portafoglio(String numero, Utente utente){
        this.numero=numero;
        this.utente=utente;
    }

    @PrePersist
    void onCreate(){
        if(created == null) created = LocalDateTime.now();
    }


    public void setSaldo(BigDecimal saldo) {
        this.saldo = saldo;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getNumero() {
        return numero;
    }

    public BigDecimal getSaldo() {
        return saldo;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public Utente getUtente() {
        return utente;
    }
}
