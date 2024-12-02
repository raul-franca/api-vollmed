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
import voll.med.api.domain.medico.*;
import voll.med.api.domain.medico.dto.DadosAtualizarMedico;
import voll.med.api.domain.medico.dto.DadosCadastroMedico;
import voll.med.api.domain.medico.dto.DadosDetalhesMedico;
import voll.med.api.domain.medico.dto.DadosListagemMedico;

// Anotação para indicar que esta classe é um controlador REST
@RestController
// Define o caminho base da URL para os endpoints deste controlador
@RequestMapping("medicos")
public class MedicoController {

    // Injeção de dependência do repositório MedicoRepository para acessar o banco de dados
    @Autowired
    private MedicoRepository repository;


    @PostMapping// Endpoint POST para cadastrar um novo médico
    @Transactional  // Anotação para indicar que o metodo é transacional
    public ResponseEntity<DadosDetalhesMedico> cadastrarMedico(
            @Valid @RequestBody DadosCadastroMedico dados, UriComponentsBuilder uriBuilder) {
        System.out.print("Cadastrar médicos\n");

        var medico = new Medico(dados);
        repository.save(medico);
        // Cria uma URI para o novo médico cadastrado
        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(medico.getId()).toUri();
        // Cria um objeto DadosDetalhesMedico com os dados do médico cadastrado
        var dto = new DadosDetalhesMedico(medico);

        // Retorna os dados do médico cadastrado com status 201 (Created)
        return ResponseEntity.created(uri).body(dto);

    }

    // Endpoint GET para listar médicos com paginação
    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listarMedicos(
            @PageableDefault( sort = {"nome"}) Pageable paginas) { //size = 10, page = 0, sort = nome ja é o default
        System.out.print("Listando médicos\n");
        // Busca todos os médicos ativos no banco de dados e mapeia para a classe DadosListagemMedico
        var page = repository.findAllByAtivoTrue(paginas).map(DadosListagemMedico::new);
        // Retorna a lista de médicos com status 200 (OK)
        return ResponseEntity.ok(page);
    }

    // Endpoint GET para detalhar as informações de um médico
    @GetMapping("/{id}")
    public ResponseEntity<DadosDetalhesMedico> detalharMedico(@PathVariable Long id) {
        System.out.print("Detalhando médico\n");

        // Busca um médico pelo ID e mapeia para a classe DadosDetalhesMedico
        var medico = repository.getReferenceById(id);
        // Retorna os dados do médico com status 200 (OK)
        return ResponseEntity.ok(new DadosDetalhesMedico(medico));

    }


    // Endpoint PUT para atualizar as informações de um médico
    @PutMapping
    @Transactional
    public ResponseEntity<DadosDetalhesMedico> atualizarMedico(@RequestBody @Valid DadosAtualizarMedico dados) {
        System.out.print("Atualizando médico\n");
        // Criar uma variável para armazenar a referência do médico pelo ID
        var medico = repository.getReferenceById(dados.id());
        // Atualiza os dados do médico com base nos dados recebidos
        medico.atualizarDados(dados);
        // Retorna um DTO com os dados atualizados do médico com status 200 (OK)
        return ResponseEntity.ok(new DadosDetalhesMedico(medico));
    }


    // Endpoint DELETE para desativar (deletar logicamente) um médico
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletarMedico(@PathVariable Long id) {
        System.out.print("Deletando médico\n");

        // Busca uma referência do médico pelo ID
        var medico = repository.getReferenceById(id);
        // Desativa o médico sem removê-lo do banco de dados
        medico.desativar();
        // Retorna uma resposta HTTP 204 (No Content) se a operação for bem-sucedida
        return ResponseEntity.noContent().build();

    }
}