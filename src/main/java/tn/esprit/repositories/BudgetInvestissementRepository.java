package tn.esprit.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.entities.BudgetInvestissement;
import tn.esprit.entities.EntiteSI;

import java.util.List;

@Repository
public interface BudgetInvestissementRepository extends CrudRepository<BudgetInvestissement, Long> {
    @Query("select b from BudgetInvestissement b where b.anneebudgetaire like %?1% or b.coutLogiciel like %?1% or b.coutMateriel like %?1% or b.coutEtudeServ like %?1%")
    List<BudgetInvestissement> search(String keyword);
}
