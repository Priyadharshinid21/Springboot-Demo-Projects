package com.example.demo.springdatajpa.entity;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor

@Table(name="student_details",
uniqueConstraints=@UniqueConstraint(name="emailid_unique",
columnNames="email_id"))
@ToString
@Builder
public class Student {
	@Id
	@SequenceGenerator(name="student_sequence",
	sequenceName="student_sequence",
	allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,
	generator="student_sequence")
	private Long studentId;
	private String firstName;
	private String lastName;
	@Column(name="email_id",nullable=false)
	private String emailId;
	
	@Embedded
	public Guardian guardian;
	
	//this is sample"
	
	

}
