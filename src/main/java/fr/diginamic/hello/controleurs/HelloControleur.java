package fr.diginamic.hello.controleurs;

import fr.diginamic.hello.controleurs.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/hello")
public class HelloControleur {
    @Autowired
    private HelloService service;
    @GetMapping
    public String dire(){
        return service.salutations(); }

}
