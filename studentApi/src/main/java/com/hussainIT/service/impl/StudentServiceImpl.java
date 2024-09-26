package com.hussainIT.service.impl;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hussainIT.entites.Student;
import com.hussainIT.repository.StudentRepository;
import com.hussainIT.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentRepository repository;

	@Override
	public Student saveStudent(Student student) {
		return repository.save(student);
	}

	@Override
	public Optional<Student> getStudent(Long id) {
		return repository.findById(id);
	}

	@Override
	public List<Student> getStudentsByAgeRange(int startAge, int endAge) {
		return repository.findByAgeBetween(startAge, endAge);
	}

	@Override
	public void updateStudentAge(Long id) {
		 Optional<Student> studentOptional = repository.findById(id);
	        if (studentOptional.isPresent()) {
	            Student student = studentOptional.get();
	            student.setAge(calculateAge(student.getDayOfBirth(), student.getMonthOfBirth(), student.getYearOfBirth()));
	            repository.save(student);
	        }
	}
	 private int calculateAge(int day, int month, int year) {
	        LocalDate birthDate = LocalDate.of(year, month, day);
	        return Period.between(birthDate, LocalDate.now()).getYears();
	    }

}
