package com.jpaTransaction.demo.repository;

import com.jpaTransaction.demo.entity.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CourseRepo
//        extends JpaRepository<Course, Integer>
{


    List<Course> findByName(String name);




}
