package teste.exemplo.datosdeportivosapi.controller;

import java.util.Collections;
import java.util.List;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import teste.exemplo.datosdeportivosapi.model.dto.ClienteDTO;
import teste.exemplo.datosdeportivosapi.model.entity.Cliente;
import teste.exemplo.datosdeportivosapi.model.form.ClienteForm;
import teste.exemplo.datosdeportivosapi.service.ClienteService;

@RestController
@RequestMapping("/cliente")
public class ClienteController {

    @Autowired
    private ClienteService clienteService;

    @PostMapping
    public ClienteDTO salvar(@RequestBody @Valid ClienteForm clienteForm){
        return clienteService.createCliente(clienteForm);

    }
    @GetMapping
    public List<ClienteDTO> list(){
        return clienteService.findAllCliente();
    }

    @GetMapping("/{id}")
    public ClienteDTO findById(@PathVariable("id") Long id){
        return clienteService.findClienteById(id);
    }
    @GetMapping(value = "/status")
    public List<List<Cliente>> findByStatus(){
        List<Cliente> clientes = clienteService.findStatus();
        return Collections.singletonList(clientes);
    }

    @GetMapping(value = "/statusFalse")
    public List<List<Cliente>> findByStatusFalse(){
        List<Cliente> clientes = clienteService.findStatusFalse();
        return Collections.singletonList(clientes);
    }
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable("id") Long id){
        clienteService.deleteById(id);
    }

}





