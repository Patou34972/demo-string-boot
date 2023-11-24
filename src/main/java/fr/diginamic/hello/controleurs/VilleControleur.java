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
    ArrayList<Ville> villes = new ArrayList<>();
    @GetMapping
   public List<Ville> getListeVilles() {

       /*villes.add(new Ville(25000,"JACOU"));
       villes.add(new Ville(15000,"MORNE ROUGE"));
       villes.add(new Ville(53400,"NARBONNE"));
       villes.add(new Ville(484000,"LYON"));
       villes.add(new Ville(35000,"MONTPELLIER"));
       villes.add(new Ville(77200,"PAU"));*/

       return villes;
   }
   /*@GetMapping("")
   public Ville getVille(@PathVariable) {

   }*/
    @PutMapping
    public String ajouterVilles(@RequestBody Ville nvVille) {
        if (!villes.contains(nvVille)) {
            villes.add(nvVille);
            return "la ville a été créée avec succès";
        }
        return "La ville existe déja";

    }
    @PostMapping("/{id}")
    public String modifierVille(@PathVariable int id, @RequestBody Ville nvVille) {
        for (Ville v: villes) {
            if(v.getId()==id) {
                v.setNom(nvVille.getNom());
                v.setNbHabitants(nvVille.getNbHabitants());
                return"la ville a étét modfiée avec succès";
            }
        }
        return " la ville existe déjà";
    }

}