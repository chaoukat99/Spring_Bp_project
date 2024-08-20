package stage.BpApi.chaoukat_Riad.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stage.BpApi.chaoukat_Riad.Entities.Client;
import stage.BpApi.chaoukat_Riad.Entities.Compte;
import stage.BpApi.chaoukat_Riad.Repositories.CompteRepositor;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

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


public Iterable<Compte> GetAccounts() {
    return compterepo.findAll();


}
// Post New Account


public String PostAccount(Compte Acc){




         Compte new_account= new Compte();

         Client searched_client = clientservice.clientcin("MA1212");

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





}
