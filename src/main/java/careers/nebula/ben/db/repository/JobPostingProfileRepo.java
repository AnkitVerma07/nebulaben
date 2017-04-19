package careers.nebula.ben.db.repository;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit_Nebula
 *
 */
public class JobPostingProfileRepo {
	//note: need to create only one session factory for entire project. 
	SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
	Session session = sessionFactory.openSession();
	// Connection c = null;
   //  Statement stmt = null;
	
	public void InsertUserData(User userData){
				session.beginTransaction();
				session.save(userData);
				session.getTransaction().commit();
				session.close();
				session.getSessionFactory().close();
//			      try {
//			         Class.forName("org.postgresql.Driver");
//			         c = DriverManager
//			            .getConnection("jdbc:postgresql://10.128.0.3/danstaging",
//			            "postgres", "madison91");
//			         c.setAutoCommit(false);
//			         System.out.println("Opened database successfully");
//
//			         stmt = c.createStatement();
//			         String sql = "INSERT INTO users(id, aboutme, currentlyemployeed, currentlyinschool, email, fburl, firstname, goals, highestqualification, lastname, linkedinurl, location_id, personalwebsiteurl, phonenumber, photourl, preferredname, skills_id, user_rating, videourl)"
//			         		+ " VALUES(" +  userData.getId() + ","+ "'"+userData.getAboutMe()+ "'" + "," + userData.getCurrentlyEmployeed()+ "," + userData.getCurrentlyInSchool() + "," + "'"+userData.getEmail()+"'" + "," + "'"+userData.getFbUrl()+"'" + "," + "'"+userData.getFirstName()+"'" + "," + "'"+userData.getGoals()+"'" + "," + "'"+userData.getHighestQualification()+"'" + "," + "'"+userData.getLastName()+"'" + "," + "'"+userData.getLinkedinUrl()+"'" + "," + userData.getLocation_id() + "," + "'"+userData.getPersonalWebsiteUrl()+"'" + "," + "'"+userData.getPhoneNumber()+"'" + "," + "'"+userData.getPhotoUrl()+"'" + "," + "'"+userData.getPreferredName()+"'" + "," + userData.getSkills_id() + "," + userData.getUser_rating() + "," + "'"+userData.getVideoUrl()+"'" + ")";
//			         System.out.println(sql);
//			         stmt.executeUpdate(sql);
//			         stmt.close();
//			         c.commit();
//			         c.close();
//			      } catch (Exception e) {
//			         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
//			         System.exit(0);
//			      }
//			      System.out.println("Records created successfully");
			   }

	public void updateUserdata(User userData){
		session.beginTransaction();
		session.merge(userData);
		session.getTransaction().commit();
		session.close();
		session.getSessionFactory().close();
	}
	
	public User getUserData(int userID){
				User userData = new User();
				session = sessionFactory.openSession();
				session.beginTransaction();
				userData = (User)session.get(User.class, userID);
				session.close();
				session.getSessionFactory().close();
//			       try {
//				         Class.forName("org.postgresql.Driver");
//				         c = DriverManager
//				            .getConnection("jdbc:postgresql://10.128.0.3/danstaging",
//				            "postgres", "madison91");
//				         c.setAutoCommit(false);
//				         System.out.println("Opened database successfully");
//
//			         stmt = c.createStatement();
//			         ResultSet rs = stmt.executeQuery( "SELECT * FROM USERS WHERE id =" + userID +";");
//			         while ( rs.next() ) {
//			        	 userData.setId(rs.getInt("id"));
//			        	 userData.setFirstName(rs.getString("firstname"));
//			        	 userData.setLastName(rs.getString("lastname"));
//			        	 userData.setPreferredName(rs.getString("preferredname"));
//			        	 userData.setPhoneNumber(rs.getString("phonenumber"));
//			        	 userData.setEmail(rs.getString("email"));
//			        	 userData.setPhotoUrl(rs.getString("photourl"));
//			        	 userData.setVideoUrl("videourl");
//			        	 userData.setPersonalWebsiteUrl(rs.getString("personalwebsiteurl"));
//			        	 userData.setFbUrl(rs.getString("fburl"));
//			        	 userData.setLinkedinUrl(rs.getString("linkedinurl"));
//			        	 userData.setGoals(rs.getString("goals"));
//			        	 userData.setAboutMe(rs.getString("aboutme"));
//			        	 userData.setCurrentlyEmployeed(rs.getBoolean("currentlyemployeed"));
//			        	 userData.setCurrentlyInSchool(rs.getBoolean("currentlyinschool"));
//			        	 userData.setHighestQualification(rs.getString("highestqualification"));
//			        	 userData.setUser_rating(rs.getInt("user_rating"));
//			        	 userData.setSkills_id(rs.getInt("skills_id"));
//			        	 userData.setLocation_id(rs.getInt("location_id"));
//			         }
//			         rs.close();
//			         stmt.close();
//			         c.close();
//			       } catch ( Exception e ) {
//			         System.err.println( e.getClass().getName()+": "+ e.getMessage() );
//			         System.exit(0);
//			       }
//			       System.out.println("Operation done successfully");
				return userData;
	}
	
}
