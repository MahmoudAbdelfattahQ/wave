package com.example.errorhandling.service.student;

import com.example.errorhandling.error.exception.StudentNotFoundException;
import com.example.errorhandling.model.dto.StudentDto;
import com.example.errorhandling.model.entity.Student;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface StudentService {

    void insertStudent(StudentDto studentDto);

    void updateStudent(String id, StudentDto studentDto);

    Map<String, Student> getStudentMap();

    int countStudents();

    void clear();

    Collection<StudentDto> findAll();

    StudentDto findById(String id) throws StudentNotFoundException;

    StudentDto findByEmail(String email) throws StudentNotFoundException;

    void removeStudent(String key);

    Optional<StudentDto> findFirstStudent();
}
