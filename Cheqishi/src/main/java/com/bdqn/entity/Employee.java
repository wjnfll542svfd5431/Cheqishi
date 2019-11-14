package com.bdqn.entity;

/**
 * 员工实体类
 * @author 王江南
 *
 */
public class Employee {
	 private int employeeId;//员工编号
	 private String employeeName;//员工名称
	 private String employeeSex;//员工性别
	 private String employeePhone;//员工电话
	 private String employeeDate;//时间
	 private double employeeBassalary;//底薪
	 private String employeeState;//状态
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getEmployeeName() {
		return employeeName;
	}
	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}
	public String getEmployeeSex() {
		return employeeSex;
	}
	public void setEmployeeSex(String employeeSex) {
		this.employeeSex = employeeSex;
	}
	public String getEmployeePhone() {
		return employeePhone;
	}
	public void setEmployeePhone(String employeePhone) {
		this.employeePhone = employeePhone;
	}
	public String getEmployeeDate() {
		return employeeDate;
	}
	public void setEmployeeDate(String employeeDate) {
		this.employeeDate = employeeDate;
	}
	public double getEmployeeBassalary() {
		return employeeBassalary;
	}
	public void setEmployeeBassalary(double employeeBassalary) {
		this.employeeBassalary = employeeBassalary;
	}
	public String getEmployeeState() {
		return employeeState;
	}
	public void setEmployeeState(String employeeState) {
		this.employeeState = employeeState;
	}
}
