/**
 * 
 */
package careers.nebula.ben.pojo.iws;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.Courses;
import careers.nebula.ben.db.enitity.Locations;
import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class HighschoolDataPojo {
	private Integer id;
	private String highschool_name;
	private Double gpa;
	private String year_started;
	private String year_graduated;
	private String year_standing;
	private Double highschool_rating;
	private Collection<Locations> locationList = new ArrayList<Locations>();
	private Collection<Courses> coursesList = new ArrayList<Courses>();
	private Collection<User> userList = new ArrayList<User>();
	
	public HighschoolDataPojo(){
		
	}
	
	public HighschoolDataPojo(Integer id, String year_standing, String highschool_name, Double gpa, String year_started, String year_graduated, Double highschool_rating, Collection<Locations> locationList, Collection<Courses> coursesList, Collection<User> userList){
		this.id = id;
		this.highschool_name = highschool_name;
		this.highschool_rating = highschool_rating;
		this.gpa = gpa;
		this.year_graduated = year_graduated;
		this.year_started = year_started;
		this.locationList = locationList;
		this.userList = userList;
		this.coursesList = coursesList;
		this.year_standing = year_standing;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getHighschool_name() {
		return highschool_name;
	}

	public void setHighschool_name(String highschool_name) {
		this.highschool_name = highschool_name;
	}

	public Double getGpa() {
		return gpa;
	}

	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}

	public String getYear_started() {
		return year_started;
	}

	public void setYear_started(String year_started) {
		this.year_started = year_started;
	}

	public String getYear_graduated() {
		return year_graduated;
	}

	public void setYear_graduated(String year_graduated) {
		this.year_graduated = year_graduated;
	}

	public Double getHighschool_rating() {
		return highschool_rating;
	}

	public void setHighschool_rating(Double highschool_rating) {
		this.highschool_rating = highschool_rating;
	}

	public Collection<Locations> getLocationList() {
		return locationList;
	}

	public void setLocationList(Collection<Locations> locationList) {
		this.locationList = locationList;
	}

	public Collection<Courses> getCoursesList() {
		return coursesList;
	}

	public void setCoursesList(Collection<Courses> coursesList) {
		this.coursesList = coursesList;
	}

	public Collection<User> getUserList() {
		return userList;
	}

	public void setUserList(Collection<User> userList) {
		this.userList = userList;
	}

	public String getYear_standing() {
		return year_standing;
	}

	public void setYear_standing(String year_standing) {
		this.year_standing = year_standing;
	}
	
	
}
