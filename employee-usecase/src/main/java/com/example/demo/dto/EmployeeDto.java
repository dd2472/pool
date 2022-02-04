package com.example.demo.dto;

//import javax.validation.constraints.Email;

public class EmployeeDto {
	private int employeeCode;
    private String employeeName;
    private String jobtitle;
  //  @Email(message = "Email is invaid..please try with valid email address")
    private String emailId;
    private Integer experience;
    private Long phoneNumber;
    private String location;
    private String projectStatus;
    
    public EmployeeDto() {
    	super();
    }
	 
	    public EmployeeDto(int employeeCode, String employeeName, String jobtitle, String emailId, Integer experience,
			Long phoneNumber, String location, String projectStatus) {
		super();
		this.employeeCode = employeeCode;
		this.employeeName = employeeName;
		this.jobtitle = jobtitle;
		this.emailId = emailId;
		this.experience = experience;
		this.phoneNumber = phoneNumber;
		this.location = location;
		this.projectStatus = projectStatus;
	}
		
		public int getEmployeeCode() {
			return employeeCode;
		}
		public void setEmployeeCode(int employeeCode) {
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
			return "EmployeeDto [employeeCode=" + employeeCode + ", employeeName=" + employeeName + ", jobtitle="
					+ jobtitle + ", emailId=" + emailId + ", experience=" + experience + ", phoneNumber=" + phoneNumber
					+ ", location=" + location + ", projectStatus=" + projectStatus + "]";
		}
}
