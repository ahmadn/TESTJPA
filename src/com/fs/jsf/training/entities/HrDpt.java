package com.fs.jsf.training.entities;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;


/**
 * The persistent class for the hr_dpt database table.
 * 
 */
@Entity
@Table(name="hr_dpt")
@NamedQuery(name="HrDpt.findAll", query="SELECT h FROM HrDpt h")
public class HrDpt {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="dpt_id")
	private int dptId;

	@Column(name="dpt_name")
	private String dptName;

	//bi-directional many-to-one association to HrEmp
	@OneToMany(mappedBy="hrDpt")
	private List<HrEmp> hrEmps;
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return dptName;
	}

	public HrDpt() {
	}

	public int getDptId() {
		return this.dptId;
	}

	public void setDptId(int dptId) {
		this.dptId = dptId;
	}

	public String getDptName() {
		return this.dptName;
	}

	public void setDptName(String dptName) {
		this.dptName = dptName;
	}

	public List<HrEmp> getHrEmps() {
		return this.hrEmps;
	}

	public void setHrEmps(List<HrEmp> hrEmps) {
		this.hrEmps = hrEmps;
	}

	public HrEmp addHrEmp(HrEmp hrEmp) {
		getHrEmps().add(hrEmp);
		hrEmp.setHrDpt(this);

		return hrEmp;
	}

	public HrEmp removeHrEmp(HrEmp hrEmp) {
		getHrEmps().remove(hrEmp);
		hrEmp.setHrDpt(null);

		return hrEmp;
	}

}