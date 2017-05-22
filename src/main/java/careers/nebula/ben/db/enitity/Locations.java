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
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Ankit_Nebula
 *
 */
@Entity
@Table (name = "locations")
public class Locations {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	private String street_address1;
	private String street_address2;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "locationList", cascade = CascadeType.ALL)
	private Collection<User> userList = new ArrayList<User>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "locationList", cascade = CascadeType.ALL)
	private Collection<Highschool> highSchoolList = new ArrayList<Highschool>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "locationList", cascade = CascadeType.ALL)
	private Collection<Qualification> qualificationList = new ArrayList<Qualification>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "locationList", cascade = CascadeType.ALL)
	private Collection<Companies> companyList = new ArrayList<Companies>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "locationList", cascade = CascadeType.ALL)
	private Collection<SurveyTaken> surveyTakenList = new ArrayList<SurveyTaken>();
	
//	@OneToOne(cascade=CascadeType.ALL, mappedBy="location")
//	private Jobs jobLocation = new Jobs();
	
	public Integer getId() {
		return id; 
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getStreet_address1() {
		return street_address1;
	}
	public void setStreet_address1(String street_address1) {
		this.street_address1 = street_address1;
	}
	public String getStreet_address2() {
		return street_address2;
	}
	public void setStreet_address2(String street_address2) {
		this.street_address2 = street_address2;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public Collection<User> getUserList() {
		return userList;
	}
	public void setUserList(Collection<User> userList) {
		this.userList = userList;
	}
	public Collection<Highschool> getHighSchoolList() {
		return highSchoolList;
	}
	public void setHighSchoolList(Collection<Highschool> highSchoolList) {
		this.highSchoolList = highSchoolList;
	}
	public Collection<Companies> getCompanyList() {
		return companyList;
	}
	public void setCompanyList(Collection<Companies> companyList) {
		this.companyList = companyList;
	}
	public String getCountry() {
		return country;
	}
	public void setCountry(String country) {
		this.country = country;
	}
	public Collection<Qualification> getQualificationList() {
		return qualificationList;
	}
	public void setQualificationList(Collection<Qualification> qualificationList) {
		this.qualificationList = qualificationList;
	}
//	public Jobs getJobLocation() {
//		return jobLocation;
//	}
//	public void setJobLocation(Jobs jobLocation) {
//		this.jobLocation = jobLocation;
//	}
	
}
