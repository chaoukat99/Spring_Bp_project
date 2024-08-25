package stage.BpApi.chaoukat_Riad.Services;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stage.BpApi.chaoukat_Riad.Entities.Compte;
import stage.BpApi.chaoukat_Riad.Entities.Virement;
import stage.BpApi.chaoukat_Riad.Repositories.CompteRepositor;
import stage.BpApi.chaoukat_Riad.Repositories.VirementRepo;
import java.util.UUID;
import java.util.Date;

@Service




public class VirementService {
    private VirementRepo virementRepo ;

    public VirementService(VirementRepo virementRepo, CompteService compteService) {
        this.virementRepo = virementRepo;
        this.compteService = compteService;
    }

    private CompteService compteService;





    public String PostVirement(Virement virr){


        Compte src_Account = compteService.findById(virr.getNum_compte_src());
        Compte dest_Account = compteService.findById(virr.getNum_compte_dest());
        Virement newVirement = new Virement();
         if(!compteService.CheckSolde(src_Account,virr.getAmount())){
              return "Impossible de passer Le virement" ;
         }else{
             // random Id
             // String generatedId = UUID.randomUUID().toString();

             //newVirement.setId(generatedId);
            // newVirement.setCreatedat(new Date());
             newVirement.setCompte_src(src_Account);
             newVirement.setCompte_dest(dest_Account);
             newVirement.setStatus(virr.getStatus());
             newVirement.setNum_compte_dest(virr.getNum_compte_dest());
             newVirement.setNum_compte_src(virr.getNum_compte_src());
             newVirement.setAmount(virr.getAmount());

              this.compteService.PrelevementCompte(src_Account,virr.getAmount());
              this.compteService.CrediterAccount(dest_Account,virr.getAmount());
              this.virementRepo.save(newVirement);



              return "Virement Effectué";







         }




    }






}
