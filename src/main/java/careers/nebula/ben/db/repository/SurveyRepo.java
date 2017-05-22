/**
 * 
 */
package careers.nebula.ben.db.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import careers.nebula.ben.db.enitity.Survey;
import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit Verma
 *
 */
public class SurveyRepo {
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	
	public void insertSurvey(Survey surveyData){
				session.beginTransaction();
				session.save(surveyData);
				session.getTransaction().commit();
				session.close();
				session.getSessionFactory().close();
			   }

	public void updateSurveyById(Survey surveyData){
		session.beginTransaction();
		session.merge(surveyData);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public Survey getSurveyById(int surveyId){
				Survey surveyData = new Survey();
				session = sessionFactory.openSession();
				session.beginTransaction();
				surveyData = (Survey)session.get(Survey.class, surveyId);
				session.close();
				session.getSessionFactory().close();
				return surveyData;
	}
	
	
	
}
