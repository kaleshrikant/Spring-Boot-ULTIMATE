package com.alibou.example.controller;

import com.alibou.example.dto.StudentDto;
import com.alibou.example.dto.StudentResponseDto;
import com.alibou.example.service.StudentService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class StudentController {

    private final StudentService studentService;

    // constuctor injection
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }


    @PostMapping("/students")
    public StudentResponseDto saveStudent(
           @Valid @RequestBody StudentDto studentDto
    ) {
        return this.studentService.saveStudent(studentDto);
    }

    @GetMapping("/students")
    public List<StudentResponseDto> findAllStudents() {
        return studentService.findAllStudents();
    }

    @GetMapping("/students/{student-id}")
    public StudentResponseDto findStudentById(
            @PathVariable("student-id") Integer studentId
    ) {
        return studentService.findStudentById(studentId);
    }

    // http://localhost:8080/students/search/Shrikant
    @GetMapping("/students/search/{student-name}")
    public List<StudentResponseDto> findStudentByName(
            @PathVariable("student-name") String studentName
    ) {
        return studentService.findStudentByName(studentName);
    }

    // http://localhost:8080/students/matches/Kale
    @GetMapping("/students/matches/{student-name}")
    public List<StudentResponseDto> findStudentByLastNameContaining(
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

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleMethodArgumentNotValidException(
            MethodArgumentNotValidException exception
    ){
            var errors = new HashMap<String, String>();
                exception.getBindingResult().getAllErrors()
                        .forEach(error -> {
                                var fieldName = ((FieldError) error).getField();
                                var errorMessage = error.getDefaultMessage();
                        errors.put(fieldName,errorMessage);
                });
            return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
    }
}
