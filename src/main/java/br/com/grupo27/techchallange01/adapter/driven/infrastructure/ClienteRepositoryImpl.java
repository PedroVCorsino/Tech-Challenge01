package br.com.grupo27.techchallange01.adapter.driven.infrastructure;

import java.util.List;

import org.springframework.stereotype.Repository;

import br.com.grupo27.techchallange01.core.application.dto.ClienteDTO;
import br.com.grupo27.techchallange01.core.application.repositories.ClienteRepository;

@Repository
public class ClienteRepositoryImpl implements ClienteRepository {

    @Override
    public ClienteDTO findClienteById(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'findClienteById'");
    }

    @Override
    public List<ClienteDTO> listAllClientes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'listAllClientes'");
    }

    @Override
    public ClienteDTO saveCliente(ClienteDTO clienteDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'saveCliente'");
    }

    @Override
    public ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCliente'");
    }

    @Override
    public boolean deleteCliente(Long id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCliente'");
    }
    
}
