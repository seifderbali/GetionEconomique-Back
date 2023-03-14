package tn.esprit.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.entities.Fournisseur;
import tn.esprit.services.IFournisseurService;


import java.util.List;

@RestController
@RequestMapping("/Fournisseur")
@CrossOrigin(origins = {"*","http://localhost:4200/"})

public class FournisseurController {

    @Autowired
    IFournisseurService Fs;


    @PostMapping("/addFournisseur")
    void add(@RequestBody Fournisseur f)
    {
        Fs.addFournisseur(f);
    }

    @PutMapping("/updateFournisseur")
    void update(@RequestBody Fournisseur f)
    {
        Fs.updateFournisseur(f);
    }
    @DeleteMapping("/deleteFournisseur/{id}")
    void delete(@PathVariable("id") int id)
    {
        Fs.deleteFournisseur(id);
    }
    @GetMapping("/displayFournisseur")
    List<Fournisseur> display()
    {
        return Fs.retreiveAllFournisseur();
    }
    @GetMapping("/find/{id}")
    Fournisseur find(@PathVariable("id") int id)
    {
        return Fs.retrieveFournisseur(id);
    }

    @GetMapping("/search/{keyword}")
    List<Fournisseur> search(@PathVariable("keyword") String keyword)
    {
        return Fs.searchFournisseur(keyword);
    }
}
