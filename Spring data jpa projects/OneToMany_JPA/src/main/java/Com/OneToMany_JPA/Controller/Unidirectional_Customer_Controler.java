package Com.OneToMany_JPA.Controller;

import Com.OneToMany_JPA.Entity.Unidirectional_Customer;
import Com.OneToMany_JPA.Entity.Unidirectional_Orders;
import Com.OneToMany_JPA.Repository.Unidirectional_Customer_Repo;
import Com.OneToMany_JPA.Repository.Unidirectional_Orders_Repo;
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
@RequestMapping("/Customer")
public class Unidirectional_Customer_Controler {

    @Autowired
    private Unidirectional_Customer_Repo unidirectionalCustomerRepo;

    @Autowired
    private Unidirectional_Orders_Repo unidirectionalOrdersRepo;  // You need to inject this repo as well

    @GetMapping("AllCous")
    public List<Unidirectional_Customer> getAllCustomers() {
        return unidirectionalCustomerRepo.findAll();
    }

    // Get Customer details by Order ID (this will NOT work because Order doesn't have a reference to Customer)

 /*  @GetMapping("/order/{orderId}")
    public ResponseEntity<Unidirectional_Customer> getCustomerByOrderId(@PathVariable Long orderId) {
        // Attempt to find the order by ID (this part is fine)
        Unidirectional_Orders order = new Unidirectional_Orders();
        order.setOrderid(orderId);

        // ERROR: Cannot fetch customer from order in unidirectional setup
        // The following code will not compile because there is no reference to `Customer` in `Order`
        Unidirectional_Customer customer = order.getCustomer();  // ERROR: Cannot find `getCustomer()` in `Unidirectional_Orders`

        return ResponseEntity.ok(customer);  // This line won't be reached because the above line will cause a compile-time error
    }*/
}

