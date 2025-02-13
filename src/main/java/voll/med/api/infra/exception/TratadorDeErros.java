package voll.med.api.infra.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import voll.med.api.domain.ValidacaoException;

import java.util.List;

// Anotação que indica que esta classe fornecerá tratamento global de exceções para controladores REST
@RestControllerAdvice
public class TratadorDeErros {

    // Novo handler para ValidacaoException
    @ExceptionHandler(ValidacaoException.class)
    public ResponseEntity<DadosErro> tratarErroValidacao(ValidacaoException ex) {
        var dadosErro = new DadosErro(ex.getMessage());
        // Retorna 400 (Bad Request) com um JSON contendo a mensagem do erro
        return ResponseEntity.badRequest().body(dadosErro);
    }


    // Metodo que trata exceções do tipo EntityNotFoundException
    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<Void> tratarErro404() {
        // Retorna uma resposta HTTP 404 (Not Found) sem corpo
        return ResponseEntity.notFound().build();
    }

    // Metodo que trata exceções do tipo MethodArgumentNotValidException (erros de validação de campos)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<DadosErroValidacao>> tratarErro400(MethodArgumentNotValidException ex) {
        // Obtém a lista de erros de validação dos campos
        var erros = ex.getFieldErrors();
        // Mapeia cada erro para o record DadosErroValidacao e retorna uma resposta HTTP 400 (Bad Request) com a lista de erros no corpo
        return ResponseEntity.badRequest().body(erros.stream().map(DadosErroValidacao::new).toList());
    }


    private record DadosErroValidacao(String campo, String mensagem) {

        public DadosErroValidacao(FieldError erro){
            this(erro.getField(), erro.getDefaultMessage());
        }
    }

    private record DadosErro(String mensagem) {}
}