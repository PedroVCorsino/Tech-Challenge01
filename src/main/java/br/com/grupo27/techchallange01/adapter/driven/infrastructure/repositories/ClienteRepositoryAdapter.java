package br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories;


import br.com.grupo27.techchallange01.adapter.driven.infrastructure.entities.ClienteEntity;
import br.com.grupo27.techchallange01.adapter.driven.infrastructure.repositories.JPA.ClienteJPA;
import br.com.grupo27.techchallange01.core.domain.model.Cliente;
import br.com.grupo27.techchallange01.core.domain.ports.repository.ClienteRepositoryPort;

import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.stream.Collectors;

@Repository
public class ClienteRepositoryAdapter implements ClienteRepositoryPort {

    private final ClienteJPA ClienteJPA;

    public ClienteRepositoryAdapter(ClienteJPA ClienteJPA) {
        this.ClienteJPA = ClienteJPA;
    }

    @Override
    public Cliente saveCliente(Cliente cliente) {
        try {
            ClienteEntity clienteEntity = ClienteJPA.save(cliente.toEntity());
            return clienteEntity.toCliente();
        } catch (Exception e) {
            e.printStackTrace();
            // Lidar com o caso em que a entidade não foi salva corretamente
            throw new RuntimeException("Falha ao salvar o cliente no banco de dados.");
        }
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
