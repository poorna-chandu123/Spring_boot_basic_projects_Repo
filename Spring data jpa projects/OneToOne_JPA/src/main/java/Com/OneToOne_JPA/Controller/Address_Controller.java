package Com.OneToOne_JPA.Controller;

import Com.OneToOne_JPA.Entity.Bidirectional_Address;
import Com.OneToOne_JPA.Entity.Bidirectional_User;
import Com.OneToOne_JPA.Entity.Unidirectional_Address;
import Com.OneToOne_JPA.Entity.Unidirectional_User;
import Com.OneToOne_JPA.Repository.Address_Repo;
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
@RequestMapping("/address")
public class Address_Controller {



    @Autowired
    private Address_Repo AddressRepo;

    //creating Get mapping to return all the users with out using service layer
    @GetMapping("/add")
    public List<Unidirectional_Address> getAllUsers() {
        return AddressRepo.findAll();
    }

    // creating getmapping to return user by id
    @GetMapping("/add/{id}")
    public Unidirectional_Address getUserById(@PathVariable Long id) {
        return AddressRepo.findById(id).orElse(null);
    }


    // Get User details by Address ID

    // E code anedi work avvadu because addressOptional.get().getname(); ane method work avvadu
    // yendukante Unidirectional OneToOne lo  Address ni vadi user ni get cheyalamu daniki Bidirectional oneTOone vadali
    // coustom query use chesi achive cheyachhu
  /*  @GetMapping("/user/byAddress/{addressId}")
    public ResponseEntity<Unidirectional_User> getUserByAddressId(@PathVariable Long addressId) {
        // Find Address by ID
        Optional<Unidirectional_Address> addressOptional = AddressRepo.findById(addressId);

        if (addressOptional.isPresent()) {
            // Get the User associated with the Address
            Unidirectional_User user = addressOptional.get().getname(); // Since it's unidirectional, there’s no reference in Address
            return ResponseEntity.ok(user);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }*/

}
