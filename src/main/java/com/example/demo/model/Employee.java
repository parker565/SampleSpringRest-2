package com.example.demo.model;

import javax.xml.bind.annotation.XmlRootElement;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "All details about the Employee. ")
@XmlRootElement
public class Employee {

    @ApiModelProperty(notes = "Employee ID")
	private String empNo;
    
    @ApiModelProperty(notes = "Employee Name")
	private String empName;

    @ApiModelProperty(notes = "Employee Position")
	private String position;
    
    @ApiModelProperty(notes = "Employee Phone Number")
    private String empPhone;
    
    @ApiModelProperty(notes = "Employee email")
    private String empEmail;
	
	public Employee(String empNo, String empName, String position, String empPhone, String empEmail) {
		this.empNo = empNo;
		this.empName = empName;
		this.position = position;
		this.empPhone = empPhone;
		this.empEmail = empEmail;
	}

	public String getEmpNo() {
		return empNo;
	}

	public void setEmpNo(String empNo) {
		this.empNo = empNo;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getEmpPhone() {
		return empPhone;
	}

	public void setEmpPhone(String empPhone) {
		this.empPhone = empPhone;
	}

	public String getEmpEmail() {
		return empEmail;
	}

	public void setEmpEmail(String empEmail) {
		this.empEmail = empEmail;
	}

	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + ", position=" + position + ", empPhone=" + empPhone
				+ ", empEmail=" + empEmail + "]";
	}
	
	
}
