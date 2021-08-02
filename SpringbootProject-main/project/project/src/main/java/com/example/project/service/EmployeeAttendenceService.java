package com.example.project.service;

import org.springframework.stereotype.Service;

import com.example.project.model.EmployeeAttendence;
import com.example.project.repository.EmployeeAttendenceRepository;


@Service
public class EmployeeAttendenceService {
	
	private final EmployeeAttendenceRepository employeeAttendenceRepository;
	
	public EmployeeAttendenceService(EmployeeAttendenceRepository employeeAttendenceRepository) {
		super();
		this.employeeAttendenceRepository = employeeAttendenceRepository;
	}

	public void login(EmployeeAttendence employeeAttendence) {
		
		System.out.println("empId:" + employeeAttendence.getEmpId()+"\n logintime : "+ employeeAttendence.getLoginTime());	
		employeeAttendenceRepository.save(employeeAttendence);
	}
	
	public void logout(EmployeeAttendence employeeAttendence) throws RuntimeException  {
		
		System.out.println("empId:" + employeeAttendence.getEmpId()+"\n logouttime : "+ employeeAttendence.getLogoutTime());	
		employeeAttendenceRepository.updateLogoutTime( employeeAttendence.getLogoutTime(),employeeAttendence.getEmpId(),employeeAttendence.getEntryDate());
	}
	public void delete(int empId) {
		
		employeeAttendenceRepository.delete(empId);
	}

}
