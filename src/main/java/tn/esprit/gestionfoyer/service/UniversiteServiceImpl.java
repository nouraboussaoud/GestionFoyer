package tn.esprit.gestionfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.models.Foyer;
import tn.esprit.gestionfoyer.models.Universite;
import tn.esprit.gestionfoyer.repository.IUniversityRepo;

import java.util.List;
@Service
@AllArgsConstructor

public class UniversiteServiceImpl implements IUniversiteService{
   @Autowired
    IUniversityRepo universityRepo ;

    @Override
    public List<Universite> retrieveAllUniversities() {
        return universityRepo.findAll(); // This retrieves all Foyer records from the database
    }

    @Override
    public Universite addUniversite(Universite u) {
        return universityRepo.save(u);

    }

    @Override
    public Universite updateUniversite(Universite u) {
        // Vérifier si l'université existe dans la base de données
        Universite existingUniversite = universityRepo.findById(u.getIdUniversite()).orElse(null);

        if (existingUniversite != null) {
            // Mettre à jour les informations de l'université existante
            existingUniversite.setNomUniversite(u.getNomUniversite());
            existingUniversite.setAdresse(u.getAdresse());

            // Mettre à jour le foyer si présent
            if (u.getFoyer() != null) {
                existingUniversite.setFoyer(u.getFoyer());
            }

            // Sauvegarder et retourner l'université mise à jour
            return universityRepo.save(existingUniversite);
        } else {
            // Gérer le cas où l'université n'existe pas
            return null; // Ou lancer une exception
        }
    }

    @Override
    public Universite modifierUniversiteParid(long idUniversite, Universite universite) {
        // Récupérer l'université par ID
        Universite existingUniversite = universityRepo.findById(idUniversite).orElse(null);

        if (existingUniversite != null) {
            // Mettre à jour l'université existante avec les nouvelles données
            existingUniversite.setNomUniversite(universite.getNomUniversite());
            existingUniversite.setAdresse(universite.getAdresse());
            existingUniversite.setFoyer(universite.getFoyer()); // Mettre à jour le foyer

            // Sauvegarder et retourner l'université mise à jour
            return universityRepo.save(existingUniversite);
        } else {
            // Gérer le cas où l'université n'existe pas
            return null; // Ou lancer une exception
        }
    }


    @Override
    public Universite retrieveUniversite(long idUniversite) {
        // Use the repository to find the Universite by ID
        return universityRepo.findById(idUniversite).orElse(null);
    }

}
