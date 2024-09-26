package com.hussainIT.entites;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name = "student_tbl")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Student {
	    @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    
	    private String name;
	    
	    @Column(name = "dob_day")
	    private int dayOfBirth;
	    
	    @Column(name = "dob_month")
	    private int monthOfBirth;
	    
	    @Column(name = "dob_year")
	    private int yearOfBirth;
	    
	    private int age;
}
