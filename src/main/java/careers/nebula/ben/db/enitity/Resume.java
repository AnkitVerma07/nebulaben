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
import javax.persistence.Table;

/**
 * @author Ankit_Nebula
 *
 */
@Entity
@Table (name = "resume")
public class Resume {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	private String fileName;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String userAddress;
	@Column(length = 100000)
	private String userLinks;  
	@Column(length = 100000)
	private String userExperience;
	@Column(length = 100000)
	private String userEducation;
	@Column(length = 100000)
	private String userAboutme; //summary
	@Column(length = 100000)
	private String userGoals; //objective
	@Column(length = 100000)
	private String userSkills; 
	@Column(length = 100000)
	private String userResearch; //research+publications
	@Column(length = 100000)
	private String userCourses; 
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "resumeList", cascade = CascadeType.ALL)
	private Collection<User> userList = new ArrayList<User>();
	private String keywordsMatched;
	private String keywordsNotMatched;
	private Boolean updated;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserEmail() {
		return userEmail;
	}
	public void setUserEmail(String userEmail) {
		this.userEmail = userEmail;
	}
	public String getUserPhone() {
		return userPhone;
	}
	public void setUserPhone(String userPhone) {
		this.userPhone = userPhone;
	}
	public String getUserAddress() {
		return userAddress;
	}
	public void setUserAddress(String userAddress) {
		this.userAddress = userAddress;
	}
	public String getUserLinks() {
		return userLinks;
	}
	public void setUserLinks(String userLinks) {
		this.userLinks = userLinks;
	}
	public String getUserExperience() {
		return userExperience;
	}
	public void setUserExperience(String userExperience) {
		this.userExperience = userExperience;
	}
	public String getUserEducation() {
		return userEducation;
	}
	public void setUserEducation(String userEducation) {
		this.userEducation = userEducation;
	}
	public String getUserAboutme() {
		return userAboutme;
	}
	public void setUserAboutme(String userAboutme) {
		this.userAboutme = userAboutme;
	}
	public String getUserGoals() {
		return userGoals;
	}
	public void setUserGoals(String userGoals) {
		this.userGoals = userGoals;
	}
	public String getUserSkills() {
		return userSkills;
	}
	public void setUserSkills(String userSkills) {
		this.userSkills = userSkills;
	}
	public String getUserResearch() {
		return userResearch;
	}
	public void setUserResearch(String userResearch) {
		this.userResearch = userResearch;
	}
	public String getUserCourses() {
		return userCourses;
	}
	public void setUserCourses(String userCourses) {
		this.userCourses = userCourses;
	}
	public Collection<User> getUserList() {
		return userList;
	}
	public void setUserList(Collection<User> userList) {
		this.userList = userList;
	}
	public String getKeywordsMatched() {
		return keywordsMatched;
	}
	public void setKeywordsMatched(String keywordsMatched) {
		this.keywordsMatched = keywordsMatched;
	}
	public String getKeywordsNotMatched() {
		return keywordsNotMatched;
	}
	public void setKeywordsNotMatched(String keywordsNotMatched) {
		this.keywordsNotMatched = keywordsNotMatched;
	}
	public Boolean getUpdated() {
		return updated;
	}
	public void setUpdated(Boolean updated) {
		this.updated = updated;
	}
	
	
	
}
