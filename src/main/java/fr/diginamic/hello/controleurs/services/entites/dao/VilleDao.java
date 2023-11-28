package fr.diginamic.hello.controleurs.services.entites.dao;

import fr.diginamic.hello.controleurs.services.entites.Ville;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class VilleDao {
    @PersistenceContext
    private EntityManager em;
     public List<Ville> extraitAll() {
         TypedQuery<Ville> query = em.createQuery("SELECT v FROM Ville v", Ville.class);
         return query.getResultList();
     }

    public Ville extraitById(int id) {
        return em.find(Ville.class, id);
    }
    public Ville extraitByName(String nom) {
        TypedQuery<Ville> query1 = em.createQuery("SELECT v FROM Ville v WHERE v.nom = :nom", Ville.class);
        query1.setParameter("nom", nom);
         return  query1.getSingleResult();

    }

    @Transactional
    public ResponseEntity<String> insertVille(Ville nvVille) {
         em.persist(nvVille);
        return ResponseEntity.ok("Ville ajoutée avec succès");
    }

    @Transactional
    public ResponseEntity<String> modifVille (int id, Ville villeModifiee) {
         Ville villeFromDb = em.find(Ville.class, id);
        if ( villeFromDb!=null) {
            villeFromDb.setNom( villeModifiee.getNom());
            villeFromDb.setNbHabitants( villeModifiee.getNbHabitants());
            em.merge(villeFromDb);
            return ResponseEntity.ok("Ville modifiée avec succès");
        }
        return ResponseEntity.badRequest().body("Ville non trouvée");
    }


    @Transactional
    public ResponseEntity<String> deleteVille (int id) {

        Ville villeFromDb1 = em.find(Ville.class, id);
        em.remove(villeFromDb1);

        return ResponseEntity.ok("Ville suprimée avec succès");
    }



}
