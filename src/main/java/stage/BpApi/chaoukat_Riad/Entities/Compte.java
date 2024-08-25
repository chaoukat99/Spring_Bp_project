package stage.BpApi.chaoukat_Riad.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jdk.jfr.Timestamp;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "comptes")
public class Compte {
    @Id
    private long numero_de_compte;
    @Column(nullable = false)
    private  Type type;
    @Column(nullable = false)
    private  String devise;
    @Column(nullable = false)
    private  double solde ;
    @Column(nullable = false)
    private Status status;
    @CreationTimestamp
    @Column(name ="created_at")
    private Date date_ouverture;
    @Column(nullable = false)
    private String cinclient;



    @ManyToOne
    @JoinColumn(name = "client_id",nullable = false)
    @JsonBackReference
    private Client client_id;
    @OneToMany(mappedBy="compte_src",cascade = CascadeType.ALL)
    private Set<Virement> Vir1 = new HashSet<>();
    @OneToMany(mappedBy="compte_dest",cascade = CascadeType.ALL)
    private Set<Virement> Vir2 = new HashSet<>();

     public Compte(){};
    public Compte(long numero_de_compte, Type type, String devise, double solde, Status status, Date date_ouverture, Client client) {
        this.numero_de_compte = numero_de_compte;
        this.type = type;
        this.devise = devise;
        this.solde = solde;
        this.status = status;
        this.date_ouverture = date_ouverture;
        this.client_id = client;
    }

    public long getNumero_de_compte() {
        return numero_de_compte;
    }

    public void setNumero_de_compte(long numero_de_compte) {
        this.numero_de_compte = numero_de_compte;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    public String getDevise() {
        return devise;
    }

    public void setDevise(String devise) {
        this.devise = devise;
    }

    public double getSolde() {
        return solde;
    }

    public void setSolde(double solde) {
        this.solde = solde;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Date getDate_ouverture() {
        return date_ouverture;
    }

    public void setDate_ouverture(Date date_ouverture) {
        this.date_ouverture = date_ouverture;
    }

    public Client getClient() {
        return client_id;
    }

    public void setClient(Client client) {
        this.client_id = client;
    }
    public String getCinclient() {
        return cinclient;
    }

    public void setCinclient(String cinclient) {
        this.cinclient = cinclient;
    }

    public Client getClient_id() {
        return client_id;
    }

    public void setClient_id(Client client_id) {
        this.client_id = client_id;
    }

    public Set<Virement> getVir1() {
        return Vir1;
    }

    public void setVir1(Set<Virement> vir1) {
        Vir1 = vir1;
    }

    public Set<Virement> getVir2() {
        return Vir2;
    }

    public void setVir2(Set<Virement> vir2) {
        Vir2 = vir2;
    }



    @Override
    public String toString() {
        return "Compte{" +
                "numero_de_compte=" + numero_de_compte +
                ", type=" + type +
                ", devise='" + devise + '\'' +
                ", solde=" + solde +
                ", status=" + status +
                ", date_ouverture=" + date_ouverture +
                ", client=" + client_id +
                '}';
    }
}
