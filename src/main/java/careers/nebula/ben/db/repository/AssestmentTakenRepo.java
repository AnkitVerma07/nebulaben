/**
 * 
 */
package careers.nebula.ben.db.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import careers.nebula.ben.db.enitity.Assestment;
import careers.nebula.ben.db.enitity.AssestmentTaken;
import careers.nebula.ben.db.enitity.Survey;
import careers.nebula.ben.db.enitity.SurveyTaken;
import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit Verma
 *
 */
public class AssestmentTakenRepo {
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	
	public void insertAssestmentTaken(AssestmentTaken assestmentData){
				session.beginTransaction();
				session.save(assestmentData);
				session.getTransaction().commit();
				session.close();
				session.getSessionFactory().close();
			   }
	
	public void insertAssestmentTaken(AssestmentTaken assestmentTakenData, User userData, Assestment assestmentData){
		session.beginTransaction();
		session.save(assestmentTakenData);
		session.merge(assestmentData);
		session.merge(assestmentTakenData);		
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }

	public void updateAssestmentTakenById(AssestmentTaken assestmentData){
		session.beginTransaction();
		session.merge(assestmentData);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public AssestmentTaken getAssestmentTakenById(int assestmentId){
		AssestmentTaken assestmentData = new AssestmentTaken();
				session = sessionFactory.openSession();
				session.beginTransaction();
				assestmentData = (AssestmentTaken)session.get(AssestmentTaken.class, assestmentId);
				session.close();
				session.getSessionFactory().close();
				return assestmentData;
	}
}
