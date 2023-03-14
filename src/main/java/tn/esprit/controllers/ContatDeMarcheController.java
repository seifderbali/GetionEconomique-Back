package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.ContatDeMarche;
import tn.esprit.services.IBudgetInvestissementService;
import tn.esprit.services.IContatDeMarcheService;
import tn.esprit.services.IFournisseurService;

import java.util.List;

@RestController
@RequestMapping("/ContatDeMarche")
@CrossOrigin(origins = {"*","http://localhost:4200/"})

public class ContatDeMarcheController {

    @Autowired
    IContatDeMarcheService Cs;

    @Autowired
    IBudgetInvestissementService Bs;

    @Autowired
    IFournisseurService Fs;


    @PostMapping("/addContatDeMarche/{idb}/{idf}")
    void add(@RequestBody ContatDeMarche c, @PathVariable("idb") long idb, @PathVariable("idf") long idf)
    {
        c.setBudgetInvestissement(Bs.retrieveBudgetInvestissement(idb));
        c.setFournisseur(Fs.retrieveFournisseur(idf));
        Cs.addContatDeMarche(c);
    }

    @PutMapping("/updateContatDeMarche")
    void update(@RequestBody ContatDeMarche c)
    {
        Cs.updateContatDeMarche(c);
    }
    @DeleteMapping("/deleteContatDeMarche/{id}")
    void delete(@PathVariable("id") int id)
    {
        Cs.deleteContatDeMarche(id);
    }
    @GetMapping("/displayContatDeMarche")
    List<ContatDeMarche> display()
    {
        return Cs.retreiveAllContatDeMarche();
    }
    @GetMapping("/find/{id}")
    ContatDeMarche find(@PathVariable("id") int id)
    {
        return Cs.retrieveContatDeMarche(id);
    }

    @GetMapping("/search/{keyword}")
    List<ContatDeMarche> search(@PathVariable("keyword") String keyword)
    {
        return Cs.searchContatDeMarche(keyword);
    }
}
