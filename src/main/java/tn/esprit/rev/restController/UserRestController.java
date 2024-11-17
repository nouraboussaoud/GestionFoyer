package tn.esprit.rev.restController;

import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import tn.esprit.rev.models.Project;
import tn.esprit.rev.models.User;
import tn.esprit.rev.service.ProjectService;
import tn.esprit.rev.service.UserService;

import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("/Rev")
public class UserRestController {
    @Autowired
    private final UserService userService ;
    private final ProjectService projectService ;

    ///Add
    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody User user) {
       User addedUser = userService.addUser(user);
        return new ResponseEntity<>(addedUser, HttpStatus.CREATED);
    }

    @PostMapping("/assign-project/{projectId}/{userId}")
    public ResponseEntity<String> assignProjectToUser(
            @PathVariable("projectId") Long projectId,
            @PathVariable("userId") Long userId) {

        Project updatedUser = userService.assignProjectToUser(userId, projectId);

        if (updatedUser != null) {
            return ResponseEntity.ok("success"); // 200 OK with a success message
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User or Project not found."); // 404 Not Found with an error message
        }
    }
    @GetMapping("/list")
    public ResponseEntity<List<User>> afficherTout() {
        List<User> users = userService.afficherTout();

        if (!users.isEmpty()) {
            return new ResponseEntity<>(users, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }



}
