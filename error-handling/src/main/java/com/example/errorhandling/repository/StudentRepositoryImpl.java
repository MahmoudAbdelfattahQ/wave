package com.example.errorhandling.repository;

import com.example.errorhandling.error.exception.StudentNotFoundException;
import com.example.errorhandling.model.entity.Student;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
@Component
public class StudentRepositoryImpl implements StudentRepository {

    private static final String CLASS_NAME = StudentRepositoryImpl.class.getSimpleName();

    @Getter
    private final Map<String, Student> studentMap;

    public StudentRepositoryImpl() {
        studentMap = new HashMap<>();
    }

    public void insertOrUpdateStudent(Student student) {
        String methodName = CLASS_NAME + ".insertOrUpdateStudent()";
        studentMap.put(student.getId(), student);
        log.info("Student inserted/updated successfully");
        log.debug("{}, Student id: {}", methodName, student.getId());
    }

    @Override
    public Student findById(String id) throws StudentNotFoundException {
        Object[] params;
        String methodName = CLASS_NAME + ".findById()";
        log.trace("Id of student that I will search with is: {}", id);
        Student student = studentMap.get(id);
        if (Objects.isNull(student)) {
            throw new StudentNotFoundException("Student with id: " + id + " is not found");
        }
        params = new Object[]{methodName, id, student.getName(), student.getEmail(), student.getAge()};
        log.debug("{}, Successfully found student with id: {}, name: {}, email: {}, and age: {}", params);
        return student;
    }

    @Override
    public Student findByEmail(String email) throws StudentNotFoundException {
        return studentMap.values()
                .stream()
                .filter(student -> student.getEmail().equals(email))
                .findFirst()
                .orElseThrow(() -> new StudentNotFoundException("Student with email: " + email + " id not found"));
    }

    public int countStudents() {
        return studentMap.size();
    }

    public void clear() {
        studentMap.clear();
    }

    public Collection<Student> findAll() {
        return studentMap.values();
    }

    public void removeStudent(String key) {
        studentMap.remove(key);
        log.info("Student removed successfully with id: {}", key);
    }
}
