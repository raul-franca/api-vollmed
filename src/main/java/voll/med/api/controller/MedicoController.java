package voll.med.api.controller;


import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import voll.med.api.medico.*;


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
    public Page<DadosListagemMedico> listarMedicos(@PageableDefault(size = 10 , sort = {"nome"}) Pageable paginas ) {
        System.out.print("Listando médicos\n");
        return repository.findAllByAtivoTrue(paginas).map(DadosListagemMedico::new);
    }



    @PutMapping
    @Transactional
    public void atualizarMedico(@RequestBody @Valid DadosAtualizarMedico dados) {
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarDados(dados);
        System.out.print("Atualizando médico\n");
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void deletarMedico(@PathVariable Long id) {
        System.out.print("Deletando médico\n");
        var medico = repository.getReferenceById(id);
        medico.desativar();
    }

}
