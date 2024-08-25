package stage.BpApi.chaoukat_Riad.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import stage.BpApi.chaoukat_Riad.Entities.Compte;
import stage.BpApi.chaoukat_Riad.Entities.Dto.ComteDto;
import stage.BpApi.chaoukat_Riad.Entities.Status;
import stage.BpApi.chaoukat_Riad.Services.CompteService;

import java.util.List;

@RestController
@RequestMapping("/api/comptes")
public class CompteController {


    // getting service

    @Autowired

    private CompteService servicecompte ;


    @GetMapping("/")
    public List<ComteDto> GetAccounts(){
        return  servicecompte.GetAccounts();
    }

    @ResponseStatus(value = HttpStatus.CREATED)

    @PostMapping("/postAccount")

    public String PostAccount(@RequestBody Compte Acc){

        return servicecompte.PostAccount(Acc);
    }
    @GetMapping("/account/{numero_de_compte}")
    public ComteDto  findbyco (@PathVariable long numero_de_compte){
        return  servicecompte.findbyco(numero_de_compte);
    }
    @DeleteMapping("/deleteaccount/{numero_de_compte}")
    public String deletecompte(@PathVariable long numero_de_compte){
        return  servicecompte.deletecompte(numero_de_compte);
    }


    @PatchMapping("/upateStatus/{numAcc}/{status}")
    public String UpdateStatus(@PathVariable Long numAcc,@PathVariable Status status){
            return servicecompte.UpdateStatus(status,numAcc);
    }


}
