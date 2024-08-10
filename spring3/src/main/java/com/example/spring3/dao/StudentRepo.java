package com.example.spring3.dao;

import com.example.demo.model.dto.StudentDto;
import lombok.Getter;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Component
public class StudentRepo {

    private static StudentRepo studentRepo;
    @Getter
    private final Map<String, StudentDto> studentDtoMap;

    public StudentRepo() {
        studentDtoMap = new HashMap<>();
    }

    public static StudentRepo getInstance() {
        if (studentRepo == null) {
            studentRepo = new StudentRepo();
        }
        return studentRepo;
    }

    public void insertOrUpdateStudent(StudentDto studentDto) {
        studentDtoMap.put(studentDto.getEmail(), studentDto);
    }

    public int countStudents() {
        return studentDtoMap.size();
    }

    public void clear() {
        studentDtoMap.clear();
    }

    public Collection<StudentDto> findAll() {
        return studentDtoMap.values();
    }

    public void removeStudent(StudentDto studentDto) {
        studentDtoMap.remove(studentDto.getEmail());
    }
}
