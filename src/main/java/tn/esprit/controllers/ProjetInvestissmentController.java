package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.ProjetInvestissment;
import tn.esprit.services.IBudgetInvestissementService;
import tn.esprit.services.IEntiteSIService;
import tn.esprit.services.IProjetInvestissmentService;


import java.util.List;

@RestController
@RequestMapping("/ProjetInvestissment")
@CrossOrigin(origins = {"*","http://localhost:4200/"})

public class ProjetInvestissmentController {
    @Autowired
    IProjetInvestissmentService Ps;
    @Autowired
    IEntiteSIService Es;

    @Autowired
    IBudgetInvestissementService Bs;

    @PostMapping("/addProjetInvestissment/{ide}/{idb}")
    void add(@RequestBody ProjetInvestissment p, @PathVariable("ide") int ide, @PathVariable("idb") int idb)
    {

        p.setEntiteSI(Es.retrieveEntiteSI(ide));
        p.setBudgetInvestissement(Bs.retrieveBudgetInvestissement(idb));
        Ps.addProjetInvestissmentr(p);
    }

    @PutMapping("/updateProjetInvestissment")
    void update(@RequestBody ProjetInvestissment p)
    {
        Ps.updateProjetInvestissment(p);
    }
    @DeleteMapping("/deleteProjetInvestissment/{id}")
    void delete(@PathVariable("id") int id)
    {
        Ps.deleteProjetInvestissment(id);
    }
    @GetMapping("/displayProjetInvestissment")
    List<ProjetInvestissment> display()
    {
        return Ps.retreiveAllProjetInvestissment();
    }
    @GetMapping("/find/{id}")
    ProjetInvestissment find(@PathVariable("id") int id)
    {
        return Ps.retrieveProjetInvestissment(id);
    }

    @GetMapping("/search/{keyword}")
    List<ProjetInvestissment> search(@PathVariable("keyword") String keyword)
    {
        return Ps.searchProjetInvestissment(keyword);
    }
}
