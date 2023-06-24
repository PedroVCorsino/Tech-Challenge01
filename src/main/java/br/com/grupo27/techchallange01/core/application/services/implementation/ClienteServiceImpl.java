package br.com.grupo27.techchallange01.core.application.services.implementation;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.grupo27.techchallange01.core.application.dto.ClienteDTO;
import br.com.grupo27.techchallange01.core.application.repositories.ClienteRepository;
import br.com.grupo27.techchallange01.core.application.services.interfaces.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Override
    public ClienteDTO getClienteById(Long id) {
        // TODO Inserir a logica nescessaria para buscar por um cliente
        return clienteRepository.findClienteById(id);
    }
    
    @Override
    public List<ClienteDTO> getAllClientes() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllClientes'");
    }

    @Override
    public ClienteDTO createCliente(ClienteDTO clienteDTO) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'createCliente'");
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
