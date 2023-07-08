package br.com.grupo27.techchallange01.core.domain.ports.repository;

import java.util.List;

import br.com.grupo27.techchallange01.core.domain.model.Cliente;
import br.com.grupo27.techchallange01.core.domain.valuesObjects.ValidadorCPF;

public interface ClienteRepositoryPort {
    Cliente saveCliente(Cliente clienteDTO);
    Cliente updateCliente(Long id, Cliente clienteDTO);
    Cliente findById(Long id);
    boolean deleteCliente(Long id);
    List<Cliente> listAllClientes();
    Cliente findByCpf(ValidadorCPF cpf);
}