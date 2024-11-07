package voll.med.api.paciente;

import jakarta.validation.constraints.NotNull;
import voll.med.api.endereco.DadosEndereco;


public record DadosAtualizarPaciente(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        DadosEndereco endereco) {
}
