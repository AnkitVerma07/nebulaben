/**
 * 
 */
package careers.nebula.ben.db.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import careers.nebula.ben.db.enitity.Companies;
import careers.nebula.ben.db.enitity.Experiences;
import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit_Nebula
 *
 */
public class ExperienceRepo {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	User userEntity;
	Experiences expEntity;
	Companies compEntity;
	
	public void InsertUserExperience(User userEntity, Experiences expEntity){
		session.beginTransaction();			
		session.save(expEntity);
		session.merge(userEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }
	
	public Experiences getExperienceData(int id){
		expEntity = new Experiences();
		session = sessionFactory.openSession();
		session.beginTransaction();
		expEntity = (Experiences)session.get(Experiences.class, id);
		session.close();
		session.getSessionFactory().close();
		return expEntity;
}
	
	public void updateExperienceData(Experiences expEntity){
		session.beginTransaction();
		session.merge(expEntity);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public void InsertUsrExpCompData(Experiences expEntity, Companies compEntity){
		session.beginTransaction();			
		session.save(compEntity);
		session.merge(expEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }
	
	public Companies getCompanyData(int id){
		compEntity = new Companies();
		session = sessionFactory.openSession();
		session.beginTransaction();
		compEntity = (Companies)session.get(Companies.class, id);
		session.close();
		session.getSessionFactory().close();
		return compEntity;
}
	
	public void updateCompanyData(Companies compEntity){
		session.beginTransaction();
		session.merge(compEntity);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
}
