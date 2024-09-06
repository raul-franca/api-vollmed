package voll.med.api.medico;

import voll.med.api.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome, String email, String telefone, String crm, Especialidade especialidade, DadosEndereco endereco) {

}



//
// "nome": "Luiz de França",
//         "email": "Luiz.franca@vollmed.com",
//    "telefone": "112233",
//    "crm": "101010",
//    "especialidade": "CARDIOLOGIA",
//    "endereco": {
//        "logradouro": "av. Bernardo Viera de mello",
//        "bairro": "candeis",
//        "cep": "12345678",
//        "numero": "1",
//        "complemento": "casa",
//        "cidade": "Recife",
//        "uf": "PE"
