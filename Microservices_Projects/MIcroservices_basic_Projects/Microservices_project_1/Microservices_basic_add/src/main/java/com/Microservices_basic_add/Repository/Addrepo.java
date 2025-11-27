package com.Microservices_basic_add.Repository;

import com.Microservices_basic_add.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Addrepo extends JpaRepository <Address, Long> {
}
