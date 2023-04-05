package teste.exemplo.datosdeportivosapi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import teste.exemplo.datosdeportivosapi.model.dto.ClienteDTO;
import teste.exemplo.datosdeportivosapi.model.entity.Cliente;
import teste.exemplo.datosdeportivosapi.model.form.ClienteForm;
import teste.exemplo.datosdeportivosapi.repository.ClienteRepository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClienteService {

    @Autowired
    ClienteRepository clienteRepository;

    public ClienteDTO createCliente(ClienteForm form) {
        Cliente cliente = convertToRequest(form);
        cliente = clienteRepository.save(cliente);
        return convertToResponse(cliente);
    }

    public List<ClienteDTO> findAllCliente() {
        List<Cliente> all = clienteRepository.findAll();
        return convertListToResponse(all);

    }

    public ClienteDTO findClienteById(Long id){
        Optional<Cliente> optional = clienteRepository.findById(id);
        return optional.map(this::convertToResponse).orElse(null);
    }

    public void deleteById(Long id){
        if(clienteRepository.existsById(id)){
            clienteRepository.deleteById(id);
        }
    }
    public List<Cliente> findStatus() {
        return clienteRepository.findByStatus(true);
    }
    public List<Cliente> findStatusFalse() {
        return clienteRepository.findByStatus(false);
    }

    private Cliente convertToRequest(ClienteForm form) {
        Cliente cliente = new Cliente();
        cliente.setId(form.getId());
        cliente.setNome(form.getNome());
        cliente.setCpf(form.getCpf());
        cliente.setProfissao(form.getProfissao());
        cliente.setEndereco(form.getEndereco());
        cliente.setStatus(form.isStatus());
        return cliente;
    }

    private ClienteDTO convertToResponse(Cliente cliente) {
        ClienteDTO dto = new ClienteDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());
        dto.setCpf(cliente.getCpf());
        dto.setProfissao(cliente.getProfissao());
        dto.setEndereco(cliente.getEndereco());
        dto.setStatus(cliente.isStatus());
        return dto;

    }

    private static List<ClienteDTO> convertListToResponse(List<Cliente> clientes){
        return clientes.stream().map(ClienteDTO::new).collect(Collectors.toList());
    }

}








