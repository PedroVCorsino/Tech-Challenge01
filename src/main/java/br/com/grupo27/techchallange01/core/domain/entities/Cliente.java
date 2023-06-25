package br.com.grupo27.techchallange01.core.domain.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

import br.com.grupo27.techchallange01.core.domain.valuesObjects.ValidadorCPF;

@Entity
@Table(name = "CLIENTE")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    @Embedded
    private ValidadorCPF cpf;  // CPF é um objeto de valor validando o formato do CPF

    private String nome;
    private String email; // Email é um objeto de valor validando o formato do email

    protected Cliente() {
        // para uso do JPA
    }

    public Cliente(ValidadorCPF cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    // getters

    public Long getId() {
        return id;
    }

    public ValidadorCPF getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public String getEmail() {
        return email;
    }

    // métodos de domínio
    // ...

    // equals, hashCode, toString
    // ...
}