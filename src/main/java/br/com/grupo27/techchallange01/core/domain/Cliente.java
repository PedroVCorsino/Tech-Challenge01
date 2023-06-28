package br.com.grupo27.techchallange01.core.domain;

import br.com.grupo27.techchallange01.core.application.dto.ClienteDTO;
import br.com.grupo27.techchallange01.core.domain.valuesObjects.ValidadorCPF;

public class Cliente {
    private Long id;
    private ValidadorCPF cpf;
    private String nome;
    private String email;

    public Cliente() {}
    public Cliente(Long id, ValidadorCPF cpf, String nome, String email) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public Cliente(ClienteDTO clienteDTO) {
        this.id = clienteDTO.id();
        this.cpf = clienteDTO.cpf();
        this.nome = clienteDTO.nome();
        this.email = clienteDTO.email();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public ValidadorCPF getCpf() {
        return cpf;
    }

    public void setCpf(ValidadorCPF cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ClienteDTO toDTO() {
        return new ClienteDTO(this.id, this.cpf, this.nome, this.email);
    }
}
