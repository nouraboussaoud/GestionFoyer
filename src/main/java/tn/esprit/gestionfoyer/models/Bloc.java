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
public class Bloc {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idBloc;

    @NonNull
    String nomBloc;
    Long capaciteBloc;
    //chambres bloc
    @OneToMany(mappedBy = "bloc", cascade = CascadeType.ALL)
    Set<Chambre>chambres;
    ///
    @ManyToOne
    Foyer foyer;
}
