package tn.esprit.rev.restController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rev.models.Project;
import tn.esprit.rev.models.User;
import tn.esprit.rev.service.ProjectService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Rev")
public class ProjectRestController {
    @Autowired
    private  final ProjectService projectService ;
    @PostMapping("/addP")
    public ResponseEntity<Project> addProject(@RequestBody Project project) {
        Project addedProject = projectService.addProject(project);
        return new ResponseEntity<>(addedProject, HttpStatus.CREATED);
    }
    @GetMapping("/listP")
    public ResponseEntity<List<Project>> afficherTout() {
        List<Project> projects = projectService.getAllProjects();

        if (!projects.isEmpty()) {
            return new ResponseEntity<>(projects, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
