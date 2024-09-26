package com.hussainIT.controller;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.hussainIT.entites.Student;
import com.hussainIT.service.StudentService;


/*
 *  Example API Endpoints
 *  http://localhost:9099/students/create endpoint
 *  
Create Student: POST /students/create with a JSON payload like:

{
  "name": "khalid hussain",
  "dayOfBirth": 15,
  "monthOfBirth": 8,
  "yearOfBirth": 2000
}
Get Student by ID: GET /students/{id}

Update Age for Student: PUT /students/update-age/{id}

Get Students between Age 18 and 25: GET /students/age-range?startAge=18&endAge=25
 * */


@RestController
@RequestMapping("/students")
public class StudentController {
 	
	@Autowired
	private StudentService studentService;
	
	@PostMapping("/create")
    public ResponseEntity<Student> createStudent(@RequestBody Student student) {
        Student savedStudent = studentService.saveStudent(student);
        return new ResponseEntity<>(savedStudent, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getStudentById(@PathVariable Long id) {
        Optional<Student> student = studentService.getStudent(id);
        return student.map(ResponseEntity::ok).orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PutMapping("/update-age/{id}")
    public ResponseEntity<String> updateStudentAge(@PathVariable Long id) {
        studentService.updateStudentAge(id);
        return new ResponseEntity<>("Age updated successfully", HttpStatus.OK);
    }

    @GetMapping("/age-range")
    public ResponseEntity<List<Student>> getStudentsByAgeRange(@RequestParam int startAge, @RequestParam int endAge) {
        List<Student> students = studentService.getStudentsByAgeRange(startAge, endAge);
        return new ResponseEntity<>(students, HttpStatus.OK);
    }
}
