package com.example.demo.controller;

import java.time.LocalDate;
import java.util.List;
import org.slf4j.Logger;

import javax.validation.Valid;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
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

import com.example.demo.dto.ActivityDto;
import com.example.demo.entity.Activity;
import com.example.demo.service.ActivityService;

@RestController
@RequestMapping("/activity")

public class ActivityController {
Logger logger = LoggerFactory.getLogger(ActivityController.class);
	@Autowired
	private ActivityService activityService;

	@PostMapping("/add")
	public ResponseEntity<String> addActivity(@RequestBody @Valid  ActivityDto activityRequest) {
		//activityService.addActivity(activityRequest);
		//return new ResponseEntity<String>("Activity added "+activityRequest, HttpStatus.CREATED);
	return ResponseEntity.status(HttpStatus.CREATED).body(activityService.addActivity(activityRequest));

	}
	
	@GetMapping(value="/name", params={"employeeName"})
	public ResponseEntity<List<ActivityDto>> getActivityByEmployeeName(@RequestParam String employeeName){
	return ResponseEntity.status(HttpStatus.OK).body(activityService.getActivityByEmployeeName(employeeName));
	}
	
	@PatchMapping(value="/{id}")
	public ResponseEntity<String> editActivity(@PathVariable Long id, @RequestBody @Valid ActivityDto actRequest) {
	String message= activityService.editActivity(id,actRequest);
	return ResponseEntity.status(HttpStatus.OK).body(message);
	}
	
	@GetMapping(value="/date/",params={"startDate"})
	public ResponseEntity<List<ActivityDto>> viewwithDate(@RequestParam @DateTimeFormat(pattern="dd-MM-yyyy") LocalDate startDate){
		System.out.println("entering view with date method");
	return ResponseEntity.status(HttpStatus.OK).body(activityService.viewwithDate(startDate));
	}
	
	@GetMapping(value="/dates/", params= {"startDate","endDate"})
	public ResponseEntity<List<ActivityDto>> getAllBtwnDates(@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate startDate,
	@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate endDate) {
	if(startDate.isAfter(endDate)) {
	return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
	}
	return ResponseEntity.status(HttpStatus.OK).body(activityService.getAllBtwnDates(startDate,endDate));
	}

	@GetMapping(value="/namedate/",params= {"employeeName","startDate","endDate"})
	public ResponseEntity<List<ActivityDto>> getAllActivitiesStartBetween(
			@RequestParam String employeeName,@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate startDate,
			@RequestParam @DateTimeFormat(pattern="yyyy-MM-dd") LocalDate endDate){
		if(startDate.isAfter(endDate)) {
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
		}
		return ResponseEntity.status(HttpStatus.OK).body(activityService.getAllActivitiesStartBetween(employeeName,startDate,endDate));
		
	}
}


	

