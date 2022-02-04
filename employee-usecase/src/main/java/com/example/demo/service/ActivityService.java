package com.example.demo.service;

import java.time.LocalDate;
import java.util.List;

import javax.validation.Valid;

import com.example.demo.dto.ActivityDto;
import com.example.demo.entity.Activity;

public interface ActivityService {

public String addActivity(ActivityDto activity) ;

public List<ActivityDto> getActivityByEmployeeName(String employeeName);

public String editActivity(Long id, ActivityDto actRequest);

public List<ActivityDto> viewwithDate(LocalDate startDate);

public List<ActivityDto> getAllBtwnDates(LocalDate startDate, LocalDate endDate);

public List<ActivityDto> getAllActivitiesStartBetween(String employeeName, LocalDate startDate, LocalDate endDate);



}
