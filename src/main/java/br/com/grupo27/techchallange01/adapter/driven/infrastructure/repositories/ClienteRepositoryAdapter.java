package br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories;


import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.ClienteEntity;
import br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories.JPA.ClienteRepository;
import br.com.grupo27.techchallange01.core.domain.Cliente;
import br.com.grupo27.techchallange01.core.domain.ports.repository.ClienteRepositoryPort;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final ClienteRepository clienteRepository;

    public ClienteRepositoryAdapter(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity(cliente.getCpf(), cliente.getNome(), cliente.getEmail());
        clienteEntity = clienteRepository.save(clienteEntity);
        return clienteEntity.toCliente();
    }

    @Override
    public Cliente updateCliente(Long id, Cliente cliente) {
        return clienteRepository.findById(id).map(clienteEntity -> {
            clienteEntity.setCpf(cliente.getCpf());
            clienteEntity.setNome(cliente.getNome());
            clienteEntity.setEmail(cliente.getEmail());
            clienteEntity = clienteRepository.save(clienteEntity);
            return clienteEntity.toCliente();
        }).orElse(null);
    }

    @Override
    public Cliente findById(Long id) {
        return clienteRepository.findById(id).map(ClienteEntity::toCliente).orElse(null);
    }

    @Override
    public boolean deleteCliente(Long id) {
        if(clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Cliente> listAllClientes() {
        return clienteRepository.findAll().stream()
                .map(ClienteEntity::toCliente)
                .collect(Collectors.toList());
    }
}
