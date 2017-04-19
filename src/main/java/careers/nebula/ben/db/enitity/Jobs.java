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
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Ankit_Nebula
 *
 */
@Entity
@Table (name = "jobs")
public class Jobs {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	private String title;
	private String industry;
	private String responsibilities;
	private String wage;
	private String type;
	private Double rating;
	private Double experienceNeeded;
	private Integer applicantsApplied;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "jobsList", cascade = CascadeType.ALL)
	private Collection<Companies> companyList = new ArrayList<Companies>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="jobs_keywords",
			joinColumns=@JoinColumn(name="job_id"), 
			inverseJoinColumns=@JoinColumn(name="keyword_id")
	)
	private Collection<Keywords> keywordList = new ArrayList<Keywords>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="jobs_industry",
			joinColumns=@JoinColumn(name="job_id"), 
			inverseJoinColumns=@JoinColumn(name="industry_id")
	)
	private Collection<Industry> industryList = new ArrayList<Industry>();
	
	@OneToOne(fetch=FetchType.EAGER, cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	private Locations location = new Locations();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "jobsApplied", cascade = CascadeType.ALL)
	private Collection<User> usersApplied = new ArrayList<User>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "jobsQualified", cascade = CascadeType.ALL)
	private Collection<User> usersQualified = new ArrayList<User>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "jobsSaved", cascade = CascadeType.ALL)
	private Collection<User> usersSaved = new ArrayList<User>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "jobsReferred", cascade = CascadeType.ALL)
	private Collection<User> usersReferred = new ArrayList<User>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="job_interviews",
			joinColumns=@JoinColumn(name="job_id"), 
			inverseJoinColumns=@JoinColumn(name="interview_id")
	)
	private Collection<Interview> interviewList = new ArrayList<Interview>();

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

	public Collection<Keywords> getKeywordList() {
		return keywordList;
	}

	public void setKeywordList(Collection<Keywords> keywordList) {
		this.keywordList = keywordList;
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
