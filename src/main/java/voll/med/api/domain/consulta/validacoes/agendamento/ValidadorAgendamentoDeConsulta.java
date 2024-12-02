package voll.med.api.domain.consulta.validacoes.agendamento;


import voll.med.api.domain.consulta.dto.DadosAgendamentoConsulta;

public interface ValidadorAgendamentoDeConsulta {
    void validar(DadosAgendamentoConsulta dados);
}
