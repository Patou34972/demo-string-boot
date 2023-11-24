package fr.diginamic.hello.controleurs;


import fr.diginamic.hello.controleurs.services.entites.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleControleur {
   @GetMapping
   public List<Ville> getListeVilles() {
        ArrayList<Ville> villes = new ArrayList<>();
       villes.add(new Ville(25000,"JACOU"));
       villes.add(new Ville(15000,"MORNE ROUGE"));
       villes.add(new Ville(53400,"NARBONNE"));
       villes.add(new Ville(484000,"LYON"));
       villes.add(new Ville(35000,"MONTPELLIER"));
       villes.add(new Ville(77200,"PAU"));

       return villes;
   }


}