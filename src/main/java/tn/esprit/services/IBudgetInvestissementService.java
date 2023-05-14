package tn.esprit.services;


import tn.esprit.entities.BudgetInvestissement;

import java.util.List;

public interface IBudgetInvestissementService {

    List<BudgetInvestissement> retreiveAllBudgetInvestissement();
    BudgetInvestissement addBudgetInvestissement(BudgetInvestissement b);
    void deleteBudgetInvestissement(long id);
    BudgetInvestissement updateBudgetInvestissement(BudgetInvestissement b);
    BudgetInvestissement retrieveBudgetInvestissement(long id);
    List<BudgetInvestissement> searchBudgetInvestissement(String keyword);
    BudgetInvestissement findByContrat(long id);

}


