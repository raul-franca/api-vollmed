package voll.med.api.domain.consulta;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDateTime;

/**
 * Interface responsável pela definição dos métodos de acesso aos dados das consultas.
 * Estende a interface JpaRepository, fornecendo métodos de persistência prontos para a entidade Consulta.
 */
public interface ConsultaRepository extends JpaRepository<Consulta, Long> {

    /**
     * Verifica se existe uma consulta associada a um determinado médico e data.
     *
     * @param idMedico o ID do médico
     * @param data     a data da consulta
     * @return true se a consulta existir, false caso contrário
     */
    boolean existsByMedicoIdAndData(Long idMedico, LocalDateTime data);

    /**
     * Verifica se existe uma consulta associada a um determinado paciente e que ocorra entre um intervalo de datas.
     *
     * @param idPaciente      o ID do paciente
     * @param primeiroHorario o primeiro horário do intervalo
     * @param ultimoHorario   o último horário do intervalo
     * @return true se a consulta existir, false caso contrário
     */
    boolean existsByPacienteIdAndDataBetween(Long idPaciente, LocalDateTime primeiroHorario, LocalDateTime ultimoHorario);

    /**
     * Busca todas as consultas agendadas para uma determinada data.
     *
     * @param data      a data das consultas
     * @param paginacao informações sobre a paginação
     * @return uma página com as consultas agendadas para a data especificada
     */
     @Query("""
            SELECT c
            FROM Consulta c
            WHERE c.data >= :data
            ORDER BY c.data
    """)
    Page<Consulta> findAllByData(LocalDateTime data, Pageable paginacao);


     /**
     * Recupera uma página de consultas cuja data seja posterior à data fornecida.
     *
     * @param data       a data de referência
     * @param paginacao  informações de paginação
     * @return uma página de consultas
     */
    Page<Consulta> findAllByDataGreaterThan(LocalDateTime data, Pageable paginacao);


}
