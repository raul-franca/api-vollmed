### Controller

@RestController → define que se trata de um rest controller

### Mapeamento de Requisições

@RequestMapping("/api") → define que a url base para acessar os métodos desse controller é /api
@PostMapping → define que o método é um post
@RequestBody → define que o método recebe um objeto no corpo da requisição
@GetMapping → define que o método é um get
@PathVariable → define que o método recebe um parâmetro na url
@PutMapping → define que o método é um put
@DeleteMapping → define que o método é um delete


### Manipulação de Dados

@Embeddable → define que a classe é uma classe embutida
@Entity → define que a classe é uma entidade
@Getters → define que os getters serão gerados automaticamente
@AllArgsContructor → define que o construtor com todos os argumentos será gerado automaticamente
@NoArgsContructor → define que o construtor sem argumentos será gerado automaticamente
@EqualsAndHashCode → define que os métodos equals e hashcode serão gerados automaticamente


### Repositório

@Repository → define que a classe é um repositório
@Autowired → define que a injeção de dependência será feita automaticamente

### Transação

@Transactional → define que o método é uma transação
