package stage.BpApi.chaoukat_Riad.Entities;

import jakarta.persistence.*;


@Entity
public class Fournisseur {
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
private Integer id ;
@Column(nullable = false)
private  String nom;

public  Fournisseur(){};


    public Fournisseur(Integer id, String nom) {
        this.id = id;
        this.nom = nom;
    }


    @Override
    public String toString() {
        return "Fournisseur{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }
}
