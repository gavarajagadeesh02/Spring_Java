package com.example.project.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.project.model.EmployeeAttendence;

@Repository
public interface EmployeeAttendenceRepository  extends CrudRepository<EmployeeAttendence, Integer>{
	@Query("update EmployeeAttendence e set e.logoutTime=?1 where e.empId=?2 and e.entryDate=?3")
	@Transactional
	@Modifying
	int updateLogoutTime(String logoutTime,int empId, String entryDate);

   @Query("delete from EmployeeAttendence e  where e.empId=?1")
   @Transactional
   @Modifying
   int  delete(int empId);
   }


