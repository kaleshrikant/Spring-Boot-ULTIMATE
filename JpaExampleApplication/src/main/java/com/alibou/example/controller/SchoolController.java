package com.alibou.example.controller;

import com.alibou.example.dto.SchoolDto;
import com.alibou.example.entity.School;
import com.alibou.example.service.SchoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public class SchoolController {

    private final SchoolService schoolService;

    @Autowired
    public SchoolController(SchoolService schoolService) {
        this.schoolService = schoolService;
    }


    // http://localhost:8080/school
    @GetMapping("/school")
    public List<SchoolDto> getAllSchool() {
        return schoolService.getSchool().stream()
                .map(this::toSchoolDto)
                .collect(Collectors.toUnmodifiableList());
    }

    // http://localhost:8080/school
    @PostMapping("/school")
    public SchoolDto create(
            @RequestBody SchoolDto schoolDto
    ) {
        var school = toSchool(schoolDto);
        schoolService.saveSchool(school);
        return schoolDto;
    }

    private School toSchool(SchoolDto schoolDto) {
        var school = new School();
            school.setName(schoolDto.name());
        return school;
    }

    private SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getName());
    }
}
