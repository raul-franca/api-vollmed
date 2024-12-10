package voll.med.api.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import voll.med.api.domain.consulta.AgendaDeConsultas;
import voll.med.api.domain.consulta.ConsultaRepository;
import voll.med.api.domain.consulta.dto.DadosAgendamentoConsulta;
import voll.med.api.domain.consulta.dto.DadosDetalhamentoConsulta;
import voll.med.api.domain.consulta.dto.DadosListagemConsulta;
import voll.med.api.domain.consulta.validacoes.cancelamento.DadosCancelamentoConsulta;

import java.time.LocalDateTime;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private AgendaDeConsultas agenda;

    @Autowired
    private ConsultaRepository consultaRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhamentoConsulta> agendar(@RequestBody @Valid DadosAgendamentoConsulta dados) {
        // Agenda uma consulta com base nos dados de agendamento recebidos
        var dto = agenda.agendar(dados);

        // Retorna uma resposta com os detalhes da consulta agendada
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemConsulta>> listarProximasConsultas(@PageableDefault( sort = {"data"}) Pageable paginacao) {
        var proximasConsultas = consultaRepository.findAllByDataGreaterThan(LocalDateTime.now(), paginacao).map(DadosListagemConsulta::new);
        return ResponseEntity.ok(proximasConsultas);
    }


    @GetMapping("/{data}")
    public ResponseEntity<Page<DadosListagemConsulta>> listarConsultasPorData(@PathVariable @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss") LocalDateTime data, @PageableDefault( sort = {"data"}) Pageable paginacao) {
        System.out.printf("Listando consultas para a data %s\n", data);
        var consultas = consultaRepository.findAllByData(data, paginacao).map(DadosListagemConsulta::new);
        return ResponseEntity.ok(consultas);
    }


    @DeleteMapping("{id}")
    @Transactional
    public ResponseEntity<DadosDetalhamentoConsulta> cancelar(@RequestBody @Valid DadosCancelamentoConsulta dados) {
        // Cancela uma consulta com base nos dados de cancelamento recebidos
        agenda.cancelar(dados);

        // Retorna uma resposta com o status "no content" indicando que o cancelamento foi bem-sucedido
        return ResponseEntity.noContent().build();
    }

}
