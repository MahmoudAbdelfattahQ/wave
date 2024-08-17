package com.example.errorhandling.controller;

import com.example.errorhandling.error.exception.StudentNotFoundException;
import com.example.errorhandling.model.dto.StudentDto;
import com.example.errorhandling.service.student.StudentService;
import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("students")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
        log.info("Successfully injected StudentService into StudentsController");
    }

    // todo: handle error for the following API
    @PostMapping("insert")
    public void insertStudentApi(@RequestBody StudentDto studentDto) {
        studentService.insertStudent(studentDto);
        log.debug("Successfully added {} into the hashMap ", studentDto);
    }

    @GetMapping("size")
    public int listSizeApi() {
        log.debug("Students size is: {}", studentService.countStudents());
        return studentService.countStudents();
    }

    // todo: handle error for the following API
    @GetMapping("findFirst")
    public StudentDto findFirstStudentApi() {
        Optional<StudentDto> studentDtoOptional = studentService.findFirstStudent();

        studentDtoOptional.ifPresent(studentDto -> log.debug("Found Student with email {}", studentDto.getEmail()));

        return studentDtoOptional.orElse(null);
    }

    @GetMapping("find/{id}")
    public StudentDto findStudentByIdApi(@PathVariable String id) throws StudentNotFoundException {
        return studentService.findById(id);
    }

    @GetMapping("find")
    public StudentDto findStudentByEmailApi(@RequestParam String email) throws StudentNotFoundException {
        return studentService.findByEmail(email);
    }

    @GetMapping("findAll")
    public Collection<StudentDto> findAllStudentApi() {
        return studentService.findAll();
    }


    // todo: handle error for the following API
    @DeleteMapping("delete/{id}")
    public void deleteStudentApi(@PathVariable String id) {
        studentService.removeStudent(id);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<String> updateStudentApi(@Valid @RequestBody StudentDto studentDto, @PathVariable String id) {

        // todo: handle the following check
        if (!studentService.getStudentMap().containsKey(id)) {
            log.error("Student is not found!!");
            return ResponseEntity.notFound().build();
        }

        studentService.updateStudent(id, studentDto);
        return ResponseEntity.ok("Data updated successfully");
    }

    @DeleteMapping("removeAll")
    public void removeAllStudentsApi() {
        studentService.clear();
    }
}
