package Com.OneToOne_JPA.Controller;

import Com.OneToOne_JPA.Entity.Bidirectional_Address;
import Com.OneToOne_JPA.Entity.Bidirectional_User;
import Com.OneToOne_JPA.Entity.Unidirectional_User;
import Com.OneToOne_JPA.Repository.Bidirectional_User_Repo;
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
@RequestMapping("/BIuser")
public class Bidirectional_User_Controller {


    @Autowired
    private Bidirectional_User_Repo BidirectionalUserRepo;

    //creating Get mapping to return all the users with out using service layer
    @GetMapping("/users")
    public List<Bidirectional_User> getAllUsers() {
        return BidirectionalUserRepo.findAll();
    }

    // creating getmapping to return user by id
    @GetMapping("/user/{id}")
    public Bidirectional_User getUserById(@PathVariable Long id) {
        return BidirectionalUserRepo.findById(id).get();
    }

    // Get Address details by User ID
    @GetMapping("/address/byUser/{userId}")
    public Bidirectional_User getAddressByUserID(@PathVariable Long Id) {
        // Find User by ID
        Bidirectional_User user = BidirectionalUserRepo.findById(Id).get();
        return user;
    }


    // Get Address details by User ID
    // child details by parent id
    @GetMapping("/address/byUserID/{userId}")
    public ResponseEntity<Bidirectional_Address> getAddressByUserId(@PathVariable Long userId) {
        // Find User by ID
        Optional<Bidirectional_User> userOptional = BidirectionalUserRepo.findById(userId);

        if (userOptional.isPresent()) {
            // Get the Address associated with the User
            Bidirectional_Address address = userOptional.get().getAddress(); // Navigate from User to Address
            return ResponseEntity.ok(address);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
