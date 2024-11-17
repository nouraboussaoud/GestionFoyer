package tn.esprit.gestionfoyer.restController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.gestionfoyer.models.Foyer;
import tn.esprit.gestionfoyer.models.Universite;
import tn.esprit.gestionfoyer.service.IUniversiteService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/GestionFoyerU")

public class UniversiteRestController {
    @Autowired
    private final IUniversiteService universiteService;
    ///Add University
    @PostMapping("/addU")
    public ResponseEntity<Universite> addUniversite(@RequestBody Universite u) {
        Universite addedu = universiteService.addUniversite(u);
        return new ResponseEntity<>(addedu,HttpStatus.CREATED);
    }
    @PutMapping("/updateUniversite/{id}")
    public ResponseEntity<Universite> modifierUniversiteParId(@PathVariable long id, @RequestBody Universite universiteDetails) {
        Universite updatedUniversite = universiteService.modifierUniversiteParid(id, universiteDetails);

        if (updatedUniversite != null) {
            // Retourner l'université mise à jour avec un statut OK
            return new ResponseEntity<>(updatedUniversite, HttpStatus.OK);
        } else {
            // Retourner un statut NOT FOUND si l'université n'est pas trouvée
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    // Mettre à jour une université par ID
    @PutMapping("/updateUniversite")
    public ResponseEntity<Universite> updateUniversite(@RequestBody Universite universite) {
        Universite updatedUniversite = universiteService.updateUniversite(universite);

        if (updatedUniversite != null) {
            // Retourner l'université mise à jour avec un statut OK
            return new ResponseEntity<>(updatedUniversite, HttpStatus.OK);
        } else {
            // Retourner un statut NOT FOUND si l'université n'est pas trouvée
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/universities")
    public ResponseEntity<List<Universite>> retrieveAllUniversities() {
        List<Universite> universites = universiteService.retrieveAllUniversities(); // Make sure this method is implemented in the service

        if (!universites.isEmpty()) {
            return new ResponseEntity<>(universites, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
    // Récupérer une université par son ID
    @GetMapping("/universite/{id}")
    public ResponseEntity<Universite> retrieveUniversite(@PathVariable long id) {
        Universite universite = universiteService.retrieveUniversite(id);

        if (universite != null) {
            // Retourner l'université trouvée avec un statut OK
            return new ResponseEntity<>(universite, HttpStatus.OK);
        } else {
            // Retourner un statut NOT FOUND si l'université n'est pas trouvée
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
