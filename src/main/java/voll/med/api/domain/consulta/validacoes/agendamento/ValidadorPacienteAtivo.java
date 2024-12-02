package voll.med.api.domain.consulta.validacoes.agendamento;


import voll.med.api.domain.ValidacaoException;
import voll.med.api.domain.consulta.dto.DadosAgendamentoConsulta;
import voll.med.api.domain.paciente.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ValidadorPacienteAtivo implements ValidadorAgendamentoDeConsulta {
    @Autowired
    private PacienteRepository repository;

    public void validar(DadosAgendamentoConsulta dados){

        if( dados.idMedico() == null ){
            return;
        }

        var pacienteAtivo = repository.findAtivoById(dados.idPaciente());
        if(!pacienteAtivo){
            throw new ValidacaoException("Paciente não está ativo!");
        }

    }


}
