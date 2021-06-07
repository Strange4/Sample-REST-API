package com.example.demo.student;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

// This is the basic configuration that the server runs before starting.
@Configuration
public class StudentConfig {

    @Bean
    CommandLineRunner commandLineRunner(
            StudentRepository repository)
    {
        // Creates a new student on the start of the server
        return args -> {
            Student brandon = new Student(
                    "base user",
                    "based@gmail.com",
                    LocalDate.of(2000, Month.JANUARY, 1)
            );
            repository.saveAll(
                    List.of(brandon)
            );
        };
    }
}
