package voll.med.api.domain.medico.dto;

import voll.med.api.domain.endereco.Endereco;
import voll.med.api.domain.medico.Especialidade;
import voll.med.api.domain.medico.Medico;

public record DadosDetalhesMedico(Long id, String nome, String crm, Especialidade especialidade, String telefone, String email, Endereco endereco, boolean ativo) {

    public DadosDetalhesMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getEspecialidade(), medico.getTelefone(), medico.getEmail(), medico.getEndereco(), medico.getAtivo());
    }
}