/**
 * 
 */
package careers.nebula.ben.db.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import careers.nebula.ben.db.enitity.Question;
import careers.nebula.ben.db.enitity.Survey;

/**
 * @author Ankit Verma
 *
 */
public class QuestionRepo {

	
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	
	public void insertQuestion(Survey surveyEntity, Question questionData){
				session.beginTransaction();
				session.save(questionData);
				session.merge(surveyEntity); 
				session.getTransaction().commit();
				session.close();
				session.getSessionFactory().close();
			   }

	public void updateQuestionById(Question questionData){
		session.beginTransaction();
		session.merge(questionData);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public Question getQuestionById(int questionId){
				Question questionData = new Question();
				session = sessionFactory.openSession();
				session.beginTransaction();
				questionData = (Question)session.get(Question.class, questionId);
				session.close();
				session.getSessionFactory().close();
				return questionData;
	}
	
	
}
