/**
 * 
 */
package careers.nebula.ben.db.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import careers.nebula.ben.db.enitity.Coaches;
import careers.nebula.ben.db.enitity.Courses;
import careers.nebula.ben.db.enitity.Resume;
import careers.nebula.ben.db.enitity.Students;
import careers.nebula.ben.db.enitity.Transcript;
import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit_Nebula
 *
 */
public class DocumentRepo {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	User userEntity;
	Resume resumeEntity;
	Transcript tranEntity;
	
	
	public void InsertResumeData(User userEntity, Resume resumeEntity) {
		session.beginTransaction();			
		session.save(resumeEntity);
		session.merge(userEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();		
	}
	
	public void InsertTranscriptData(User userEntity, Transcript tranEntity) {
		session.beginTransaction();			
		session.save(tranEntity);
		session.merge(userEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();		
	}
	
	public Resume getResumeById(int resumeId){
		resumeEntity= new Resume();
		session = sessionFactory.openSession();
		session.beginTransaction();
		resumeEntity = (Resume)session.get(Resume.class, resumeId);
		session.close();
		session.getSessionFactory().close();
		return resumeEntity;
	}
	
	public Transcript getTranscriptById(int transcriptId){
		tranEntity= new Transcript();
		session = sessionFactory.openSession();
		session.beginTransaction();
		tranEntity = (Transcript)session.get(Transcript.class, transcriptId);
		session.close(); 
		session.getSessionFactory().close();
		return tranEntity;
	}
	
	public void updateResumedata(Resume resumeData){
		session.beginTransaction();
		session.merge(resumeData);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public void updateTranscriptdata(Transcript transcriptId){
		session.beginTransaction();
		session.merge(transcriptId);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}

	
}
