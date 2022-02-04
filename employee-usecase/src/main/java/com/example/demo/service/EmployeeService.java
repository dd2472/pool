package com.example.demo.service;

import java.util.List;

import javax.validation.Valid;

import com.example.demo.dto.EmployeeDto;

public interface EmployeeService {
	
public String addEmployee(EmployeeDto employee);

public List<EmployeeDto> viewEmployees();



public List <EmployeeDto> viewEmployeeById(Long id);

public String updateEmployee(Long id,EmployeeDto empRequest);

public List<EmployeeDto> viewEmployeeByCode(Integer employeeCode);







}