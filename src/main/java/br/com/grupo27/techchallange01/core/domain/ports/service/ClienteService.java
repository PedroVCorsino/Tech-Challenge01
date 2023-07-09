package br.com.grupo27.techchallange01.core.domain.ports.service;

import java.util.List;

import br.com.grupo27.techchallange01.core.application.dto.ClienteDTO;
import br.com.grupo27.techchallange01.core.domain.valuesObjects.ValidadorCPF;

public interface ClienteService {

    ClienteDTO getClienteById(Long id);

    List<ClienteDTO> getAllClientes();

    ClienteDTO createCliente(ClienteDTO clienteDTO);

    ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO);

    boolean deleteCliente(Long id);

    ClienteDTO getClienteByCPF(String cpf);
    
}