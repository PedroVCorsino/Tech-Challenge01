package br.com.grupo27.techchallange01.core.domain.ports.repository;

import java.util.List;

import br.com.grupo27.techchallange01.core.domain.Cliente;

public interface ClienteRepositoryPort {
    Cliente saveCliente(Cliente clienteDTO);
    Cliente updateCliente(Long id, Cliente clienteDTO);
    Cliente findById(Long id);
    boolean deleteCliente(Long id);
    List<Cliente> listAllClientes();
}