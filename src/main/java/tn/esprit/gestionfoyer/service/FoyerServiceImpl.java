package tn.esprit.gestionfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.models.Chambre;
import tn.esprit.gestionfoyer.models.Foyer;
import tn.esprit.gestionfoyer.models.Universite;
import tn.esprit.gestionfoyer.repository.IChambreRepo;
import tn.esprit.gestionfoyer.repository.IFoyerRepo;
import tn.esprit.gestionfoyer.repository.IUniversityRepo;

import java.util.List;

@Service
@AllArgsConstructor

public class FoyerServiceImpl implements IFoyerService {
    @Autowired
    IFoyerRepo foyerRepo;
    @Autowired
    IUniversityRepo universityRepo ;
    @Autowired
    private IChambreRepo chambreRepository;

    @Override
    public Foyer ajouterFoyerEtBloc(Foyer foyer) {

        return null;
    }

    @Override
    public Foyer ajouterFoyer(Foyer foyer) {
        return foyerRepo.save(foyer);
    }

    @Override
    public Foyer modifierFoyer(Foyer foyer) {
        // Vérifiez si le foyer existe déjà dans la base de données
        Foyer existingFoyer = foyerRepo.findById(foyer.getIdFoyer()).orElse(null);

        if (existingFoyer != null) {
            // Mettre à jour les champs de l'objet existant avec ceux du foyer fourni
            existingFoyer.setNomFoyer(foyer.getNomFoyer());
            existingFoyer.setCapaciteFoyer(foyer.getCapaciteFoyer());


            // Enregistrer les modifications
            return foyerRepo.save(existingFoyer); // Enregistrez et renvoyez l'objet mis à jour
        } else {
            // Gérer le cas où le foyer n'existe pas (optionnel)
            return null; // Ou lancez une exception, ou renvoyez un indicateur approprié
        }
    }

    @Override
    public Foyer modifierFoyerParid(long idFoyer, Foyer foyer) {
        Foyer existingFoyer = foyerRepo.findById(idFoyer).orElse(null); // Retrieve the foyer by ID

        if (existingFoyer != null) {
            // Update the existing foyer with the new details
            existingFoyer.setNomFoyer(foyer.getNomFoyer());
            existingFoyer.setBloc(foyer.getBloc());
            existingFoyer.setCapaciteFoyer(foyer.getCapaciteFoyer());
            existingFoyer.setUniversite(foyer.getUniversite());}
        return existingFoyer ;
    }

    @Override
    public Foyer chercherParId(long idFoyer) {
        return null;
    }

    @Override
    public List<Foyer> afficherTout() {

            return foyerRepo.findAll(); // This retrieves all Foyer records from the database
    }

    @Override
    public Boolean supprimerFoyer( Foyer foyer) {
        Foyer existingFoyer = foyerRepo.findById(foyer.getIdFoyer()).orElse(null); // Vérifie si le foyer existe
        if (existingFoyer != null) {
            foyerRepo.delete(existingFoyer); // Supprime le foyer si trouvé
            return true; // Renvoie true si la suppression est réussie
        }
        return false; // Renvoie false si le foyer n'a pas été trouvé
    }

    @Override
    public Boolean supprimerParId(long idFoyer) {
        if (foyerRepo.existsById(idFoyer)) {
            foyerRepo.deleteById(idFoyer); // Supprime par ID si trouvé
            return true; // Suppression réussie
        }
        return false; // Foyer introuvable
    }
    @Override
    public Universite affecterFoyerAUniversite(long idFoyer , String nomUniversite){
        //1ere etape la recherche

            Foyer foyer = foyerRepo.findById(idFoyer).orElse(null);
            Universite universite = universityRepo.findUniversiteByNomUniversite(nomUniversite);
        //2eme etape  affectation parent.setfile   /
        universite.setFoyer(foyer);
        ///persistance save parent
        return universityRepo.save(universite);
    }
    @Override
    public Universite desaffecterFoyerAUniversite(long idFoyer, String nomUniversite) {
        // Step 1: Retrieve the Universite by its name
        Universite universite = universityRepo.findUniversiteByNomUniversite(nomUniversite);

        if (universite != null) {
            // Step 2: Set the Foyer of the Universite to null
            universite.setFoyer(null); // Remove the association

            // Step 3: Save the updated Universite
            return universityRepo.save(universite);
        }
        return null; // Return null if the Universite was not found
    }

    @Override

    public List<Chambre> getInvalidReservationsByFoyer(String nomFoyer) {
        System.out.println("Searching for invalid reservations in Foyer: " + nomFoyer);

        // Call the updated repository method to get chambres with invalid reservations
        List<Chambre> chambres = chambreRepository.findByBloc_Foyer_NomFoyerAndReservationsEstValideIsFalse(nomFoyer);

        if (chambres.isEmpty()) {
            System.out.println("No invalid reservations found for Foyer: " + nomFoyer);
        } else {
            System.out.println("Found invalid reservations: " + chambres);
        }

        return chambres;
    }




}
