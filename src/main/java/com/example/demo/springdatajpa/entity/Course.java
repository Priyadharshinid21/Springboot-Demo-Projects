package com.example.demo.springdatajpa.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Builder

public class Course {
	@Id
	@SequenceGenerator(name="course_sequence",
			sequenceName="course_sequence",allocationSize=1)
	@GeneratedValue(strategy=GenerationType.SEQUENCE,generator="couse_sequence")
	private Long courseId;
	private String title;
	private Integer credit;
	@OneToOne(mappedBy="course",cascade=CascadeType.ALL)
	private CourseMaterial courseMaterial;
	
	@ManyToOne(cascade=CascadeType.ALL)
	private Teacher teacher;
	
	@ManyToMany(cascade=CascadeType.ALL)
	@JoinTable(name="student_course_map",joinColumns=@JoinColumn(name="course_id",referencedColumnName="courseId"),
	inverseJoinColumns=@JoinColumn(name="student_id",referencedColumnName="studentId"))
	private List<Student> students;
	
	public void addStudent(Student student)
	{
		if(students==null)
		{
			students=new ArrayList<>();
		}
		students.add(student);
		}
	


}
