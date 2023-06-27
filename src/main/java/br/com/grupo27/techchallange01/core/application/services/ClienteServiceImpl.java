package br.com.grupo27.techchallange01.core.application.services;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import br.com.grupo27.techchallange01.core.application.dto.ClienteDTO;
import br.com.grupo27.techchallange01.core.domain.Cliente;
import br.com.grupo27.techchallange01.core.domain.ports.repository.ClienteRepositoryPort;
import br.com.grupo27.techchallange01.core.domain.ports.services.ClienteService;

@Service
public class ClienteServiceImpl implements ClienteService {

    private final ClienteRepositoryPort clienteRepository;

    public ClienteServiceImpl(ClienteRepositoryPort clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    @Override
    public ClienteDTO createCliente(ClienteDTO clienteDTO) {
        Cliente cliente = clienteDTO.toCliente();
        cliente = clienteRepository.saveCliente(cliente);
        return cliente.toDTO();
    }

    @Override
    public ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO) {
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
}
