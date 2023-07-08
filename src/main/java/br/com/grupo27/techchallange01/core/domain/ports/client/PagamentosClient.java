package br.com.grupo27.techchallange01.core.domain.ports.client;

public interface PagamentosClient {
    boolean consultaStatusPagamento(Long orderId);
}
