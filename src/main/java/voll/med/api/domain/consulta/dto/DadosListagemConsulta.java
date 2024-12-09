package voll.med.api.domain.consulta.dto;


import voll.med.api.domain.consulta.Consulta;
import voll.med.api.domain.medico.Especialidade;

import java.time.LocalDateTime;

public record DadosListagemConsulta(Long id, LocalDateTime data, String crm, Especialidade especialidade, String medico, String paciente, String telefone) {

    public DadosListagemConsulta(Consulta consulta) {
        this(consulta.getId(),
                consulta.getData(),
                consulta.getMedico().getCrm(),
                consulta.getMedico().getEspecialidade(),
                consulta.getMedico().getNome(),
                consulta.getPaciente().getNome()
                ,consulta.getPaciente().getTelefone());
    }

}



