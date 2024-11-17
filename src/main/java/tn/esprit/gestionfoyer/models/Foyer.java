package tn.esprit.gestionfoyer.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
public class Foyer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idFoyer;

    @NonNull
    String nomFoyer;
    Long capaciteFoyer;
    //foyer bloc
    @OneToMany(mappedBy = "foyer" , cascade = CascadeType.ALL)
    Set<Bloc>bloc ;
    /// foyer university
    @OneToOne(mappedBy = "foyer")
    Universite universite;
}
