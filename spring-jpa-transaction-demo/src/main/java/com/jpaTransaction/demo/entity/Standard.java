package com.jpaTransaction.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static javax.persistence.CascadeType.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Entity
//@Table(name = "standard")
public class Standard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "standard_id")
    private int id;
    @Column(name = "standard_name")
    private String name;
    @OneToMany(mappedBy = "standard",
            cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JsonBackReference
    private List<Student> studentList;

//    public void addStudent(Student student){
//        if (studentList == null) studentList = new ArrayList<>();
//        studentList.add(student);
//        student.setStandard(this);
//    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Standard)) return false;
        Standard standard = (Standard) o;
        return id == standard.id && name.equals(standard.name);
    }

    @Override
    public String toString() {
        return "Standard{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
