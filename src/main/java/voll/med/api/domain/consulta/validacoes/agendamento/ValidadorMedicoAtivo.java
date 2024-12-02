package voll.med.api.domain.consulta.validacoes.agendamento;

import voll.med.api.domain.ValidacaoException;
import voll.med.api.domain.consulta.dto.DadosAgendamentoConsulta;
import voll.med.api.domain.medico.MedicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorMedicoAtivo implements ValidadorAgendamentoDeConsulta {

    @Autowired
    private MedicoRepository repository;

    public void validar(DadosAgendamentoConsulta dados){

        if( dados.idMedico() == null ){
          return;
        }

            var medicoAtivo = repository.findAtivoById(dados.idMedico());
        if(!medicoAtivo){
          throw new ValidacaoException("Médico não está ativo!");
        }

    }

}
