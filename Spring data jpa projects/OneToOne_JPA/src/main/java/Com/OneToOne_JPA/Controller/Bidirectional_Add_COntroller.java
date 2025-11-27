package Com.OneToOne_JPA.Controller;

import Com.OneToOne_JPA.Entity.Bidirectional_Address;
import Com.OneToOne_JPA.Entity.Bidirectional_User;
import Com.OneToOne_JPA.Repository.Bidirectional_Add_Repo;
import Com.OneToOne_JPA.Repository.Bidirectional_User_Repo;
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
@RequestMapping("/BIadd")
public class Bidirectional_Add_COntroller {
    @Autowired
    private Bidirectional_Add_Repo BidirectionalAddRepo;

    //creating Get mapping to return all the users with out using service layer
    @GetMapping("/Add")
    public List<Bidirectional_Address> getAllUsers() {
        return BidirectionalAddRepo.findAll();
    }

    // creating getmapping to return user by id
    @GetMapping("/Add/{id}")
    public Bidirectional_Address getUserById(@PathVariable Long id) {
        return BidirectionalAddRepo.findById(id).get();
    }

    // Get User details by Address ID


    @GetMapping("/user/byAddressID/{addressId}")
    public ResponseEntity<Bidirectional_User> getUserByAddressId(@PathVariable Long addressId) {
        // Find Address by ID
        Optional<Bidirectional_Address> addressOptional = BidirectionalAddRepo.findById(addressId);

        if (addressOptional.isPresent()) {
            // Get the User associated with the Address
            Bidirectional_User user = addressOptional.get().getUser(); // Navigate from Address to User
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }


}
