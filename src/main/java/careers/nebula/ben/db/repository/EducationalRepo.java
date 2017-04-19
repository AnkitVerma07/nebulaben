/**
 * 
 */
package careers.nebula.ben.db.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import careers.nebula.ben.db.enitity.Coaches;
import careers.nebula.ben.db.enitity.Courses;
import careers.nebula.ben.db.enitity.Highschool;
import careers.nebula.ben.db.enitity.Qualification;
import careers.nebula.ben.db.enitity.Students;
import careers.nebula.ben.db.enitity.TestResult;
import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit_Nebula
 *
 */
public class EducationalRepo {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	User userEntity;
	Coaches coEntity;
	Students stuEntity;
	Courses courseEntity;
	TestResult testEntity;
	
	
	public void InsertUserCoach(User userEntity, Coaches coEntity) {
		session.beginTransaction();			
		session.save(coEntity);
		session.merge(userEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();		
	}


	public Coaches getCoachData(int id) {
		coEntity = new Coaches();
		session = sessionFactory.openSession();
		session.beginTransaction();
		coEntity = (Coaches)session.get(Coaches.class, id);
		session.close();
		session.getSessionFactory().close();
		return coEntity;
	}

	public Coaches updateCoachData(Coaches coEntity){
		session.beginTransaction();
		session.merge(coEntity);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return coEntity;
	}
	
	public void InsertUserStudent(User userEntity, Students stuEntity) {
		session.beginTransaction();			
		session.save(stuEntity);
		session.merge(userEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();		
	}
	
	public Students getStudentData(int id) {
		stuEntity = new Students();
		session = sessionFactory.openSession();
		session.beginTransaction();
		stuEntity = (Students)session.get(Students.class, id);
		session.close();
		session.getSessionFactory().close();
		return stuEntity;
	}
	
	public Students updateStudentData(Students stuEntity){
		session.beginTransaction();
		session.merge(stuEntity);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return stuEntity;
	}
	
	public void InsertHSCourse(Highschool hsEntity, Courses courseEntity) {
		session.beginTransaction();			
		session.save(courseEntity);
		session.merge(hsEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();		
	}
	
	public void InsertUniCourse(Qualification uniEntity, Courses courseEntity) {
		session.beginTransaction();			
		session.save(courseEntity);
		session.merge(uniEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();		
	}
	
	public void InserCoachCourse(Coaches coEntity, Courses courseEntity) {
		session.beginTransaction();			
		session.save(courseEntity);
		session.merge(coEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();		
	}
	
	public void InserStudentCourse(Students stuEntity, Courses courseEntity) {
		session.beginTransaction();			
		session.save(courseEntity);
		session.merge(stuEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();		
	}
	
	public Courses getCourseData(int id) {
		courseEntity = new Courses();
		session = sessionFactory.openSession();
		session.beginTransaction();
		courseEntity = (Courses)session.get(Courses.class, id);
		session.close();
		session.getSessionFactory().close();
		return courseEntity;
	}
	
	public Courses updateCourseData(Courses courseEntity){
		session.beginTransaction();
		session.merge(courseEntity);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return courseEntity;
	}
	
	public void InsertCoachStudent(Coaches coEntity) {
		session.beginTransaction();			
		session.merge(coEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();		
	}
	
	public void InsertUserTests(User userEntity, TestResult testEntity) {
		session.beginTransaction();			
		session.save(testEntity);
		session.merge(userEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();		
	}
	
	public TestResult getTestResultData(int id) {
		testEntity = new TestResult();
		session = sessionFactory.openSession();
		session.beginTransaction();
		testEntity = (TestResult)session.get(TestResult.class, id);
		session.close();
		session.getSessionFactory().close();
		return testEntity;
	}

	public TestResult updateTestResultData(TestResult testEntity){
		session.beginTransaction();
		session.merge(testEntity);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return testEntity;
	}
}
