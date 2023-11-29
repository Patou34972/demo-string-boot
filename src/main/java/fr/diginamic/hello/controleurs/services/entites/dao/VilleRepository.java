package fr.diginamic.hello.controleurs.services.entites.dao;

import fr.diginamic.hello.controleurs.services.entites.Ville;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;


public interface VilleRepository extends CrudRepository<Ville, Integer> {

    Ville findByNom(String nom) ;

    Ville findById(int id);
    @Query("SELECT v FROM Ville v WHERE v.departement.nom = :nomDep order by v.nbHabitants desc")
    Iterable<Ville> extractVilleByMaxPopulation(String nomDep);

    Ville save( Ville nvville);


}
