package com.fs.jsf.training.mb;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.fs.jsf.training.dao.EmployeeDAO;
import com.fs.jsf.training.entities.HrEmp;

@ManagedBean(name = "mbEmployee")
@ViewScoped
public class MBEmployee {
	private EmployeeDAO dao = new EmployeeDAO();
	private HrEmp emp = new HrEmp();
	private List<HrEmp> allEmp=new ArrayList();
	

	public List<HrEmp> getAllEmp() {
		allEmp=dao.getAll();
		return allEmp;
	}

	public String reset() {
		emp = new HrEmp();
		return null;
	}

	public String find() {
		emp = dao.find(emp.getEmpId());
		return null;
	}

	public String add() {
		dao.add(emp);
		reset();
		return null;
	}

	public HrEmp getEmp() {
		return emp;
	}

	public void setEmp(HrEmp emp) {
		this.emp = emp;
	}

}
