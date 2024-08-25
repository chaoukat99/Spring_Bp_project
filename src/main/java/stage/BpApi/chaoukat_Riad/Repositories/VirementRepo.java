package stage.BpApi.chaoukat_Riad.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import stage.BpApi.chaoukat_Riad.Entities.Virement;

public interface VirementRepo extends JpaRepository<Virement,String> {

}
