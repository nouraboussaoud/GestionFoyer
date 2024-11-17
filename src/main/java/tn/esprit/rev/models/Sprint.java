package tn.esprit.rev.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "Sprint")
public class Sprint {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idSprint ;
    @NonNull
    String description ;
    @DateTimeFormat(pattern = "MM-dd-yyyy")
    LocalDate startDate;
    @ManyToOne
    @JoinColumn(name = "id_Proj")
    Project project ;


}
