package br.com.grupo27.techchallange01.core.domain.ports.repository;

import java.util.List;

import br.com.grupo27.techchallange01.core.domain.model.Sobremesa;

public interface SobremesaRepositoryPort {
    Sobremesa saveSobremesa(Sobremesa sobremesa);
    Sobremesa updateSobremesa(Long id, Sobremesa sobremesa);
    Sobremesa findSobremesaById(Long id);
    boolean deleteSobremesa(Long id);
    List<Sobremesa> listAllSobremesas();
}
