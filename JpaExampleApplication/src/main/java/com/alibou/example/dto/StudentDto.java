package com.alibou.example.dto;

import jakarta.persistence.Column;

public record StudentDto(

        String firstName,

        String lastName,

        String email,

        Integer schoolId
) {}
