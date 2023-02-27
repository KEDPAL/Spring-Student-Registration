package com.coriolis.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.coriolis.demo.model.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long> {
    
}
