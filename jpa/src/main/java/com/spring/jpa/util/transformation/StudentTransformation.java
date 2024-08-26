package com.spring.jpa.util.transformation;

import com.spring.jpa.model.dto.StudentDto;
import com.spring.jpa.model.entity.Student;

import java.util.UUID;

public class StudentTransformation {

    private StudentTransformation() {
    }

    public static StudentDto toStudentDto(Student student) {
        return new StudentDto(
                student.getName(), student.getEmail(), student.getAge(), student.getMarks(), student.getPhone());
    }

    public static Student toStudent(StudentDto studentDto) {
        Student student = new Student();
        student.setId(UUID.randomUUID());
        student.setName(studentDto.getName());
        student.setEmail(studentDto.getEmail());
        student.setAge(studentDto.getAge());
        student.setMarks(studentDto.getMarks());
        student.setPhone(studentDto.getPhone());
        return student;
    }

}
