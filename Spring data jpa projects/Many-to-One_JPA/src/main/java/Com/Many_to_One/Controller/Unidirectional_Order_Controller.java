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

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/Order")
public class Unidirectional_Order_Controller {


    @Autowired
    private Unidirectional_Order_Repo unidirectionalOrderRepo;

    // Get all Orders
    @GetMapping("/allOrders")
    public List<Unidirectional_Order> getAllOrders() {
        return unidirectionalOrderRepo.findAll();
    }

    // Get Orders by Customer ID
    // it will not work because of findByCustomer_Coustomerid method anedi work avvadu

   /* @GetMapping("/ordersByCustomer/{customerId}")
    public List<Unidirectional_Order> getOrdersByCustomerId(@PathVariable Long customerId) {
        return unidirectionalOrderRepo.findByCustomer_Coustomerid(customerId);
    }
*/

}
