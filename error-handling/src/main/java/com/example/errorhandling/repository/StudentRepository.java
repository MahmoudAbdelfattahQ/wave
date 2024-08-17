package com.example.errorhandling.repository;

import com.example.errorhandling.error.exception.StudentNotFoundException;
import com.example.errorhandling.model.entity.Student;

import java.util.Collection;
import java.util.Map;

public interface StudentRepository {
    void insertOrUpdateStudent(Student student);

    Map<String, Student> getStudentMap();

    Student findById(String id) throws StudentNotFoundException;

    Student findByEmail(String email) throws StudentNotFoundException;

    int countStudents();

    void clear();

    Collection<Student> findAll();

    void removeStudent(String key);
}
