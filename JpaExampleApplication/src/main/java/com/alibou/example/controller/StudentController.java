package com.alibou.example.controller;

import com.alibou.example.dto.StudentDto;
import com.alibou.example.dto.StudentResponseDto;
import com.alibou.example.entity.School;
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

    private Student toStudent(StudentDto dto) {
        var student = new Student();
        student.setFirstName(dto.firstName());
        student.setLastName(dto.lastName());
        student.setEmail(dto.email());

        var school = new School();
        student.setId(dto.schoolId());
        student.setSchool(school);

        return student;
    }

    private StudentResponseDto toStudentResponseDto(Student student) {
        return new StudentResponseDto(
                student.getFirstName(),
                student.getLastName(),
                student.getEmail()
        );
    }

    @PostMapping("/students")
    public StudentResponseDto post(
            @RequestBody StudentDto studentDto
    ) {
        var student = toStudent(studentDto);
        var savedStudent = studentService.save(student);
        return toStudentResponseDto(savedStudent);
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

    // http://localhost:8080/students/search/Shrikant
    @GetMapping("/students/search/{student-name}")
    public List<Student> findStudentByName(
            @PathVariable("student-name") String studentName
    ) {
        return studentService.findStudentByName(studentName);
    }

    // http://localhost:8080/students/matches/Kale
    @GetMapping("/students/matches/{student-name}")
    public List<Student> findStudentByLastNameContaining(
            @PathVariable("student-name") String studentName
    ) {
        return studentService.findStudentByLastNameContaining(studentName);
    }

    // http://localhost:8080/students/delete/52
    @DeleteMapping("/students/delete/{student-id}")
    public void delete(
            @PathVariable("student-id") Integer studentId
    ) {
        studentService.deleteStudent(studentId);
    }
}
