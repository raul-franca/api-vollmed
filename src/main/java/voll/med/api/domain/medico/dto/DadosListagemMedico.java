package voll.med.api.domain.medico.dto;

import voll.med.api.domain.medico.Especialidade;
import voll.med.api.domain.medico.Medico;

public record DadosListagemMedico(Long id, String nome, String email, String telefone, String crm, Especialidade especialidade) {


    public DadosListagemMedico(Medico medico) {
        this(medico.getId(),  medico.getNome(), medico.getEmail(), medico.getTelefone(), medico.getCrm(), medico.getEspecialidade());
    }
}
