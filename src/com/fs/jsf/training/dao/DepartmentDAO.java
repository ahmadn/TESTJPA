package com.fs.jsf.training.dao;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.fs.jsf.training.entities.HrDpt;
import com.fs.jsf.training.entities.HrDpt;

public class DepartmentDAO {
	
	
	public static void main(String[] args) {
		DepartmentDAO dao = new DepartmentDAO();
//		dao.update(new Employee(2, "ataaa", 50));
//Employee find = dao.find(1);
//System.out.println(find.getName());
		List all = dao.getAll();
		System.out.println(all);
		System.out.println("added");
	}
	public List<HrDpt> getAll() {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("unit1");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		String qlString = "select emp from HrDpt emp";
		Query result = em.createQuery(qlString);
		List<HrDpt> resultList = result.getResultList();
		em.getTransaction().commit();
		em.close();
		return resultList;
	}

	public void update(HrDpt e) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("unit1");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.merge(e);
		em.getTransaction().commit();
		em.close();
	}

	public void delete(HrDpt e) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("unit1");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.remove(e);
		em.getTransaction().commit();
		em.close();
	}

	public void add(HrDpt e) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("unit1");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		em.persist(e);
		em.getTransaction().commit();
		em.close();
	}

	public HrDpt find(int empId) {
		EntityManagerFactory emf = Persistence
				.createEntityManagerFactory("unit1");
		EntityManager em = emf.createEntityManager();
		em.getTransaction().begin();
		HrDpt e = em.find(HrDpt.class, empId);
		em.getTransaction().commit();
		em.close();
		return e;
	}


}
