package com.example.spring3.service.student;

import com.example.demo.model.dto.StudentDto;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface StudentService {

    void insertOrUpdateStudent(StudentDto studentDto);

    Map<String, StudentDto> getStudentDtoMap();

    int countStudents();

    void clear();

    Collection<StudentDto> findAll();

    void removeStudent(StudentDto studentDto);

    Optional<StudentDto> findFirstStudent();

    Optional<StudentDto> filterFirstStudentByEmail(String email);
}
