package br.com.grupo27.techchallange01.core.application.repositories;

import java.util.List;

import br.com.grupo27.techchallange01.core.application.dto.ClienteDTO;

public interface ClienteRepository {

    ClienteDTO findClienteById(Long id);

    List<ClienteDTO> listAllClientes();

    ClienteDTO saveCliente(ClienteDTO clienteDTO);

    ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO);

    boolean deleteCliente(Long id);
    
}