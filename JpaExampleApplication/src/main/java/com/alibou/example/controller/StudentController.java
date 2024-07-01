package com.alibou.example.controller;

import com.alibou.example.entity.Student;
import com.alibou.example.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class StudentController {

    private final StudentService studentService;

    // constuctor injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/students")
    public Student post(
            @RequestBody Student student
    ) {
        return studentService.save(student);
    }

    @GetMapping("/students")
    public List<Student> findAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/students/{student-id}")
    public Optional<Student> findStudent(
            @PathVariable("student-id") Integer studentId
    ) {
        return studentService.findStudent(studentId);
    }
}
