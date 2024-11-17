package tn.esprit.gestionfoyer.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter

@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Reservation {
    @Id
    ///@GeneratedValue(strategy = GenerationType.IDENTITY)
    String idReservation;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    LocalDate anneeUniversitaire;

    boolean estValide;
    ///reservation etudiant
    @ManyToMany(mappedBy = "reservations")
    Set<Etudiant> etudiants;
    ///chambre res

}
