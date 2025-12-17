package com.second_mini_project.Repo;

import com.second_mini_project.Entity.CourseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface CourseRepo extends JpaRepository<CourseEntity, Integer> {

    // get distinct course names
    @Query(value = "select distinct(course_name) from course_table", nativeQuery = true)
    public List<String> getAllCourseNames();
}
