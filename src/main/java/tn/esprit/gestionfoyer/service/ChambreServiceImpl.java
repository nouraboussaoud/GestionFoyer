package tn.esprit.gestionfoyer.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.gestionfoyer.models.Bloc;
import tn.esprit.gestionfoyer.models.Chambre;
import tn.esprit.gestionfoyer.models.Reservation;
import tn.esprit.gestionfoyer.repository.IBlocRepo;
import tn.esprit.gestionfoyer.repository.IChambreRepo;

import java.time.LocalDate;
import java.util.List;

@Service
@AllArgsConstructor
public class ChambreServiceImpl implements IChambreService {

    @Autowired
    private IChambreRepo chambreRepo;

    @Autowired
    private IBlocRepo blocRepo;

    @Override
    public long nombreChambreNonReserve(String nomFoyer, LocalDate anneUniversitaire) {
        long count = 0;

        // Find all chambres
        List<Chambre> chambres = chambreRepo.findAll();

        // Loop through chambres to check conditions
        for (Chambre chambre : chambres) {
            if (chambre.getBloc() != null &&
                    chambre.getBloc().getFoyer() != null &&
                    chambre.getBloc().getFoyer().getNomFoyer().equals(nomFoyer)) {

                for (Reservation reservation : chambre.getReservations()) {
                    if (reservation.getAnneeUniversitaire().getYear() == anneUniversitaire.getYear() &&
                            !reservation.isEstValide()) {
                        // This chambre is not reserved
                        count++;
                    }
                }
            }
        }
        return count;
    }

    @Override
    public Chambre ajouterChambreEtBloc(Chambre chambre) {
        // Save the Bloc (if it doesn't exist already) and automatically link it to the Chambre
        if (chambre.getBloc() != null) {
            Bloc existingBloc = blocRepo.findById(chambre.getBloc().getIdBloc()).orElse(null);
            if (existingBloc == null) {
                blocRepo.save(chambre.getBloc()); // Save the Bloc if it's not found
            }
        }

        // Save the Chambre (it will automatically be associated with the saved Bloc)
        return chambreRepo.save(chambre);
    }
}
