package com.example.demo.springdatajpa;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.springdatajpa.dao.StudentRepository;
import com.example.demo.springdatajpa.entity.Guardian;
import com.example.demo.springdatajpa.entity.Student;
import org.springframework.data.domain.Sort;

@SpringBootTest
public class StudentTest {
	
	@Autowired
	private StudentRepository srepo;
	
	/*@Test
	public void saveStudent()
	{
		Student student=Student.builder().firstName("Lucky").LastName("Raj").emailId("Lassynia@gmail.com").guardianName("Rosy").guardianEmail("rosy@gmail.com").guardianMobile(99999998879l).build();
		srepo.save(student);
	}*/
	
	@Test
	public void saveStudentAndGuardian()
	{
		Guardian guardian=Guardian.builder().guardianName("Lucy").guardianEmail("Lucy@gmail.com").guardianMobile(99999998879l).build();
		Student student=Student.builder().firstName("Rocky").lastName("Leo").emailId("Ranjana@gmail.com").guardian(guardian).build();
		srepo.save(student);
	}
	
	@Test
	public void AnotherSaveStudentAndGuardian()
	{
		Guardian guardian=Guardian.builder().guardianName("Rocky").guardianEmail("rocky@gmail.com").guardianMobile(99988998879l).build();
		Student student=Student.builder().firstName("Lan").lastName("Lan").emailId("Lan123@gmail.com").guardian(guardian).build();
		srepo.save(student);
	}
	
	@Test
	public void AnotherSaveStudentAndGuardianWise()
	{
		Guardian guardian=Guardian.builder().guardianName("Rinchen").guardianEmail("ringen123@gmail.com").guardianMobile(99955998879l).build();
		Student student=Student.builder().firstName("Shamita").lastName("Lacky").emailId("Lacky123@gmail.com").guardian(guardian).build();
		srepo.save(student);
	}
	@Test
	public void saveStudentAndGuardianWhole()
	{
		Guardian guardian=Guardian.builder().guardianName("Ranjy").guardianEmail("Ranjy@gmail.com").guardianMobile(99559998879l).build();
		Student student=Student.builder().firstName("Shamita").lastName("Rosy").emailId("Rosy44@gmail.com").guardian(guardian).build();
		Guardian guardian1=Guardian.builder().guardianName("Lingam").guardianEmail("lingam44@gmail.com").guardianMobile(9955944479l).build();
		Student student1=Student.builder().firstName("Maruthi").lastName("Mani").emailId("Maruthi224@gmail.com").guardian(guardian1).build();
		Guardian guardian2=Guardian.builder().guardianName("Lin").guardianEmail("Rlin1234@gmail.com").guardianMobile(91122998879l).build();
		Student student2=Student.builder().firstName("Rick").lastName("Richard").emailId("Ricky@gmail.com").guardian(guardian2).build();
		List<Student> stu=Arrays.asList(student,student1,student2);
		srepo.saveAll(stu);
	}
	@Test
	public void getAllStudents()
	{
		List<Student> stu=srepo.findAll();
		System.out.println("Student List are"+stu);
		
		
	}
	@Test
	public void findByLastStudentName()
	{ 
		List<Student> stuLastName=srepo.findByLastName("Leo");
		System.out.println("Student List are"+stuLastName);
	}
	
	@Test
	public void findByLastStudentNameContaining()
	{ 
		List<Student> stuLastName=srepo.findByLastNameContaining("R");
		System.out.println("Student List are"+stuLastName);
	}
	
	@Test
	public void findByLastStudentNameNotNull()
	{
		List<Student> stud=srepo.findByLastNameNotNull();
		System.out.println(stud);
	}
	
	@Test
	public void findFirstNameAndLastName()
	{
		List<Student> stud=srepo.findByLastNameAndFirstName("Lan", "Lan");
		System.out.println(stud);
		
	}
	@Test
	public void getId()
	{
		List<Student> stud=srepo.findByStudentIdNotIn(Arrays.asList(1l,3l));
		System.out.println(stud);
		//List<Student> passengers = srepo.findAll(Sort.by(Sort.Direction.ASC, "seatNumber"));
		
	}
	
	@Test
	public void getFirstNameEndingWith()
	{
		List<Student> stud=srepo.findByFirstNameEndsWith("ck");
		System.out.println(stud);
		
	}
	
@Test
public void getGuardianName()
{
	List<Student> stu=srepo.findByGuardianName("cy");
	System.out.println(stu);
}

@Test
public void findBySort()
{
	List<Student> stu=srepo.findByAndSort("Sha", Sort.by("lastName"));
	System.out.println(stu);
}

@Test
public void getFirstNameAndLastNameUsingParam()
{
	List<Student> stu=srepo.findByLastnameOrFirstname("Richard","Rick");
	System.out.println(stu);
	
}

@Test
public void changeFirstNameLastName()
{
	int stu=srepo.updateLastNameByFirstName("Lucifer", "Lan");
	System.out.println(stu);
}

}
