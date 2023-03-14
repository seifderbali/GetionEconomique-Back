package tn.esprit.services;

import tn.esprit.entities.ComiteTechnique;

import java.util.List;

public interface IComiteTechniqueService {

    List<ComiteTechnique> retreiveAllComiteTechnique();
    ComiteTechnique addComiteTechnique(ComiteTechnique c);
    void deleteComiteTechnique(long id);
    ComiteTechnique updateComiteTechnique(ComiteTechnique c);
    ComiteTechnique retrieveComiteTechnique(long id);
    List<ComiteTechnique> searchComiteTechnique(String keyword);
}


