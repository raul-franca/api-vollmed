package voll.med.api.paciente;

//dados para a listagem de pacientes
//        nome, email, cpf
//        A listagem deve ser ordenada pelo nome do paciente,
//        de maneira crescente, bem como ser paginada, trazendo 10 registros por página.

//classe record para mapear os dados do paciente para a listagem
public record DadosListagemPaciente(String nome, String email, String cpf) {

        //construtor para mapear os dados do paciente para a listagem
        public DadosListagemPaciente(Paciente paciente) {
            this(paciente.getNome(), paciente.getEmail(), paciente.getCpf());
        }
}
