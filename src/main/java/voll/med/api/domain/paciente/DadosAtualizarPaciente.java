package voll.med.api.domain.paciente;

import jakarta.validation.constraints.NotNull;
import voll.med.api.domain.endereco.DadosEndereco;


public record DadosAtualizarPaciente(
        @NotNull
        Long id,
        String nome,
        String email,
        String telefone,
        DadosEndereco endereco) {
}
