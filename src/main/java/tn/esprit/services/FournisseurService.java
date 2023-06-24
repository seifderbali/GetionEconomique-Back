package tn.esprit.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.entities.EntiteSI;
import tn.esprit.entities.Fournisseur;
import tn.esprit.repositories.FournisseurRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class FournisseurService implements IFournisseurService{
    @Autowired
    FournisseurRepository fournisseurRepository;

    @Override
    public List<Fournisseur> retreiveAllFournisseur() {
        List<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>();
        try {
            listFournisseurs = (List<Fournisseur>) fournisseurRepository.findAll();
            for(Fournisseur f : listFournisseurs)
            {
              //  u.setUsers(null);
                log.info("Fournisseur = "+f);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listFournisseurs;       }

    @Override
    public Fournisseur addFournisseur(Fournisseur f) {
        try
        {
            fournisseurRepository.save(f);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return f;
    }


    @Override
    public void deleteFournisseur(long id) {
        try{
            //	Long idl = Long.parseLong(id);
            fournisseurRepository.deleteById(id);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
    }

    @Override
    public Fournisseur updateFournisseur(Fournisseur f) {
        try
        {
            fournisseurRepository.save(f);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return f;    }

    @Override
    public Fournisseur retrieveFournisseur(long id) {
        Fournisseur f = new Fournisseur();
        try{
            f = fournisseurRepository.findById(id).get();
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return f ;
    }

    @Override
    public List<Fournisseur> searchFournisseur(String keyword) {
        List<Fournisseur> listFournisseurs = new ArrayList<Fournisseur>();
        try {
            listFournisseurs = (List<Fournisseur>) fournisseurRepository.search(keyword);
            for(Fournisseur f : listFournisseurs)
            {
                log.info("Fournisseur = "+f);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listFournisseurs;    }

    @Override
    public Fournisseur findByContrat(long id) {
        return fournisseurRepository.findByContrat(id);
    }

    @Override
    public String findBudget(long id) {


        return  fournisseurRepository.findBudget(id);
    }
}
