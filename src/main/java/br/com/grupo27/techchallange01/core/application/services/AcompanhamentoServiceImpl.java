package br.com.grupo27.techchallange01.core.application.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.grupo27.techchallange01.core.application.dto.AcompanhamentoDTO;
import br.com.grupo27.techchallange01.core.domain.model.Acompanhamento;
import br.com.grupo27.techchallange01.core.domain.ports.repository.AcompanhamentoRepositoryPort;
import br.com.grupo27.techchallange01.core.domain.ports.service.AcompanhamentoService;

@Service
public class AcompanhamentoServiceImpl implements AcompanhamentoService {

    private final AcompanhamentoRepositoryPort acompanhamentoRepository;

    public AcompanhamentoServiceImpl(AcompanhamentoRepositoryPort acompanhamentoRepository) {
        this.acompanhamentoRepository = acompanhamentoRepository;
    }

    @Override
    public AcompanhamentoDTO createAcompanhamento(AcompanhamentoDTO acompanhamentoDTO) {
        Acompanhamento acompanhamento = acompanhamentoDTO.toAcompanhamento();
        acompanhamento = acompanhamentoRepository.saveAcompanhamento(acompanhamento);
        return acompanhamento.toDTO();
    }

    @Override
    public AcompanhamentoDTO updateAcompanhamento(Long id, AcompanhamentoDTO acompanhamentoDTO) {
        Acompanhamento acompanhamento = acompanhamentoDTO.toAcompanhamento();
        acompanhamento = acompanhamentoRepository.updateAcompanhamento(id, acompanhamento);
        return acompanhamento != null ? acompanhamento.toDTO() : null;
    }

    @Override
    public AcompanhamentoDTO getAcompanhamentoById(Long id) {
        Acompanhamento acompanhamento = acompanhamentoRepository.findAcompanhamentoById(id);
        return acompanhamento != null ? acompanhamento.toDTO() : null;
    }

    @Override
    public boolean deleteAcompanhamento(Long id) {
        return acompanhamentoRepository.deleteAcompanhamento(id);
    }

    @Override
    public List<AcompanhamentoDTO> getAllAcompanhamentos() {
        return acompanhamentoRepository.listAllAcompanhamentos().stream()
                .map(Acompanhamento::toDTO)
                .collect(Collectors.toList());
    }
}
