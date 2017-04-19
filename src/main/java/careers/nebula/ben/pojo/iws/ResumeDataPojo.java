/**
 * 
 */
package careers.nebula.ben.pojo.iws;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class ResumeDataPojo {

	private Integer id;
	private String fileName;
	private String userName;
	private String userEmail;
	private String userPhone;
	private String userAddress;
	private String userLinks;  
	private String userExperience;
	private String userEducation;
	private String userAboutme; //summary
	private String userGoals; //objective
	private String userSkills; 
	private String userResearch; //research+publications
	private String userCourses; 
	private Collection<User> userList = new ArrayList<User>();
	private String keywordsMatched;
	private String keywordsNotMatched;
	private Boolean updated;
	
	public ResumeDataPojo(){
		
	}
	
	public ResumeDataPojo(Integer id, String fileName, String userName, String userEmail, String userPhone, String userAddress, String userLinks, String userExperience, String userEducation, String userAboutMe, String userGoals, String userSkills, String userResearch, String userCourses, Collection<User> userList, String keywordsMatched, String keywordsNotMatched, Boolean updated){
		this.id = id;
		this.fileName = fileName;
		this.userName = userName;
		this.userEmail = userEmail;
		this.userPhone = userPhone;
		this.userAddress = userAddress;
		this.userLinks = userLinks;
		this.userEducation = userEducation;
		this.userExperience = userExperience;
		this.userAboutme = userAboutMe;
		this.userGoals = userGoals;
		this.userSkills = userSkills;
		this.userResearch = userResearch;
		this.userCourses = userCourses;
		this.userList = userList;
		this.keywordsMatched = keywordsMatched;
		this.keywordsNotMatched = keywordsNotMatched;
		this.updated = updated;
	}
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
