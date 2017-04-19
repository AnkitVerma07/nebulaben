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
@Table (name = "qualifications")
public class Qualification {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	private String year_started;
	private String year_gradauted;
	private String qualification_earned;
	private Double gpa;
	private Double university_rating;
	private Boolean most_recent;
	private String year_standing;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="qualification_location",
			joinColumns=@JoinColumn(name="qualification_id"), 
			inverseJoinColumns=@JoinColumn(name="location_id")
	)
	private Collection<Locations> locationList = new ArrayList<Locations>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="qualification_courses",
			joinColumns=@JoinColumn(name="qualification_id"), 
			inverseJoinColumns=@JoinColumn(name="courses_id")
	)
	private Collection<Courses> coursesList = new ArrayList<Courses>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "universityList", cascade = CascadeType.ALL)
	private Collection<User> userList = new ArrayList<User>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="qualification_universities",
			joinColumns=@JoinColumn(name="qualification_id"), 
			inverseJoinColumns=@JoinColumn(name="uni_id")
	)
	private Collection<Universities> uniNameList = new ArrayList<Universities>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="qualification_colleges",
			joinColumns=@JoinColumn(name="qualification_id"), 
			inverseJoinColumns=@JoinColumn(name="college_id")
	)
	private Collection<Colleges> collegeNameList = new ArrayList<Colleges>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="qualification_major",
			joinColumns=@JoinColumn(name="qualification_id"), 
			inverseJoinColumns=@JoinColumn(name="major_id")
	)
	private Collection<Majors> majorList = new ArrayList<Majors>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="qualification_minor",
			joinColumns=@JoinColumn(name="qualification_id"), 
			inverseJoinColumns=@JoinColumn(name="minor_id")
	)
	private Collection<Minors> minorList = new ArrayList<Minors>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="qualification_transfer",
			joinColumns=@JoinColumn(name="qualification_id"), 
			inverseJoinColumns=@JoinColumn(name="transfer_id")
	)
	private Collection<Transfer> transferList = new ArrayList<Transfer>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getYear_started() {
		return year_started;
	}
	public void setYear_started(String year_started) {
		this.year_started = year_started;
	}
	public String getYear_gradauted() {
		return year_gradauted;
	}
	public void setYear_gradauted(String year_gradauted) {
		this.year_gradauted = year_gradauted;
	}
	public String getQualification_earned() {
		return qualification_earned;
	}
	public void setQualification_earned(String qualification_earned) {
		this.qualification_earned = qualification_earned;
	}
	public Double getUniversity_rating() {
		return university_rating;
	}
	public void setUniversity_rating(Double university_rating) {
		this.university_rating = university_rating;
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
	public Collection<Majors> getMajorList() {
		return majorList;
	}
	public void setMajorList(Collection<Majors> majorList) {
		this.majorList = majorList;
	}
	public Collection<Minors> getMinorList() {
		return minorList;
	}
	public void setMinorList(Collection<Minors> minorList) {
		this.minorList = minorList;
	}
	public Double getGpa() {
		return gpa;
	}
	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}
	
	public Boolean getMost_recent() {
		return most_recent;
	}
	public void setMost_recent(Boolean most_recent) {
		this.most_recent = most_recent;
	}
	public Collection<Transfer> getTransferList() {
		return transferList;
	}
	public void setTransferList(Collection<Transfer> transferList) {
		this.transferList = transferList;
	}
	public Collection<Universities> getUniNameList() {
		return uniNameList;
	}
	public void setUniNameList(Collection<Universities> uniNameList) {
		this.uniNameList = uniNameList;
	}
	public Collection<Colleges> getCollegeNameList() {
		return collegeNameList;
	}
	public void setCollegeNameList(Collection<Colleges> collegeNameList) {
		this.collegeNameList = collegeNameList;
	}
	public String getYear_standing() {
		return year_standing;
	}
	public void setYear_standing(String year_standing) {
		this.year_standing = year_standing;
	}
	
	
}
