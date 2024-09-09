package voll.med.api;

import io.github.cdimascio.dotenv.Dotenv;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@Controller
public class ApiVollMedApplication {

    @GetMapping("/")
    public String index() {
        return "index";
    }

    public static void main(String[] args) {
         // Carregar variáveis do arquivo .env
        Dotenv dotenv = Dotenv.load();
        // Verifique se a variável DATABASE_URL está sendo carregada
        System.out.println("DATABASE_URL: " + dotenv.get("DATABASE_URL"));
        SpringApplication.run(ApiVollMedApplication.class, args);
    }
}