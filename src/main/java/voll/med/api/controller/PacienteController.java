package voll.med.api.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;
import voll.med.api.domain.paciente.*;
import voll.med.api.domain.paciente.dto.DadosAtualizarPaciente;
import voll.med.api.domain.paciente.dto.DadosCadastroPaciente;
import voll.med.api.domain.paciente.dto.DadosDetalhadoPaciente;
import voll.med.api.domain.paciente.dto.DadosListagemPaciente;


@RestController
@RequestMapping("pacientes")
public class PacienteController {


    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<DadosDetalhadoPaciente> cadastrarPaciente(
            @Valid @RequestBody DadosCadastroPaciente dados, UriComponentsBuilder uriBuilder ) {
        System.out.print("Cadastrando paciente\n");

        var paciente =  repository.save(new Paciente(dados));
        var uri = uriBuilder.path("/pacientes/{id}").buildAndExpand(paciente.getId()).toUri();
        var dto = new DadosDetalhadoPaciente(paciente);

        return ResponseEntity.created(uri).body(dto);
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemPaciente>> listarPacientes(
            @PageableDefault( sort = {"nome"}) Pageable paginas) {
        System.out.print("Listando pacientes\n");

        var page = repository.findAllByAtivoTrue(paginas).map(DadosListagemPaciente::new);

        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    @Transactional
    public ResponseEntity<DadosDetalhadoPaciente> detalhadoPaciente(@PathVariable Long id) {
        System.out.print("Detalhando paciente\n");

        var paciente = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhadoPaciente(paciente));

    }

    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhadoPaciente> atualizarPaciente(
            @RequestBody DadosAtualizarPaciente dados) {
        System.out.print("Atualizando paciente\n");

        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarDados(dados);
        return ResponseEntity.ok(new DadosDetalhadoPaciente(paciente));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletarPaciente(@PathVariable Long id) {
        System.out.print("Deleção logica do paciente\n");

        var paciente = repository.getReferenceById(id);
        paciente.desativar();
        return ResponseEntity.noContent().build();
    }
}
