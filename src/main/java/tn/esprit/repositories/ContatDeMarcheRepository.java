package tn.esprit.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.ContatDeMarche;

import java.util.List;

@Repository

public interface ContatDeMarcheRepository extends CrudRepository<ContatDeMarche, Long> {

    @Query("select c from ContatDeMarche c where c.reference like %?1% or c.objetContrat like %?1% or c.intituleProjet like %?1% or c.observation like %?1% or c.montantHT like %?1% or c.montantTTC like %?1% or c.dateAcquisition like %?1% or c.dateReceptionProvisoire like %?1% or c.dateReceptionDefinitive like %?1%")
    List<ContatDeMarche> search(String keyword);
}
