/**
 * 
 */
package careers.nebula.ben.db.enitity;

import java.util.ArrayList;
import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Ankit_Nebula
 *
 */
@Entity
@Table (name = "highschools")
public class Highschool {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	private String highschool_name;
	private Double gpa;
	private String year_started;
	private String year_graduated;
	private Double highschool_rating;
	private String year_standing;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="highschool_location",
			joinColumns=@JoinColumn(name="highschool_id"), 
			inverseJoinColumns=@JoinColumn(name="location_id")
	)
	private Collection<Locations> locationList = new ArrayList<Locations>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="highschool_courses",
			joinColumns=@JoinColumn(name="highschool_id"), 
			inverseJoinColumns=@JoinColumn(name="courses_id")
	)
	private Collection<Courses> coursesList = new ArrayList<Courses>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "highschoolList", cascade = CascadeType.ALL)
	private Collection<User> userList = new ArrayList<User>();
	
	
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
