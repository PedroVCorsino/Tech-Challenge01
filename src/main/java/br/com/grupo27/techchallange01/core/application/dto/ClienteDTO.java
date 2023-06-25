package br.com.grupo27.techchallange01.core.application.dto;

import br.com.grupo27.techchallange01.core.domain.valuesObjects.ValidadorCPF;

public record ClienteDTO(Long id, ValidadorCPF cpf, String nome, String email) {}