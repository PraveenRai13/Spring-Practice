package hibernateUtil;

import org.hibernate.SessionFactory;
import org.hibernate.Session;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class HibernateUtil {
	private static SessionFactory sessionFactoryObj;
	//private static Session sessionObj;
	private static SessionFactory buildSessionFactory() {
		try {
		Configuration configObj=new Configuration();
		configObj.configure("hibernate.cfg.xml");
		ServiceRegistry serviceRegistry=new StandardServiceRegistryBuilder().applySettings(configObj.getProperties()).build();
		sessionFactoryObj =configObj.buildSessionFactory(serviceRegistry);
		return sessionFactoryObj;
		}
		catch(Throwable ex) {
			System.out.println("sessionfactory creation failed");
			ex.printStackTrace();
		}
		return sessionFactoryObj;
	}
	public static SessionFactory getSessionFactory() {
		if(sessionFactoryObj==null)
			sessionFactoryObj=buildSessionFactory();
		return sessionFactoryObj;
	}
	
}
