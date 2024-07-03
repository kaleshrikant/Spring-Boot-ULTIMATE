package com.alibou.example.service;

import com.alibou.example.dto.SchoolDto;
import com.alibou.example.entity.School;
import org.springframework.stereotype.Service;

@Service
public class SchoolMapper {

    public School toSchool(SchoolDto schoolDto) {
        var school = new School();
        school.setName(schoolDto.name());
        return school;
    }

    public SchoolDto toSchoolDto(School school) {
        return new SchoolDto(school.getName());
    }
}
