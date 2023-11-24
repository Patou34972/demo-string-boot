package fr.diginamic.hello.controleurs;

import fr.diginamic.hello.controleurs.services.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleControleur {
    @Autowired
    private String nom;
    @GetMapping
    public List<String> getListeVilles() {
        List<String> villes = Arrays.asList("Paris", "Lyon", "Marseille", "Bordeaux", "Toulouse");
        return villes;
    }

}