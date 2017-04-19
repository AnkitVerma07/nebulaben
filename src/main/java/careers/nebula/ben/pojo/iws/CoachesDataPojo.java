/**
 * 
 */
package careers.nebula.ben.pojo.iws;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.Courses;
import careers.nebula.ben.db.enitity.Students;
import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class CoachesDataPojo {
	private Integer id;
	private Double coach_hourlyrate;
	private Double coach_rating;
	private Collection<User> userList = new ArrayList<User>();
	private Collection<Courses> coursesList = new ArrayList<Courses>();
	private Collection<Students> studentsList = new ArrayList<Students>();
	
	public CoachesDataPojo(){
		
	}
	
	public CoachesDataPojo(Integer id, Double coach_hourlyrate, Double coach_rating, Collection<User> userList, Collection<Courses> coursesList, Collection<Students> studentsList){
		this.id = id;
		this.coach_hourlyrate = coach_hourlyrate;
		this.coach_rating = coach_rating;
		this.userList = userList;
		this.coursesList = coursesList;
		this.studentsList = studentsList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getCoach_hourlyrate() {
		return coach_hourlyrate;
	}

	public void setCoach_hourlyrate(Double coach_hourlyrate) {
		this.coach_hourlyrate = coach_hourlyrate;
	}

	public Double getCoach_rating() {
		return coach_rating;
	}

	public void setCoach_rating(Double coach_rating) {
		this.coach_rating = coach_rating;
	}

	public Collection<User> getUserList() {
		return userList;
	}

	public void setUserList(Collection<User> userList) {
		this.userList = userList;
	}

	public Collection<Courses> getCoursesList() {
		return coursesList;
	}

	public void setCoursesList(Collection<Courses> coursesList) {
		this.coursesList = coursesList;
	}

	public Collection<Students> getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(Collection<Students> studentsList) {
		this.studentsList = studentsList;
	}
	
	
}
