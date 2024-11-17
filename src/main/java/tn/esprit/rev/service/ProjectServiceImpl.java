package tn.esprit.rev.service;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.rev.models.Project;
import tn.esprit.rev.repository.IProjectRepo;

import java.util.List;

@Service
@AllArgsConstructor
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    IProjectRepo projectRepo ;
    @Override
    public Project addProject(Project project) {
        return projectRepo.save(project);
    }

    @Override
    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }


}
