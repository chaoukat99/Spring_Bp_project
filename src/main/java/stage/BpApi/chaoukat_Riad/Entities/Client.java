package stage.BpApi.chaoukat_Riad.Entities;

import jakarta.persistence.* ;
import jdk.jfr.Timestamp;
import org.apache.catalina.UserDatabase;
import org.hibernate.annotations.CreationTimestamp;


import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name="clients")
public class Client {


    public Client(){};
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)

    private String id;
    @Column(nullable = false)
    private String nom;
    @Column(nullable = false)
    private String prenom;
    @Column(nullable = false)
    private Integer age;
    @Column(unique = true,nullable = false)
    private String email;
    @Column(nullable = false,name="adresse")
    private String adresse;
    @Column(nullable = false)
    private String mobile;
    @Column(nullable=false)
    private  String cin ;
    @Column(nullable=false)
    private String adresse_banque_origine ;
    @CreationTimestamp
    @Column(name="created_at")
    private Date created_at;

    @OneToMany(mappedBy = "client_id", cascade = CascadeType.ALL,orphanRemoval = true)
    private Set<Compte> Accounts = new HashSet<>();

    public Client(String cin){
        this.cin = cin;
    };
    public Client(String id, String nom, String prenom, Integer age, String email, String adresse, String mobile, String cin, String adresse_banque_origine) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.age = age;
        this.email = email;
        this.adresse = adresse;
        this.mobile = mobile;
        this.cin = cin;
        this.adresse_banque_origine = adresse_banque_origine;

    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public void setAccounts(Set<Compte> accounts) {
        Accounts = accounts;
    }

    public Set<Compte> getAccounts() {
        return Accounts;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public String getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public Integer getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getMobile() {
        return mobile;
    }


    public String getAdresse_banque_origine() {
        return adresse_banque_origine;
    }


    public void setId(String id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }



    public void setAdresse_banque_origine(String adresse_banque_origine) {
        this.adresse_banque_origine = adresse_banque_origine;
    }




    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", prenom='" + prenom + '\'' +
                ", age=" + age +
                ", email='" + email + '\'' +
                ", Adresse='" + adresse + '\'' +
                ", mobile='" + mobile + '\'' +
                ", Cin='" + cin + '\'' +
                ", adresse_banque_origine='" + adresse_banque_origine + '\'' +
                " " +
                '}';
    }
}
