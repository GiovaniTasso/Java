package teste.exemplo.datosdeportivosapi.model.dto;

import jakarta.persistence.Id;
import teste.exemplo.datosdeportivosapi.model.entity.Cliente;

import lombok.Data;

@Data
public class ClienteDTO {

    @Id
    private Long id;
    private String nome;
    private String cpf;
    private String profissao;
    private String endereco;
    private boolean status;

    public ClienteDTO(){

    }
    public ClienteDTO(Cliente cliente){
        this.id = cliente.getId();
        this.nome = cliente.getNome();
        this.cpf = cliente.getCpf();
        this.profissao = cliente.getProfissao();
        this.endereco = cliente.getEndereco();
        this.status = cliente.isStatus();
    }
}
