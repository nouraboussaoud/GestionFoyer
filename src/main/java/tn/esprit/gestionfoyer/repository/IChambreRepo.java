package tn.esprit.gestionfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionfoyer.models.Chambre;

import java.time.LocalDate;
import java.util.List;
@Repository
public interface IChambreRepo extends JpaRepository<Chambre, Long> {

    List<Chambre> findByNumeroChambre(long num);

    List<Chambre> findByBloc_Foyer_NomFoyer(String nomFoyer);

    // Add this method to find chambres with invalid reservations (where the reservation is not valid)
    List<Chambre> findByBloc_Foyer_NomFoyerAndReservationsEstValideIsFalse(String nomFoyer);

}



