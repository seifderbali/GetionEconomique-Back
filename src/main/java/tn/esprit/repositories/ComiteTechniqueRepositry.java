package tn.esprit.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.ComiteTechnique;

import java.util.List;

@Repository

public interface ComiteTechniqueRepositry extends CrudRepository<ComiteTechnique, Long> {
    @Query("select c from ComiteTechnique c where c.annee like %?1% or c.statutProjet like %?1% or c.axeDemande like %?1% or c.typeDemande like %?1% or c.observationComite like %?1%")
    List<ComiteTechnique> search(String keyword);
}
