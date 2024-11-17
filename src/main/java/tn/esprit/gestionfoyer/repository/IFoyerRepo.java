package tn.esprit.gestionfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionfoyer.models.Foyer;

@Repository
public interface IFoyerRepo extends JpaRepository<Foyer,Long> {

}
