package voll.med.api.domain.paciente;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PacienteRepository extends JpaRepository<Paciente, Long> {
    Page<Paciente> findAllByAtivoTrue(Pageable paginacao);

    @Query("""
        select p.ativo from Paciente p
        where p.id = :idPaciente
    """)
    boolean findAtivoById(Long idPaciente);


    @Query("""
        select p from Paciente p
        where p.ativo = true
        and lower(p.nome) like :nome%
    """)
    Page<Paciente> findByNomeContainingIgnoreCase(String nome, Pageable paginacao);
}