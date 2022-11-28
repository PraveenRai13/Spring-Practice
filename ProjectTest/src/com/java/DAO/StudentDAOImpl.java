package com.java.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.java.persistance.Student;

import hibernateUtil.HibernateUtil;

public class StudentDAOImpl implements StudentDAO {
	SessionFactory sessionFactoryObj=HibernateUtil.getSessionFactory();
	Session sessionObj;

	@Override
	public int addStudent(Student student) {
		try{
			sessionObj=sessionFactoryObj.openSession();
			sessionObj.getTransaction().begin();
			sessionObj.saveOrUpdate(student);
			
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
	public List<Student> getCollegeClass() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getStudent(int studentId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudent(int studentId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStudent(int studentId) {
		// TODO Auto-generated method stub
		
	}

}
