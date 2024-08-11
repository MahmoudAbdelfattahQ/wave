package com.example.spring3.service.student;

import com.example.spring3.model.dto.StudentDto;
import com.example.spring3.model.entity.Student;
import com.example.spring3.util.RepoUtils;
import lombok.extern.slf4j.Slf4j;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.example.spring3.dao.StudentRepo;
import com.example.spring3.controller.StudentsController;

import java.util.*;

@Slf4j
@Component
public class StudentServiceImpl implements StudentService {

    private final StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
        log.info("Successfully injected StudentRepo into StudentService");
    }

    public void insertStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setId(String.valueOf(RepoUtils.ID));
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setAge(studentDto.getAge());
        RepoUtils.ID++;

        studentRepo.insertOrUpdateStudent(student);
    }

    @Override
    public void updateStudent(String id, StudentDto studentDto) {
        Student student = new Student();
        student.setId(id);
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setAge(studentDto.getAge());

        studentRepo.insertOrUpdateStudent(student);
    }

    public Map<String, Student> getStudentMap() {
        return studentRepo.getStudentMap();
    }

    public int countStudents() {
        return studentRepo.countStudents();
    }

    public void clear() {
        studentRepo.clear();
    }

    public Collection<StudentDto> findAll() {
        return studentRepo.findAll()
                .stream()
                .map(student -> new StudentDto(student.getName(), student.getEmail(), student.getAge()))
                .toList();
    }

    public void removeStudent(String key) {
        studentRepo.removeStudent(key);
    }

    public Optional<StudentDto> findFirstStudent() {
        return studentRepo.findAll()
                .stream()
                .map(student -> new StudentDto(student.getName(), student.getEmail(), student.getAge()))
                .findFirst();
    }
}
