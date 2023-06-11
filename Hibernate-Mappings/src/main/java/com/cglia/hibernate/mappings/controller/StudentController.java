package com.cglia.hibernate.mappings.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cglia.hibernate.mappings.entity.Course;
import com.cglia.hibernate.mappings.entity.Student;
import com.cglia.hibernate.mappings.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {

    private StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping
    public List<Student> getAllStudents() {
        return studentService.findAll();
    }

    @GetMapping("/{id}")
    public Student getStudentById(@PathVariable int id) {
        return studentService.findById(id);
    }

    @PostMapping
    public void addStudent(@RequestBody Student student) {
        studentService.save(student);
    }

    @PutMapping("/{id}")
    public void updateStudent(@RequestBody Student student, @PathVariable int id) {
        studentService.update(student, id);
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable int id) {
        studentService.deleteById(id);
    }
    
    @GetMapping("/courses/{id}")
    public List<Course> getAllCoursesForStudent(@PathVariable int id){
    	return studentService.getStudentCourses(id);
    }
}

