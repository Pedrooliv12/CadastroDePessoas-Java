package dev.oliveira.CadastroDePessoas;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")

public class Controller {

    @GetMapping("/HelloWorld")
    public String hello() {
        return("Hello, World!");
    }

}
