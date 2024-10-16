package voll.med.api.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import voll.med.api.medico.DadosCadastroMedico;
import voll.med.api.medico.Medico;
import voll.med.api.medico.MedicoRepository;

@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarMedico(@Valid  @RequestBody DadosCadastroMedico dados) {
        repository.save(new Medico(dados));

    }

    @GetMapping
    public void listarMedicos() {
        System.out.print("Listando médicos\n");
    }

    @PutMapping
    public void atualizarMedico() {
        System.out.print("Atualizando médico\n");
    }

    @DeleteMapping
    public void deletarMedico() {
        System.out.print("Deletando médico\n");
    }

}
