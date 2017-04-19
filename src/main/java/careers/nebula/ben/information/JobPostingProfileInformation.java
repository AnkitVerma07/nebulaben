package careers.nebula.ben.information;

import careers.nebula.ben.db.enitity.Analytics;
import careers.nebula.ben.db.enitity.Jobs;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.db.repository.UserRepo;
import careers.nebula.ben.pojo.iws.AnalyticsDataPojo;
import careers.nebula.ben.pojo.iws.IndustryDataPojo;
import careers.nebula.ben.pojo.iws.JobsDataPojo;
import careers.nebula.ben.pojo.iws.KeywordsDataPojo;
import careers.nebula.ben.pojo.iws.LocationDataPojo;
import careers.nebula.ben.pojo.iws.UserDataPojo;
import careers.nebula.ben.service.HelperMethods;

/**
 * @author Ankit_Nebula
 *
 */
public class JobPostingProfileInformation {


	private UserRepo userRepo;
	private User userEntity;
	private HelperMethods methods;
	private Analytics analyticsEntity;
	private AnalyticsDataPojo analyticsdatapojo;
	
	public User InsertPrimaryUserInfo(UserDataPojo userData){	
		userEntity = new User();
		methods = new HelperMethods();
		userEntity.setDob(userData.getDob());
		userEntity.setAge(methods.ageCalculator(userData.getDob()));
		userEntity.setFirstName(userData.getFirstName());
		userEntity.setLastName(userData.getLastName());
		userEntity.setPreferredName(userData.getPreferredName());
		userEntity.setPhoneNumber(userData.getPhoneNumber());
		userEntity.setEmail(userData.getEmail());
		userEntity.setCurrentlyInSchool(userData.getCurrentlyInSchool());
		userEntity.setCurrentlyEmployeed(userData.getCurrentlyEmployeed());
		userEntity.setGoals(userData.getGoals());
		userEntity.setAboutMe(userData.getAboutMe());
		userEntity.setPhotoUrl(userData.getPhotoUrl());
		userEntity.setVideoUrl(userData.getVideoUrl());
		userEntity.setFb_info(userData.getFb_info());
		userEntity.setTwitter_info(userData.getTwitter_info());
		userEntity.setLocale(userData.getLocale());
		userEntity.setUser_rating(userData.getUser_rating());
		userEntity.setActive(userData.isActive());
		userEntity.setStudent(userData.isStudent());
		userEntity.setCoach(userData.isCoach());
		userEntity.setPersonalWebsiteUrl(userData.getPersonalWebsiteUrl());
		userEntity.setHighestQualification(userData.getHighestQualification());
		userEntity.setGender(userData.getGender());
		userRepo = new UserRepo();
		userRepo.InsertUserData(userEntity);
		return userEntity;
	}

	public UserDataPojo getPrimaryUserInfo(int id) {
		userRepo = new UserRepo();
		userEntity = new User();
		UserDataPojo userpojo = new UserDataPojo();
		userEntity = userRepo.getUserData(id);
		userpojo.setId(userEntity.getId());
		userpojo.setDob(userEntity.getDob());
		userpojo.setAge(userEntity.getAge());
		userpojo.setFirstName(userEntity.getFirstName());
		userpojo.setLastName(userEntity.getLastName());
		userpojo.setPreferredName(userEntity.getPreferredName());
		userpojo.setPhoneNumber(userEntity.getPhoneNumber());
		userpojo.setEmail(userEntity.getEmail());
		userpojo.setCurrentlyInSchool(userEntity.getCurrentlyInSchool());
		userpojo.setCurrentlyEmployeed(userEntity.getCurrentlyEmployeed());
		userpojo.setGoals(userEntity.getGoals());
		userpojo.setAboutMe(userEntity.getAboutMe());
		userpojo.setPhotoUrl(userEntity.getPhotoUrl());
		userpojo.setVideoUrl(userEntity.getVideoUrl());
		userpojo.setFb_info(userEntity.getFb_info());
		userpojo.setTwitter_info(userEntity.getTwitter_info());
		userpojo.setLocale(userEntity.getLocale());
		userpojo.setUser_rating(userEntity.getUser_rating());
		userpojo.setActive(userEntity.isActive());
		userpojo.setCoach(userEntity.isCoach());
		userpojo.setStudent(userEntity.isStudent());
		userpojo.setPersonalWebsiteUrl(userEntity.getPersonalWebsiteUrl());
		userpojo.setHighestQualification(userEntity.getHighestQualification());
		userpojo.setGender(userEntity.getGender());
		return userpojo;
	}
	
