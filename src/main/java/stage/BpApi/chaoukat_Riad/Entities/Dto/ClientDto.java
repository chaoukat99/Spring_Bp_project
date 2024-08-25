package stage.BpApi.chaoukat_Riad.Entities.Dto;

import java.util.Date;

public class ClientDto {



    private String id;
    private String nom;
    private String prenom;
    private Integer age;
    private String email;
    private String adresse;
    private String mobile;
    private  String cin ;
    private String adresse_banque_origine ;
    private Date created_at;


   public ClientDto(){};
    public ClientDto(String id, String nom, String prenom, Integer age, String email, String mobile, String cin, String adresse, String adresseBanqueOrigine, Date createdAt) {
        this.id=id;
        this.nom=nom;
        this.prenom=prenom;
        this.age=age;
        this.email=email;
        this.mobile=mobile;
        this.cin=cin;
        this.adresse=adresse;
        this.adresse_banque_origine=adresseBanqueOrigine;
        this.created_at=createdAt;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getAdresse_banque_origine() {
        return adresse_banque_origine;
    }

    public void setAdresse_banque_origine(String adresse_banque_origine) {
        this.adresse_banque_origine = adresse_banque_origine;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }
}
