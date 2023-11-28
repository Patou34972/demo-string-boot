package fr.diginamic.hello.controleurs.services.entites;

import jakarta.persistence.*;

import java.util.Objects;
import java.util.Set;

@Entity
public class Departement {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column
    String nom;
    @Column
    int code;
    @OneToMany(mappedBy="departement")
    private Set<Ville> villes;

    public Departement() {
    }

    public Departement(String nom, int code, Set<Ville> villes) {
        this.nom = nom;
        this.code = code;
        this.villes = villes;
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

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public Set<Ville> getVilles() {
        return villes;
    }

    public void setVilles(Set<Ville> villes) {
        this.villes = villes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Departement that = (Departement) o;
        return id == that.id && code == that.code && Objects.equals(nom, that.nom) && Objects.equals(villes, that.villes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nom, code, villes);
    }

    @Override
    public String toString() {
        return "Departement{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", code=" + code +
                ", villes=" + villes +
                '}';
    }
}
