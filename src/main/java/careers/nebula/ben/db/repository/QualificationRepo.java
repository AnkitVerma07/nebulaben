/**
 * 
 */
package careers.nebula.ben.db.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import careers.nebula.ben.db.enitity.Colleges;
import careers.nebula.ben.db.enitity.Majors;
import careers.nebula.ben.db.enitity.Minors;
import careers.nebula.ben.db.enitity.Qualification;
import careers.nebula.ben.db.enitity.Transfer;
import careers.nebula.ben.db.enitity.Universities;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.pojos.QualificationMajorPojo;
import careers.nebula.ben.pojos.QualificationMinorPojo;
import careers.nebula.ben.pojos.UserQualificationPojo;

/**
 * @author Ankit_Nebula
 *
 */
public class QualificationRepo {

	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	User userEntity;
	Qualification qualEntity;
	Majors majorEntity;
	Minors minorEntity;
	Transfer transferEntity;
	Universities uniEntity;
	Colleges collegeEntity;
	
	public void InsertUserUniData(UserQualificationPojo combinedPojo){
		userEntity = combinedPojo.getUser();
		qualEntity = combinedPojo.getUniversity();
		session.beginTransaction();			
		session.save(qualEntity);
		session.merge(userEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }

	public Qualification getQualificationData(int id){
		qualEntity = new Qualification();
		session = sessionFactory.openSession();
		session.beginTransaction();
		qualEntity = (Qualification)session.get(Qualification.class, id);
		session.close();
		session.getSessionFactory().close();
		return qualEntity;
}
	  
	 
	public void updateQualificationData(Qualification uniData){
		session.beginTransaction();
		session.merge(uniData);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public void InsertUniNameData(Qualification qualData, Universities uniData){
		session.beginTransaction();			
		session.save(uniData);
		session.merge(qualData); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }
	
	public void InsertCollegeNameData(Qualification qualData, Colleges collegeData){
		session.beginTransaction();			
		session.save(collegeData);
		session.merge(qualData); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }
	
	public void InsertUniMajorData(QualificationMajorPojo combinedPojo){
		qualEntity = combinedPojo.getUni();
		majorEntity = combinedPojo.getMajor();
		session.beginTransaction();			
		session.save(majorEntity);
		session.merge(qualEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }
	
	public void InsertUniMinorData(QualificationMinorPojo combinedPojo){
		qualEntity = combinedPojo.getUni();
		minorEntity = combinedPojo.getMinor();
		session.beginTransaction();			
		session.save(minorEntity);
		session.merge(qualEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }
	
	public Universities getUniData(int id){
		uniEntity = new Universities();
		session = sessionFactory.openSession();
		session.beginTransaction();
		uniEntity = (Universities)session.get(Universities.class, id);
		session.close();
		session.getSessionFactory().close();
		return uniEntity;
}
	
	public Colleges getCollegeData(int id){
		collegeEntity = new Colleges();
		session = sessionFactory.openSession();
		session.beginTransaction();
		collegeEntity = (Colleges)session.get(Colleges.class, id);
		session.close();
		session.getSessionFactory().close();
		return collegeEntity;
}
	
	public Majors getMajorData(int id){
		majorEntity = new Majors();
		session = sessionFactory.openSession();
		session.beginTransaction();
		majorEntity = (Majors)session.get(Majors.class, id);
		session.close();
		session.getSessionFactory().close();
		return majorEntity;
}
	
	public Minors getMinorData(int id){
		minorEntity = new Minors();
		session = sessionFactory.openSession();
		session.beginTransaction();
		minorEntity = (Minors)session.get(Minors.class, id);
		session.close();
		session.getSessionFactory().close();
		return minorEntity;
}

	public void updateUniData(Universities uniData){
		session.beginTransaction();
		session.merge(uniData);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public void updateCollegeData(Colleges collegeData){
		session.beginTransaction();
		session.merge(collegeData);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public void updateMajorData(Majors majordata){
		session.beginTransaction();
		session.merge(majordata);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public void updateMinorData(Minors minordata){
		session.beginTransaction();
		session.merge(minordata);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public void InsertTransferUser(Transfer transferEntity, Qualification qualEntity){
		session.beginTransaction();			
		session.save(transferEntity);
		session.merge(qualEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }
	
	public Transfer getTransferData(int id){
		transferEntity = new Transfer();
		session = sessionFactory.openSession();
		session.beginTransaction();
		transferEntity = (Transfer)session.get(Transfer.class, id);
		session.close();
		session.getSessionFactory().close();
		return transferEntity;
}
	
	public void updateTransfer(Transfer transferdata){
		session.beginTransaction();
		session.merge(transferdata);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
}
