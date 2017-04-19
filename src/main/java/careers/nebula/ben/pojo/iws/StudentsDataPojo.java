/**
 * 
 */
package careers.nebula.ben.pojo.iws;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.Coaches;
import careers.nebula.ben.db.enitity.Courses;
import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class StudentsDataPojo {
	private Integer id;
	private Collection<Courses> coursesList = new ArrayList<Courses>(); 
	private Double student_rating;
	private Collection<Coaches> coachesList = new ArrayList<Coaches>();
	private Collection<User> userList = new ArrayList<User>();
	
	public StudentsDataPojo(){
		
	}
	
	public StudentsDataPojo(Integer id, Double student_rating, Collection<Courses> coursesList, Collection<Coaches> coachesList, Collection<User> userList){
		this.id = id;
		this.student_rating = student_rating;
		this.coursesList = coursesList;
		this.coachesList = coachesList;
		this.userList = userList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Collection<Courses> getCoursesList() {
		return coursesList;
	}

	public void setCoursesList(Collection<Courses> coursesList) {
		this.coursesList = coursesList;
	}

	public Double getStudent_rating() {
		return student_rating;
	}

	public void setStudent_rating(Double student_rating) {
		this.student_rating = student_rating;
	}

	public Collection<Coaches> getCoachesList() {
		return coachesList;
	}

	public void setCoachesList(Collection<Coaches> coachesList) {
		this.coachesList = coachesList;
	}

	public Collection<User> getUserList() {
		return userList;
	}

	public void setUserList(Collection<User> userList) {
		this.userList = userList;
	}
	
	
}
