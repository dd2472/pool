package com.example.demo.repository;

import java.time.LocalDate;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


import com.example.demo.entity.Activity;

@Repository
public interface ActivityRepository extends JpaRepository<Activity,Long> {

	List<Activity> findByEmployeeName(String employeeName);


	List<Activity> findByStartDate(LocalDate startDate);
	
	List<Activity> findAllByStartDateBetween(LocalDate startDate, LocalDate endDate);


	List<Activity> findAllByEmployeeNameAndStartDateBetween(String employeeName,LocalDate startDate, LocalDate endDate);
}
