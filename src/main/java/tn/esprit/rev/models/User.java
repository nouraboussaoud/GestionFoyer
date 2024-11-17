package tn.esprit.rev.models;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "User")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idUser;

    @NonNull
    String email ;
    String pwd ;
    String fName ;
    String IName ;
    Role role ;

    @ManyToMany
    Set<Project> projects ;

}
