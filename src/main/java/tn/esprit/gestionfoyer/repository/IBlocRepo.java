package tn.esprit.gestionfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionfoyer.models.Bloc;
import tn.esprit.gestionfoyer.models.Chambre;

@Repository

public interface IBlocRepo extends JpaRepository<Bloc , Long> {
}
