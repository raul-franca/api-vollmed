package voll.med.api;


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

        SpringApplication.run(ApiVollMedApplication.class, args);

    }
}