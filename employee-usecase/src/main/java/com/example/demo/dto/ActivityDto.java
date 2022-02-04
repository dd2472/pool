package com.example.demo.dto;

import java.time.LocalDate;



import com.fasterxml.jackson.annotation.JsonFormat;

public class ActivityDto {
	
	private String employeeName;
	private String employeeCode;

	@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate startDate;
	
@JsonFormat(pattern = "dd-MM-yyyy")
	private LocalDate endDate;

	private String activityDescription;
	private String activityStatus;
	
	public ActivityDto() {
		
	}
	public ActivityDto(String employeeName, String employeeCode, LocalDate startDate, LocalDate endDate,
			String activityDescription, String activityStatus) {
		super();
		this.employeeName = employeeName;
		this.employeeCode = employeeCode;
		this.startDate = startDate;
		this.endDate = endDate;
		this.activityDescription = activityDescription;
		this.activityStatus = activityStatus;
	}

	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(String employeeCode) {
		this.employeeCode = employeeCode;
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
		return "ActivityDto [employeeName=" + employeeName + ", employeeCode=" + employeeCode + ", startDate="
				+ startDate + ", endDate=" + endDate + ", activityDescription=" + activityDescription
				+ ", activityStatus=" + activityStatus + "]";
	}
	
	
	

}
