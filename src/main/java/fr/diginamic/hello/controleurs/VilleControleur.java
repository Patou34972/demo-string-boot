package fr.diginamic.hello.controleurs;


import fr.diginamic.hello.controleurs.services.entites.Ville;
import fr.diginamic.hello.controleurs.services.entites.dao.VilleDao;
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
    @Autowired
    private VilleDao villeDao;

    /**
     * Une méthode pour Extrait toutes les villes
     * @return villeDao.extraitAll();
     */
    @GetMapping
    public List<Ville> getVilles() {
        return villeDao.extraitAll();
    }

    /**
     * Une méthode pour Extrait une ville par son ID
     * @return villeDao. extraitById(id);
     */
    @GetMapping("/{id}")
    public Ville getVilleById(@PathVariable int id) {
        return villeDao. extraitById(id);
    }

    /**
     * Une méthode pour Extrait une ville par son nom
     * @return villeDao.extraitByName(nom);
     */
   /* @GetMapping("/{nom}")
    public Ville getVilleByName(@PathVariable String nom) {
        return villeDao.extraitByName(nom);
    }*/

    /**
     * Une méthode pour ajouter  une ville
     * @return villeDao.insert(nvVille);
     */
    @PutMapping
    public ResponseEntity<String> ajouterVilles(@RequestBody Ville nvVille) {
        return villeDao.insertVille(nvVille);
    }

    /**
     * Une méthode pour modifier  une  ville
     * @return villeDao.modifVille(id, villeModifiee);
     */
   @PostMapping("/{id}")
    public ResponseEntity<String> modifierVille(@PathVariable int id, @RequestBody Ville villeModifiee) {

                return villeDao.modifVille(id, villeModifiee);
            }

    /**
     * Une méthode pour supprimer  une  ville par son ID
     *  * @return villeDao.deleteVille(id);
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> suprimeVille(@PathVariable int id) {
        return villeDao.deleteVille(id);
    }
}