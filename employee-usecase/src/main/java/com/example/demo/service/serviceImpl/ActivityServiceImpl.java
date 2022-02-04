package com.example.demo.service.serviceImpl;



import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.dto.ActivityDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.entity.Activity;
import com.example.demo.entity.Employee;
import com.example.demo.exceptions.EmployeeNotFoundException;
import com.example.demo.repository.ActivityRepository;
import com.example.demo.service.ActivityService;
@Service
public class ActivityServiceImpl  implements ActivityService {
	
	@Autowired
	private ActivityRepository activityRepository;



	@Override
	public String addActivity(ActivityDto activity) {
	Activity activityObject=new Activity();
	
	activityObject.setEmployeeName(activity.getEmployeeName());
	activityObject.setEmployeeCode(activity.getEmployeeCode());
	activityObject.setStartDate(activity.getStartDate());
	activityObject.setEndDate(activity.getEndDate());
	activityObject.setActivityDescription(activity.getActivityDescription());
    activityObject.setActivityStatus(activity.getActivityStatus());
    
	activityRepository.save(activityObject);
	return "New Daily Activity is added";
	}

	@Override
	public List<ActivityDto> getActivityByEmployeeName(String employeeName) {
	return activityRepository.findByEmployeeName(employeeName).stream().map(activity -> {
	ActivityDto dto = new ActivityDto();

	dto.setEmployeeCode(activity.getEmployeeCode());
	dto.setEmployeeName(activity.getEmployeeName());
	dto.setStartDate(activity.getStartDate());
	dto.setEndDate(activity.getEndDate());
	dto.setActivityDescription(activity.getActivityDescription());
	dto.setActivityStatus(activity.getActivityStatus());
	return dto;
	}).toList();
	}
	
	
	@Override
	public String editActivity(Long id, ActivityDto actRequest) {
	Activity actObj = activityRepository.findById(id).orElseThrow(()->new EmployeeNotFoundException("Activity not found with id - "+id));
	
	actObj.setEmployeeCode(actRequest.getEmployeeCode());
	actObj.setEmployeeName(actRequest.getEmployeeName());
	actObj.setActivityDescription(actRequest.getActivityDescription());
	actObj.setActivityStatus(actRequest.getActivityStatus());
	actObj.setStartDate(actRequest.getStartDate());
	
	activityRepository.save(actObj);
	return "employee updated successfully ";
}
	
	@Override
	public List<ActivityDto> viewwithDate(LocalDate startDate) {
	System.out.println("entering view with date impl"+startDate);
		return activityRepository.findByStartDate(startDate).stream().map(act->{
			ActivityDto dto=new ActivityDto();
			
			dto.setEmployeeCode(act.getEmployeeCode());
			dto.setEmployeeName(act.getEmployeeCode());
			dto.setActivityDescription(act.getActivityDescription());
			dto.setActivityStatus(act.getActivityStatus());
			dto.setEndDate(act.getEndDate());
		return dto;
	}).toList();
	}
	
	@Override
	public List<ActivityDto> getAllBtwnDates(LocalDate startDate, LocalDate endDate) {

	return activityRepository.findAllByStartDateBetween(startDate,endDate).stream().map(activity -> {
	ActivityDto dto=new ActivityDto();
	
	dto.setEmployeeName(activity.getEmployeeName());
	dto.setEmployeeCode(activity.getEmployeeCode());
	dto.setActivityDescription(activity.getActivityDescription());
	dto.setActivityStatus(activity.getActivityStatus());
	return dto;
	}).toList();
	}
	
	@Override
	public List<ActivityDto> getAllActivitiesStartBetween(String employeeName,LocalDate startDate,LocalDate endDate){
		
		return activityRepository.findAllByEmployeeNameAndStartDateBetween(employeeName,startDate,endDate).stream().map(activity -> {
			ActivityDto dto=new ActivityDto();
			
			dto.setEmployeeName(activity.getEmployeeName());
			dto.setEmployeeCode(activity.getEmployeeCode());
			dto.setActivityDescription(activity.getActivityDescription());
			dto.setActivityStatus(activity.getActivityStatus());
			return dto;
			}).toList();	
	}
}
