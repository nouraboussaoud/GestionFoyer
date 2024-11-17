package tn.esprit.rev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.rev.models.Sprint;

@Repository
public interface ISprintRepo extends JpaRepository<Sprint,Long> {
}
