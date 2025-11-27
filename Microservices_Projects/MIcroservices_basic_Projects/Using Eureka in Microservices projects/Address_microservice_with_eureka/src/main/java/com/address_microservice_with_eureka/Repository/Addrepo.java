package com.address_microservice_with_eureka.Repository;

import com.address_microservice_with_eureka.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Addrepo extends JpaRepository <Address, Long> {
}
