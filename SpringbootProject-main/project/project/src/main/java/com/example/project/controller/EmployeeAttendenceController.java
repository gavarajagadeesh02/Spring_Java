package com.example.project.controller;

import java.sql.Time;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.project.model.EmployeeAttendence;
import com.example.project.service.EmployeeAttendenceService;

@RestController
@RequestMapping("school/employeeattendence")
public class EmployeeAttendenceController {
	
	private final EmployeeAttendenceService employeeAttendenceService;

	public EmployeeAttendenceController(EmployeeAttendenceService employeeAttendenceService) {
		super();
		this.employeeAttendenceService = employeeAttendenceService;
	}
 @PostMapping(path = "login", consumes=MediaType.APPLICATION_JSON_VALUE)
 public ResponseEntity<String>  login(@RequestBody EmployeeAttendence employeeAttendence)
 {
	 Time time = new Time(System.currentTimeMillis());
	 employeeAttendence.setLoginTime(String.valueOf(time));
	 employeeAttendenceService.login(employeeAttendence);
     return ResponseEntity.ok("login successfully");
 }
 @PostMapping(path = "logout", consumes=MediaType.APPLICATION_JSON_VALUE)
 public ResponseEntity<String>  logout(@RequestBody EmployeeAttendence employeeAttendence)
 {
	 Time time = new Time(System.currentTimeMillis());
	 employeeAttendence.setLogoutTime(String.valueOf(time));
	 try
	 {
	 employeeAttendenceService.logout(employeeAttendence);
     return ResponseEntity.ok("logout successfully");
	 }
	 catch(RuntimeException rex)
	 {
		 System.out.println(rex);
		 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(rex.getMessage());
	 }
 }
 @GetMapping(path = "delete", consumes=MediaType.APPLICATION_JSON_VALUE)
 public ResponseEntity<String>  delete(@RequestParam int empId )	
 {
     employeeAttendenceService.delete(empId);
     return ResponseEntity.ok("delete successfully");	 
		 
 }
}
	 
 
