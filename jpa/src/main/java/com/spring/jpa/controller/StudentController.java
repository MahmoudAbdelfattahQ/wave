package com.spring.jpa.controller;

import com.spring.jpa.model.dto.StudentDto;
import com.spring.jpa.service.student.StudentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Slf4j
@RestController
@RequestMapping("/student")
public class StudentController {
    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("save")
    public void saveStudentApi(@Valid @RequestBody StudentDto studentDto) {
        studentService.save(studentDto);
    }

    @PutMapping("update")
    public void updateStudentApi(@Valid @RequestBody StudentDto studentDto) {
        studentService.update(studentDto);
    }

    @DeleteMapping("delete/{id}")
    public void deleteStudentApi(@PathVariable UUID id) {
        studentService.delete(id);
    }

    @GetMapping("find/{id}")
    public StudentDto findStudentByIdApi(@PathVariable UUID id) {
        return studentService.findById(id);
    }

    @GetMapping("findAll")
    public List<StudentDto> findAllStudentsApi() {
        return studentService.findAll();
    }

    @GetMapping("count")
    public Long countStudentsApi() {
        return studentService.count();
    }
}
