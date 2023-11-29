package fr.diginamic.hello.controleurs;


import fr.diginamic.hello.controleurs.services.entites.Ville;
import fr.diginamic.hello.controleurs.services.entites.dao.VilleDao;
import fr.diginamic.hello.controleurs.services.entites.dao.VilleRepository;
import fr.diginamic.hello.controleurs.services.entites.dao.exception.AnomalieException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/villes")
public class VilleControleur {
    @Autowired
    private VilleDao villeDao;
    @Autowired
    private VilleRepository villeRepository;

    /**
     * Une méthode pour Extrait toutes les villes
     * @return villes;
     */
    @GetMapping
    public Iterable<Ville> getVilles() {
        Iterable<Ville> villes = villeRepository.findAll();
        return villes;
    }


    /**
     * Une méthode pour Extrait une ville par son ID
     * @return villeDao. extraitById(id);
     */
    @GetMapping("/{id}")
    public Ville getVilleById(@PathVariable int id) {
        Ville ville = villeRepository.findById(id);
        return ville;
        /*return villeDao. extraitById(id);*/
    }

    /**
     * Une méthode pour Extrait une ville par son nom
     * @return ville
     */
    @GetMapping("/nom/{nom}")
    public Ville getVilleByName(@PathVariable String nom) {
        Ville ville = villeRepository.findByNom(nom);
        return ville;
       /* return villeDao.extraitByName(nom);*/
    }

    /**
     * Une méthode pour Extrait la plus grande ville dans un departement
     * @return villeDao.nPlusGrandesVillesParDepartement(nomDep, n);
     */
    @GetMapping("/departements/grand/{nomDep}")
    public Iterable<Ville>getBigVille(@PathVariable String nomDep) {
        Iterable<Ville> ville = villeRepository.extractVilleByMaxPopulation(nomDep);
        return ville;
       /* return villeDao.nPlusGrandesVillesParDepartement(nomDep);*/
    }



    /**
     * Une méthode pour ajouter  une ville
     * @return villeDao.insert(nvVille);
     */
    @PutMapping
    public Ville ajouterVilles(@RequestBody Ville nvVille) {
        Ville ville = villeRepository.save(nvVille);
        return ville;
        /*return villeDao.insertVille(nvVille);*/
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