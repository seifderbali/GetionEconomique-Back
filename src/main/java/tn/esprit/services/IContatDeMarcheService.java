package tn.esprit.services;


import tn.esprit.entities.ContatDeMarche;

import java.util.List;

public interface IContatDeMarcheService {

    List<ContatDeMarche> retreiveAllContatDeMarche();
    ContatDeMarche addContatDeMarche(ContatDeMarche c);
    void deleteContatDeMarche(long id);
    ContatDeMarche updateContatDeMarche(ContatDeMarche c);
    ContatDeMarche retrieveContatDeMarche(long id);
    List<ContatDeMarche> searchContatDeMarche(String keyword);
}
