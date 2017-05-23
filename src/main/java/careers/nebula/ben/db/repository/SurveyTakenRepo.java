/**
 * 
 */
package careers.nebula.ben.db.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import careers.nebula.ben.db.enitity.Survey;
import careers.nebula.ben.db.enitity.SurveyTaken;
import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit Verma
 *
 */
public class SurveyTakenRepo {
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	
	public void insertSurveyTaken(SurveyTaken surveyData){
				session.beginTransaction();
				session.save(surveyData);
				session.getTransaction().commit();
				session.close();
				session.getSessionFactory().close();
			   }
	
	public void insertSurveyTaken(SurveyTaken surveyTakenData, User userData, Survey surveyData){
		session.beginTransaction();
		session.save(surveyTakenData);
		session.merge(surveyData);
		session.merge(surveyTakenData);		
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }

	public void updateSurveyTakenById(SurveyTaken surveyData){
		session.beginTransaction();
		session.merge(surveyData);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public SurveyTaken getSurveyTakenById(int surveyId){
		SurveyTaken surveyData = new SurveyTaken();
				session = sessionFactory.openSession();
				session.beginTransaction();
				surveyData = (SurveyTaken)session.get(SurveyTaken.class, surveyId);
				session.close();
				session.getSessionFactory().close();
				return surveyData;
	}
}
