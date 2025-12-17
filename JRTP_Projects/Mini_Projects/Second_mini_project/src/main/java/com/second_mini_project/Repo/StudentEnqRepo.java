package com.second_mini_project.Repo;

import com.second_mini_project.DTO.Add_and_Update_Form;
import com.second_mini_project.Entity.StudentEnqEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.util.List;

public interface StudentEnqRepo extends JpaRepository<StudentEnqEntity, Integer> ,
        JpaSpecificationExecutor<StudentEnqEntity> {

    // get the list of enquiries by userId
    public List<StudentEnqEntity> findByUserDtlsEntity_UserId(Integer userId);

    // add user
    public StudentEnqEntity save(Add_and_Update_Form form);
}
