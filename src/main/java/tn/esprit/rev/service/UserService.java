package tn.esprit.rev.service;

import tn.esprit.rev.models.Project;
import tn.esprit.rev.models.User;

import java.util.List;

public interface UserService {
    User addUser(User user);
   Project assignProjectToUser(long idProject , long userId);
    List<User> afficherTout();
    List<Project> getProjectsByUser(int userId);



}
