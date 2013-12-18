package com.fs.jsf.training.mb;

import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

import com.fs.jsf.training.dao.DepartmentDAO;
import com.fs.jsf.training.entities.HrDpt;

@ManagedBean
@ViewScoped
public class MBDepartment {
	private DepartmentDAO dao = new DepartmentDAO();
	private HrDpt dpt=new HrDpt();
	private List<HrDpt> alldpt;

	public String find(){
		dpt=dao.find(dpt.getDptId());
		return null;
	}
	
	
	public String reset(){
		dpt=new HrDpt();
		return null;
	}
	public String save(){
		System.out.println(dpt.getDptName());
		dao.update(dpt);
		dpt=new HrDpt();
		return null;
	}
	
	
	
	public DepartmentDAO getDao() {
		return dao;
	}



	public List<HrDpt> getAlldpt() {
		alldpt = dao.getAll();
		return alldpt;
	}

	public HrDpt getDpt() {
		return dpt;
	}

	public void setDpt(HrDpt dpt) {
		System.out.println(dpt);
		this.dpt = dpt;
	}

}
