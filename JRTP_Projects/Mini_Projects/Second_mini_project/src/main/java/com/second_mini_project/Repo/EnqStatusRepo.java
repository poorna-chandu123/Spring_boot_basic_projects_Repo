package com.second_mini_project.Repo;

import com.second_mini_project.Entity.EnqStatusEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface EnqStatusRepo extends JpaRepository<EnqStatusEntity, Integer> {

    // get distinct Enquiry Status
    @Query(value = "select distinct(status_name) from enq_status_table", nativeQuery = true)
    public List<String> getAllEnqStatusNames();






}
