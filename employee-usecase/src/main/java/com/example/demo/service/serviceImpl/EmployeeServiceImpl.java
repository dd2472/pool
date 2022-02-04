package com.example.demo.service.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ActivityDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Activity;
import com.example.demo.entity.Employee;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.service.EmployeeService;
@Service
public class EmployeeServiceImpl implements EmployeeService {
@Autowired
	EmployeeRepository employeeRepository;

@Override
public String addEmployee(EmployeeDto employee) {
	Employee empObject = new Employee();
	
	 empObject.setEmployeeCode(employee.getEmployeeCode());
    empObject.setEmployeeName(employee.getEmployeeName());
   empObject.setJobtitle(employee.getJobtitle());
    empObject.setEmailId(employee.getEmailId());
    empObject.setExperience(employee.getExperience());
    empObject.setPhoneNumber(employee.getPhoneNumber());
    empObject.setLocation(employee.getLocation());
    empObject.setProjectStatus(employee.getProjectStatus());
    
    employeeRepository.save(empObject);
    return "Employee Details Added successfully---";
    }

@Override
public List <EmployeeDto> viewEmployees(){
	return employeeRepository.findAll().stream().map(emp->{
		EmployeeDto dto = new EmployeeDto();
		
		
		dto.setEmployeeCode(emp.getEmployeeCode());
		dto.setEmployeeName(emp.getEmployeeName());
		dto.setJobtitle(emp.getJobtitle());
		dto.setEmailId(emp.getEmailId());
		dto.setExperience(emp.getExperience());
		dto.setPhoneNumber(emp.getPhoneNumber());
		dto.setLocation(emp.getLocation());
		dto.setProjectStatus(emp.getProjectStatus());
		
		return dto;
	}).toList();
}


public List <EmployeeDto > viewEmployeeById(Long id) {
	
return employeeRepository.findById(id).stream().map(emp->{
	EmployeeDto dto=new EmployeeDto();
	dto.setEmployeeCode(emp.getEmployeeCode());
	dto.setEmployeeName(emp.getEmployeeName());
	dto.setJobtitle(emp.getJobtitle());
	dto.setEmailId(emp.getEmailId());
	dto.setExperience(emp.getExperience());
	dto.setPhoneNumber(emp.getPhoneNumber());
	dto.setLocation(emp.getLocation());
	dto.setProjectStatus(emp.getProjectStatus());
	return dto;
}).toList();	
}

@Override
public String updateEmployee(Long id,EmployeeDto empRequest) {
Employee empObj=employeeRepository.findById(id)
.orElseThrow(()->new EmployeeNotFoundException("Emloyee Not found with id -"+id));


empObj.setEmployeeCode(empRequest.getEmployeeCode());
empObj.setEmployeeName(empRequest.getEmployeeName());
empObj.setJobtitle(empRequest.getJobtitle());
empObj.setEmailId(empRequest.getEmailId());
empObj.setExperience(empRequest.getExperience());
empObj.setPhoneNumber(empRequest.getPhoneNumber());
empObj.setLocation(empRequest.getLocation());
empObj.setProjectStatus(empRequest.getProjectStatus());
employeeRepository.save(empObj);
return "employee updated successfully -"+empObj.getId();
}
 

public List <EmployeeDto> viewEmployeeByCode(Integer employeeCode){
return employeeRepository.findByEmployeeCode(employeeCode).stream().map(emp->{
	EmployeeDto dto = new EmployeeDto();
	
		dto.setEmployeeCode(emp.getEmployeeCode());
		dto.setEmployeeName(emp.getEmployeeName());
		dto.setJobtitle(emp.getJobtitle());
		dto.setEmailId(emp.getEmailId());
		dto.setExperience(emp.getExperience());
	    dto.setLocation(emp.getLocation());
    	dto.setProjectStatus(emp.getProjectStatus());
    	
		return dto;
	}).toList();
}


}




