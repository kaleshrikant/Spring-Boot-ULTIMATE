package com.alibou.example.service;

import com.alibou.example.entity.School;
import com.alibou.example.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository) {
        this.schoolRepository = schoolRepository;
    }

    public School saveSchool(School school) {
        return schoolRepository.save(school);
    }

    public List<School> getSchool() {
        return schoolRepository.findAll();
    }
}
