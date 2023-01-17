package com.jpaTransaction.demo.service;

import com.jpaTransaction.demo.entity.Student;
import com.jpaTransaction.demo.repository.StudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService{

    @Autowired
    private StudentRepo studentRepo;

    @Override
    public Student merge(Student student) {
        return null;
    }
}
