package com.jpaTransaction.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "course")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "course_id")
    private int id;
    @Column(name = "course_name")
    private String name;
    @Column(name = "course_type")
    private String type;
    @ManyToMany(mappedBy = "courseList",
            cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
//    @JoinTable(
//            name = "student_course",
//            joinColumns = @JoinColumn(name = "course_id", referencedColumnName = "id"),
//            inverseJoinColumns = @JoinColumn(name = "stu_id", referencedColumnName = "id")
//    )
    @JsonBackReference
    List<Student> studentList;

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", type='" + type + '\'' +
                '}';
    }
}
