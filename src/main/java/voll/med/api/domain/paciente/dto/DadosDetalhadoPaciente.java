package voll.med.api.domain.paciente.dto;

import voll.med.api.domain.endereco.Endereco;
import voll.med.api.domain.paciente.Paciente;

public record DadosDetalhadoPaciente(Long id, String nome, String cpf, String email, String telefone, Endereco endereco, boolean ativo) {
    public DadosDetalhadoPaciente(Paciente paciente) {
        this(paciente.getId(), paciente.getNome(), paciente.getCpf(), paciente.getEmail(), paciente.getTelefone(), paciente.getEndereco(), paciente.getAtivo());
    }
}
