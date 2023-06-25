package br.com.grupo27.techchallange01.core.domain.valuesObjects;

import java.util.Objects;

public class ValidadorCPF {

  private String valor;

  public ValidadorCPF(String valor) {
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
    ValidadorCPF cpf = (ValidadorCPF) o;
    return valor.equals(cpf.valor);
  }

  @Override
  public int hashCode() {
    return Objects.hash(valor);
  }

  public static boolean validarDigitosVerificadores(String valor) {
    // Verifica se o CPF não tem uma sequência de números iguais
    if (valor.equals("00000000000")
        || valor.equals("11111111111")
        || valor.equals("22222222222")
        || valor.equals("33333333333")
        || valor.equals("44444444444")
        || valor.equals("55555555555")
        || valor.equals("66666666666")
        || valor.equals("77777777777")
        || valor.equals("88888888888")
        || valor.equals("99999999999")
        || (valor.length() != 11)) return (false);

    char dig10, dig11;
    int soma, i, r, num, peso;

    // Calcula o primeiro dígito verificador
    soma = 0;
    peso = 10;
    for (i = 0; i < 9; i++) {
      num = (int) (valor.charAt(i) - 48);
      soma = soma + (num * peso);
      peso = peso - 1;
    }

    r = 11 - (soma % 11);
    if ((r == 10) || (r == 11)) dig10 = '0';
    else dig10 = (char) (r + 48);

    // Calcula o segundo dígito verificador
    soma = 0;
    peso = 11;
    for (i = 0; i < 10; i++) {
      num = (int) (valor.charAt(i) - 48);
      soma = soma + (num * peso);
      peso = peso - 1;
    }

    r = 11 - (soma % 11);
    if ((r == 10) || (r == 11)) dig11 = '0';
    else dig11 = (char) (r + 48);

    // Verifica se os dígitos calculados conferem com os dígitos informados
    if ((dig10 == valor.charAt(9)) && (dig11 == valor.charAt(10))) return (true);
    else return (false);
  }
}
