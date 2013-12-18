package com.fs.jsf.training.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import javax.persistence.Query;

import com.fs.jsf.training.entities.HrEmp;

public class EmployeeDAO {
	
	
	public static void main(String[] args) {
		EmployeeDAO dao = new EmployeeDAO();
//		dao.update(new Employee(2, "ataaa", 50));
//Employee find = dao.find(1);
//System.out.println(find.getName());
		List all = dao.getAll();
		System.out.println(all);
		System.out.println("added");
	}
	public List getAll() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("unit1");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		String qlString = "select emp from HrEmp emp";
		Query result = em.createQuery(qlString);
		List resultList = result.getResultList();
		em.getTransaction().commit();
		em.close();
		return resultList;
	}

	public void update(HrEmp e) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("unit1");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
		em.close();
	}

	public void delete(HrEmp e) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("unit1");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		em.close();
	}

	public void add(HrEmp e) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("unit1");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}

	public HrEmp find(int empId) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("unit1");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		HrEmp e = em.find(HrEmp.class, empId);
		em.getTransaction().commit();
		em.close();
		return e;
	}


}
