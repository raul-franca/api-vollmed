package voll.med.api.medico;

import jakarta.validation.constraints.NotNull;
import voll.med.api.endereco.DadosEndereco;


public record DadosAtualizarMedico(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        DadosEndereco endereco) {

}
