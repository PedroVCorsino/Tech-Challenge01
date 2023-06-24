package br.com.grupo27.techchallange01.domain.valueObjects;

import java.util.Objects;

public class CPF {

    private String valor;

    public CPF(String valor) {
        if (valor == null || !valor.matches("\\d{11}") || !validarDigitosVerificadores(valor)) {
            throw new IllegalArgumentException("CPF inválido");
        }
        this.valor = valor;
    }

    public String getValor() {
        return valor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CPF cpf = (CPF) o;
        return valor.equals(cpf.valor);
    }

    @Override
    public int hashCode() {
        return Objects.hash(valor);
    }

    private static boolean validarDigitosVerificadores(String valor) {
        // TODO Implementação da validação dos dígitos verificadores do CPF
        return true;
    }

}

