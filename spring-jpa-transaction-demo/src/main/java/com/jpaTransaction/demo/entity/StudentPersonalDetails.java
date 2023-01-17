package com.jpaTransaction.demo.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.procedure.spi.ParameterRegistrationImplementor;

import javax.persistence.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "student_personal_detail")
public class StudentPersonalDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "pd_id")
    private long id;
    @Column(name = "hobby")
    private String hobby;
    @Column(name = "city")
    private String city;
    @OneToOne(mappedBy = "pd", cascade = CascadeType.ALL)
    Student student;


    @Override
    public String toString() {
        return "StudentPersonalDetails{" +
                "id=" + id +
                ", hobby='" + hobby + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
