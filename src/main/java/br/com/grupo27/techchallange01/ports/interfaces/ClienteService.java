package br.com.grupo27.techchallange01.ports.interfaces;

import java.util.List;

import br.com.grupo27.techchallange01.dto.ClienteDTO;

public interface ClienteService {

    ClienteDTO getClienteById(Long id);

    List<ClienteDTO> getAllClientes();

    ClienteDTO createCliente(ClienteDTO clienteDTO);

    ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO);

    boolean deleteCliente(Long id);
    
}
