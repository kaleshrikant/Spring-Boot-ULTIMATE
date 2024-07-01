package com.alibou.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "T_STUDENT", schema = "ultimate_db")
public class Student {

    @Id
    @GeneratedValue
    private Integer id;

    @Column(
            name = "c_fname",
            length = 20
    )
    private String firstName;
    private String lastName;

    @Column(unique = true)
    private String email;
    private int age;

    @Column(
            updatable = false
    )
    private String some_column;

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", age=" + age +
                '}';
    }
}
