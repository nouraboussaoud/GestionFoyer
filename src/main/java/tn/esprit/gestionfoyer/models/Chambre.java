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
public class Chambre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idChambre;

    @NonNull
    Long numeroChambre;

    @Enumerated(EnumType.ORDINAL)
    TypeChambre typeC;
    ///chambre res
    @OneToMany
    Set<Reservation> reservations ;
    ///chambres bloc
    @ManyToOne
    @JoinColumn(name = "bloc_id")  // Explicitly name the foreign key column
    Bloc bloc ;
}