package voll.med.api.medico;

import voll.med.api.endereco.Endereco;

public record DadosDetalhesMedico(Long id, String nome, String crm, Especialidade especialidade, String telefone, String email, Endereco endereco, boolean ativo) {

    public DadosDetalhesMedico(Medico medico) {
        this(medico.getId(), medico.getNome(), medico.getCrm(), medico.getEspecialidade(), medico.getTelefone(), medico.getEmail(), medico.getEndereco(), medico.getAtivo());
    }
}