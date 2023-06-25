package br.com.grupo27.techchallange01.core.application.dto;

import br.com.grupo27.techchallange01.core.domain.valuesObjects.CPF;

public record ClienteDTO(Long id, CPF cpf, String nome, String email) {}