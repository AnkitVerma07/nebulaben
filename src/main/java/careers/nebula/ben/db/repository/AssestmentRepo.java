/**
 * 
 */
package careers.nebula.ben.db.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import careers.nebula.ben.db.enitity.Assestment;
import careers.nebula.ben.db.enitity.Survey;

/**
 * @author Ankit Verma
 *
 */
public class AssestmentRepo {

	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	
	public void insertAssestment(Assestment assestmentData){
				session.beginTransaction();
				session.save(assestmentData);
				session.getTransaction().commit();
				session.close();
				session.getSessionFactory().close();
			   }

	public void updateAssestmentById(Assestment assestmentData){
		session.beginTransaction();
		session.merge(assestmentData);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public Assestment getassestmentById(int assestmentId){
		Assestment assestmentData = new Assestment();
				session = sessionFactory.openSession();
				session.beginTransaction();
				assestmentData = (Assestment)session.get(Assestment.class, assestmentId);
				session.close();
				session.getSessionFactory().close();
				return assestmentData;
	}
	
	
}
