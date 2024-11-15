package voll.med.api.domain.paciente;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import voll.med.api.domain.endereco.DadosEndereco;


public record DadosCadastroPaciente(

        @NotBlank
        String nome,

        @NotBlank
        @Pattern(regexp = "^\\d{11,15}$", message = "O CPF deve ter 11 dígitos.")
        String cpf,

        @NotBlank
        @Email
        String email,

        String telefone,

        @NotNull
        @Valid
        DadosEndereco endereco

    ) {

}

