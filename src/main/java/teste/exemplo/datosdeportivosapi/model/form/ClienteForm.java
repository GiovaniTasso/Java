package teste.exemplo.datosdeportivosapi.model.form;

import lombok.Data;

@Data
public class ClienteForm {
    private Long id;
    private String nome;
    private String cpf;
    private String profissao;
    private String endereco;
    private boolean status;

}
