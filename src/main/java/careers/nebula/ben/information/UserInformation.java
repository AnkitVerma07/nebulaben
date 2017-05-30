/**
 * 
 */
package careers.nebula.ben.information;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import careers.nebula.ben.db.enitity.Analytics;
import careers.nebula.ben.db.enitity.Experiences;
import careers.nebula.ben.db.enitity.Highschool;
import careers.nebula.ben.db.enitity.Qualification;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.db.repository.UserRepo;
import careers.nebula.ben.pojo.iws.AnalyticsDataPojo;
import careers.nebula.ben.pojo.iws.UserDataPojo;
import careers.nebula.ben.pojos.ResponseIntegerList;
import careers.nebula.ben.pojos.TimelinePojo;
import careers.nebula.ben.service.HelperMethods;

/**
 * @author Ankit_Nebula
 *
 */
public class UserInformation {

	private UserRepo userRepo;
	private User userEntity;
	private HelperMethods methods;
	private Analytics analyticsEntity;
	private AnalyticsDataPojo analyticsdatapojo;
	
	public User InsertPrimaryUserInfo(UserDataPojo userData){	
		userEntity = new User();
		methods = new HelperMethods();
		userEntity.setDob(userData.getDob());
		if(userData.getDob() != null){
			userEntity.setAge(methods.ageCalculator(userData.getDob()));
		}	
		userEntity.setFirstName(userData.getFirstName());
		userEntity.setLastName(userData.getLastName());
		userEntity.setHashed_password(userData.getHashed_password());
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
		userpojo.setHashed_password(userEntity.getHashed_password());
		return userpojo;
	}
	
	public TimelinePojo getPrimaryUserTimelineInfo(int id){
		TimelinePojo timeline = new TimelinePojo();
		userRepo = new UserRepo();
		userEntity = new User();
		userEntity = userRepo.getUserData(id);
		Collection<Experiences> expList = new ArrayList<Experiences>();
		expList = userEntity.getExperienceList();
		Collection<Qualification> qualList = new ArrayList<Qualification>();
		qualList = userEntity.getUniversityList();
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		hsList = userEntity.getHighschoolList();
		Map<String, Experiences> expMap = new HashMap<String, Experiences>();
		for(Experiences e : expList){
			expMap.put(e.getStart_date(), e);
		}
		Map<String, Qualification> qualMap = new HashMap<String, Qualification>();
		for(Qualification q : qualList){
			qualMap.put(q.getYear_started(), q);
		}
		Map<String, Highschool> hsMap = new HashMap<String, Highschool>();
		for(Highschool hs : hsList){
			hsMap.put(hs.getYear_started(), hs);
		}
		timeline.setExpMap(expMap);
		timeline.setHsMap(hsMap);
		timeline.setQualMap(qualMap);
		return timeline;
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

	public Integer getUserIdByEmail(String email) {
		userEntity = new User();
		userRepo = new UserRepo();
		Integer id = 0;
		List<User> userData = new ArrayList<User>();
		userData = userRepo.LocateUserByEmail(email);
		if(userData.isEmpty()){
			id = 0;
		}
		for(User users : userData){
			id = users.getId();
		} 
		return id;
	}
	
	public Analytics InsertUserAnalytics(int id, AnalyticsDataPojo analyticsData){	
	 	userEntity = new User();
		userRepo = new UserRepo();
		userEntity = userRepo.getUserData(id);
		analyticsEntity = new Analytics();
		analyticsEntity.setUser_comparePeers_used(analyticsData.getUser_comparePeers_used());
		analyticsEntity.setUser_login_count(analyticsData.getUser_login_count());
		analyticsEntity.setUser_profile_viewed(analyticsData.getUser_profile_viewed());
		analyticsEntity.setUser_SuggestCourse_used(analyticsData.getUser_SuggestCourse_used());
		userEntity.getAnalyticsList().add(analyticsEntity);
		userRepo = new UserRepo();
		userRepo.InsertAnalyticsData(userEntity, analyticsEntity);
		return analyticsEntity;
	}
	
	public AnalyticsDataPojo getAnalyticsById(int id) {
		userRepo = new UserRepo();
		analyticsEntity = new Analytics();
		 analyticsdatapojo = new AnalyticsDataPojo();
		 analyticsEntity = userRepo.getAnalyticsData(id);
		 analyticsdatapojo.setId(analyticsEntity.getId());
		 analyticsdatapojo.setUser_comparePeers_used(analyticsEntity.getUser_comparePeers_used());
		 analyticsdatapojo.setUser_login_count(analyticsEntity.getUser_login_count());
		 analyticsdatapojo.setUser_profile_viewed(analyticsEntity.getUser_profile_viewed());
		 analyticsdatapojo.setUser_SuggestCourse_used(analyticsEntity.getUser_SuggestCourse_used());
		return analyticsdatapojo;
	}
	
	public ResponseIntegerList getUserAnalyticsList(int id) {
		userRepo = new UserRepo();
		userEntity = new User();
		userEntity = userRepo.getUserData(id);  
		Collection<Analytics> analyticsList = new ArrayList<Analytics>();
		List<Integer> analyticIDs = new ArrayList<Integer>();
		analyticsList = userEntity.getAnalyticsList();
		for(Analytics a : analyticsList){
			analyticIDs.add(a.getId());
		}
		ResponseIntegerList list = new ResponseIntegerList();
		list.setList(analyticIDs);
		return list;
	}
	
	public Analytics UpdateAnalyticsInformation(AnalyticsDataPojo analyticsData){
		analyticsEntity = new Analytics();
		userRepo = new UserRepo();
		int id = analyticsData.getId();	
		analyticsEntity = userRepo.getAnalyticsData(id);	
		if(analyticsData.getUser_profile_viewed() == null){
			analyticsEntity.setUser_profile_viewed(analyticsEntity.getUser_profile_viewed());
		} else {
			analyticsEntity.setUser_profile_viewed(analyticsData.getUser_profile_viewed());
		}
		if(analyticsData.getUser_comparePeers_used() == null){
			analyticsEntity.setUser_comparePeers_used(analyticsEntity.getUser_comparePeers_used());
		} else {
			analyticsEntity.setUser_comparePeers_used(analyticsData.getUser_comparePeers_used());
		}
		if(analyticsData.getUser_login_count() == null){
			analyticsEntity.setUser_login_count(analyticsEntity.getUser_login_count());
		} else {
			analyticsEntity.setUser_login_count(analyticsData.getUser_login_count());
		}
		if(analyticsData.getUser_SuggestCourse_used() == null){
			analyticsEntity.setUser_SuggestCourse_used(analyticsEntity.getUser_SuggestCourse_used());
		} else {
			analyticsEntity.setUser_SuggestCourse_used(analyticsData.getUser_SuggestCourse_used());
		}
		userRepo = new UserRepo();
		userRepo.updateAnalyticsData(analyticsEntity);
		return analyticsEntity;
	}

	public User checkUserLogin(String email, String password) {
		userEntity = new User();
		userRepo = new UserRepo();
		List<User> userData = new ArrayList<User>();
		
		userData = userRepo.LocateUserByEmail(email);
		if(userData.isEmpty()){
			System.out.println("error no user found by given email");
		}
		if(userData.get(0).getHashed_password().equals(password)){
			return userData.get(0);
		} else {
			System.out.println("return error wrong password");
		}
		return userEntity;
	}
}
