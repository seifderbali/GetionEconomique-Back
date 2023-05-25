package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.Depense;
import tn.esprit.services.IContatDeMarcheService;
import tn.esprit.services.IDepenseService;
import tn.esprit.services.IFactureService;

import java.util.List;

@RestController
@RequestMapping("/Depense")
@CrossOrigin(origins = {"*","http://localhost:4200/"})
public class DepenseController {

    @Autowired
    IDepenseService Ds;
    @Autowired
    IFactureService Fs;
    @Autowired
    IContatDeMarcheService Cs;


    @PostMapping("/addDepense/{idf}/{idc}")
    void add(@RequestBody Depense d, @PathVariable("idf") int idf, @PathVariable("idc") int idc)
    {
        d.setFacture(Fs.retrieveFacture(idf));
        d.setContrat(Cs.retrieveContatDeMarche(idc));
        Ds.addDepense(d);
    }

    @PutMapping("/updateDepense")
    void update(@RequestBody Depense d)
    {
        Ds.updateDepense(d);
    }

    @DeleteMapping("/deleteDepense/{id}")
    void delete(@PathVariable("id") int id)
    {
        Ds.deleteDepense(id);
    }
    @GetMapping("/displayDepense")
    List<Depense> display()
    {
        return Ds.retreiveAllDepense();
    }

    @GetMapping("/find/{id}")
    Depense find(@PathVariable("id") int id)
    {
        return Ds.retrieveDepense(id);
    }

    @GetMapping("/search/{keyword}")
    List<Depense> search(@PathVariable("keyword") String keyword)
    {
        return Ds.searchDepense(keyword);
    }

}
