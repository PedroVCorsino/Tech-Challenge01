package br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories;


import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.ClienteEntity;
import br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories.JPA.ClienteRepositoryJPA;
import br.com.grupo27.techchallange01.core.domain.Cliente;
import br.com.grupo27.techchallange01.core.domain.ports.repository.ClienteRepositoryPort;

import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final ClienteRepositoryJPA ClienteJPA;

    public ClienteRepositoryAdapter(ClienteRepositoryJPA ClienteJPA) {
        this.ClienteJPA = ClienteJPA;
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        ClienteEntity clienteEntity = new ClienteEntity(cliente.getCpf(), cliente.getNome(), cliente.getEmail());
        clienteEntity = ClienteJPA.save(clienteEntity);
        return clienteEntity.toCliente();
    }

    @Override
    public Cliente updateCliente(Long id, Cliente cliente) {
        return ClienteJPA.findById(id).map(clienteEntity -> {
            clienteEntity.setCpf(cliente.getCpf());
            clienteEntity.setNome(cliente.getNome());
            clienteEntity.setEmail(cliente.getEmail());
            clienteEntity = ClienteJPA.save(clienteEntity);
            return clienteEntity.toCliente();
        }).orElse(null);
    }

    @Override
    public Cliente findById(Long id) {
        return ClienteJPA.findById(id).map(ClienteEntity::toCliente).orElse(null);
    }

    @Override
    public boolean deleteCliente(Long id) {
        if(ClienteJPA.existsById(id)) {
            ClienteJPA.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    @Override
    public List<Cliente> listAllClientes() {
        return ClienteJPA.findAll().stream()
                .map(ClienteEntity::toCliente)
                .collect(Collectors.toList());
    }
}
