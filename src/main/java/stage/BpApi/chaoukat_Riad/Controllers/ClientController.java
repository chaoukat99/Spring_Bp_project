package stage.BpApi.chaoukat_Riad.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import stage.BpApi.chaoukat_Riad.Entities.Client;
import stage.BpApi.chaoukat_Riad.Entities.Dto.ClientDto;
import stage.BpApi.chaoukat_Riad.Services.ClientService;
import stage.BpApi.chaoukat_Riad.Services.EmailService;

import java.util.List;



@RestController
@RequestMapping("/api/clients")
public class ClientController {
    @Autowired
    private  ClientService clientService;
    @Autowired
    private EmailService emailservice ;


    @GetMapping("/sendemail")
    public String SendEmail(){

       emailservice.sendSimpleMessage("youssefriading@gmail.com","Test from spring bp app","HELLO YOUSSEF WHAT'S Going on ");

        return "Email sent" ;
    }



    @GetMapping("/{cin}")
           public Client clientcin(@PathVariable String cin){
            return clientService.clientcin(cin);
     }


    @GetMapping("/Id/{id}")
    public ClientDto clientId(@PathVariable String id){
        return clientService.findById(id);
    }

    @ResponseStatus(value = HttpStatus.CREATED)

    @PostMapping("/postclient")
    public String saveClient(@RequestBody Client client) {

        return clientService.SaveClient(client);
    }

    @GetMapping("/")
    public List<ClientDto> getallclient(){
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
