package com.leonard.demo1.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.PostMapping;


import java.time.LocalDate;
import java.time.Month;
import java.util.List;


/* THE API LAYER/LEVEL!!! */
/* API = application programming interface... contract of service between 2 applications */
/* 'api layer' talks to the 'service layer' */
/* 'service layer' gives data back to the 'api layer' */

@RestController  // used to create RESTful webservices in Spring
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;  // a reference to student services

    @Autowired  // tells the below StudentService to take above studentService as instantiation
    public StudentController(StudentService studentService) {  // a constructor
        this.studentService = studentService;
    }

    @GetMapping // makes the below class a Restful endpoint
    // GetMapping gets something out of our server
    public List<Student> getStudents() {
        return studentService.getStudents();
    }

    @PostMapping  // API to store payload. this makes it work
    // post is used to add new resources/data from a user
    // can also use post to upload to display
    public void registerNewStudent(@RequestBody Student student) {
        // above takes the request body and maps it into student
        studentService.addNewStudent(student);
    }
    // creating a new method to delete a student
    @DeleteMapping(path = "{studentID}")
    public void deleteStudent(@PathVariable("studentID") Long studentId) {
        studentService.deleteStudent(studentId);
    }
}
