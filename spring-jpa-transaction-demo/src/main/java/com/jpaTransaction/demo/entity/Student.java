package com.jpaTransaction.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;
import org.springframework.beans.factory.annotation.Configurable;

import javax.persistence.*;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Entity
@Table(name = "student")
@Configurable
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "stu_id")
    private long id;
    @Column(name = "stu_name")
    private String name;
    @Column(name = "stu_email")
    private String email;
    @Column(name = "stu_ph")
    private String ph;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pd_id")
    private StudentPersonalDetails pd;
    @ManyToMany(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
    @JoinTable(
            name = "student_course",
            joinColumns = @JoinColumn(name = "stu_id", referencedColumnName = "stu_id"),
            inverseJoinColumns = @JoinColumn(name = "course_id", referencedColumnName = "course_id")
    )
    @JsonManagedReference
    List<Course> courseList;
//    @ManyToOne(fetch = FetchType.LAZY,
//            cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.REFRESH})
//    @JoinColumn(name = "standard_id")
//    @JsonManagedReference
//    Standard standard;
}
