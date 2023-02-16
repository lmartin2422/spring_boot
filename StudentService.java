package com.leonard.demo1.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;
import java.util.Optional;

/* THE SERVICE LAYER!!! */
/* mainly made for business logic */


/* side note:
    must eventually connect to the database.
    use command in linux \c databaseName to connect
*/

@Service  // meant to be a service class. tells studentService in other class to be connected
public class StudentService {

    private final StudentRepository studentRepository;  // for use in StudentRepository interfae/class

    @Autowired
    public StudentService(StudentRepository studentRepository) {  // constructor for above method
        this.studentRepository = studentRepository;
    }

    public List<Student> getStudents() {
        return studentRepository.findAll();  // will return a list
    }
    
    public void addNewStudent(Student student) {
        Optional<Student> studentOptional =
        studentRepository.findStudentByEmail(student.getEmail());
        if (studentOptional.isPresent()) {
            throw new IllegalStateException("EMAIL TAKEN");
            // if the student isn't present, this saves the student
        }
        studentRepository.save(student);
    }

    public void deleteStudent(Long studentId) {
        boolean exists = studentRepository.existsById(studentId);
        if (!exists) {
            throw new IllegalStateException(
                    "student with id " + studentId + "does not exists");
        }
        studentRepository.deleteById(studentId);

    }
}
