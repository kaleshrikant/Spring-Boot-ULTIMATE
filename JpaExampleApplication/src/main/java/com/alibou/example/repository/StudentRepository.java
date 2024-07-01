package com.alibou.example.repository;

import com.alibou.example.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    List<Student> findAllByFirstName(String firstName);

    List<Student> findAllByLastNameContaining(String studentName);
}
