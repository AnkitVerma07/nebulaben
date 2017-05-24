/**
 * 
 */
package careers.nebula.ben.db.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

import careers.nebula.ben.db.enitity.AssestmentTaken;
import careers.nebula.ben.db.enitity.Companies;
import careers.nebula.ben.db.enitity.Highschool;
import careers.nebula.ben.db.enitity.Locations;
import careers.nebula.ben.db.enitity.Qualification;
import careers.nebula.ben.db.enitity.SurveyTaken;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.pojo.iws.LocationDataPojo;
import careers.nebula.ben.pojos.HighSchoolLocationPojo;
import careers.nebula.ben.pojos.QualificationLocationPojo;
import careers.nebula.ben.pojos.UserLocationPojo;

/**
 * @author Ankit_Nebula
 * get the user data object from service and store to DB using hibernate
 */
public class LocationRepo {
	//note: need to create only one session factory for entire project. 
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	LocationRepo locationRepo;
	Locations locationEntity;
	UserRepo userRepo;
	User userEntity;
	LocationDataPojo locationPojo;
	Highschool hsEntity;
	Qualification uniEntity;
	Companies compEntity;
	
	public void InsertUserLocationData(UserLocationPojo pojo){
				userEntity = pojo.getUser();
				locationEntity = pojo.getLocation();
				session.beginTransaction();			
				session.save(locationEntity);
				session.merge(userEntity); 
				session.getTransaction().commit();
				session.close();
				session.getSessionFactory().close();
			   }
	
	public void insertSurveyTakenLocation(SurveyTaken surveyTaken, Locations location){
		session.beginTransaction();			
		session.save(location);
		session.merge(surveyTaken); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }
	
	public void insertAssestmentTakenLocation(AssestmentTaken assestmentTaken, Locations location){
		session.beginTransaction();			
		session.save(location);
		session.merge(assestmentTaken); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }

	public void updateLocationData(Locations locationData){
		session.beginTransaction();
		session.merge(locationData);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public Locations getLocationData(int id){
				Locations locationData = new Locations();
				session = sessionFactory.openSession();
				session.beginTransaction();
				locationData = (Locations)session.get(Locations.class, id);
				session.close();
				session.getSessionFactory().close();
				return locationData;
	}
	
	public void InsertHSLocationData(HighSchoolLocationPojo pojo){
		hsEntity = pojo.getHs();
		locationEntity = pojo.getLocation();
		session.beginTransaction();			
		session.save(locationEntity);
		session.merge(hsEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }
	
	public void InsertUniLocationData(QualificationLocationPojo pojo){
		uniEntity = pojo.getUni();
		locationEntity = pojo.getLocation();
		session.beginTransaction();			
		session.save(locationEntity);
		session.merge(uniEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }
	
	public void InsertCompanyLocationData(Companies compEntity, Locations locationData){
		session.beginTransaction();			
		session.save(locationData);
		session.merge(compEntity); 
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	   }
}
