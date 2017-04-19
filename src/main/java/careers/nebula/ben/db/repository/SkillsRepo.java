/**
 * 
 */
package careers.nebula.ben.db.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import careers.nebula.ben.db.enitity.Courses;
import careers.nebula.ben.db.enitity.Extracurricular;
import careers.nebula.ben.db.enitity.Industry;
import careers.nebula.ben.db.enitity.Interests;
import careers.nebula.ben.db.enitity.Keywords;
import careers.nebula.ben.db.enitity.Languages;
import careers.nebula.ben.db.enitity.Majors;
import careers.nebula.ben.db.enitity.Minors;
import careers.nebula.ben.db.enitity.Transfer;
import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit_Nebula
 *
 */
public class SkillsRepo {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	User userEntity;
	Extracurricular extraEntity;
	Languages lanEntity;
	Interests interestEntity;
	Industry indusEntity;
	Keywords keywordEntity;
	
	public void InsertExtracurricularSkill(User userEntity, Extracurricular extraEntity){
		session.beginTransaction();			
		session.save(extraEntity);
		session.merge(userEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }
	
	public Extracurricular getExtracurricularData(int id){
		extraEntity = new Extracurricular();
		session = sessionFactory.openSession();
		session.beginTransaction();
		extraEntity = (Extracurricular)session.get(Extracurricular.class, id);
		session.close();
		session.getSessionFactory().close();
		return extraEntity;
}
	
	public void updateExtracurricularData(Extracurricular extraEntity){
		session.beginTransaction();
		session.merge(extraEntity);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public void InsertLanguageSkill(User userEntity, Languages lanEntity){
		session.beginTransaction();			
		session.save(lanEntity);
		session.merge(userEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }
	
	public Languages getLanguageData(int id){
		lanEntity = new Languages();
		session = sessionFactory.openSession();
		session.beginTransaction();
		lanEntity = (Languages)session.get(Languages.class, id);
		session.close();
		session.getSessionFactory().close();
		return lanEntity;
}
	
	public void updateLaguageData(Languages lanEntity){
		session.beginTransaction();
		session.merge(lanEntity);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public void InsertInterestsData(User userEntity, Interests interestEntity){
		session.beginTransaction();			
		session.save(interestEntity);
		session.merge(userEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }
	
	public Interests getInterestData(int id){
		interestEntity = new Interests();
		session = sessionFactory.openSession();
		session.beginTransaction();
		interestEntity = (Interests)session.get(Interests.class, id);
		session.close();
		session.getSessionFactory().close();
		return interestEntity;
}
	
	public void updateInterestData(Interests interestEntity){
		session.beginTransaction();
		session.merge(interestEntity);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public void InsertIndustryData(User userEntity, Industry indusEntity){
		session.beginTransaction();			
		session.save(indusEntity);
		session.merge(userEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }
	
	public Industry getIndustryData(int id){
		indusEntity = new Industry();
		session = sessionFactory.openSession();
		session.beginTransaction();
		indusEntity = (Industry)session.get(Industry.class, id);
		session.close();
		session.getSessionFactory().close();
		return indusEntity;
}
	
	public void updateIndustryData(Industry indusEntity){
		session.beginTransaction();
		session.merge(indusEntity);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public void InsertKeywordData(User userEntity, Keywords keywordEntity){
		session.beginTransaction();			
		session.save(keywordEntity);
		session.merge(userEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }
	
	public Keywords getKeywordData(int id){
		keywordEntity = new Keywords();
		session = sessionFactory.openSession();
		session.beginTransaction();
		keywordEntity = (Keywords)session.get(Keywords.class, id);
		session.close();
		session.getSessionFactory().close();
		return keywordEntity;
}
	
	public void updateKeywordData(Keywords keywordEntity){
		session.beginTransaction();
		session.merge(keywordEntity);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public void updateCoursesSkills(Courses coEntity, Industry industryEntity){
		session.beginTransaction();
		session.merge(industryEntity);
		session.merge(coEntity);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public void insertCoursesSkills(Courses coEntity, Industry industryEntity){
		session.beginTransaction();
		session.save(industryEntity);
		session.merge(coEntity);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
}
