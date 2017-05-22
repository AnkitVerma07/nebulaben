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
@Table (name = "users")
public class User {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	private String firstName;  
	private String lastName;
	private String preferredName;
	private String phoneNumber;
	private String email;
	private String photoUrl;
	private String videoUrl;
	private String personalWebsiteUrl;
	private String fb_info;
	private String goals;
	private String aboutMe;
	private Boolean currentlyEmployeed;
	private Boolean currentlyInSchool;
	private String highestQualification;
	private Double user_rating;
	private Boolean coach;
	private Boolean student;
	private Boolean active;
	private String dob;
	private String gender;
	private String locale;
	private String twitter_info;
	private Integer age;
	private String hashed_password;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_survey_taken",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="survey_taken")
	)
	private Collection<SurveyTaken> surveyTakenList = new ArrayList<SurveyTaken>();
	
	
	@OneToOne(fetch = FetchType.LAZY)
	@PrimaryKeyJoinColumn
	private AssestmentTaken assestmentTaken;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_locations",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="location_id")
	)
	private Collection<Locations> locationList = new ArrayList<Locations>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_highschool",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="highschool_id")
	)
	private Collection<Highschool> highschoolList = new ArrayList<Highschool>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_qualification",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="uni_id")
	)
	private Collection<Qualification> universityList = new ArrayList<Qualification>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_keywords",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="keyword_id")
	)
	private Collection<Keywords> keywordList = new ArrayList<Keywords>();
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_extracurricular",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="extracurricular_id")
	)
	private Collection<Extracurricular> extracurricularList = new ArrayList<Extracurricular>();
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_languages",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="language_id")
	)
	private Collection<Languages> languageList = new ArrayList<Languages>();
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_interest",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="interest_id")
	)
	private Collection<Interests> interestList = new ArrayList<Interests>();
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_industry",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="industry_id")
	)
	private Collection<Industry> industryList = new ArrayList<Industry>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_experience",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="experience_id")
	)
	private Collection<Experiences> experienceList = new ArrayList<Experiences>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_coach",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="coach_id")
	)
	private Collection<Coaches> coachList = new ArrayList<Coaches>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_student",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="student_id")
	)
	private Collection<Students> studentsList = new ArrayList<Students>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_resume",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="resume_id")
	)
	private Collection<Resume> resumeList = new ArrayList<Resume>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_transcript",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="transcript_id")
	)
	private Collection<Transcript> transcriptList = new ArrayList<Transcript>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_tests",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="test_id")
	)
	private Collection<TestResult> testList = new ArrayList<TestResult>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_analytics",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="analytics_id")
	)
	private Collection<Analytics> analyticsList = new ArrayList<Analytics>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_jobs_applied",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="job_id")
	)
	private Collection<Jobs> jobsApplied = new ArrayList<Jobs>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_jobs_qualify",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="job_id")
	)
	private Collection<Jobs> jobsQualified = new ArrayList<Jobs>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_jobs_saved",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="job_id")
	)
	private Collection<Jobs> jobsSaved = new ArrayList<Jobs>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_jobs_referred",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="job_id")
	)
	private Collection<Jobs> jobsReferred = new ArrayList<Jobs>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="user_interview",
			joinColumns=@JoinColumn(name="user_id"), 
			inverseJoinColumns=@JoinColumn(name="interview_id")
	)
	private Collection<Interview> userInterviews = new ArrayList<Interview>();
	
	
	public Boolean isActive() {
		return active;
	}
	public void setActive(Boolean active) {
		this.active = active;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public String getPreferredName() {
		return preferredName;
	}
	public void setPreferredName(String preferredName) {
		this.preferredName = preferredName;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhotoUrl() {
		return photoUrl;
	}
	public void setPhotoUrl(String photoUrl) {
		this.photoUrl = photoUrl;
	}
	public String getVideoUrl() {
		return videoUrl;
	}
	public void setVideoUrl(String videoUrl) {
		this.videoUrl = videoUrl;
	}
	public String getPersonalWebsiteUrl() {
		return personalWebsiteUrl;
	}
	public void setPersonalWebsiteUrl(String personalWebsiteUrl) {
		this.personalWebsiteUrl = personalWebsiteUrl;
	}
	public String getGoals() {
		return goals;
	}
	public void setGoals(String goals) {
		this.goals = goals;
	}
	public String getAboutMe() {
		return aboutMe;
	}
	public void setAboutMe(String aboutMe) {
		this.aboutMe = aboutMe;
	}
	public Boolean getCurrentlyEmployeed() {
		return currentlyEmployeed;
	}
	public void setCurrentlyEmployeed(Boolean currentlyEmployeed) {
		this.currentlyEmployeed = currentlyEmployeed;
	}
	public Boolean getCurrentlyInSchool() {
		return currentlyInSchool;
	}
	public void setCurrentlyInSchool(Boolean currentlyInSchool) {
		this.currentlyInSchool = currentlyInSchool;
	}
	public String getHighestQualification() {
		return highestQualification;
	}
	public void setHighestQualification(String highestQualification) {
		this.highestQualification = highestQualification;
	}
	public Double getUser_rating() {
		return user_rating;
	}
	public void setUser_rating(Double user_rating) {
		this.user_rating = user_rating;
	}
	public Collection<Locations> getLocationList() {
		return locationList;
	}
	public void setLocationList(Collection<Locations> locationList) {
		this.locationList = locationList;
	}
	public Collection<Highschool> getHighschoolList() {
		return highschoolList;
	}
	public void setHighschoolList(Collection<Highschool> highschoolList) {
		this.highschoolList = highschoolList;
	}
	public Collection<Qualification> getUniversityList() {
		return universityList;
	}
	public void setUniversityList(Collection<Qualification> universityList) {
		this.universityList = universityList;
	}
	public Collection<Keywords> getKeywordList() {
		return keywordList;
	}
	public void setKeywordList(Collection<Keywords> keywordList) {
		this.keywordList = keywordList;
	}
	public Collection<Experiences> getExperienceList() {
		return experienceList;
	}
	public void setExperienceList(Collection<Experiences> experienceList) {
		this.experienceList = experienceList;
	}
	public Collection<Coaches> getCoachList() {
		return coachList;
	}
	public void setCoachList(Collection<Coaches> coachList) {
		this.coachList = coachList;
	}
	public Collection<Students> getStudentsList() {
		return studentsList;
	}
	public void setStudentsList(Collection<Students> studentsList) {
		this.studentsList = studentsList;
	}
	public Collection<Extracurricular> getExtracurricularList() {
		return extracurricularList;
	}
	public void setExtracurricularList(Collection<Extracurricular> extracurricularList) {
		this.extracurricularList = extracurricularList;
	}
	public Collection<Languages> getLanguageList() {
		return languageList;
	}
	public void setLanguageList(Collection<Languages> languageList) {
		this.languageList = languageList;
	}
	public Collection<Interests> getInterestList() {
		return interestList;
	}
	public void setInterestList(Collection<Interests> interestList) {
		this.interestList = interestList;
	}
	public Collection<Industry> getIndustryList() {
		return industryList;
	}
	public void setIndustryList(Collection<Industry> industryList) {
		this.industryList = industryList;
	}
	public Boolean isCoach() {
		return coach;
	}
	public void setCoach(Boolean coach) {
		this.coach = coach;
	}
	public Boolean isStudent() {
		return student;
	}
	public void setStudent(Boolean student) {
		this.student = student;
	}
	public String getDob() {
		return dob;
	}
	public void setDob(String dob) {
		this.dob = dob;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public Collection<Resume> getResumeList() {
		return resumeList;
	}
	public void setResumeList(Collection<Resume> resumeList) {
		this.resumeList = resumeList;
	}
	public Collection<Transcript> getTranscriptList() {
		return transcriptList;
	}
	public void setTranscriptList(Collection<Transcript> transcriptList) {
		this.transcriptList = transcriptList;
	}
	public String getFb_info() {
		return fb_info;
	}
	public void setFb_info(String fb_info) {
		this.fb_info = fb_info;
	}
	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	public String getTwitter_info() {
		return twitter_info;
	}
	public void setTwitter_info(String twitter_info) {
		this.twitter_info = twitter_info;
	}
	public Collection<TestResult> getTestList() {
		return testList;
	}
	public void setTestList(Collection<TestResult> testList) {
		this.testList = testList;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public Collection<Analytics> getAnalyticsList() {
		return analyticsList;
	}
	public void setAnalyticsList(Collection<Analytics> analyticsList) {
		this.analyticsList = analyticsList;
	}
	public Collection<Jobs> getJobsApplied() {
		return jobsApplied;
	}
	public void setJobsApplied(Collection<Jobs> jobsApplied) {
		this.jobsApplied = jobsApplied;
	}
	public Collection<Jobs> getJobsQualified() {
		return jobsQualified;
	}
	public void setJobsQualified(Collection<Jobs> jobsQualified) {
		this.jobsQualified = jobsQualified;
	}
	public Collection<Jobs> getJobsSaved() {
		return jobsSaved;
	}
	public void setJobsSaved(Collection<Jobs> jobsSaved) {
		this.jobsSaved = jobsSaved;
	}
	public Collection<Jobs> getJobsReferred() {
		return jobsReferred;
	}
	public void setJobsReferred(Collection<Jobs> jobsReferred) {
		this.jobsReferred = jobsReferred;
	}
	public Collection<Interview> getUserInterviews() {
		return userInterviews;
	}
	public void setUserInterviews(Collection<Interview> userInterviews) {
		this.userInterviews = userInterviews;
	}
	public String getHashed_password() {
		return hashed_password;
	}
	public void setHashed_password(String hashed_password) {
		this.hashed_password = hashed_password;
	}

	public Collection<SurveyTaken> getSurveyTakenList() {
		return surveyTakenList;
	}
	public void setSurveyTakenList(Collection<SurveyTaken> surveyTakenList) {
		this.surveyTakenList = surveyTakenList;
	}
	public AssestmentTaken getAssestmentTaken() {
		return assestmentTaken;
	}
	public void setAssestmentTaken(AssestmentTaken assestmentTaken) {
		this.assestmentTaken = assestmentTaken;
	}

	
	
}
