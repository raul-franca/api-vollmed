package voll.med.api.medico;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import voll.med.api.endereco.DadosEndereco;

public record DadosCadastroMedico(

        @NotBlank
        String nome,

        @NotBlank
        @Email
        String email,

        String telefone,

        @NotBlank
        @Pattern(regexp = "^\\d{4,6}$", message = "O valor deve ter entre 4 e 6 dígitos.")
        String crm,

        @NotNull
        Especialidade especialidade,

        @NotNull
        @Valid
        DadosEndereco endereco

    ) {

}
