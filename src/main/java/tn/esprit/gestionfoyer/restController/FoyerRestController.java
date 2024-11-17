package tn.esprit.gestionfoyer.restController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.models.Chambre;
import tn.esprit.gestionfoyer.models.Foyer;
import tn.esprit.gestionfoyer.models.Universite;
import tn.esprit.gestionfoyer.repository.IFoyerRepo;
import tn.esprit.gestionfoyer.repository.IUniversityRepo;
import tn.esprit.gestionfoyer.service.IFoyerService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/GestionFoyer")
public class FoyerRestController {
@Autowired
private IFoyerRepo foyerRepository ; // Injection du repository

    private final IFoyerService foyerService;
    // Add a Foyer
    @PostMapping("/add")
    public ResponseEntity<Foyer> ajouterFoyer(@RequestBody Foyer foyer) {
        Foyer addedFoyer = foyerService.ajouterFoyer(foyer);
        return new ResponseEntity<>(addedFoyer, HttpStatus.CREATED);
    }

    // Modify an existing Foyer
    @PutMapping("/update/{id}")
    public ResponseEntity<Foyer> modifierFoyerParId(@PathVariable long id, @RequestBody Foyer foyerDetails) {

            // You can update other fields similarly
            foyerService.modifierFoyerParid(id,foyerDetails);
            return new ResponseEntity<>(foyerDetails,HttpStatus.OK);
    }
    @PutMapping("/updateFoyer")
    public ResponseEntity<Foyer> modifierFoyer( @RequestBody Foyer foyerDetails) {

        // You can update other fields similarly
        foyerService.modifierFoyer(foyerDetails);
        return new ResponseEntity<>(foyerDetails,HttpStatus.OK);
    }
    @GetMapping("/list")
    public ResponseEntity<List<Foyer>> afficherTout() {
        List<Foyer> foyers = foyerService.afficherTout();

        if (!foyers.isEmpty()) {
            return new ResponseEntity<>(foyers, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    @DeleteMapping("/delete/{idFoyer}")
    public ResponseEntity<Void> supprimerParId(@PathVariable long idFoyer) {
        Boolean isDeleted = foyerService.supprimerParId(idFoyer);

        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Suppression réussie
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Foyer introuvable
        }
    }
    @DeleteMapping("/delete")
    public ResponseEntity<Void> supprimerFoyer(@RequestBody Foyer foyer) {
        Boolean isDeleted = foyerService.supprimerFoyer(foyer);

        if (isDeleted) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT); // Suppression réussie
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); // Foyer introuvable
        }
    }
    @PutMapping(path = "/affectation/{id}/{nomUniversite}")
    public ResponseEntity<Universite> affecterFoyerAUniversite(
            @PathVariable("id") long idFoyer,
            @PathVariable("nomUniversite") String nomUniversite) {

        Universite updatedUniversite = foyerService.affecterFoyerAUniversite(idFoyer, nomUniversite);

        if (updatedUniversite != null) {
            return ResponseEntity.ok(updatedUniversite); // 200 OK with the updated Universite
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found if either is not found
        }
    }
    @PutMapping(path = "/desaffectation/{id}/{nomUniversite}")
    public ResponseEntity<Universite> desaffecterFoyerAUniversite(
            @PathVariable("id") long idFoyer,
            @PathVariable("nomUniversite") String nomUniversite) {

        Universite updatedUniversite = foyerService.desaffecterFoyerAUniversite(idFoyer, nomUniversite);

        if (updatedUniversite != null) {
            return ResponseEntity.ok(updatedUniversite); // 200 OK with the updated Universite
        } else {
            return ResponseEntity.notFound().build(); // 404 Not Found if the Universite is not found
        }
    }
    @GetMapping("/chambres/invalid/{nomFoyer}")
    public List<Chambre> getChambresWithInvalidReservations(@PathVariable String nomFoyer) {
        return foyerService.getInvalidReservationsByFoyer(nomFoyer);
    }
}
