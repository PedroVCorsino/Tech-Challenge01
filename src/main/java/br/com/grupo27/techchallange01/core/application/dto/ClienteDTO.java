package br.com.grupo27.techchallange01.core.application.dto;

import br.com.grupo27.techchallange01.core.domain.Cliente;
import br.com.grupo27.techchallange01.core.domain.valuesObjects.ValidadorCPF;

public record ClienteDTO(Long id, ValidadorCPF cpf, String nome, String email) {
    public Cliente toCliente() {
        return new Cliente(this.id, this.cpf, this.nome, this.email);
    }
}