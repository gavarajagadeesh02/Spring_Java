package com.example.project.controller;


import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.Student;
import com.example.project.service.StudentService;

@RestController
@RequestMapping("school/student")
public class StudentController {
	
	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	 @PostMapping(path = "register", consumes=MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<String> registerStudent(@RequestBody Map<String,String> map){
		  Student student = new Student();
		  student.setRollno(Integer.parseInt(map.get("rollno")));
		  student.setName(map.get("name"));
		  student.setAge(Integer.parseInt(map.get("age")));
		  student.setGender(map.get("gender"));
		  student.setGrade(map.get("grade"));
		  student.setSection(map.get("section"));
		  student.setContactno(map.get("contactno"));
		  student.setAddress(map.get("address"));
		  try
		  {	  
		  studentService.registerStudent(student);
		  return ResponseEntity.ok("register successfully");
		  }
		  catch(RuntimeException rex)
		  {
			  System.out.println(rex);
			  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(rex.getMessage());
		  }
	 
	 }
	 @PostMapping(path = "updateName", consumes=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> updateName(@RequestBody Map<String,String> map){
		Student student = new Student();
		student.setRollno(Integer.parseInt(map.get("rollno")));
		student.setName(map.get("name"));
		try
		  {	  
		  studentService.updateName(student.getName(),student.getRollno());
		  return ResponseEntity.ok("updatename successfully");
		  }
		  catch(RuntimeException rex)
		  {
			  System.out.println(rex);
			  return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(rex.getMessage());
		  }
	 }
	 @PostMapping(path = "updateContactNo", consumes=MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<String> updateContactNo(@RequestBody Map<String,String> map){
	   Student student = new Student();
	 student.setContactno(map.get("contactno"));
	 student.setRollno(Integer.parseInt(map.get("rollno")));
	 try
	 {
		 studentService.updateContactNo(student.getContactno(),student.getRollno());
		 return ResponseEntity.ok("updatecontactno successfully");
	 }
	 catch(RuntimeException rex)
	 {
		 System.out.println(rex);
		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(rex.getMessage());
	 }
}
	 @PostMapping(path = "updateAddress", consumes=MediaType.APPLICATION_JSON_VALUE)
	 public ResponseEntity<String> updateAddresss(@RequestBody Map<String,String> map){
	   Student student = new Student();
	 student.setAddress(map.get("address"));
	 student.setRollno(Integer.parseInt(map.get("rollno")));
	 try
	 {
		 studentService.updateAddress(student.getAddress(),student.getRollno());
		 return ResponseEntity.ok("updateaddress successfully");
	 }
	 catch(RuntimeException rex)
	 {
		 System.out.println(rex);
		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(rex.getMessage());
	 }
}
	 @PostMapping(path = "delete", consumes = org.springframework.http.MediaType.APPLICATION_JSON_VALUE)
		public String deleteStudent(@RequestBody Map<String, String> map)
		{
			Student student = new Student();
			student.setRollno(Integer.parseInt(map.get("rollno")));
			
			if(studentService.deleteStudent(student.getRollno())==1)
				return "Deleted Student successfully"; 
			else
				return "Something Went Wrong";
		}
		
}