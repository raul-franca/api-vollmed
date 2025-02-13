package voll.med.api.domain.medico;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import voll.med.api.domain.endereco.Endereco;
import voll.med.api.domain.medico.dto.DadosAtualizarMedico;
import voll.med.api.domain.medico.dto.DadosCadastroMedico;

@Table(name = "medicos")
@Entity(name = "Medico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Medico {

        @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
        private Long id;
        private String nome;
        private String email;
        private String crm;
        private String telefone;


        @Enumerated(EnumType.STRING)
        private Especialidade especialidade;

        @Embedded
        private Endereco endereco;

        private Boolean ativo;

        public Medico(DadosCadastroMedico dados) {
                this.nome = dados.nome();
                this.email = dados.email();
                this.crm = dados.crm();
                this.telefone = dados.telefone();
                this.especialidade = dados.especialidade();
                this.endereco = new Endereco(dados.endereco());
                this.ativo = true;
        }

        public void atualizarDados(DadosAtualizarMedico dados) {

                if (dados.nome() != null) {
                        this.nome = dados.nome();
                }
                if (dados.email() != null) {
                        this.email = dados.email();
                }
                if (dados.telefone() != null) {
                        this.telefone = dados.telefone();
                }
                if (dados.endereco() != null) {
                        this.endereco.atualizarDados(dados.endereco());
                }
        }

        public void desativar() {
                this.ativo = false;
        }
}
