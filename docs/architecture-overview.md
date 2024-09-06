Primeiro paradão de projeto é o DTO, que é a abreviação de Data Transfer Object.
Ele é uma classe cujo objetivo é transferir dados entre o cliente e o servidor.
O DTO é uma classe simples, que contém apenas atributos e métodos accessors.
Ele é utilizado para evitar que a entidade seja exposta diretamente para o cliente,
o que pode ser um problema de segurança. Além disso, o DTO permite que o desenvolvedor
tenha mais controle sobre os dados que estão sendo transferidos entre o cliente e o servidor. 

O DTO é uma classe simples, que contém apenas atributos e métodos accessors.

Exemplo de DTO:

```java   

    @PostMapping
    public void cadastrarMedico( @RequestBody DadosCadastroMedico dados) {

        System.out.println(dados);
    }
```
Onde minha classe DadosCadastroMedico é um DTO.

```java

import voll.med.api.endereco.DadosEndereco;

public record DadosCadastroMedico(String nome, String email, String telefone, String crm, Especialidade especialidade, DadosEndereco endereco) {

}
```

Documentação: https://docs.oracle.com/en/java/javase/16/language/records.html     


