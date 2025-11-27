package Com.OneToMany_JPA.Repository;

import Com.OneToMany_JPA.Entity.Bidirectional_Orders;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface Bidirectional_Orders_Repo extends JpaRepository<Bidirectional_Orders, Long> {

    // E mothod rayataniki reason user ID dwara orders ni fetch cheyali ani
    // ala cheyali ante daniki Order details store cheyatniki oka method kavali
    // ante eikkada OneToMany jaruguthyndi
    // Qustion same yendukani Coustomer repo lo method rayaledu?
    // Answer: Customer entity class alredy Orders details get cheyatiki menthod rasam
    // so A method ni JPA internal ga vadukoni Order Id isthe user details get chesthundi
    List<Bidirectional_Orders> findByCustomer_Id(Long customerId);


}
