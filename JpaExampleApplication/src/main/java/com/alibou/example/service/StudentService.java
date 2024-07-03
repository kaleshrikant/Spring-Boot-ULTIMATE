package com.alibou.example.service;

import com.alibou.example.dto.StudentDto;
import com.alibou.example.dto.StudentResponseDto;
import com.alibou.example.entity.Student;
import com.alibou.example.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    private final StudentMapper studentMapper;

    @Autowired
    public StudentService(StudentRepository studentRepository, StudentMapper studentMapper) {
        this.studentRepository = studentRepository;
        this.studentMapper = studentMapper;
    }

    public StudentResponseDto saveStudent(
            StudentDto studentDto
    ) {
        var student = studentMapper.toStudent(studentDto);
        var savedStudent = studentRepository.save(student);
        return studentMapper.toStudentResponseDto(savedStudent);
    }

    public List<StudentResponseDto> findAllStudents() {
        return studentRepository.findAll()
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toUnmodifiableList());
    }

    public StudentResponseDto findStudentById(Integer studentId) {
        return studentRepository.findById(studentId)
                .map(studentMapper::toStudentResponseDto)
                .orElse(null);
    }

    public List<StudentResponseDto> findStudentByName(String firstName) {
        return studentRepository.findAllByFirstName(firstName)
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toUnmodifiableList());
    }

    public List<StudentResponseDto> findStudentByLastNameContaining(String studentName) {
        return studentRepository.findAllByLastNameContaining(studentName)
                .stream()
                .map(studentMapper::toStudentResponseDto)
                .collect(Collectors.toUnmodifiableList());
    }

    public void deleteStudent(Integer studentId) {
        studentRepository.deleteById(studentId);
    }
}
