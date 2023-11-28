package fr.diginamic.hello.controleurs;

import fr.diginamic.hello.controleurs.services.entites.Departement;
import fr.diginamic.hello.controleurs.services.entites.dao.DepartementDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/departements")
public class DepartementControleur {

    @Autowired
    private DepartementDao departementDao;

    /**
     * Une méthode pour Extrait tous les departements
     * @return departementDao.extraitAll();
     */
    @GetMapping
    public List<Departement> getDepartements() {
        return departementDao.extraitAll();
    }

    /**
     * Une méthode pour Extrait un departement par son ID
     * @return departementDao.extraitById(id);
     */
    @GetMapping("/{id}")
    public Departement getDepartementById(@PathVariable int id) {
        return departementDao.extraitById(id);
    }

    /**
     * Une méthode pour Extrait un departement par son nom
     * @return departementDao.extraitByName(nom);
     */
    @GetMapping("/nom/{nom}")
    public Departement getDepartementByName(@PathVariable String nom) {
        return departementDao.extraitByName(nom);
    }

    /**
     * Une méthode pour ajouter  un departement
     * @return departementDao.insertDepartement(nvDepartement);
     */
    @PutMapping
    public ResponseEntity<String> ajouterDepatement(@RequestBody Departement nvDepartement) {
        return departementDao.insertDepartement(nvDepartement);
    }

    /**
     * Une méthode pour modifier  un departement
     * @return departementDao.modifDepartement(id, departementModif);
     */
    @PostMapping("/{id}")
    public ResponseEntity<String> modifierDepartement(@PathVariable int id, @RequestBody Departement departementModif) {

        return departementDao.modifDepartement(id, departementModif);
    }

    /**
     * Une méthode pour supprimer  un departement par son ID
     *  * @return departementDao.deleteDepartement(id);
     */
    @DeleteMapping("/{id}")
    public ResponseEntity<String> suprimeDepartement(@PathVariable int id) {
        return departementDao.deleteDepartement(id);
    }
}
