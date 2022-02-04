package com.example.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Employee {
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer employeeCode;
    private String employeeName;
    private String jobtitle;
    private String emailId;
    private Integer experience;
    private Long phoneNumber;
    private String location;
    private String projectStatus;
    
    public Employee() {
    	
    }

	public Employee(Long id, Integer employeeCode, String employeeName, String jobtitle, String emailId,
			Integer experience, Long phoneNumber, String location, String projectStatus) {
		
		this.id = id;
		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
		this.jobtitle = jobtitle;
		this.emailId = emailId;
		this.experience = experience;
		this.phoneNumber = phoneNumber;
		this.location = location;
		this.projectStatus = projectStatus;
	}
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		id = id;
	}
	public Integer getEmployeeCode() {
		return employeeCode;
	}
	public void setEmployeeCode(Integer employeeCode) {
		this.employeeCode = employeeCode;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getJobtitle() {
		return jobtitle;
	}
	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}
	public String getEmailId() {
		return emailId;
	}
	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	public Integer getExperience() {
		return experience;
	}
	public void setExperience(Integer experience) {
		this.experience = experience;
	}
	public Long getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(Long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public String getProjectStatus() {
		return projectStatus;
	}
	public void setProjectStatus(String projectStatus) {
		this.projectStatus = projectStatus;
	}
	@Override
	public String toString() {
		return "Employee [Id=" + id + ", employeeCode=" + employeeCode + ", employeeName=" + employeeName
				+ ", jobtitle=" + jobtitle + ", emailId=" + emailId + ", experience=" + experience + ", phoneNumber="
				+ phoneNumber + ", location=" + location + ", projectStatus=" + projectStatus + "]";
	}

    
}
