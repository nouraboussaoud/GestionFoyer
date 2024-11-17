package tn.esprit.gestionfoyer.service;

import tn.esprit.gestionfoyer.models.Chambre;
import tn.esprit.gestionfoyer.models.Foyer;
import tn.esprit.gestionfoyer.models.Universite;

import java.util.List;

public interface IFoyerService  {
    Foyer ajouterFoyerEtBloc(Foyer foyer );
    Foyer ajouterFoyer(Foyer foyer);
    Foyer modifierFoyer(Foyer foyer);
    Foyer modifierFoyerParid(long idFoyer , Foyer foyer);
    Foyer chercherParId(long idFoyer);
    List<Foyer> afficherTout();
    Boolean supprimerFoyer(Foyer foyer);
    Boolean supprimerParId(long idFoyer);
    public Universite affecterFoyerAUniversite(long idFoyer , String nomUniversite);
    public Universite desaffecterFoyerAUniversite(long idFoyer, String nomUniversite);
    public List<Chambre> getInvalidReservationsByFoyer(String nomFoyer) ;
}