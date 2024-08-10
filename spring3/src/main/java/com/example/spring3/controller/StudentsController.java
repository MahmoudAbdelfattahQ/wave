package com.example.spring3.controller;

import com.example.demo.model.dto.StudentDto;
import com.example.demo.service.student.StudentService;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.Optional;

@RestController
@RequestMapping("student")
public class StudentsController {

    public static final Logger logger = org.apache.logging.log4j.LogManager.getLogger(StudentsController.class);

    private final StudentService studentService;

    @Autowired
    public StudentsController(StudentService studentService) {
        this.studentService = studentService;
        logger.trace("Successfully injected StudentService into StudentsController");
    }

    @PostMapping("insert")
    public void insertStudentApi(@RequestBody StudentDto studentDto) {
        studentService.insertOrUpdateStudent(studentDto);
        logger.info("Successfully added {} into the hashMap ", studentDto);
    }

    @GetMapping("size")
    public int listSizeApi() {
        logger.info("Students size is: {}", studentService.countStudents());
        return studentService.countStudents();
    }

    @GetMapping("findFirst")
    public StudentDto findFirstStudentApi() {
        Optional<StudentDto> studentDtoOptional = studentService.findFirstStudent();

        studentDtoOptional.ifPresent(studentDto -> logger.info("Found Student with email {}", studentDto.getEmail()));

        return studentDtoOptional.orElse(null);
    }

    @GetMapping("findAll")
    public Collection<StudentDto> findAllStudentApi() {
        return studentService.findAll();
    }

    @DeleteMapping("deleteByEmail")
    public void deleteStudentByEmailWithPathVariableApi(@RequestParam String email) {
        Optional<StudentDto> studentDtoOptional = studentService.filterFirstStudentByEmail(email);

        studentDtoOptional.ifPresent(student -> studentService.getStudentDtoMap().remove(student.getEmail()));
    }

    // todo: This API has an issue in updating the key as well. Solve it please
    @PutMapping("updateByEmail/{email}")
    public ResponseEntity<String> updateStudentApi(@RequestBody StudentDto studentDto, @PathVariable String email) {
        logger.info("accepted email: {} from client", email);
        if (!email.contains(".com") || !email.contains("@")) {
            String returnMessage = email + " is not Valid";
            logger.error("The Email with id: {}", returnMessage);
            return ResponseEntity.badRequest().body("");
        }
        if (!studentService.getStudentDtoMap().containsKey(email)) {
            logger.error("Email is not found!!");
            return ResponseEntity.notFound().build();
        }

        studentService.insertOrUpdateStudent(studentDto);
        logger.info("Map keys are: {}", studentService.getStudentDtoMap().keySet());
        logger.info("Successfully added {} into the hashMap with email {}", studentDto, email);
        return ResponseEntity.ok("Data updated successfully");
    }
}
