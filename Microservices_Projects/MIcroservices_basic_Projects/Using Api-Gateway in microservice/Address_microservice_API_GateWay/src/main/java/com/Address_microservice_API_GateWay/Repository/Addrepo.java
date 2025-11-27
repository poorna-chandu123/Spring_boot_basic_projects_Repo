package com.Address_microservice_API_GateWay.Repository;

import com.Address_microservice_API_GateWay.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Addrepo extends JpaRepository <Address, Long> {
}
