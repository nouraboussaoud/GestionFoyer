package tn.esprit.gestionfoyer.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "Etudiant")
public class Etudiant {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idEtudiant;

    @NonNull
    String nomEt;
    String prenomEt;
    Long cin;
    String ecole;

    @DateTimeFormat(pattern = "MM-dd-yyyy")
    LocalDate dateNaissance;
    @ManyToMany
    Set<Reservation> reservations;
}
