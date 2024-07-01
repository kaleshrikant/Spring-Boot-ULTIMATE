package com.alibou.example.controller;

import com.alibou.example.entity.Student;
import com.alibou.example.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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
}
