package br.com.grupo27.techchallange01.core.domain.ports.repository;

import java.util.List;

import br.com.grupo27.techchallange01.core.domain.Acompanhamento;

public interface AcompanhamentoRepositoryPort {
    Acompanhamento saveAcompanhamento(Acompanhamento acompanhamento);
    Acompanhamento updateAcompanhamento(Long id, Acompanhamento acompanhamento);
    Acompanhamento findAcompanhamentoById(Long id);
    boolean deleteAcompanhamento(Long id);
    List<Acompanhamento> listAllAcompanhamentos();
}
