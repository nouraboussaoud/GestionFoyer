package tn.esprit.gestionfoyer.service;

import tn.esprit.gestionfoyer.models.Universite;

import java.util.List;

public interface IUniversiteService {
    List<Universite> retrieveAllUniversities();
    Universite addUniversite (Universite u);
    Universite updateUniversite (Universite u);
    Universite modifierUniversiteParid(long idUniversite , Universite universite);

    Universite retrieveUniversite (long idUniversite);

}
