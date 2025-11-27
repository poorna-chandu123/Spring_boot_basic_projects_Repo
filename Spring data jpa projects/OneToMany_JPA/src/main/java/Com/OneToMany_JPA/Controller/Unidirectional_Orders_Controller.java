package Com.OneToMany_JPA.Controller;

import Com.OneToMany_JPA.Entity.Unidirectional_Customer;
import Com.OneToMany_JPA.Entity.Unidirectional_Orders;
import Com.OneToMany_JPA.Repository.Unidirectional_Customer_Repo;
import Com.OneToMany_JPA.Repository.Unidirectional_Orders_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Orders")
public class Unidirectional_Orders_Controller {
    @Autowired
    private Unidirectional_Orders_Repo orderRepo;

    @Autowired
    private Unidirectional_Customer_Repo customerRepo;

    // Get all Orders
    @GetMapping("/allOrders")
    public List<Unidirectional_Orders> getAllOrders() {
        return orderRepo.findAll();
    }

    // Get Order details by Customer ID
    @GetMapping("/ordersByCustomer/{customerId}")
    public List<Unidirectional_Orders> getOrdersByCustomerId(@PathVariable Long customerId) {
        // Fetch the customer by ID
        Optional<Unidirectional_Customer> customerOptional = customerRepo.findById(customerId);

        if (customerOptional.isPresent()) {
            // Return the orders list from the customer entity
            return customerOptional.get().getOrders();
        } else {
            // If customer is not found, return an empty list or handle the error accordingly
            return new ArrayList<>();
        }
    }
}