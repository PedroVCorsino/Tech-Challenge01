package br.com.grupo27.techchallange01.core.application.clients;

import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import br.com.grupo27.techchallange01.core.domain.ports.client.PagamentosClient;
import reactor.core.publisher.Mono;

public class PagamentosClientImpl implements PagamentosClient {

    private final WebClient webClient;

    public PagamentosClientImpl(WebClient.Builder webClientBuilder) {
        this.webClient = webClientBuilder.baseUrl("http://mercado-pago-api.com").build();
    }

    @Override
    public boolean consultaStatusPagamento(Long orderId) {
        // Simulando uma chamada HTTP, o resultado não é usado por enquanto sempre retorna true
        try {
            webClient.get()
                    .uri("/check-payment/" + orderId)
                    .retrieve()
                    .bodyToMono(Boolean.class)
                    .block();
        } catch (Exception e) {
            // Lida com qualquer exceção lançada pela chamada do serviço externo
        }

        // Por enquanto o sucesso ou falha da chamada acima não importa, sempre retorna true
        Mono<Boolean> responseSimulado = Mono.just(true);
        Boolean result = responseSimulado.block();
        return result;
    }

}