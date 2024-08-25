package stage.BpApi.chaoukat_Riad.Services;

import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import stage.BpApi.chaoukat_Riad.Entities.Client;
import stage.BpApi.chaoukat_Riad.Entities.Dto.ClientDto;
import stage.BpApi.chaoukat_Riad.Entities.Fournisseur;
import stage.BpApi.chaoukat_Riad.Repositories.FournisseurRepo;
import stage.BpApi.chaoukat_Riad.Repositories.clientRepo;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ClientService {

    @Autowired
    private FournisseurRepo fourssineur;
    @Autowired
    private  clientRepo clientRepo;




    public String SaveFournisseur(Fournisseur fr){
        fourssineur.save(fr);
        return "created";
    }

    public String GetRootMessage(){
        return "Welcome To BP API We are working on THREE DIfferent Endpoints \n ACCOUNT  CLIENT VIREMENT ";
    }




public String SaveClient(Client client) {
         clientRepo.save(client);
         return "created";
    }
   public Client clientcin(String cin){


        return clientRepo.findByCin(cin).orElseThrow(()->new RuntimeException("UNfound Client"));
   }




   public ClientDto findById(String id){
        return clientRepo.findById(id).map(client ->new ClientDto(
                client.getId(),
                client.getNom(),
                client.getPrenom(),
                client.getAge(),
                client.getEmail(),
                client.getMobile(),
                client.getCin(),
                client.getAdresse(),
                client.getAdresse_banque_origine(),
                client.getCreated_at()
        )).orElseThrow(() -> new RuntimeException("Client not found"));
   }





   public List<ClientDto> getallclient(){
        return clientRepo.findAll().stream().map(client -> new ClientDto(
                client.getId(),
                client.getNom(),
                client.getPrenom(),
                client.getAge(),
                client.getEmail(),
                client.getMobile(),
                client.getCin(),
                client.getAdresse(),
                client.getAdresse_banque_origine(),
                client.getCreated_at()
        )).collect(Collectors.toList());
   }

   public String updateClient(String  cin, Client client){
        Client clientbd =  this.clientcin(cin);
        clientbd.setNom(client.getNom());
        clientbd.setPrenom(client.getPrenom());
        clientbd.setAge(client.getAge());
        clientbd.setAdresse(client.getAdresse());
        clientbd.setMobile(client.getMobile());
        clientbd.setAdresse_banque_origine(client.getAdresse_banque_origine());
        clientbd.setEmail(client.getEmail());

       this.clientRepo.save(clientbd);
        return "Client Updated Successfully";

   }


 @Transactional
   public String deleteclient(String cin){

        Client searched_client=this.clientcin(cin);
        if(searched_client.getNom().isEmpty()){
            return "Unfound Client";
        }else{
            this.clientRepo.deleteByCin(cin);
            return "Client Deleted Successfully";
        }

   }









}
