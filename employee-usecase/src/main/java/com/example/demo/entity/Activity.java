package com.example.demo.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.fasterxml.jackson.annotation.JsonFormat;

@Entity
public class Activity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private  Long id;
	
	private String employeeCode;
	private String employeeName;
	private LocalDate startDate ;
	private LocalDate endDate;
	private String activityDescription;
	private String activityStatus;
	
	public Activity() {
		
	}
	public Activity(Long id, String employeeCode, String employeeName, LocalDate startDate, LocalDate endDate,
			String activityDescription, String activityStatus) {
		this.id = id;
		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
		this.startDate = startDate;
		this.endDate = endDate;
		this.activityDescription = activityDescription;
		this.activityStatus = activityStatus;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public LocalDate getStartDate() {
		return startDate;
	}
	public void setStartDate(LocalDate startDate) {
		this.startDate = startDate;
	}
	public LocalDate getEndDate() {
		return endDate;
	}
	public void setEndDate(LocalDate endDate) {
		this.endDate = endDate;
	}
	public String getActivityDescription() {
		return activityDescription;
	}
	public void setActivityDescription(String activityDescription) {
		this.activityDescription = activityDescription;
	}
	public String getActivityStatus() {
		return activityStatus;
	}
	public void setActivityStatus(String activityStatus) {
		this.activityStatus = activityStatus;
	}
	@Override
	public String toString() {
		return "Activity [id=" + id + ", employeeCode=" + employeeCode + ", employeeName=" + employeeName
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", activityDescription=" + activityDescription
				+ ", activityStatus=" + activityStatus + "]";
	}
	
	
	
	
}
