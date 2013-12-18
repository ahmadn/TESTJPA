package com.fs.jsf.training.entities;

import java.io.Serializable;

import javax.persistence.*;


/**
 * The persistent class for the hr_emp database table.
 * 
 */
@Entity
@Table(name="hr_emp")
public class HrEmp {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="emp_id")
	private int empId;

	@Column(name="emp_name")
	private String empName;

	@Column(name="emp_salary")
	private double empSalary;

	//bi-directional many-to-one association to HrDpt
	@ManyToOne
	@JoinColumn(name="emp_dpt_id")
	private HrDpt hrDpt;

	public HrEmp() {
	}

	public int getEmpId() {
		return this.empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return this.empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public double getEmpSalary() {
		return this.empSalary;
	}

	public void setEmpSalary(double empSalary) {
		this.empSalary = empSalary;
	}

	public HrDpt getHrDpt() {
		return this.hrDpt;
	}

	public void setHrDpt(HrDpt hrDpt) {
		
		this.hrDpt = hrDpt;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return "id= "+ empId+ " name= "+empName + " salary="+empSalary;
	}


}