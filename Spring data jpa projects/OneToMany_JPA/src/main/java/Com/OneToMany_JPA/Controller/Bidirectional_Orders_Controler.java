package Com.OneToMany_JPA.Controller;


import Com.OneToMany_JPA.Entity.Bidirectional_Customer;
import Com.OneToMany_JPA.Entity.Bidirectional_Orders;
import Com.OneToMany_JPA.Repository.Bidirectional_Orders_Repo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
@RestController
@RequestMapping("/BIOrders")
public class Bidirectional_Orders_Controler {

    @Autowired
    private Bidirectional_Orders_Repo BidirectionalOrdersRepo;

    // Creating Get mapping to return all the orders without using service layer
    @GetMapping("/Orders")
    public List<Bidirectional_Orders> getAllOrders() {
        return BidirectionalOrdersRepo.findAll();
    }

    // Get Order details by Customer ID
    @GetMapping("/orders/customer/{customerId}")
    public ResponseEntity<List<Bidirectional_Orders>> getOrdersByCustomerId(@PathVariable Long customerId) {
        // Fetch orders by customerId
        List<Bidirectional_Orders> orders = BidirectionalOrdersRepo.findByCustomer_Id(customerId);

        if (orders.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

        return ResponseEntity.ok(orders);
    }

}

