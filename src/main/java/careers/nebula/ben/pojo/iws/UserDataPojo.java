/**
 * 
 */
package careers.nebula.ben.pojo.iws;

import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.Analytics;
import careers.nebula.ben.db.enitity.Coaches;
import careers.nebula.ben.db.enitity.Experiences;
import careers.nebula.ben.db.enitity.Extracurricular;
import careers.nebula.ben.db.enitity.Highschool;
import careers.nebula.ben.db.enitity.Industry;
import careers.nebula.ben.db.enitity.Interests;
import careers.nebula.ben.db.enitity.Interview;
import careers.nebula.ben.db.enitity.Jobs;
import careers.nebula.ben.db.enitity.Keywords;
import careers.nebula.ben.db.enitity.Languages;
import careers.nebula.ben.db.enitity.Locations;
import careers.nebula.ben.db.enitity.Qualification;
import careers.nebula.ben.db.enitity.Resume;
import careers.nebula.ben.db.enitity.Students;
import careers.nebula.ben.db.enitity.TestResult;
import careers.nebula.ben.db.enitity.Transcript;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class UserDataPojo {

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
	private String twitter_info;
	private String locale;
	private String goals;
	private String aboutMe;
	private Boolean currentlyEmployeed;
	private Boolean currentlyInSchool;
	private String highestQualification; 
	private Double user_rating; 
	private Boolean active; 
	private Boolean coach;
	private Boolean student;
	private String dob;
	private String gender;
	private Integer age;
	private Collection<Locations> locationList = new ArrayList<Locations>();
	private Collection<Highschool> highschoolList = new ArrayList<Highschool>();
	private Collection<Qualification> qualificationList = new ArrayList<Qualification>();
	private Collection<Keywords> keywordList = new ArrayList<Keywords>();
	private Collection<Experiences> experienceList = new ArrayList<Experiences>();
	private Collection<Coaches> coachList = new ArrayList<Coaches>();
	private Collection<Students> studentsList = new ArrayList<Students>();
	private Collection<Extracurricular> extracurricularList = new ArrayList<Extracurricular>();
	private Collection<Languages> languageList = new ArrayList<Languages>();
	private Collection<Interests> interestList = new ArrayList<Interests>();
	private Collection<Industry> industryList = new ArrayList<Industry>();
	private Collection<Resume> resumeList = new ArrayList<Resume>();
	private Collection<Transcript> transcriptList = new ArrayList<Transcript>();
	private Collection<TestResult> testList = new ArrayList<TestResult>();
	private Collection<Analytics> analyticsList = new ArrayList<Analytics>();
	private Collection<Jobs> jobsApplied = new ArrayList<Jobs>();
	private Collection<Jobs> jobsQualified = new ArrayList<Jobs>();
	private Collection<Jobs> jobsSaved = new ArrayList<Jobs>();
	private Collection<Jobs> jobsReferred = new ArrayList<Jobs>();
	private Collection<Interview> userInterviews = new ArrayList<Interview>();
	
	public UserDataPojo(){
		
	}
	
	public UserDataPojo(Integer id, String gender, Integer age, String dob, String firstName, String lastName, String preferredName, String phoneNumber, String email, String photoUrl, String videoUrl, String personalWebsiteUrl, String fb_info, String twitter_info, String locale, String goals, String aboutMe, Boolean currentlyEmployeed, Boolean currentlyInSchool, String highestQualification, Double user_rating, Boolean active, Collection<Locations> locationList, Collection<Highschool> highschoolList, Collection<Qualification> qualificationList, Collection<Keywords> keywordList, Collection<Experiences> experienceList, Collection<Coaches> coachList, Collection<Students> studentList, Collection<Extracurricular> extracurricularList, Collection<Resume> resumeList , Collection<Transcript> transcriptList, Collection<Languages> languageList , Collection<Interests> interestList,Collection<Industry> industryList, Collection<TestResult> testList, Collection<Analytics> analyticsList, Boolean student, Boolean coach, Collection<Jobs> jobsApplied, Collection<Jobs> jobsQualified, Collection<Jobs> jobsSaved, Collection<Jobs> jobsReferred, Collection<Interview> userInterviews){
		this.id = id;
		this.dob = dob;
		this.age = age;
		this.firstName = firstName;
		this.lastName = lastName;
		this.preferredName = preferredName;
		this.phoneNumber = phoneNumber;
		this.email = email;
		this.photoUrl = photoUrl;
		this.videoUrl = videoUrl;
		this.personalWebsiteUrl = personalWebsiteUrl;
		this.fb_info = fb_info;
		this.twitter_info = twitter_info;
		this.locale = locale;
		this.goals = goals;
		this.aboutMe = aboutMe;
		this.currentlyEmployeed = currentlyEmployeed;
		this.currentlyInSchool = currentlyInSchool;
		this.highestQualification = highestQualification;
		this.user_rating = user_rating;
		this.active = active;
		this.locationList = locationList;
		this.highschoolList = highschoolList;
		this.qualificationList = qualificationList;
		this.keywordList = keywordList;
		this.experienceList = experienceList;
		this.coachList = coachList;
		this.studentsList = studentList;
		this.extracurricularList = extracurricularList;
		this.industryList = industryList;
		this.interestList = interestList;
		this.languageList = languageList;
		this.student = student;
		this.coach = coach;
		this.gender = gender;
		this.resumeList = resumeList;
		this.transcriptList = transcriptList;
		this.testList = testList;
		this.analyticsList = analyticsList;
		this.jobsApplied = jobsApplied;
		this.jobsQualified = jobsQualified;
		this.jobsReferred = jobsReferred;
		this.jobsSaved = jobsSaved;
		this.userInterviews = userInterviews;
	}
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
	public Boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
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

	public String getTwitter_info() {
		return twitter_info;
	}

	public void setTwitter_info(String twitter_info) {
		this.twitter_info = twitter_info;
	}

	public String getLocale() {
		return locale;
	}

	public void setLocale(String locale) {
		this.locale = locale;
	}

	public Collection<Qualification> getQualificationList() {
		return qualificationList;
	}

	public void setQualificationList(Collection<Qualification> qualificationList) {
		this.qualificationList = qualificationList;
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
	
	
	
}
