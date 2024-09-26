package com.hussainIT.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hussainIT.entites.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
	 List<Student> findByAgeBetween(int startAge, int endAge);
}
