package voll.med.api.domain.paciente;

//dados para a listagem de pacientes
//        nome, email, cpf
//        A listagem deve ser ordenada pelo nome do paciente,
//        de maneira crescente, bem como ser paginada, trazendo 10 registros por página.

//classe record para mapear os dados do paciente para a listagem
public record DadosListagemPaciente(Long id, String nome, String email, String telefone, String cpf) {

        //construtor para mapear os dados do paciente para a listagem
        public DadosListagemPaciente(Paciente paciente) {
            this(paciente.getId(), paciente.getNome(), paciente.getEmail(), paciente.getTelefone(), paciente.getCpf());
        }
}
