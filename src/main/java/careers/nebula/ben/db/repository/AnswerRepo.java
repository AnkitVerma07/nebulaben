/**
 * 
 */
package careers.nebula.ben.db.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import careers.nebula.ben.db.enitity.Answer;
import careers.nebula.ben.db.enitity.Survey;
import careers.nebula.ben.db.enitity.SurveyTaken;
import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit Verma
 *
 */
public class AnswerRepo {
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	
	public void insertAnswer(Answer answerData){
				session.beginTransaction();
				session.save(answerData);
				session.getTransaction().commit();
				session.close();
				session.getSessionFactory().close();
			   }
	
	public void insertAnswer(Answer answerData, SurveyTaken surveyTakenData){
		session.beginTransaction();
		session.save(answerData);
		session.merge(surveyTakenData);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }

	public void updateAnswerTakenById(Answer answerData){
		session.beginTransaction();
		session.merge(answerData);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public Answer getAnswerById(int answerId){
				Answer answerData = new Answer();
				session = sessionFactory.openSession();
				session.beginTransaction();
				answerData = (Answer)session.get(Answer.class, answerId);
				session.close();
				session.getSessionFactory().close();
				return answerData;
	}
}
