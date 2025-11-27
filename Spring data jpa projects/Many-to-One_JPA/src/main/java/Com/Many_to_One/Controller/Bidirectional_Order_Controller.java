package Com.Many_to_One.Controller;

import Com.Many_to_One.Entity.Bidirectional_Order;
import Com.Many_to_One.Repository.Bidirectional_Order_Repo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.databind.annotation.JsonAppend;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/BIOrders")
public class Bidirectional_Order_Controller {

    @Autowired
    private Bidirectional_Order_Repo BidirectionalOrdersRepo;

    // get all orders
    @GetMapping("/AllOrders")
    @JsonIgnore
    public List<Bidirectional_Order> getAllOrders() {
        return BidirectionalOrdersRepo.findAll();
    }

    // Get Orders by Customer ID (User ID)
    @GetMapping("/ordersByCustomer/{customerId}")
    public List<Bidirectional_Order> getOrdersByCustomerId(@PathVariable Long customerId) {
        return BidirectionalOrdersRepo.findByCustomer_Id(customerId);  // Find orders by customer ID
    }




}
