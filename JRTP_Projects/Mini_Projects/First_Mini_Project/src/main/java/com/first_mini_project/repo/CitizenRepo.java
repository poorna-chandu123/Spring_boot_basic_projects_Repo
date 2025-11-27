package com.first_mini_project.repo;


import com.first_mini_project.entity.CitizenPlane;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CitizenRepo extends JpaRepository<CitizenPlane, Integer> ,
        JpaSpecificationExecutor<CitizenPlane> {

    // native query to get distinct citizen plane names
     @Query(value = "SELECT DISTINCT citizen_plane_name FROM citizen_plan", nativeQuery = true)
     List<String> findDistinctCitizenPlaneNames();
        // native query to get distinct citizen plane status
        @Query(value = "SELECT DISTINCT citizen_plane_status FROM citizen_plan", nativeQuery = true)
        List<String> findDistinctCitizenPlaneStatus();

}
