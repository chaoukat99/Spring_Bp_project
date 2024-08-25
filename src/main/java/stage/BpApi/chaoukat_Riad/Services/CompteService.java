package stage.BpApi.chaoukat_Riad.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stage.BpApi.chaoukat_Riad.Entities.Client;
import stage.BpApi.chaoukat_Riad.Entities.Compte;
import stage.BpApi.chaoukat_Riad.Entities.Dto.ComteDto;
import stage.BpApi.chaoukat_Riad.Entities.Status;
import stage.BpApi.chaoukat_Riad.Repositories.CompteRepositor;

import java.util.List;
import java.util.Optional;
import java.util.Random;
import java.util.stream.Collectors;

@Service
public class CompteService {

    @Autowired
    private CompteRepositor compterepo;


    // getting client service
    @Autowired
    private ClientService clientservice;



// Method That generate Random Long Value
public  long GenerateRandomAccountNumber(){
    Random random = new Random();

    long min=11111111111L;
    long max=99999999999L;
    long randomLong = min + (long) (random.nextDouble() * (max - min + 1));

    return randomLong ;
}



// Get all accounts

  /*  public Iterable<Compte> GetAccounts(){
        List<Compte> comptes  compterepo.findAll();
        return comptes.stream().map(compte -> new Compte(
                compte.getNumero_de_compte(),
                compte.getType(),
                compte.getDevise(),
                compte.getSolde()
        )).collect(Collectors.toUnmodifiableList());
    }
*/


public List<ComteDto> GetAccounts(){
    return compterepo.findAll().stream()
            .map(compte -> new ComteDto(compte.getNumero_de_compte(),compte.getSolde(),compte.getType(),compte.getDate_ouverture(),compte.getStatus(),compte.getCinclient(),compte.getDevise()))
            .collect(Collectors.toList());
}
// Post New Account

    public ComteDto findbyco(long numero_de_compte){
          return compterepo.findById(numero_de_compte).map(compte -> new ComteDto(compte.getNumero_de_compte(),compte.getSolde(),compte.getType(),compte.getDate_ouverture(),compte.getStatus(),compte.getCinclient(),compte.getDevise()))
                .orElseThrow(() -> new RuntimeException("Account not found"));
    }



    public Compte findById(Long num_compte){

        return compterepo.findById(num_compte).orElseThrow(()->new RuntimeException("UNfound Account"));
    }


public String PostAccount(Compte Acc){




         Compte new_account= new Compte();

         Client searched_client = clientservice.clientcin(Acc.getCinclient());

         new_account.setClient(searched_client);
         new_account.setDevise(Acc.getDevise());
         new_account.setSolde(Acc.getSolde());
         new_account.setStatus(Acc.getStatus());
         new_account.setType(Acc.getType());
         new_account.setCinclient(Acc.getCinclient());
         new_account.setNumero_de_compte(this.GenerateRandomAccountNumber());


         compterepo.save(new_account);




         return  "Created ";
}


    public Boolean CheckSolde(Compte acc,double solde){

        double SoldeActuelle = acc.getSolde();

        return SoldeActuelle-solde >= 0 ;

    }





public Boolean PrelevementCompte(Compte acc,Double Solde_a_prelever){



    if(!this.CheckSolde(acc,Solde_a_prelever)){
        return false ;
    }else{
        acc.setSolde(acc.getSolde()-Solde_a_prelever);
        return true ;
    }

}



public Boolean CrediterAccount(Compte acc,Double Solde_a_crediter){

    acc.setSolde(acc.getSolde()+Solde_a_crediter);
    return true;
}


public String deletecompte(Long numero_de_compte){

    compterepo.deleteById(numero_de_compte);
    return "Account Deleted ";

}



    public String UpdateStatus(Status status,Long id_compte){

    Compte acc = this.findById(id_compte);


      acc.setStatus(status);
      compterepo.save(acc);
    return "Account Status Updated successfully";
    }








}
