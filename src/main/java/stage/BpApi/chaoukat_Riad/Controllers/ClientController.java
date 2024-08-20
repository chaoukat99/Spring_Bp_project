package stage.BpApi.chaoukat_Riad.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import stage.BpApi.chaoukat_Riad.Entities.Client;
import stage.BpApi.chaoukat_Riad.Entities.Fournisseur;
import stage.BpApi.chaoukat_Riad.Services.ClientService;

import java.util.Optional;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private  ClientService clientService;




      @GetMapping("/{cin}")
           public Client clientcin(@PathVariable String cin){
            return clientService.clientcin(cin);
     }


    @ResponseStatus(value = HttpStatus.CREATED)

    @PostMapping("/postclient")
    public String saveClient(@RequestBody Client client) {

        return clientService.SaveClient(client);
    }

    @GetMapping("/")
    public Iterable<Client> getallclient(){
        return clientService.getallclient();
    }


    @PutMapping("/updateClient/{cin}")
    public String update(@PathVariable String  cin, @RequestBody Client client){
        return clientService.updateClient(cin,client);
    }
    @DeleteMapping("/deleteclient/{cin}")
    public String delete(@PathVariable String cin){
        return clientService.deleteclient(cin);
    }





}
