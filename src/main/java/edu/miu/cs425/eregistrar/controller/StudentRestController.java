package edu.miu.cs425.eregistrar.controller;

import edu.miu.cs425.eregistrar.model.Student;
import edu.miu.cs425.eregistrar.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;


@RestController
@RequestMapping("/api/items")
public class StudentRestController {

    @Autowired
    private StudentService studentService;


    @GetMapping("/{id}")
    public Optional<Student> getStudentById(@PathVariable Long id) {
        return studentService.findById(id);

    }
    @PostMapping
    public Student createStudent(@RequestBody Student student) {
        return studentService.save(student);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable Long id, @RequestBody Student student) {
        Optional<Student> std =  studentService.findById(id);
        std.get().setStudentNumber(student.getStudentNumber());
        std.get().setFirstName(student.getFirstName());
        std.get().setMiddleName(student.getMiddleName());
        std.get().setLastName(student.getLastName());
        std.get().setCgpa(student.getCgpa());
        std.get().setEnrollmentDate(student.getEnrollmentDate());
        return ResponseEntity.ok(studentService.save(std.get()));
        }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        if (studentService.findById(id) != null) {
            studentService.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}