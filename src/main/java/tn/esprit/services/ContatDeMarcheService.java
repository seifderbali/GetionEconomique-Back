package tn.esprit.services;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.entities.ContatDeMarche;
import tn.esprit.repositories.ContatDeMarcheRepository;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class ContatDeMarcheService implements IContatDeMarcheService {

    @Autowired
    ContatDeMarcheRepository contatDeMarcheRepository;

    @Override
    public List<ContatDeMarche> retreiveAllContatDeMarche() {
        List<ContatDeMarche> listContatDeMarches = new ArrayList<ContatDeMarche>();
        try {
            listContatDeMarches = (List<ContatDeMarche>) contatDeMarcheRepository.findAll();
            for(ContatDeMarche c: listContatDeMarches)
            {
                //   u.setUsers(null);
                log.info("ContatDeMarche = "+c);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listContatDeMarches;    }

    @Override
    public ContatDeMarche addContatDeMarche(ContatDeMarche c) {
        try
        {
            contatDeMarcheRepository.save(c);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return c;    }

    @Override
    public void deleteContatDeMarche(long id) {
        try{
            //	Long idl = Long.parseLong(id);
            contatDeMarcheRepository.deleteById(id);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
    }

    @Override
    public ContatDeMarche updateContatDeMarche(ContatDeMarche c) {
        try
        {
            contatDeMarcheRepository.save(c);
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return c;
    }

    @Override
    public ContatDeMarche retrieveContatDeMarche(long id) {
        ContatDeMarche c = new ContatDeMarche();
        try{
            c = contatDeMarcheRepository.findById(id).get();
        }
        catch(Exception e)
        {
            log.info("error = "+e);
        }
        return c ;
    }

    @Override
    public List<ContatDeMarche> searchContatDeMarche(String keyword) {
        List<ContatDeMarche> listContatDeMarches = new ArrayList<ContatDeMarche>();
        try {
            listContatDeMarches = (List<ContatDeMarche>) contatDeMarcheRepository.search(keyword);
            for(ContatDeMarche c : listContatDeMarches)
            {
                log.info("ContatDeMarche = "+c);
            }}
        catch(Exception e)
        {
            log.info("error = "+e);
        }

        return listContatDeMarches;        }
}
