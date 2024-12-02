# Anotações de Controller

- **`@RestController`**  
  Indica que a classe é um controller REST, combinando as anotações `@Controller` e `@ResponseBody`. 
Os métodos nesta classe retornam dados diretamente no corpo da resposta HTTP.

# Mapeamento de Requisições

- **`@RequestMapping("/api")`**  
  Define que a URL base para acessar os métodos deste controller é `/api`.

- **`@GetMapping("/medicos")`**  
  Mapeia requisições HTTP GET para o método específico, neste caso, quando a URL for `/api/medicos`.

- **`@PostMapping`**  
  Indica que o método responderá a requisições HTTP POST.

- **`@RequestBody`**  
  Anota o parâmetro do método para ser vinculado ao corpo da requisição HTTP.

- **`@PathVariable`**  
  Indica que o parâmetro do método será extraído de uma variável de caminho na URL.

- **`@PutMapping`**  
  Mapeia requisições HTTP PUT para o método.

- **`@DeleteMapping`**  
  Mapeia requisições HTTP DELETE para o método.

- **`@Valid`**  
  Define que o objeto passado como parâmetro será validado automaticamente com base nas anotações de validação presentes na classe 
- (como `@NotNull`, `@Size`, entre outras).

# Anotações de Persistência

- **`@Entity`**  
  Indica que a classe é uma entidade JPA e será mapeada para uma tabela no banco de dados.

- **`@Embeddable`**  
  Especifica que a classe pode ser incorporada em uma entidade e seus campos serão persistidos como parte da entidade.

- **`@Getter`**  
  Gera automaticamente métodos getters para todos os campos da classe.

- **`@AllArgsConstructor`**  
  Gera um construtor com um parâmetro para cada campo na classe.

- **`@NoArgsConstructor`**  
  Gera um construtor sem parâmetros.

- **`@EqualsAndHashCode`**  
  Gera automaticamente os métodos `equals()` e `hashCode()` baseados nos campos da classe.

# Anotações de Repositório e Injeção de Dependência

- **`@Repository`**  
  Indica que a classe é um componente de acesso a dados e torna-a elegível para manipulação de exceções 
específicas de persistência.

- **`@Autowired`**  
  Permite que o Spring resolva e injete colaborador ou dependências em nosso bean.

- **`@Service`**
    Indica que a classe é um serviço, que contém a lógica de negócios da aplicação.  

- **`@Component`**
    Indica que a classe é um componente genérico do Spring.

# Anotações de Tratamento de Exceções
-**`@RestControllerAdvice`**
Permite que uma classe seja usada para tratar exceções em todos os controllers.

-**`@ExceptionHandler`**  
Permite que um método seja invocado para tratar exceções específicas.

---

# Controle de Transações

- **`@Transactional`**  
  Indica que o método ou classe deve ser executado dentro de uma transação.
 
# Classes do Spring Framework

## `ResponseEntity`

Utilizado para representar toda a resposta HTTP, permitindo controlar o status, 
cabeçalhos e corpo da resposta.
```java
// Retorna HTTP 200 (OK) com o corpo da resposta
return ResponseEntity.ok(medico);

// Retorna HTTP 201 (Created) após criar um recurso
return ResponseEntity.status(HttpStatus.CREATED).body(novoMedico);

// Retorna HTTP 204 (No Content) se a operação for bem-sucedida sem conteúdo no corpo
return ResponseEntity.noContent().build();

// Retorna HTTP 404 (Not Found) quando o recurso não é encontrado
return ResponseEntity.notFound().build();
```

##  `Page` , `Pageable`, `PageRequest` 
- **`Page`** Interface que representa uma página de resultados.
- **`Pageable`** Interface que encapsula informações de paginação, como tamanho da página,
  número da página e ordenação.
- **`PageRequest`** Implementação de Pageable que cria uma solicitação de página.
```java
@GetMapping("/medicos")
public ResponseEntity<Page<DadosListagemMedico>> listarMedicos(
        @PageableDefault(size = 10, sort = "nome") Pageable pageable) {
    Page<DadosListagemMedico> medicos = repository.findAllByAtivoTrue(pageable)
            .map(DadosListagemMedico::new);
    return ResponseEntity.ok(medicos);
}
```
## `Exemplo do uso de complemento`
```java
@RestController
@RequestMapping("/api/medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository repository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> cadastrarMedico(@Valid @RequestBody DadosCadastroMedico dados) {
        Medico medico = new Medico(dados);
        repository.save(medico);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping
    public ResponseEntity<Page<DadosListagemMedico>> listarMedicos(
            @PageableDefault(size = 10, sort = "nome") Pageable pageable) {
        Page<DadosListagemMedico> medicos = repository.findAllByAtivoTrue(pageable)
                .map(DadosListagemMedico::new);
        return ResponseEntity.ok(medicos);
    }

    @PutMapping
    @Transactional
    public ResponseEntity<Void> atualizarMedico(@Valid @RequestBody DadosAtualizarMedico dados) {
        Optional<Medico> optionalMedico = repository.findById(dados.getId());
        if (optionalMedico.isPresent()) {
            Medico medico = optionalMedico.get();
            medico.atualizarDados(dados);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity<Void> deletarMedico(@PathVariable Long id) {
        Optional<Medico> optionalMedico = repository.findById(id);
        if (optionalMedico.isPresent()) {
            Medico medico = optionalMedico.get();
            medico.desativar();
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}

```

[Link do GPT](https://chatgpt.com/share/6733ed75-8d04-8003-9f45-83d22381da6d)