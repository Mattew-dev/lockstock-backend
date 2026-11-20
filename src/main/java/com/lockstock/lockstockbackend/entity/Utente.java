package com.lockstock.lockstockbackend.entity;

import com.lockstock.lockstockbackend.entity.enums.Privilegi;
import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="m_utente")
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name="nome", nullable = false, length = 50)
    private String nome;

    @Column(name="cognome", nullable = false, length = 50)
    private String cognome;

    @Column(name="email", nullable = false, unique = true)
    private String email;

    @Column(name="hashpwd", nullable = true, length = 255)
    private String hashpwd;

    @Column(name="enabled", nullable = false)
    private Boolean enabled=true;

    @Enumerated(EnumType.STRING)
    @Column(name="privilegi", nullable = false)
    private Privilegi privilegi = Privilegi.UTENTE;

    @Column(name = "created", nullable = false, updatable = false)
    private LocalDateTime created;

    @Column(name="lastlogin")
    private LocalDateTime lastlogin;

    protected Utente(){}

    public Utente(String nome, String cognome, String email){
        this.nome = nome;
        this.cognome = cognome;
        this.email = email;
    }

    @PrePersist
    void onCreate(){
        if(created == null) created = LocalDateTime.now();
    }


    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setHashpwd(String hashpwd) {
        this.hashpwd = hashpwd;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public void setPrivilegi(Privilegi privilegi) {
        this.privilegi = privilegi;
    }

    public void setLastlogin(LocalDateTime lastlogin) {
        this.lastlogin = lastlogin;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getCognome() {
        return cognome;
    }

    public String getEmail() {
        return email;
    }

    public String getHashpwd() {
        return hashpwd;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public Privilegi getPrivilegi() {
        return privilegi;
    }

    public LocalDateTime getCreated() {
        return created;
    }

    public LocalDateTime getLastlogin() {
        return lastlogin;
    }

}
