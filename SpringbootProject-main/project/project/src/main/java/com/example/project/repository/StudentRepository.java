package com.example.project.repository;

import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import com.example.project.model.Student;

@Repository
public class StudentRepository {
	private final JdbcTemplate jdbctemplate;

	public StudentRepository(JdbcTemplate jdbctemplate) {
		super();
		this.jdbctemplate = jdbctemplate;
	}

	public int registerStudent(Student student) {
		String query ="insert into student values(?,?,?,?,?,?,?,?)";
		int insert = jdbctemplate.update(query,student.getRollno(),student.getName(),student.getAge(),
				student.getGender(),student.getGrade(), student.getSection()  ,student.getContactno(),student.getAddress());
		return insert;	
		
	}
	public int updateName(String name,int rollno) {
		String query = " update   student set name= ? where rollno =?";
		int update =jdbctemplate.update(query, name,rollno);
		return update;
	}
 public int updateContactNo(String contactno,int rollno) {
	 String query = "update student set contactno = ? where rollno = ?";
	 int update =jdbctemplate.update(query,contactno,rollno);
	 return update;
 }
 public int updateAddress(String address,int rollno) {
	 String query = "update student set address = ? where rollno = ?";
	 int update =jdbctemplate.update(query,address,rollno);
	 return update;
	 
 }
 public int deleteStudent(int rollno) {
	 String query = "delete from Student where rollNo = ?";
	 int delete = jdbctemplate.update(query,rollno);
	 return delete;
}
}