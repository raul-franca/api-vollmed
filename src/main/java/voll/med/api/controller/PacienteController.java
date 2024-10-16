package voll.med.api.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import voll.med.api.medico.DadosCadastroMedico;
import voll.med.api.paciente.DadosCadastroPaciente;
import voll.med.api.paciente.Paciente;
import voll.med.api.paciente.PacienteRepository;


@RestController
@RequestMapping("pacientes")
public class PacienteController {


    @Autowired
    private PacienteRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarPaciente(@Valid @RequestBody DadosCadastroPaciente dados ) {
        repository.save(new Paciente(dados));
        System.out.print("Cadastrando paciente\n");
    }

    @GetMapping
    public void listarPacientes() {
        System.out.print("Listando pacientes\n");
    }

    @PutMapping
    public void atualizarPaciente() {
        System.out.print("Atualizando paciente\n");
    }

    @DeleteMapping
    public void deletarPaciente() {
        System.out.print("Deletando paciente\n");
    }
}
