package com.example.demo.springdatajpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.springdatajpa.dao.CourseMaterialRepository;
import com.example.demo.springdatajpa.entity.Course;
import com.example.demo.springdatajpa.entity.CourseMaterial;

@SpringBootTest
public class CourseTest {
	@Autowired
	private CourseMaterialRepository cmrepo;
	
  @Test
	public void saveCourseMaterial()
	{
	  Course course=Course.builder().title("The King of Jungle").credit(6).build();
		CourseMaterial coursem=CourseMaterial.builder().url("https://www.books.com").course(course).build();
		cmrepo.save(coursem);
	}
  @Test
 	public void showCourseMaterial()
 	{
 	  List<CourseMaterial> course=cmrepo.findAll();
 	  System.out.println(course);
 	}

}
