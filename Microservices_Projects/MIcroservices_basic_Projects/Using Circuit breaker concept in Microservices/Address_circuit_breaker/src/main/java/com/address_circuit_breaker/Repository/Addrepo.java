package com.address_circuit_breaker.Repository;

import com.address_circuit_breaker.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Addrepo extends JpaRepository <Address, Long> {
}
