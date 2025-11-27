package com.address_loadBalancer_project.Repository;

import com.address_loadBalancer_project.Entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Addrepo extends JpaRepository <Address, Long> {
}
