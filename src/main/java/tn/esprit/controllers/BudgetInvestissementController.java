package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.BudgetInvestissement;
import tn.esprit.services.IBudgetInvestissementService;


import java.util.List;

@RestController
@RequestMapping("/BudgetInvestissement")
@CrossOrigin(origins = {"*","http://localhost:4200/"})

public class BudgetInvestissementController {

    @Autowired
    IBudgetInvestissementService Bs;


    @PostMapping("/addBudgetInvestissement")
    void add(@RequestBody BudgetInvestissement b)
    {
        Bs.addBudgetInvestissement(b);
    }

    @PutMapping("/updateBudgetInvestissement")
    void update(@RequestBody BudgetInvestissement b)
    {
        Bs.updateBudgetInvestissement(b);
    }
    @DeleteMapping("/deleteBudgetInvestissement/{id}")
    void delete(@PathVariable("id") int id)
    {
        Bs.deleteBudgetInvestissement(id);
    }
    @GetMapping("/displayBudgetInvestissements")
    List<BudgetInvestissement> display()
    {
        return Bs.retreiveAllBudgetInvestissement();
    }
    @GetMapping("/find/{id}")
    BudgetInvestissement find(@PathVariable("id") int id)
    {
        return Bs.retrieveBudgetInvestissement(id);
    }

    @GetMapping("/search/{keyword}")
    List<BudgetInvestissement> search(@PathVariable("keyword") String keyword)
    {
        return Bs.searchBudgetInvestissement(keyword);
    }
}
