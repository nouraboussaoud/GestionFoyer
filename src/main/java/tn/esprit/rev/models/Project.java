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
@Table(name = "Project")
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long idProject ;
    @NonNull
    String title ;
    String description ;
    @ManyToMany(mappedBy = "projects")
    Set<User> users ;
   @OneToMany(mappedBy = "project",cascade = CascadeType.ALL)
   Set<Sprint>sprints ;


}
