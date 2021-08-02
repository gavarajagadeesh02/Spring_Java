package com.example.project.service;

import org.springframework.stereotype.Service;

import com.example.project.model.Student;
import com.example.project.repository.StudentRepository;


@Service
public class StudentService {
	private final StudentRepository studentRepository;

	public StudentService(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}
	 public int registerStudent(Student student) {
			return studentRepository.registerStudent(student);
			  }
	 public int updateName(String name,int rollno) {
		 return studentRepository.updateName(name, rollno);
	 }
	 public int updateContactNo(String contactno,int rollno) {
		 return studentRepository.updateContactNo(contactno, rollno);
	 }
		public int updateAddress(String address,int rollno) {
			return studentRepository.updateAddress(address, rollno);
		}
		public int deleteStudent(int rollno) {
			return studentRepository.deleteStudent(rollno);
		}
	

}
