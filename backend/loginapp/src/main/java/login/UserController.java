package login.controller;

import login.model.User;
import login.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity<User> login(@RequestBody User user) {
        User authenticatedUser = userService.authenticateUser(user.getUserId(), user.getPassword());
        if (authenticatedUser != null) {
            return ResponseEntity.ok(authenticatedUser);
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).build();
        }
    }

    @GetMapping("/user-details")
    public ResponseEntity<User> getUserDetails(@RequestBody User user) {
        User userDetails = user;
        if (userDetails != null) {
            return ResponseEntity.ok(userDetails);
        } else {
            return ResponseEntity.notFound().build();
        }
    }


    @GetMapping("/restricted")
    public String restrictedPage() {
        return "Welcome to the admin page!";
    }

    @GetMapping("/home")
    public String homePage() {
        return "Welcome to the home page!";
    }
}
