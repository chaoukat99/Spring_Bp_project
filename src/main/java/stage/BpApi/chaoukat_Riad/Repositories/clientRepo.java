package stage.BpApi.chaoukat_Riad.Repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import stage.BpApi.chaoukat_Riad.Entities.Client;
import stage.BpApi.chaoukat_Riad.Entities.Compte;

import java.util.List;
import java.util.Optional;

public interface clientRepo  extends CrudRepository<Client,String> {


    Optional<Client> findByCin(String cin);
    void deleteByCin(String cin);


}
