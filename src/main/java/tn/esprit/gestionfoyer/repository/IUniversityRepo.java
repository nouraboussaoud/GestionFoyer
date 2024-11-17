package tn.esprit.gestionfoyer.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import tn.esprit.gestionfoyer.models.Universite;

@Repository
public interface IUniversityRepo extends JpaRepository<Universite,Long> {
    // Native query to find Universite by name
    @Query(value = "SELECT * FROM Universite WHERE nom_universite = :nomUniversite", nativeQuery = true)
    Universite chercherParNomUniversite(@Param("nomUniversite") String nomUniversite);

    // JPQL query to find Universite by name (optional, keep if needed)
    @Query(value = "SELECT u FROM Universite u WHERE u.nomUniversite = :nomUniversite")
    Universite chercherParNomUniversiteJPQL(@Param("nomUniversite") String nomUniversite);

    // Spring Data method to find Universite by name (you can keep this)
    Universite findUniversiteByNomUniversite(String nomUniversite);


}