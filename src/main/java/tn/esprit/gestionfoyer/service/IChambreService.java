package tn.esprit.gestionfoyer.service;

import tn.esprit.gestionfoyer.models.Chambre;

import java.time.LocalDate;

public interface IChambreService {
    long nombreChambreNonReserve(String nomFoyer , LocalDate anneUniversitaire);
    Chambre ajouterChambreEtBloc(Chambre chambre) ;
}
