package tn.esprit.gestionfoyer.restController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import tn.esprit.gestionfoyer.service.IChambreService;

import java.time.LocalDate;

@RestController
@RequestMapping("/chambres")
@AllArgsConstructor

public class ChambreRestController {
    @Autowired
    private IChambreService chambreService;
    @GetMapping("/non-reserves")
    public long nombreChambreNonReserve(
            @RequestParam String nomFoyer,
            @RequestParam int anneeUniversitaire) {

        LocalDate anneUniversitaireDate = LocalDate.of(anneeUniversitaire, 1, 1); // Assuming we only need the year part
        return chambreService.nombreChambreNonReserve(nomFoyer, anneUniversitaireDate);
    }
}
