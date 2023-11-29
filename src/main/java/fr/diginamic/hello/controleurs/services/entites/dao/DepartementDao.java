package fr.diginamic.hello.controleurs.services.entites.dao;

import fr.diginamic.hello.controleurs.services.entites.Departement;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DepartementDao {
    @PersistenceContext
    private EntityManager em;
    public List<Departement> extraitAll() {
        TypedQuery<Departement> query = em.createQuery("SELECT v FROM Departement v", Departement.class);
        return query.getResultList();
    }

    public Departement extraitById(int id) {
        return em.find(Departement.class, id);
    }
    public Departement extraitByName(String nom) {
        TypedQuery<Departement> query1 = em.createQuery("SELECT v FROM Departement v WHERE v.nom = :nom", Departement.class);
        query1.setParameter("nom", nom);
        return  query1.getSingleResult();

    }

    @Transactional
    public ResponseEntity<String> insertDepartement(Departement nvDepartement) {
        em.persist(nvDepartement);
        return ResponseEntity.ok("Departement ajoutée avec succès");
    }

   @Transactional
    public ResponseEntity<String> modifDepartement (int id, Departement departementModif) {
        Departement departementFromDb = em.find(Departement.class, id);
        if ( departementFromDb!=null) {
            departementFromDb.setNom( departementModif.getNom());
            departementFromDb.setCode( departementModif.getCode());
            em.merge(departementFromDb);
            return ResponseEntity.ok("Département modifié avec succès");
        }
        return ResponseEntity.badRequest().body("Département non trouvé");
    }


    @Transactional
    public ResponseEntity<String> deleteDepartement (int id) {

        Departement departementFromDb1 = em.find(Departement.class, id);
        em.remove(departementFromDb1);

        return ResponseEntity.ok("Departement suprimé avec succès");
    }
}
