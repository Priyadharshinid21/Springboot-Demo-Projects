package com.example.demo.springdatajpa.dao;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.domain.Sort;

import com.example.demo.springdatajpa.entity.Student;
@Repository
public interface StudentRepository extends JpaRepository<Student,Long>{
	
	public List<Student> findByLastName(String lastName);
	public List<Student> findByLastNameContaining(String lastName);
	public List<Student> findByLastNameNotNull();
	public List<Student> findByLastNameAndFirstName(String firstName,String lastName);
	public List<Student> findByStudentIdNotIn(List<Long> studentId);
	@Query("select u from Student u where firstName like %?1")
	public List<Student> findByFirstNameEndsWith(String firstName);
	
	@Query(value="select * from student_details where guardian_name like %?1",nativeQuery=true)
	public List<Student> findByGuardianName(String guardianName);
	
	 @Query("select u from Student u where u.firstName like ?1%")
	  List<Student> findByAndSort(String firstName, Sort sort);
	 
	 @Query("select u from Student u where u.firstName = :firstName or u.lastName = :lastName")
	  List<Student> findByLastnameOrFirstname(@Param("lastName") String lastName,
	                                 @Param("firstName") String firstName);
	 @Modifying
	 @Transactional
	 @Query(value="update student_details s set s.last_name=?1 where s.first_name=?2",nativeQuery=true)
int updateLastNameByFirstName(String lastName,String firstName);

}
