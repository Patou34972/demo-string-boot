package fr.diginamic.hello.controleurs.services.entites;


import java.util.Objects;

public class Ville {
    private int id;
    String nom;
    int nbHabitants;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ville ville = (Ville) o;
        return nbHabitants == ville.nbHabitants && Objects.equals(nom, ville.nom);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nom, nbHabitants);
    }

    @Override
    public String toString() {
        return "Ville{" +
                ", nom='" + nom + '\'' +
                "nbHabitants=" + nbHabitants +
                '}';
    }


}
