package br.com.grupo27.techchallange01.core.application.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.grupo27.techchallange01.core.application.dto.ClienteDTO;
import br.com.grupo27.techchallange01.core.domain.model.Cliente;
import br.com.grupo27.techchallange01.core.domain.ports.repository.ClienteRepositoryPort;
import br.com.grupo27.techchallange01.core.domain.ports.service.ClienteService;
import br.com.grupo27.techchallange01.core.domain.valuesObjects.ValidadorCPF;

public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepositoryPort clienteRepository;

    public ClienteServiceImpl(ClienteRepositoryPort clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDTO createCliente(ClienteDTO clienteDTO) {
        String cpfString = clienteDTO.cpf().toString();
        if (!cpfString.isEmpty()) {
            ValidadorCPF cpf = new ValidadorCPF(cpfString);
            Cliente clienteExistente = clienteRepository.findByCpf(cpf);
            if (clienteExistente != null) {
                // O CPF já existe, você pode lançar uma exceção, retornar um erro ou lidar de acordo com a lógica do seu aplicativo
                throw new IllegalArgumentException("O CPF já está cadastrado.");
            }
        }

        Cliente cliente = clienteDTO.toCliente();
        cliente = clienteRepository.saveCliente(cliente);
        return cliente.toDTO();
    }

    @Override
    public ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO) {
        String cpfString = clienteDTO.cpf().toString();
        if (!cpfString.isEmpty()) {
            ValidadorCPF cpf = new ValidadorCPF(cpfString);
            Cliente clienteExistente = clienteRepository.findByCpf(cpf);
            if (clienteExistente != null && !clienteExistente.getId().equals(id)) {
                // O CPF já existe para outro cliente, você pode lançar uma exceção, retornar um erro ou lidar de acordo com a lógica do seu aplicativo
                throw new IllegalArgumentException("O CPF já está cadastrado para outro cliente.");
            }
        }

        Cliente cliente = clienteDTO.toCliente();
        cliente = clienteRepository.updateCliente(id, cliente);
        return cliente != null ? cliente.toDTO() : null;
    }



    @Override
    public ClienteDTO getClienteById(Long id) {
        Cliente cliente = clienteRepository.findById(id);
        return cliente != null ? cliente.toDTO() : null;
    }

    @Override
    public boolean deleteCliente(Long id) {
        return clienteRepository.deleteCliente(id);
    }

    @Override
    public List<ClienteDTO> getAllClientes() {
        return clienteRepository.listAllClientes().stream()
                .map(Cliente::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ClienteDTO getClienteByCPF(String cpfString) throws IllegalArgumentException {
        if (cpfString.isEmpty()) {
            throw new IllegalArgumentException("O CPF não pode ser vazio.");
        }

        try {
            ValidadorCPF cpf = new ValidadorCPF(cpfString);
            Cliente cliente = clienteRepository.findByCpf(cpf);
            return cliente != null ? cliente.toDTO() : null;
        } catch (IllegalArgumentException e) {
            throw e;
        }
    }

}
