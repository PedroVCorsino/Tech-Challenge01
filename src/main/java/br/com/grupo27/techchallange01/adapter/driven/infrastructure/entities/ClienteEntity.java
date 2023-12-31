package br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities;

import br.com.grupo27.techchallange01.core.domain.model.Cliente;
import br.com.grupo27.techchallange01.core.domain.valuesObjects.ValidadorCPF;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;

@Entity
@Table(name = "CLIENTE")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @Column(name = "CPF")
    private ValidadorCPF cpf;  // *CPF é um objeto de valor validando o formato do CPF

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email; // TODO Email é um objeto de valor validando o formato do email

    protected ClienteEntity() {
        
    }

    public ClienteEntity(ValidadorCPF cpf, String nome, String email) {
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

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

    public void setCpf(ValidadorCPF cpf) {
        this.cpf = cpf;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Cliente toCliente() {
        return new Cliente(id, cpf, nome, email);
    }
}
