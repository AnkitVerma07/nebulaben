/**
 * 
 */
package careers.nebula.ben.pojo.iws;

import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;
import careers.nebula.ben.db.enitity.Companies;
import careers.nebula.ben.db.enitity.Highschool;
import careers.nebula.ben.db.enitity.Jobs;
import careers.nebula.ben.db.enitity.Qualification;
import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class LocationDataPojo {
	private Integer id;
	private String street_address1;
	private String street_address2;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	private Collection<User> userList = new ArrayList<User>();
	private Collection<Highschool> highSchoolList = new ArrayList<Highschool>();
	private Collection<Qualification> qualificationList = new ArrayList<Qualification>();
	private Collection<Companies> companyList = new ArrayList<Companies>();
	//private Jobs jobLocation = new Jobs();
	
	public LocationDataPojo(){
		
	}
	public LocationDataPojo(Integer id, String street_address1, String street_address2, String city, String state, String zipcode, String country,Collection<User> userList, Collection<Highschool> highschoolList, Collection<Qualification> qualificationList, Collection<Companies> companyList, Jobs jobLocation){
		this.id = id;
		this.street_address1 = street_address1;
		this.street_address2 = street_address2;
		this.city = city;
		this.state = state;
		this.zipcode = zipcode;
		this.country = country;
		this.userList = userList;
		this.highSchoolList = highschoolList;
		this.qualificationList = qualificationList;
		this.companyList = companyList;
		//this.jobLocation = jobLocation;
	}
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
