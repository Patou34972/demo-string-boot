package fr.diginamic.hello.controleurs.services.entites;


import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    String nom;
    @Column
    int nbHabitants;
    @ManyToOne
    @JoinColumn ( name="DEPT_ID")
    private Departement departement ;

    public Ville() {
    }

    public Ville(Departement departement) {
        this.departement = departement;
    }

    public Ville(int id, int nbHabitants, String nom) {
        this.id = id;
        this.nom = nom;
        this.nbHabitants = nbHabitants;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getNbHabitants() {
        return nbHabitants;
    }

    public void setNbHabitants(int nbHabitants) {
        this.nbHabitants = nbHabitants;
    }

    public Departement getDepartement() {
        return departement;
    }

    public void setDepartement(Departement departement) {
        this.departement = departement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ville ville = (Ville) o;
        return id == ville.id && nbHabitants == ville.nbHabitants && Objects.equals(nom, ville.nom) && Objects.equals(departement, ville.departement);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, nbHabitants, departement);
    }

    @Override
    public String toString() {
        return "Ville{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", nbHabitants=" + nbHabitants +
                ", departement=" + departement +
                '}';
    }
}

