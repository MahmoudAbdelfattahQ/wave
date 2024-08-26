package com.spring.jpa.service.student;

import com.spring.jpa.model.dto.StudentDto;

import java.util.List;
import java.util.UUID;

public interface StudentService {

    void save(StudentDto studentDto);

    void update(StudentDto studentDto);

    void delete(UUID id);

    StudentDto findById(UUID id);

    List<StudentDto> findAll();

    long count();
}
