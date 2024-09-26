package com.hussainIT.service;

import java.util.List;
import java.util.Optional;

import com.hussainIT.entites.Student;

public interface StudentService {
	 public Student saveStudent(Student student);
	 public Optional<Student> getStudent(Long id);
	 public List<Student> getStudentsByAgeRange(int startAge, int endAge);
	 public void updateStudentAge(Long id);
	 
}
