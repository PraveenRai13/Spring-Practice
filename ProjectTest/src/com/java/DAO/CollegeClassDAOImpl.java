package com.java.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java.persistance.CollegeClass;

import hibernateUtil.HibernateUtil;

public class CollegeClassDAOImpl implements CollegeClassDAO {
	SessionFactory sessionFactoryObj=HibernateUtil.getSessionFactory();
	Session sessionObj;
	

	@Override
	public int addCollegeClass(CollegeClass collegeClass) {
		try{
			sessionObj=sessionFactoryObj.openSession();
			sessionObj.getTransaction().begin();
			sessionObj.saveOrUpdate(collegeClass);
			sessionObj.getTransaction().commit();
		}
		catch(Exception ex) {
			if(sessionObj.getTransaction()!=null) {
				sessionObj.getTransaction().rollback();
			}ex.printStackTrace();
			return 0;
		}
		finally {
			sessionObj.close();
		}
		return 1;
	}

	@Override
	public List<CollegeClass> getCollegeClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CollegeClass getCollegeClasses(int classId) {
		sessionObj=sessionFactoryObj.openSession();
		sessionObj.getTransaction().begin();
		CollegeClass collegeClass=(CollegeClass) sessionObj.get(CollegeClass.class, classId);
		return collegeClass;
	}

	@Override
	public void deleteCollegeClass(int classId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateCollegeClass(int classId) {
		// TODO Auto-generated method stub
		
	}

}
