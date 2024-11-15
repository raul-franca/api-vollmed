package voll.med.api.domain.paciente;

import voll.med.api.domain.endereco.Endereco;

public record DadosDetalhadoPaciente(Long id, String nome, String cpf, String email, String telefone, Endereco endereco, boolean ativo) {
    public DadosDetalhadoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEmail(), paciente.getTelefone(), paciente.getEndereco(), paciente.getAtivo());
    }
}
