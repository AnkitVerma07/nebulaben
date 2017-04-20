/**
 * 
 */
package careers.nebula.ben.db.repository;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import careers.nebula.ben.db.enitity.Colleges;
import careers.nebula.ben.db.enitity.Companies;
import careers.nebula.ben.db.enitity.Courses;
import careers.nebula.ben.db.enitity.Experiences;
import careers.nebula.ben.db.enitity.Extracurricular;
import careers.nebula.ben.db.enitity.Industry;
import careers.nebula.ben.db.enitity.Interests;
import careers.nebula.ben.db.enitity.Jobs;
import careers.nebula.ben.db.enitity.Keywords;
import careers.nebula.ben.db.enitity.Languages;
import careers.nebula.ben.db.enitity.Locations;
import careers.nebula.ben.db.enitity.Majors;
import careers.nebula.ben.db.enitity.Minors;
import careers.nebula.ben.db.enitity.Qualification;
import careers.nebula.ben.db.enitity.Universities;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.pojo.iws.UserDataPojo;
import careers.nebula.ben.pojos.QualificationMajorDataPojo;

/**
 * @author Ankit_Nebula
 *
 */
public class UserProfileRepo {
	
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	 Connection c = null;
	  Statement stmt = null;
	
	public List<User> SameHighestQualifications(String highestqualification){
		session.beginTransaction();
		Query query = session.createQuery("from User where highestqualification='"+ highestqualification +"'");
		List<User> userData = (List<User>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return userData;
	}
	
	public List<User> SameAge(int age){
		session.beginTransaction();
		Query query = session.createQuery("from User where age='"+ age +"'");
		List<User> userData = (List<User>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return userData;
	}
	
	public List<Qualification> SameQualifications(String qualification_earned){
		session.beginTransaction();
		Query query = session.createQuery("from Qualification where qualification_earned='"+ qualification_earned +"'");
		List<Qualification> userData = (List<Qualification>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return userData;
	}
	
	public List<Locations> SameLocations(String state){
		session.beginTransaction();
		Query query = session.createQuery("from Locations where state='"+ state +"'");
		List<Locations> locationData = (List<Locations>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return locationData;
	}
	
	public List<Experiences> SameExperience(String job_title){
		session.beginTransaction();
		Query query = session.createQuery("from Experiences where job_title='"+ job_title +"'");
		List<Experiences> expData = (List<Experiences>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return expData;
	}
	
	public List<Jobs> getJobsByTitle(String job_title){
		session.beginTransaction();
		Query query = session.createQuery("from Jobs where title='"+ job_title +"'");
		List<Jobs> expData = (List<Jobs>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return expData;
	}
	
	public List<Companies> SameCompanyIndustry(String company_industry){
		session.beginTransaction();
		Query query = session.createQuery("from Companies where company_industry='"+ company_industry +"'");
		List<Companies> compData = (List<Companies>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return compData;
	}
	
	public List<Integer> SameUniversity(int id){
		List<Integer> ids = new ArrayList<Integer>();
	      try {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
         .getConnection("jdbc:postgresql://localhost:5432/testdb",
         "postgres", "ankit");
      c.setAutoCommit(false);
      stmt = c.createStatement();
      String sql = "SELECT qualification_id, major_id FROM public.qualification_universities WHERE uni_id =" + id + ";";
      ResultSet rs = stmt.executeQuery(sql);
      while(rs.next()){
      	int qual_id = rs.getInt("qualification_id");
      	int m_id = rs.getInt("uni_id");
      	ids.add(qual_id);
      }
      stmt.close();
      c.commit();
      c.close();
   } catch (Exception e) {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
      System.exit(0);
   }
	      return ids;
	}
	
	public List<User> SameGoals(String goals){
		session.beginTransaction();
		Query query = session.createQuery("from User where goals='"+ goals +"'");
		List<User> userData = (List<User>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return userData;
	}
	
	public List<Majors> SameMajor(String major){
		session.beginTransaction();
		Query query = session.createQuery("from Majors where name='"+ major +"'");
		List<Majors> majorData = (List<Majors>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return majorData;
	}
	
	public List<Integer> SameMajorIds(int id){
		List<Integer> ids = new ArrayList<Integer>();
	      try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager
           .getConnection("jdbc:postgresql://localhost:5432/testdb",
           "postgres", "ankit");
        c.setAutoCommit(false);
        stmt = c.createStatement();
        String sql = "SELECT qualification_id, major_id FROM public.qualification_major WHERE major_id =" + id + ";";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
        	int qual_id = rs.getInt("qualification_id");
        	int m_id = rs.getInt("major_id");
        	ids.add(qual_id);
        }
        stmt.close();
        c.commit();
        c.close();
     } catch (Exception e) {
        System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        System.exit(0);
     }
	      return ids;
	}
	
	public List<Integer> SameMinorIds(int id){
		List<Integer> ids = new ArrayList<Integer>();
	      try {
        Class.forName("org.postgresql.Driver");
        c = DriverManager
           .getConnection("jdbc:postgresql://localhost:5432/testdb",
           "postgres", "ankit");
        c.setAutoCommit(false);
        stmt = c.createStatement();
        String sql = "SELECT qualification_id, minor_id FROM public.qualification_minor WHERE minor_id =" + id + ";";
        ResultSet rs = stmt.executeQuery(sql);
        while(rs.next()){
        	int qual_id = rs.getInt("qualification_id");
        	int m_id = rs.getInt("minor_id");
        	ids.add(qual_id);
        }
        stmt.close();
        c.commit();
        c.close();
     } catch (Exception e) {
        System.err.println( e.getClass().getName()+": "+ e.getMessage() );
        System.exit(0);
     }
	      return ids;
	}
	
	public List<Minors> SameMinor(String minor){
		session.beginTransaction();
		Query query = session.createQuery("from Minors where name='"+ minor +"'");
		List<Minors> minorData = (List<Minors>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return minorData;
	}
	
	public List<Courses> SameCourses(String name){
		session.beginTransaction();
		Query query = session.createQuery("from Courses where course_name='"+ name +"'");
		List<Courses> courseData = (List<Courses>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return courseData;
	}
	
	public List<Companies> SameCompanyName(String name){
		session.beginTransaction();
		Query query = session.createQuery("from Companies where company_name='"+ name +"'");
		List<Companies> companyData = (List<Companies>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return companyData;
	}

	
	public List<Extracurricular> SameExtracurricular(String name){
		session.beginTransaction();
		Query query = session.createQuery("from Extracurricular where name='"+ name +"'");
		List<Extracurricular> extraData = (List<Extracurricular>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return extraData;
	}
	
	public List<Languages> SameLanguages(String name){
		session.beginTransaction();
		Query query = session.createQuery("from Languages where name='"+ name +"'");
		List<Languages> languageData = (List<Languages>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return languageData;
	}
	
	public List<Interests> SameInterests(String name){
		session.beginTransaction();
		Query query = session.createQuery("from Interests where name='"+ name +"'");
		List<Interests> interestList = (List<Interests>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return interestList;
	}
	
	public List<Industry> SameIndustry(String name){
		session.beginTransaction();
		Query query = session.createQuery("from Industry where name='"+ name +"'");
		List<Industry> industryList = (List<Industry>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return industryList;
	}
	
	public List<Keywords> SameKeywords(String name){
		session.beginTransaction();
		Query query = session.createQuery("from Keywords where name='"+ name +"'");
		List<Keywords> keywordList = (List<Keywords>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return keywordList;
	}
	
	public List<Universities> SameUniName(String name){
		session.beginTransaction();
		Query query = session.createQuery("from Universities where uni_name='"+ name +"'");
		List<Universities> uniNameList = (List<Universities>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return uniNameList;
	}
	
	public List<Colleges> SameCollegeName(String name){
		session.beginTransaction();
		Query query = session.createQuery("from Colleges where college_name='"+ name +"'");
		List<Colleges> collegeList = (List<Colleges>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return collegeList;
	}
	
	public List<Courses> SameCourseName(String name){
		session.beginTransaction();
		Query query = session.createQuery("from Courses where course_name='"+ name +"'");
		List<Courses> courseList = (List<Courses>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return courseList;
	}
	
	public List<Integer> SameIndustryCourse(int id){
		List<Integer> ids = new ArrayList<Integer>();
	      try {
      Class.forName("org.postgresql.Driver");
      c = DriverManager
         .getConnection("jdbc:postgresql://localhost:5432/testdb",
         "postgres", "ankit");
      c.setAutoCommit(false);
      stmt = c.createStatement();
      String sql = "SELECT course_id, industry_id FROM public.course_industry WHERE industry_id =" + id + ";";
      ResultSet rs = stmt.executeQuery(sql);
      while(rs.next()){
      	int course_id = rs.getInt("course_id");
      	int i_id = rs.getInt("industry_id");
      	ids.add(course_id);
      }
      stmt.close();
      c.commit();
      c.close();
   } catch (Exception e) {
      System.err.println( e.getClass().getName()+": "+ e.getMessage() );
      System.exit(0);
   }
	      return ids;
	}
	
	public List<Companies> getAllCompanyData(){
		session.beginTransaction();
		Query query = session.createQuery("from Companies");
		List<Companies> compList = (List<Companies>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return compList;
	}
	
	public List<Experiences> getAllExperienceData(){
		session.beginTransaction();
		Query query = session.createQuery("from Experiences");
		List<Experiences> expList = (List<Experiences>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return expList;
	}
	
	public List<Jobs> getAllJobsData(){
		session.beginTransaction();
		Query query = session.createQuery("from Jobs");
		List<Jobs> expList = (List<Jobs>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return expList;
	}
	
	public List<Majors> getAllMajorData(){
		session.beginTransaction();
		Query query = session.createQuery("from Majors");
		List<Majors> majorList = (List<Majors>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return majorList;
	}
	
	public List<Universities> getAllQualificationData(){
		session.beginTransaction();
		Query query = session.createQuery("from Universities");
		List<Universities> unilist = (List<Universities>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return unilist;
	}
	
	public List<Keywords> getAllKeywordsData(){
		session.beginTransaction();
		Query query = session.createQuery("from Keywords");
		List<Keywords> keywordData = (List<Keywords>)query.list();
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
		return keywordData;
	}
}
