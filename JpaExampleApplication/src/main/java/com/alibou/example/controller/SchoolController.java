package com.alibou.example.controller;

import com.alibou.example.entity.School;
import com.alibou.example.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class SchoolController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }


    // http://localhost:8080/school
    @GetMapping("/school")
    public List<School> getAllSchool() {
        return schoolService.getSchool();
    }

    // http://localhost:8080/school
    @PostMapping("/school")
    public School create(
            @RequestBody School school
    ) {
        return schoolService.saveSchool(school);
    }
}
