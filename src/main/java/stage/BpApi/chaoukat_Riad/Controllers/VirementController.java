package stage.BpApi.chaoukat_Riad.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stage.BpApi.chaoukat_Riad.Entities.Virement;
import stage.BpApi.chaoukat_Riad.Services.VirementService;

@RestController
@RequestMapping("/api/virement")
public class VirementController {

    @Autowired
    private VirementService viremenserv;

    @PostMapping("/postvirement")

    public String ADDVirement(@RequestBody Virement virr){

        return viremenserv.PostVirement(virr);
    }



}
