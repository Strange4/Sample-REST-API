package com.example.demo.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/student")
public class StudentController {

    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    // Get means that when the client gets to this link he will receive this data
    // Returns all the students in the database
    @GetMapping
    public List<Student> getStudent()
    {
        return studentService.getStudents();
    }

    // Returns a specific student in the database
    @GetMapping("{studentId}")
    public List<Student> getStudent(@PathVariable("studentId") Long studentId)
    {
        if(studentId == null)
        {
            throw new IllegalStateException("The student id cannot be empty for this method");
        }
        return studentService.getStudent(studentId);
    }

    // Post means that the client is the one sending data
    // Creates a new record in the database
    @PostMapping
    public void registerNewStudent(@RequestBody Student student) {
        studentService.addNewStudent(student);
    }

    // Deletes a record in the database
    @DeleteMapping(path = "{studentId}")
    public void deleteStudent(@PathVariable("studentId") Long studentId)
    {
        if(studentId == null)
        {
            throw new IllegalArgumentException("This id is null");
        }
        studentService.deleteStudent(studentId);
    }

    // Updates a record in the database
    @PutMapping(path = "{studentId}")
    public String updateStudent(
            @PathVariable("studentId") Long studentId,
            @RequestParam(required = false) String name,
            @RequestParam(required = false) String email){
        studentService.updateStudent(studentId, name, email);
        return "Everything is going well in this end";
    }

}
