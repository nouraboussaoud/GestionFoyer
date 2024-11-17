package tn.esprit.rev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.rev.models.Project;

@Repository
public interface IProjectRepo extends JpaRepository<Project,Long> {
}
