package tn.esprit.rev.service;

import tn.esprit.rev.models.Project;

import java.util.List;

public interface ProjectService {
    Project addProject(Project project);
    public List<Project> getAllProjects() ;

}
