package tn.esprit.rev.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.rev.models.User;

@Repository
public interface IUserRepo extends JpaRepository<User ,Long> {
    User findByIdUser(int userId);
}
