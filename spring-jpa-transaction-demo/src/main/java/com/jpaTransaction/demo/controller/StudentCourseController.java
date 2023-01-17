package com.jpaTransaction.demo.controller;

import com.jpaTransaction.demo.entity.Course;
import com.jpaTransaction.demo.entity.Student;
import com.jpaTransaction.demo.repository.CourseRepo;
import com.jpaTransaction.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/student-course")
public class StudentCourseController {

    @Autowired
    private StudentRepo studentRepo;

//    @Autowired
//    private CourseRepo courseRepo;


    @GetMapping("/all")
    public List<Student> getAllStudents(){
        return studentRepo.findAll();
    }

    @PostMapping("/save")
    public Student saveStudent(@RequestBody Student student){
        return studentRepo.save(student);
    }

    @GetMapping("/s/{name}")
    public List<Student> getStudentByName(@PathVariable("name") String name){
        return studentRepo.findByNameContaining(name);
    }


//    @GetMapping("/c/{name}")
//    public List<Course> getCourseByName(@PathVariable("name") String name){
//        return courseRepo.findByName(name);
//    }






}

























