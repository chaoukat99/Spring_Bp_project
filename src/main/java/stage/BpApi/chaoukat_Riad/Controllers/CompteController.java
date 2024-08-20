package stage.BpApi.chaoukat_Riad.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import stage.BpApi.chaoukat_Riad.Entities.Compte;
import stage.BpApi.chaoukat_Riad.Services.CompteService;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {


    // getting service

    @Autowired

    private CompteService servicecompte ;


    @GetMapping("/")
    public Iterable<Compte> GetAccounts(){
        return  servicecompte.GetAccounts();
    }

    @ResponseStatus(value = HttpStatus.CREATED)

    @PostMapping("/postAccount")

    public String PostAccount(@RequestBody Compte Acc){

        return servicecompte.PostAccount(Acc);
    }


}
