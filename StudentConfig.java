package com.leonard.demo1.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// THIS CLASS CONTAINS STUDENT INFORMATION THAT IS ADDED TO THE DB
// class will add data to the db

@Configuration
public class StudentConfig {

    @Bean  // makes the below information run
    CommandLineRunner commandLineRunner(StudentRepository repository) {
        //above grants access to the repository
        return args -> {
            //  below populating the db
            Student mariam = new Student(
                    1L,
                    "Mariam",
                    "mariam@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 5)
            );

            Student alex = new Student(
                    2L,
                    "alex",
                    "alex@gmail.com",
                    LocalDate.of(2004, Month.JANUARY, 5)
            );

            // saves data to the db
            // hibernate is officially running with the data
            repository.saveAll(
                    List.of(mariam, alex)
            );
        };
    }
}

