package tn.esprit.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.entities.BudgetInvestissement;
import tn.esprit.repositories.BudgetInvestissementRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class BudgetInvestissementService implements IBudgetInvestissementService {

    @Autowired
    BudgetInvestissementRepository budgetInvestissementRepository;

    @Override
    public List<BudgetInvestissement> retreiveAllBudgetInvestissement() {
        List<BudgetInvestissement> listBudgetInvestissements = new ArrayList<BudgetInvestissement>();
        try {
            listBudgetInvestissements = (List<BudgetInvestissement>) budgetInvestissementRepository.findAll();
            for(BudgetInvestissement b : listBudgetInvestissements)
            {
             //   u.setUsers(null);
                log.info("user = "+b);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listBudgetInvestissements;
    }

    @Override
    public BudgetInvestissement addBudgetInvestissement(BudgetInvestissement b) {
        try
        {
            budgetInvestissementRepository.save(b);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return b;
    }

    @Override
    public void deleteBudgetInvestissement(long id) {
        try{
            //	Long idl = Long.parseLong(id);
            budgetInvestissementRepository.deleteById(id);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }

    }

    @Override
    public BudgetInvestissement updateBudgetInvestissement(BudgetInvestissement b) {
        try
        {
            budgetInvestissementRepository.save(b);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return b;
    }

    @Override
    public BudgetInvestissement retrieveBudgetInvestissement(long id) {
        BudgetInvestissement b = new BudgetInvestissement();
        try{
            b = budgetInvestissementRepository.findById(id).get();
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return b ;
    }

    @Override
    public List<BudgetInvestissement> searchBudgetInvestissement(String keyword) {
        List<BudgetInvestissement> listBudgetInvestissements = new ArrayList<BudgetInvestissement>();
        try {
            listBudgetInvestissements = (List<BudgetInvestissement>) budgetInvestissementRepository.search(keyword);
            for(BudgetInvestissement b : listBudgetInvestissements)
            {
                log.info("BudgetInvestissement = "+b);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listBudgetInvestissements;
    }

    @Override
    public BudgetInvestissement findByContrat(long id) {
        return budgetInvestissementRepository.findContrat(id);
    }


}
