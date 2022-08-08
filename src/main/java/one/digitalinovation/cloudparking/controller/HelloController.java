package one.digitalinovation.cloudparking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/")
@ApiIgnore
public class HelloController {

    @GetMapping
    public String helloUser(){
        return "Seja Bem-Vindo! Para experimentar o primeiro endpoint " +
                "experimente acrescentar a URI /parking/all, confira o código no meu github: <a href='https://github.com/carlossfb/Cloud-Parking'>carlossfb</a>";
    }
}
