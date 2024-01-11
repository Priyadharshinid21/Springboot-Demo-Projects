package com.example.demo.springdatajpa;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;

import com.example.demo.springdatajpa.dao.CourseRepository;
import com.example.demo.springdatajpa.entity.Course;
import com.example.demo.springdatajpa.entity.CourseMaterial;
import com.example.demo.springdatajpa.entity.Student;
import com.example.demo.springdatajpa.entity.Teacher;

@SpringBootTest
public class CourseMainTest {
	@Autowired
	private CourseRepository courserepo;
	@Test
	public void saveCourse()
	{
		CourseMaterial coursem=CourseMaterial.builder().url("Everything.com").build();
		Course course=Course.builder().title("HarryPotter").credit(6).courseMaterial(coursem).build();
		courserepo.save(course);
		System.out.println(course);
	
	}
	
	@Test
	public void showCourse()
	{
		
List<Course> course=courserepo.findAll();
System.out.println(course);
 
	}
	
	@Test
	public void saveCourseWithTeacher()
	{
	Teacher teacher=Teacher.builder().firstName("Subhangi").lastName("Karan").build();
	Course courses=Course.builder().title("Go lang").credit(8).teacher(teacher).build();
	Course course1=Course.builder().title("Dotnet").credit(9).teacher(teacher).build();
	List<Course> cm=List.of(courses,course1);
	
	courserepo.saveAll(cm);
	}
	@Test
	public void findListWithPageable()
	{
		Pageable pageWithThreeRecords=PageRequest.of(1, 2);
		//Pageable pageWithTwoRecords=PageRequest.of(0, 5, Sort.by(Direction.ASC));
		List<Course> course=courserepo.findAll(pageWithThreeRecords).getContent();
		long totalelements=courserepo.findAll(pageWithThreeRecords).getTotalElements();
		long totalPages=courserepo.findAll(pageWithThreeRecords).getTotalPages();
		System.out.println(totalPages);
		System.out.println(totalelements);
		System.out.println(course);
		
	}
	
	@Test
	public void findListWithPagdeSort() {
		Pageable page=PageRequest.of(1,3,Sort.by("credit").descending());
		List<Course> course=courserepo.findAll(page).getContent();
		System.out.println(course);
	}
	@Test
	public void pageByTitle()
	{
		Pageable page=PageRequest.of(1,3);
		List<Course> course=courserepo.findByTitleContaining("D",page).getContent();
		System.out.println(course);
		
		
	}
	@Test
	public void saveCoursewithTeacherAndStudent()
	{
		Teacher teacher=Teacher.builder().firstName("Lisa").lastName("Jennie").build();
		Student student=Student.builder().firstName("Richa").lastName("Gupta").emailId("richa@gmail.com").build();
		Course course=Course.builder().title("Python").credit(9).teacher(teacher).build();
		course.addStudent(student);
		courserepo.save(course);
	}
}
