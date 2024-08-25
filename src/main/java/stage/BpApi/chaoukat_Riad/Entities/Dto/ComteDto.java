package stage.BpApi.chaoukat_Riad.Entities.Dto;

import stage.BpApi.chaoukat_Riad.Entities.Status;
import stage.BpApi.chaoukat_Riad.Entities.Type;

import java.util.Date;

public class ComteDto {

    private long numero_de_compte;
    private Type type;
    private  String devise;
    private  double solde ;
    private Status status;
    private Date date_ouverture;
    private String cinclient;


    // CONSTRUCTORS
    public ComteDto(){};



    public ComteDto(long numeroDeCompte, double solde, Type type, Date dateOuverture, Status status,String cinClient,String devise) {
        this.numero_de_compte=numeroDeCompte;
        this.solde=solde;
        this.type=type;
        this.date_ouverture=dateOuverture;
        this.status=status ;
        this.cinclient=cinClient ;
        this.devise=devise;

    }

    public String getCinclient() {
        return cinclient;
    }

    public void setCinclient(String cinclient) {
        this.cinclient = cinclient;
    }

    public Long getNumero_de_compte() {
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
}
