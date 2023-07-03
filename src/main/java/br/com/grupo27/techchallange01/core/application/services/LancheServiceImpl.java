package br.com.grupo27.techchallange01.core.application.services;

import java.util.List;
import java.util.stream.Collectors;


import br.com.grupo27.techchallange01.config.mappers.produtos.LancheMapper;
import br.com.grupo27.techchallange01.core.application.dto.LancheDTO;
import br.com.grupo27.techchallange01.core.domain.model.Lanche;
import br.com.grupo27.techchallange01.core.domain.ports.repository.LancheRepositoryPort;
import br.com.grupo27.techchallange01.core.domain.ports.service.LancheService;

public class LancheServiceImpl implements LancheService {

    private final LancheRepositoryPort lancheRepository;
    private final LancheMapper lancheMapper;

    public LancheServiceImpl(LancheRepositoryPort lancheRepository, LancheMapper lancheMapper) {
        this.lancheRepository = lancheRepository;
        this.lancheMapper = lancheMapper;
    }

    @Override
    public LancheDTO createLanche(LancheDTO lancheDTO) {
        Lanche lanche = lancheMapper.dtoToDomain(lancheDTO);
        lanche = lancheRepository.saveLanche(lanche);
        return lancheMapper.domainToDto(lanche);
    }

    @Override
    public LancheDTO updateLanche(Long id, LancheDTO lancheDTO) {
        Lanche lanche = lancheMapper.dtoToDomain(lancheDTO);
        lanche = lancheRepository.updateLanche(id, lanche);
        return lanche != null ? lancheMapper.domainToDto(lanche) : null;
    }

    @Override
    public LancheDTO getLancheById(Long id) {
        Lanche lanche = lancheRepository.findLancheById(id);
        return lanche != null ? lancheMapper.domainToDto(lanche) : null;
    }

    @Override
    public boolean deleteLanche(Long id) {
        return lancheRepository.deleteLanche(id);
    }

    @Override
    public List<LancheDTO> getAllLanches() {
        return lancheRepository.listAllLanches().stream()
                .map(lancheMapper::domainToDto)
                .collect(Collectors.toList());
    }
}
