package stage.BpApi.chaoukat_Riad.Entities;


import jakarta.persistence.*;

import java.util.Date;


@Entity
public class Virement {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id ;
    @Column(name = "Solde",nullable = false)
    private  double amount ;
    @Column(name="status",nullable = false)
    private StatusVirement status;
    @Column(name="created_at",nullable = false)
    private Date createdat;
    @ManyToOne
    @JoinColumn(name = "compte_src",nullable = false)
    private Compte compte_src;
    @ManyToOne
    @JoinColumn(name="compte_dest",nullable = false)
    private  Compte compte_dest;


}
