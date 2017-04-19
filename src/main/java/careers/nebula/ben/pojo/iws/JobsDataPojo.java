/**
 * 
 */
package careers.nebula.ben.pojo.iws;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.Companies;
import careers.nebula.ben.db.enitity.Industry;
import careers.nebula.ben.db.enitity.Interview;
import careers.nebula.ben.db.enitity.Keywords;
import careers.nebula.ben.db.enitity.Locations;
import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class JobsDataPojo {
	private Integer id;
	private String title;
	private String industry;
	private String responsibilities;
	private String wage;
	private String type;
	private Double rating;
	private Double experienceNeeded;
	private Integer applicantsApplied;
	private Collection<Companies> companyList = new ArrayList<Companies>();
	private Collection<Keywords> keywordsList = new ArrayList<Keywords>();
	private Locations location = new Locations();
	private Collection<User> usersApplied = new ArrayList<User>();
	private Collection<User> usersQualified = new ArrayList<User>();
	private Collection<User> usersSaved = new ArrayList<User>();
	private Collection<User> usersReferred = new ArrayList<User>();
	private Collection<Interview> interviewList = new ArrayList<Interview>();
	private Collection<Industry> industryList = new ArrayList<Industry>();

	
	public JobsDataPojo(){
		
	}
	
	public JobsDataPojo(Integer id, String title, String industry, String responsibilities, String wage, String type, Double rating, Double experienceNeeded, Integer applicantsApplied,  Collection<Companies> companyList, Collection<Keywords> keywordsList, Locations location, Collection<User> usersApplied, Collection<User> usersQualified, Collection<User> usersSaved , Collection<User> usersReferred, Collection<Interview> interviewList, Collection<Industry> industryList){
		this.id = id;
		this.title = title;
		this.industry = industry;
		this.responsibilities = responsibilities;
		this.wage = wage;
		this.type = type;
		this.rating = rating;
		this.experienceNeeded = experienceNeeded;
		this.applicantsApplied = applicantsApplied;
		this.companyList = companyList;
		this.keywordsList = keywordsList;
		this.location = location;
		this.usersApplied = usersApplied;
		this.usersQualified = usersQualified;
		this.usersSaved = usersSaved;
		this.usersReferred = usersReferred;
		this.interviewList = interviewList;
		this.industryList = industryList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getIndustry() {
		return industry;
	}

	public void setIndustry(String industry) {
		this.industry = industry;
	}

	public String getResponsibilities() {
		return responsibilities;
	}

	public void setResponsibilities(String responsibilities) {
		this.responsibilities = responsibilities;
	}

	public String getWage() {
		return wage;
	}

	public void setWage(String wage) {
		this.wage = wage;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Double getRating() {
		return rating;
	}

	public void setRating(Double rating) {
		this.rating = rating;
	}

	public Double getExperienceNeeded() {
		return experienceNeeded;
	}

	public void setExperienceNeeded(Double experienceNeeded) {
		this.experienceNeeded = experienceNeeded;
	}

	public Integer getApplicantsApplied() {
		return applicantsApplied;
	}

	public void setApplicantsApplied(Integer applicantsApplied) {
		this.applicantsApplied = applicantsApplied;
	}

	public Collection<Companies> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(Collection<Companies> companyList) {
		this.companyList = companyList;
	}

	public Collection<Keywords> getKeywordsList() {
		return keywordsList;
	}

	public void setKeywordsList(Collection<Keywords> keywordsList) {
		this.keywordsList = keywordsList;
	}

	public Locations getLocation() {
		return location;
	}

	public void setLocation(Locations location) {
		this.location = location;
	}

	public Collection<User> getUsersApplied() {
		return usersApplied;
	}

	public void setUsersApplied(Collection<User> usersApplied) {
		this.usersApplied = usersApplied;
	}

	public Collection<User> getUsersQualified() {
		return usersQualified;
	}

	public void setUsersQualified(Collection<User> usersQualified) {
		this.usersQualified = usersQualified;
	}

	public Collection<User> getUsersSaved() {
		return usersSaved;
	}

	public void setUsersSaved(Collection<User> usersSaved) {
		this.usersSaved = usersSaved;
	}

	public Collection<User> getUsersReferred() {
		return usersReferred;
	}

	public void setUsersReferred(Collection<User> usersReferred) {
		this.usersReferred = usersReferred;
	}

	public Collection<Interview> getInterviewList() {
		return interviewList;
	}

	public void setInterviewList(Collection<Interview> interviewList) {
		this.interviewList = interviewList;
	}

	public Collection<Industry> getIndustryList() {
		return industryList;
	}

	public void setIndustryList(Collection<Industry> industryList) {
		this.industryList = industryList;
	}
	
	
}
