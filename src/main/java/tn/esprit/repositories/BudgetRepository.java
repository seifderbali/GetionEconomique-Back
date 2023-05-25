
package tn.esprit.repositories;

        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.CrudRepository;
        import org.springframework.stereotype.Repository;
        import tn.esprit.entities.Budget;
        import tn.esprit.entities.EntiteSI;
        import tn.esprit.entities.ProjetInvestissment;

        import java.security.SecureRandom;
        import java.util.List;

@Repository
public interface BudgetRepository extends CrudRepository<Budget, Long> {
    @Query("select b from Budget b where b.type = 'Investissement' and b.anneebudgetaire like %?1% or b.coutLogiciel like %?1% or b.coutMateriel like %?1% or b.coutEtudeServ like %?1%")
    List<Budget> searchBudgetInvestissement(String keyword);
    @Query("select b from Budget b where b.type = 'Maintenance' and b.anneebudgetaire like %?1% or b.coutLogiciel like %?1% or b.coutMateriel like %?1% or b.coutEtudeServ like %?1%")
    List<Budget> searchBudgetMaintenance(String keyword);
    @Query("select b.budget from ContatDeMarche b where b.id =:#{#id}")
    Budget findContrat(long id );



    @Query("select b from Budget b where b.type = 'Investissement'")
    List<Budget> findAllBudgetInvestissement();
    @Query("select b from Budget b where b.type = 'Maintenance'")
    List<Budget> findAllBudgetMaintenance();



    @Query("select b from Budget b where b.type = 'Investissement' and b.entiteSI.id =:#{#id}")
    List<Budget> findByEntiteInv(long id);
    @Query("select b from Budget b where b.type = 'Maintenance' and b.entiteSI.id =:#{#id}")
    List<Budget> findByEntiteMain(long id);


}
