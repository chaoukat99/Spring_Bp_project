package stage.BpApi.chaoukat_Riad.Entities;


import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Entity
public class Virement {

    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private String id ;
    @Column(name = "Solde",nullable = false)
    private  double amount ;
    @Column(name="status",nullable = false)
    private StatusVirement status;
    @CreationTimestamp
    @Column(name="created_at",nullable =true)
    private Date createdat;
    @ManyToOne
    @JoinColumn(name = "compte_src",nullable = false)
    private Compte compte_src;
    @ManyToOne
    @JoinColumn(name="compte_dest",nullable = false)
    private  Compte compte_dest;



    @Column
    private Long num_compte_src;
    @Column
    private Long num_compte_dest;


    public Virement(){};

    public Virement(String id, double amount, StatusVirement status, Date createdat, Compte compte_src, Compte compte_dest, Long num_compte_src, Long num_compte_dest) {
        this.id = id;
        this.amount = amount;
        this.status = status;
        this.createdat = createdat;
        this.compte_src = compte_src;
        this.compte_dest = compte_dest;
        this.num_compte_src = num_compte_src;
        this.num_compte_dest = num_compte_dest;
    }

    public Long getNum_compte_dest() {
        return num_compte_dest;
    }

    public void setNum_compte_dest(Long num_compte_dest) {
        this.num_compte_dest = num_compte_dest;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public StatusVirement getStatus() {
        return status;
    }

    public void setStatus(StatusVirement status) {
        this.status = status;
    }

    public Date getCreatedat() {
        return createdat;
    }

    public void setCreatedat(Date createdat) {
        this.createdat = createdat;
    }

    public Compte getCompte_src() {
        return compte_src;
    }

    public void setCompte_src(Compte compte_src) {
        this.compte_src = compte_src;
    }

    public Compte getCompte_dest() {
        return compte_dest;
    }

    public void setCompte_dest(Compte compte_dest) {
        this.compte_dest = compte_dest;
    }

    public Long getNum_compte_src() {
        return num_compte_src;
    }

    public void setNum_compte_src(Long num_compte_src) {
        this.num_compte_src = num_compte_src;
    }


}
