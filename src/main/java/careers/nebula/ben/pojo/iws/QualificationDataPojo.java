/**
 * 
 */
package careers.nebula.ben.pojo.iws;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.Colleges;
import careers.nebula.ben.db.enitity.Courses;
import careers.nebula.ben.db.enitity.Locations;
import careers.nebula.ben.db.enitity.Majors;
import careers.nebula.ben.db.enitity.Minors;
import careers.nebula.ben.db.enitity.Transfer;
import careers.nebula.ben.db.enitity.Universities;
import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit_Nebula
 *
 */ 
@XmlRootElement
public class QualificationDataPojo {
	private Integer id;
	private String year_started;
	private String year_gradauted;
	private String year_standing;
	private String qualification_earned;
	private Double university_rating;
	private Double gpa;
	private Boolean most_recent;
	private Collection<Locations> locationList = new ArrayList<Locations>();
	private Collection<Courses> coursesList = new ArrayList<Courses>();
	private Collection<User> userList = new ArrayList<User>();
	private Collection<Majors> majorList = new ArrayList<Majors>();
	private Collection<Minors> minorList = new ArrayList<Minors>();
	private Collection<Transfer> transferList = new ArrayList<Transfer>();
	private Collection<Universities> uniNamelist = new ArrayList<Universities>();
	private Collection<Colleges> collegeNameList = new ArrayList<Colleges>();
	
	public QualificationDataPojo(){
		
	}
	
	public QualificationDataPojo(Integer id, String year_started, String year_standing, Double gpa, String year_graduated, String qualification_earned,  Double university_rating, Collection<Locations> locationList, Collection<Courses> coursesList, Collection<User> userList, Collection<Transfer> transferList, Collection<Universities> uniNameList, Collection<Colleges> collegeNameList, Collection<Majors> majorList, Collection<Minors> minorList, Boolean most_recent){
		this.id = id;
		this.year_gradauted = year_graduated;
		this.year_started = year_started;
		this.qualification_earned = qualification_earned;
		this.university_rating = university_rating;
		this.locationList = locationList;
		this.coursesList = coursesList;
		this.userList = userList;
		this.gpa = gpa;
		this.transferList = transferList;
		this.most_recent = most_recent;
		this.collegeNameList = collegeNameList;
		this.uniNamelist = uniNameList;
		this.year_standing = year_standing;
	}

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

	public Collection<Transfer> getTransferList() {
		return transferList;
	}

	public void setTransferList(Collection<Transfer> transferList) {
		this.transferList = transferList;
	}

	public Boolean getMost_recent() {
		return most_recent;
	}

	public void setMost_recent(Boolean most_recent) {
		this.most_recent = most_recent;
	}

	public Collection<Universities> getUniNamelist() {
		return uniNamelist;
	}

	public void setUniNamelist(Collection<Universities> uniNamelist) {
		this.uniNamelist = uniNamelist;
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
