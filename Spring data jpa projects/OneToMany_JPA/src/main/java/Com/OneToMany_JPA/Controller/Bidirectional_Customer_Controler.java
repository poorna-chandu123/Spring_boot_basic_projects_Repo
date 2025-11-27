package Com.OneToMany_JPA.Controller;


import Com.OneToMany_JPA.Entity.Bidirectional_Customer;
import Com.OneToMany_JPA.Entity.Bidirectional_Orders;
import Com.OneToMany_JPA.Repository.Bidirectional_Customer_Repo;
import Com.OneToMany_JPA.Repository.Bidirectional_Orders_Repo;
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
@RequestMapping("/BICustomer")
public class Bidirectional_Customer_Controler {

    @Autowired
    private Bidirectional_Customer_Repo BidirectionalCustomerRepo;

    @Autowired
    private Bidirectional_Orders_Repo BidirectionalOrdersRepo;  // Add this to access orders repo

    // Creating Get mapping to return all customers without using service layer
    @GetMapping("/Customer")
    public List<Bidirectional_Customer> getAllCustomers() {
        return BidirectionalCustomerRepo.findAll();
    }

    // Get Customer details by Order ID
    @GetMapping("/customer/order/{orderId}")
    public ResponseEntity<Bidirectional_Customer> getCustomerByOrderId(@PathVariable Long orderId) {
        // Find the order by its ID using the correct repository (Bidirectional_Orders_Repo)
        Optional<Bidirectional_Orders> orderOptional = BidirectionalOrdersRepo.findById(orderId);

        if (orderOptional.isPresent()) {
            // Get the associated customer from the order
            Bidirectional_Customer customer = orderOptional.get().getCustomer();
            return ResponseEntity.ok(customer);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }
}
