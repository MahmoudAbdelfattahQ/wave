package com.example.spring3.service.student;

import com.example.demo.controller.StudentsController;
import com.example.demo.dao.StudentRepo;
import com.example.demo.model.dto.StudentDto;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Component
public class StudentServiceImpl implements StudentService {

    public static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(StudentsController.class);

    private final StudentRepo studentRepo;

    @Autowired
    public StudentServiceImpl(StudentRepo studentRepo) {
        this.studentRepo = studentRepo;
        logger.trace("Successfully injected StudentRepo into StudentService");
    }

    public void insertOrUpdateStudent(StudentDto studentDto) {
        studentRepo.insertOrUpdateStudent(studentDto);
    }

    public Map<String, StudentDto> getStudentDtoMap() {
        return studentRepo.getStudentDtoMap();
    }

    public int countStudents() {
        return studentRepo.countStudents();
    }

    public void clear() {
        studentRepo.clear();
    }

    public Collection<StudentDto> findAll() {
        return studentRepo.findAll();
    }

    public void removeStudent(StudentDto studentDto) {
        studentRepo.removeStudent(studentDto);
    }

    public Optional<StudentDto> findFirstStudent() {
        return studentRepo.findAll().stream().findFirst();
    }

    public Optional<StudentDto> filterFirstStudentByEmail(String email) {
        return studentRepo.findAll()
                .stream()
                .filter(studentDto -> studentDto.getEmail().equals(email))
                .findFirst();
    }
}
