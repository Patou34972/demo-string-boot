package fr.diginamic.hello.controleurs;


import fr.diginamic.hello.controleurs.services.entites.Ville;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleControleur {
    private List<Ville> villes = new ArrayList<>();

    /**
     * Une méthode pour Extrait toutes les villes
     * @return villes
     */
    @GetMapping
    public List<Ville> getVilles() {
        return villes;
    }

    @GetMapping("/{id}")
    public Ville getListeVilleById(@PathVariable int id) {
        for (Ville v : villes) {
            if (v.getId() == id) {
                return v;
            }
        }
        return null;
    }

    /**
     * Une méthode pour créer  une  ville : PUT
     */
    @PutMapping
    public ResponseEntity<String> ajouterVilles(@RequestBody Ville nvVille) {

        if(nvVille.getId()==0) {
            return ResponseEntity.badRequest().body("la ville doit obligatoirement avoir un ID");
        }
        for(Ville v : villes) {
            if (v.getId() == nvVille.getId()){
                return ResponseEntity.badRequest().body("Une ville avec le même id existe déjà");
            }
        }
        villes.add(nvVille);
        return ResponseEntity.ok("la ville a été ajoutée avec succès") ;

    }

    /**
     * Une méthode pour modifier  une  ville : POST
     */
    @PostMapping("/{id}")
    public ResponseEntity<String> modifierVille(@PathVariable int id, @RequestBody Ville nvVille) {

        for (Ville v : villes) {
            if (v.getId() == id) {
                v.setNom(nvVille.getNom());
                v.setNbHabitants(nvVille.getNbHabitants());
                return ResponseEntity.ok("la ville a été modfiée avec succès");
            }
        }
        return ResponseEntity.badRequest().body(" la ville existe déjà");
    }

    /**
     * Une méthode pour supprimer  une  ville par son ID : DELETE
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> suprimeVille(@PathVariable int id) {
        Iterator<Ville> iterator = villes.iterator();
        while (iterator.hasNext()) {
            Ville v = iterator.next();
            if (v.getId() == id) {
                iterator.remove();
                return ResponseEntity.ok("Ville supprimée avec succès.");
            }
        }
        return ResponseEntity.badRequest().body("Ville non trouvée avec l'ID : " + id);
    }
}