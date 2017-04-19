 /**
 * 
 */
package careers.nebula.ben.db.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import careers.nebula.ben.db.enitity.Highschool;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.pojos.UserHighschoolPojo;

/**
 * @author Ankit_Nebula
 *
 */
public class HighSchoolRepo {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	User userEntity;
	Highschool highschoolEntity;
	
	public void InsertHighschoolData(UserHighschoolPojo combinedPojo){
		userEntity = combinedPojo.getUser();
		highschoolEntity = combinedPojo.getHighschool();
		session.beginTransaction();			
		session.save(highschoolEntity);
		session.merge(userEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }
	
	public Highschool getHighschoolData(int id){
		highschoolEntity = new Highschool();
		session = sessionFactory.openSession();
		session.beginTransaction();
		highschoolEntity = (Highschool)session.get(Highschool.class, id);
		session.close();
		session.getSessionFactory().close();
		return highschoolEntity;
}
	
	public void updateHighschoolData(Highschool highschooldata){
		session.beginTransaction();
		session.merge(highschooldata);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
}
