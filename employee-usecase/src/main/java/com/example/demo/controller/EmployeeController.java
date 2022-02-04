package com.example.demo.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.service.EmployeeService;

@RestController
@RequestMapping("/employee")

public class EmployeeController {
    @Autowired
	EmployeeService employeeService;
    
	@PostMapping("/add")
	public ResponseEntity<String> addEmployee(@RequestBody @Valid EmployeeDto empRequest) {
		employeeService.addEmployee(empRequest);
		return new ResponseEntity<String>("Employee added "+empRequest, HttpStatus.CREATED);
		
       // return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.addEmployee(empRequest));   
    }
	
@GetMapping("/")
public ResponseEntity<List<EmployeeDto>> viewEmployees(){
	return ResponseEntity.status(HttpStatus.OK).body(employeeService.viewEmployees()); 
}

@GetMapping("/view/{id}")
public ResponseEntity<List<EmployeeDto>> viewEmployeeById(@PathVariable Long id){
	return ResponseEntity.status(HttpStatus.OK).body(employeeService.viewEmployeeById(id));
}

@PutMapping(value="/update/{id}")
public ResponseEntity<String> updateEmployee(@PathVariable Long id,@RequestBody @Valid EmployeeDto empRequest){
String message=employeeService.updateEmployee(id,empRequest);
return ResponseEntity.status(HttpStatus.OK).body(message);
}

@GetMapping("/viewByCode/{employeeCode}")
public ResponseEntity<List<EmployeeDto>> viewEmployeeByCode(@PathVariable int employeeCode){
	return ResponseEntity.status(HttpStatus.OK).body(employeeService.viewEmployeeByCode(employeeCode));
}


}

