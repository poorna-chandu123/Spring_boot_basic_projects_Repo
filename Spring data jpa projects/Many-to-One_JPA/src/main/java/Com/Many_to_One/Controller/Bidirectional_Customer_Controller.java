package Com.Many_to_One.Controller;

import Com.Many_to_One.Entity.Bidirectional_Customer;
import Com.Many_to_One.Entity.Bidirectional_Order;
import Com.Many_to_One.Repository.Bidirectional_Customer_Repo;
import Com.Many_to_One.Repository.Bidirectional_Order_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/BICustomer")
public class Bidirectional_Customer_Controller {

    @Autowired
    private Bidirectional_Customer_Repo bidirectionalCustomerRepo;

    @Autowired
    private Bidirectional_Order_Repo bidirectionalOrderRepo;

    // Get all Customers
    @GetMapping("/allCustomers")
    public List<Bidirectional_Customer> getAllCustomers() {
        return bidirectionalCustomerRepo.findAll();
    }

    // Get Customer details by Order ID
    @GetMapping("/customerByOrder/{orderId}")
    public Bidirectional_Customer getCustomerByOrderId(@PathVariable Long orderId) {
        Bidirectional_Order order = bidirectionalOrderRepo.findById(orderId)
                .orElseThrow(() -> new RuntimeException("Order not found"));
        return order.getCustomer();  // Get customer from the Order entity
    }

}
