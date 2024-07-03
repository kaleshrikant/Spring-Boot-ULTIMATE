package com.alibou.example.service;

import com.alibou.example.dto.SchoolDto;
import com.alibou.example.repository.SchoolRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SchoolService {

    private final SchoolRepository schoolRepository;
    private final SchoolMapper schoolMapper;

    @Autowired
    public SchoolService(SchoolRepository schoolRepository, SchoolMapper schoolMapper) {
        this.schoolRepository = schoolRepository;
        this.schoolMapper = schoolMapper;
    }

    public SchoolDto saveSchool(SchoolDto schoolDto) {
        var school =  schoolMapper.toSchool(schoolDto);
            schoolRepository.save(school);
        return schoolDto;
    }

    public List<SchoolDto> findAllSchool() {
        return schoolRepository.findAll()
                .stream()
                .map(schoolMapper::toSchoolDto)
                .collect(Collectors.toUnmodifiableList());
    }
}
