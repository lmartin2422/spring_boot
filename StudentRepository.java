package com.leonard.demo1.student;

// Data Access Layer

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository  // this db is responsible for data access
// want to use this repository inside @Service in StudentService class
public interface StudentRepository
        extends JpaRepository<Student, Long> {
    // <type(method object) where we want to work , data type for primary key>
    // will be able to fetch students from our db


    //  run a query to see if an email address already exists in the db
    //  SELECT * FROM student WHERE email = ?
    //  above is another way to do what is below
    @Query("SELECT s FROM Student s WHERE s.email = ?1")
    Optional<Student> findStudentByEmail(String email);
}
