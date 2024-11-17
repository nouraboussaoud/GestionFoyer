package tn.esprit.rev.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rev.models.Project;
import tn.esprit.rev.models.User;
import tn.esprit.rev.repository.IProjectRepo;
import tn.esprit.rev.repository.IUserRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {
    @Autowired
    IUserRepo userRepo ;
    IProjectRepo projectRepo;

    @Override
    public User addUser(User user) {
        return userRepo.save(user);
    }

    @Override
    public Project assignProjectToUser(long idProject, long userId) {
       //Fetch project
        Project project = projectRepo.findById(idProject).orElse(null);
        ///fetch user
        User user = userRepo.findById(userId).orElse(null);
        // Assign the project to the user (bidirectional association)
        user.getProjects().add(project);
        project.getUsers().add(user);

        // Save the user and project (if needed, ensure cascading works in your JPA mappings)
        userRepo.save(user);

        // Return the updated project
        return project;
    }

    @Override
    public List<User> afficherTout() {
        return userRepo.findAll();
    }

    @Override
    public List<Project> getProjectsByUser(int userId) {


        return  null ;

    }
}
