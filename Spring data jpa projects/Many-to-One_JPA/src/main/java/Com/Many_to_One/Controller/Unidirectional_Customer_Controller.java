package Com.Many_to_One.Controller;


import Com.Many_to_One.Entity.Unidirectional_Customer;
import Com.Many_to_One.Entity.Unidirectional_Order;
import Com.Many_to_One.Repository.Unidirectional_Customer_Repo;
import Com.Many_to_One.Repository.Unidirectional_Order_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/Customer")
public class Unidirectional_Customer_Controller {

    @Autowired
    private Unidirectional_Customer_Repo unidirectionalCustomerRepo;

    @Autowired
    private Unidirectional_Order_Repo unidirectionalOrderRepo;

    // Get all customers
    @GetMapping("/allCustomers")
    public List<Unidirectional_Customer> getAllCustomers() {
        return unidirectionalCustomerRepo.findAll();
    }

    // Get Customer details by Order ID
    @GetMapping("/customerByOrder/{orderId}")
    public Unidirectional_Customer getCustomerByOrderId(@PathVariable Long orderId) {
        Unidirectional_Order order = unidirectionalOrderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return order.getCustomer();  // Get customer from the Order entity
    }


}