	public User UpdateUserInformation(UserDataPojo userData){
		userEntity = new User();
		userRepo = new UserRepo();
		methods = new HelperMethods();
		int id = userData.getId();	
		userEntity = userRepo.getUserData(id);	
		if(userData.getDob() == null){
			userEntity.setDob(userEntity.getDob());
		} else {
			userEntity.setDob(userData.getDob());
		}
		if(userData.getDob() != null){
			userEntity.setAge(methods.ageCalculator(userData.getDob()));
		}
		if(userData.getFirstName() == null){
			userEntity.setFirstName(userEntity.getFirstName());
		} else {
			userEntity.setFirstName(userData.getFirstName());
		}
		if(userData.getLastName() == null){
			userEntity.setLastName(userEntity.getLastName());
		} else {
			userEntity.setLastName(userData.getLastName());
		}
		if(userData.getPreferredName() == null){
			userEntity.setPreferredName(userEntity.getPreferredName());
		} else {
			userEntity.setPreferredName(userData.getPreferredName());
		}
		if(userData.getPhoneNumber() == null){
			userEntity.setPhoneNumber(userEntity.getPhoneNumber());
		} else {
			userEntity.setPhoneNumber(userData.getPhoneNumber());
		}
		if(userData.getEmail() == null){
			userEntity.setEmail(userEntity.getEmail());
		} else {
			userEntity.setEmail(userData.getEmail());
		}
		if(userData.getCurrentlyInSchool() == null){
			userEntity.setCurrentlyInSchool(userEntity.getCurrentlyInSchool());
		} else {
			userEntity.setCurrentlyInSchool(userData.getCurrentlyInSchool());
		}
		if(userData.getCurrentlyEmployeed() == null){
			userEntity.setCurrentlyEmployeed(userEntity.getCurrentlyEmployeed());
		} else {
			userEntity.setCurrentlyEmployeed(userData.getCurrentlyEmployeed());
		}
		if(userData.getGoals() == null){
			userEntity.setGoals(userEntity.getGoals());
		} else {
			userEntity.setGoals(userData.getGoals());
		}
		if(userData.getAboutMe() == null){
			userEntity.setAboutMe(userEntity.getAboutMe());
		} else {
			userEntity.setAboutMe(userData.getAboutMe());
		}
		if(userData.getPhotoUrl() == null){
			userEntity.setPhotoUrl(userEntity.getPhotoUrl());
		} else {
			userEntity.setPhotoUrl(userData.getPhotoUrl());
		}
		if(userData.getVideoUrl() == null){
			userEntity.setVideoUrl(userEntity.getVideoUrl());
		} else {
			userEntity.setVideoUrl(userData.getVideoUrl());
		}
		if(userData.getFb_info() == null){
			userEntity.setFb_info(userEntity.getFb_info());
		} else {
			userEntity.setFb_info(userData.getFb_info());
		}
		if(userData.getTwitter_info() == null){
			userEntity.setTwitter_info(userEntity.getTwitter_info());
		} else {
			userEntity.setTwitter_info(userData.getTwitter_info());
		}
		if(userData.getLocale() == null){
			userEntity.setLocale(userEntity.getLocale());
		} else {
			userEntity.setLocale(userData.getLocale());
		}
		if(userData.getUser_rating() == null){
			userEntity.setUser_rating(userEntity.getUser_rating());
		} else {
			userEntity.setUser_rating(userData.getUser_rating());
		}
		if(userData.isActive() == null){
			userEntity.setActive(userEntity.isActive());
		} else {
			userEntity.setActive(userData.isActive());
		}
		if(userData.getPersonalWebsiteUrl() == null){
			userEntity.setPersonalWebsiteUrl(userEntity.getPersonalWebsiteUrl());
		} else {
			userEntity.setPersonalWebsiteUrl(userData.getPersonalWebsiteUrl());
		}
		if(userData.getHighestQualification() == null){
			userEntity.setHighestQualification(userEntity.getHighestQualification());
		} else {
			userEntity.setHighestQualification(userData.getHighestQualification());
		}
		if(userData.isStudent() == null){
			userEntity.setStudent(userEntity.isStudent());
		} else {
			userEntity.setStudent(userData.isStudent());
		}
		if(userData.isCoach() == null){
			userEntity.setCoach(userEntity.isCoach());
		} else {
			userEntity.setCoach(userData.isCoach());
		}
		if(userData.getGender() == null){
			userEntity.setGender(userEntity.getGender());
		} else {
			userEntity.setGender(userData.getGender());
		}
		userRepo = new UserRepo();
		userRepo.updateUserdata(userEntity);
		return userEntity;
	}

	public Jobs InsertPrimaryJobInfo(int id, JobsDataPojo jobdata) {
		return null;
		 
		
	}

	public JobsDataPojo getPrimaryJobInfo(int id) {
		 
		return null;
	}

	public void UpdateJobsInformation(JobsDataPojo jobsData) {
		 
		
	}

	public void InsertPrimaryJobKeywordInfo(int id, KeywordsDataPojo keyworddata) {
		 
		
	}

	public void InsertPrimaryJobIndustryInfo(int id, IndustryDataPojo industryData) {
		 
		
	}

	public void InsertPrimaryJobLocationInfo(int id, LocationDataPojo locationData) {
		 
		
	}
}
