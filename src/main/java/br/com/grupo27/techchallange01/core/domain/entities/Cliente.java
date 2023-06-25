package br.com.grupo27.techchallange01.core.domain.entities;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import br.com.grupo27.techchallange01.core.domain.valuesObjects.CPF;

@Entity
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    
    private CPF cpf;  // CPF é um objeto de valor validando o formato do CPF
    private String nome;
    private String email; // Email é um objeto de valor validando o formato do email

    protected Cliente() {
        // para uso do JPA
    }

    public Cliente(CPF cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    // getters

    public Long getId() {
        return id;
    }

    public CPF getCpf() {
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