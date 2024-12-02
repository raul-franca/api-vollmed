package voll.med.api.domain.consulta.validacoes.agendamento;

import voll.med.api.domain.ValidacaoException;
import voll.med.api.domain.consulta.ConsultaRepository;
import voll.med.api.domain.consulta.dto.DadosAgendamentoConsulta;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoComOutraConsultaMesnoHorario implements ValidadorAgendamentoDeConsulta {
    @Autowired
    private ConsultaRepository repository;

    public void validar(DadosAgendamentoConsulta dados){
        var medicoPossuiConsultaNoMesmoHorario = repository.existsByMedicoIdAndData(dados.idMedico(), dados.data());
        if (medicoPossuiConsultaNoMesmoHorario){
            throw new ValidacaoException("Medico ja possui outra consulta neste horario!");
        }

    }
}
