package br.com.grupo27.techchallange01.dto;

import br.com.grupo27.techchallange01.domain.valueObjects.CPF;

public record ClienteDTO(Long id, CPF cpf, String nome, String email) {
}
