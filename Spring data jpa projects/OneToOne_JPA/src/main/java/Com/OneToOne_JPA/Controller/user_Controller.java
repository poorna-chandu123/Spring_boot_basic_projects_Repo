package Com.OneToOne_JPA.Controller;


import Com.OneToOne_JPA.Entity.Unidirectional_Address;
import Com.OneToOne_JPA.Entity.Unidirectional_User;
import Com.OneToOne_JPA.Repository.User_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/user")
public class user_Controller {

    @Autowired
    private User_Repo userRepo;

     //creating Get mapping to return all the users with out using service layer
    @GetMapping("/users")
    public List<Unidirectional_User> getAllUsers() {

        return userRepo.findAll();
    }
// creating getmapping to return user by id

    @GetMapping("/user/{id}")
    public Unidirectional_User getUserById(@PathVariable Long id) {
        return userRepo.findById(id).orElse(null);
    }

    // Get Address details by User ID
    @GetMapping("/address/byUser/{userId}")
    public ResponseEntity<Unidirectional_Address> getAddressByUserId(@PathVariable Long userId) {
        // Find User by ID
        Optional<Unidirectional_User> userOptional = userRepo.findById(userId);

        if (userOptional.isPresent()) {
            // Get the Address associated with the User
            Unidirectional_Address address = userOptional.get().getAddress(); // Navigate from User to Address
            return ResponseEntity.ok(address);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

}
