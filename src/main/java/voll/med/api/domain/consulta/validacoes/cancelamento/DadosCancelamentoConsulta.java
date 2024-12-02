package voll.med.api.domain.consulta.validacoes.cancelamento;


import jakarta.validation.constraints.NotNull;
import voll.med.api.domain.consulta.MotivoCancelamento;

public record DadosCancelamentoConsulta(
        @NotNull
        Long idConsulta,
        @NotNull
        MotivoCancelamento motivo) {

}