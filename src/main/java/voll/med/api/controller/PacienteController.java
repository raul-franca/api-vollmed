package voll.med.api.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import voll.med.api.paciente.*;


@RestController
@RequestMapping("pacientes")
public class PacienteController {


    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarPaciente(@Valid @RequestBody DadosCadastroPaciente dados ) {

        System.out.print("Cadastrando paciente\n");
        repository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listarPacientes(@PageableDefault( sort = {"nome"}) Pageable paginas) {

        System.out.print("Listando pacientes\n");
        return repository.findAllByAtivoTrue(paginas).map(DadosListagemPaciente::new);
    }

    @PutMapping
    @Transactional
    public void atualizarPaciente(@RequestBody DadosAtualizarPaciente dados) {
        var paciente = repository.getReferenceById(dados.id());
        paciente.atualizarDados(dados);
        System.out.print("Atualizando paciente\n");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarPaciente(@PathVariable Long id) {
        System.out.print("Deletando paciente\n");
        var paciente = repository.getReferenceById(id);
        paciente.desativar();
    }
}
