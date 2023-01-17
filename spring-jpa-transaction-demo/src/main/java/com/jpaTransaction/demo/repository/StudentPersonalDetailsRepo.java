package com.jpaTransaction.demo.repository;

import com.jpaTransaction.demo.entity.Student;
import com.jpaTransaction.demo.entity.StudentPersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentPersonalDetailsRepo
        extends JpaRepository<StudentPersonalDetails, Long>
{
    StudentPersonalDetails getStudentPersonalDetailsByStudentId(long id);

    StudentPersonalDetails getStudentPersonalDetailsByStudent(Student s);


}
