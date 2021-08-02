package com.example.project.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class EmployeeAttendence {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY )
	@Column
	private int attendenceId;
	
	
	@Column
	private int empId;
	@Column
	private String entryDate;
	public String getEntryDate() {
		return entryDate;
	}
	public void setEntryDate(String entryDate) {
		this.entryDate = entryDate;
	}
	@Column
	private String loginTime;
	@Column
	private String logoutTime;
	
	public int getAttendenceId() {
		return attendenceId;
	}
	public void setAttendenceId(int attendenceId) {
		this.attendenceId = attendenceId;
	}
	public int getEmpId() {
		return empId;
	}
	public void setEmpId(int empId) {
		this.empId = empId;
	}
	public String getLoginTime() {
		return loginTime;
	}
	public void setLoginTime(String loginTime) {
		this.loginTime = loginTime;
	}
	public String getLogoutTime() {
		return logoutTime;
	}
	public void setLogoutTime(String logoutTime) {
		this.logoutTime = logoutTime;
	}
	public EmployeeAttendence() {
		this.attendenceId = 0;
		this.empId = 0;
		this.entryDate=null;
		this.loginTime = null;
		this.logoutTime = null;
		
	}
	public EmployeeAttendence(int attendenceId, int empId, String entryDate, String loginTime, String logoutTime) {
		super();
		this.attendenceId = attendenceId;
		this.empId = empId;
		this.entryDate=entryDate;
		this.loginTime = loginTime;
		this.logoutTime = logoutTime;
	}
		

}
