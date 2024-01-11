package com.example.demo.springdatajpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.springdatajpa.dao.TeacherRepository;
import com.example.demo.springdatajpa.entity.Course;
import com.example.demo.springdatajpa.entity.Teacher;

@SpringBootTest
public class TeacherTest {
	@Autowired
	private TeacherRepository teachrepo;

	
	/*@Test
	public void saveTeacher()
	{
		
	Course courseDBA=Course.builder().title("DBA").credit(8).build();
	Course courseJava=Course.builder().title("Java").credit(4).build();
		Teacher teacher=Teacher.builder().firstName("Lalitha").lastName("Rakesh").course(List.of(courseDBA,courseJava)).build();
	teachrepo.save(teacher);
	}*/
}
