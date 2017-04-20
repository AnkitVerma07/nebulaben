/**
 * 
 */
package careers.nebula.ben.information;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import careers.nebula.ben.db.enitity.Companies;
import careers.nebula.ben.db.enitity.Courses;
import careers.nebula.ben.db.enitity.Experiences;
import careers.nebula.ben.db.enitity.Highschool;
import careers.nebula.ben.db.enitity.Majors;
import careers.nebula.ben.db.enitity.Qualification;
import careers.nebula.ben.db.enitity.Students;
import careers.nebula.ben.db.enitity.Universities;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.db.repository.UserProfileRepo;
import careers.nebula.ben.db.repository.UserRepo;
import careers.nebula.ben.pojos.ResponseCombinedList;
import careers.nebula.ben.service.CourseSuggestionServicing;

/**
 * @author Ankit_Nebula
 *
 */
public class CourseSuggestionInformation {

	private CourseSuggestionServicing courseSuggestion;
	private UserRepo userRepo;
	private User userEntity;
	private UserProfileRepo userpro;
	
	
	//Goals type:
	//1. I would like to MAJOR in.
	//2. I would like to enroll in UNIVERSITY.
	//3. I would like to pursue an experience in JOT TITLE.
	//4. I would like to join COMPANY NAME for an experience.
	//5. I would like to join the INDUSTRY for an experience. 
	public ResponseCombinedList getGoalsType(int id){
		ResponseCombinedList list = new ResponseCombinedList();
		userEntity = new User();
		userRepo = new UserRepo();
		userEntity = userRepo.getUserData(id);
		String goals = userEntity.getGoals();
		List<Majors> allMajors = new ArrayList<Majors>();
		userpro = new UserProfileRepo();
		allMajors = userpro.getAllMajorData();
		for(Majors m : allMajors){
			if(goals.toLowerCase().contains(m.getName()) == true){
				return goalsMajorsCourses(userEntity);
			}
		}
		List<Universities> allUnis = new ArrayList<Universities>();
		userpro = new UserProfileRepo();
		allUnis = userpro.getAllQualificationData();
		for(Universities c : allUnis){
			if(goals.toLowerCase().contains(c.getUni_name()) == true){
				return goalsUniNameCourses(userEntity);
			}
		}
		List<Experiences> allExperiences = new ArrayList<Experiences>();
		userpro = new UserProfileRepo();
		allExperiences = userpro.getAllExperienceData();
		for(Experiences c : allExperiences){
			if(goals.toLowerCase().contains(c.getJob_title()) == true){
				return goalsJobTitleCourses(userEntity);
			}
		}
		List<Companies> allcompanies = new ArrayList<Companies>();
		userpro = new UserProfileRepo();
		allcompanies = userpro.getAllCompanyData();
		for(Companies c : allcompanies){
			if(goals.toLowerCase().contains(c.getCompany_industry()) == true){
				return goalsCompanyIndustryCourses(userEntity);
			}
		}
		List<Companies> allcompaniesN = new ArrayList<Companies>();
		userpro = new UserProfileRepo();
		allcompaniesN = userpro.getAllCompanyData();
		for(Companies c : allcompaniesN){
			if(goals.toLowerCase().contains(c.getCompany_name()) == true){
				return goalsCompanyNameCourses(userEntity);
			}
		}
		return list;
	}
	
	public ResponseCombinedList goalsUniNameCourses(User userEntity){
		ResponseCombinedList list = new ResponseCombinedList();
		Collection<Highschool> hslist = new ArrayList<Highschool>();
		Collection<Courses> hscoursesList = new ArrayList<Courses>();
		List<String> userHSCourses = new ArrayList<String>();
		List<String> usersHSCourses = new ArrayList<String>();
		List<String> userHSSuggests = new ArrayList<String>();
		hslist = userEntity.getHighschoolList();
		for(Highschool hs : hslist){
			hscoursesList.addAll(hs.getCoursesList());
		}
		for(Courses c : hscoursesList){
			userHSCourses.add(c.getCourse_name());
		}
		courseSuggestion = new CourseSuggestionServicing();
		usersHSCourses = courseSuggestion.matchedUserHSCoursesByUniName(userEntity.getId());
		for(int i =0; i < usersHSCourses.size(); i++){
			if(!userHSCourses.contains(usersHSCourses.get(i))){
				userHSSuggests.add(usersHSCourses.get(i));
			}
		}
		list.setListone(userHSSuggests);
		
		Collection<Qualification> qualList = new ArrayList<Qualification>();
		Collection<Courses> unicoursesList = new ArrayList<Courses>();
		List<String> userUniCourses = new ArrayList<String>();
		List<String> usersUniCourses = new ArrayList<String>();
		List<String> userUniSuggests = new ArrayList<String>();
		qualList = userEntity.getUniversityList();
		for(Qualification q : qualList){
			unicoursesList.addAll(q.getCoursesList());
		}
		for(Courses c : unicoursesList){
			userUniCourses.add(c.getCourse_name());
		}
		courseSuggestion = new CourseSuggestionServicing();
		usersUniCourses = courseSuggestion.matchedUserUniCoursesByUniName(userEntity.getId());
		for(int i = 0; i < usersUniCourses.size(); i++){
			if(! userUniCourses.contains(usersUniCourses.get(i))){
				userUniSuggests.add(usersUniCourses.get(i));
			}
		}
		list.setListtwo(userUniSuggests);
		
		Collection<Students> stuList = new ArrayList<Students>();
		Collection<Courses> stucoursesList = new ArrayList<Courses>();
		List<String> userStuCourses = new ArrayList<String>();
		List<String> usersStuCourses = new ArrayList<String>();
		List<String> userStuSuggests = new ArrayList<String>();
		stuList = userEntity.getStudentsList();
		for(Students s : stuList){
			stucoursesList.addAll(s.getCoursesList());
		}
		for(Courses c : stucoursesList){
			userStuCourses.add(c.getCourse_name());
		}
		courseSuggestion = new CourseSuggestionServicing();
		usersStuCourses = courseSuggestion.matchedUserSkillCoursesByUniName(userEntity.getId());
		for(int i = 0; i < usersStuCourses.size(); i++){
			if(! userStuCourses.contains(usersStuCourses.get(i))){
				userStuSuggests.add(usersStuCourses.get(i));
			}
		}
		list.setListthree(userStuSuggests);
		return list;
	}
	
	public ResponseCombinedList goalsJobTitleCourses(User userEntity){
		ResponseCombinedList list = new ResponseCombinedList();
		Collection<Highschool> hslist = new ArrayList<Highschool>();
		Collection<Courses> hscoursesList = new ArrayList<Courses>();
		List<String> userHSCourses = new ArrayList<String>();
		List<String> usersHSCourses = new ArrayList<String>();
		List<String> userHSSuggests = new ArrayList<String>();
		hslist = userEntity.getHighschoolList();
		for(Highschool hs : hslist){
			hscoursesList.addAll(hs.getCoursesList());
		}
		for(Courses c : hscoursesList){
			userHSCourses.add(c.getCourse_name());
		}
		courseSuggestion = new CourseSuggestionServicing();
		usersHSCourses = courseSuggestion.matchedUserHSCoursesByJobTitle(userEntity.getId());
		for(int i =0; i < usersHSCourses.size(); i++){
			if(!userHSCourses.contains(usersHSCourses.get(i))){
				userHSSuggests.add(usersHSCourses.get(i));
			}
		}
		list.setListone(userHSSuggests);
		
		Collection<Qualification> qualList = new ArrayList<Qualification>();
		Collection<Courses> unicoursesList = new ArrayList<Courses>();
		List<String> userUniCourses = new ArrayList<String>();
		List<String> usersUniCourses = new ArrayList<String>();
		List<String> userUniSuggests = new ArrayList<String>();
		qualList = userEntity.getUniversityList();
		for(Qualification q : qualList){
			unicoursesList.addAll(q.getCoursesList());
		}
		for(Courses c : unicoursesList){
			userUniCourses.add(c.getCourse_name());
		}
		courseSuggestion = new CourseSuggestionServicing();
		usersUniCourses = courseSuggestion.matchedUserUniCoursesByJobTitle(userEntity.getId());
		for(int i = 0; i < usersUniCourses.size(); i++){
			if(! userUniCourses.contains(usersUniCourses.get(i))){
				userUniSuggests.add(usersUniCourses.get(i));
			}
		}
		list.setListtwo(userUniSuggests);
		
		Collection<Students> stuList = new ArrayList<Students>();
		Collection<Courses> stucoursesList = new ArrayList<Courses>();
		List<String> userStuCourses = new ArrayList<String>();
		List<String> usersStuCourses = new ArrayList<String>();
		List<String> userStuSuggests = new ArrayList<String>();
		stuList = userEntity.getStudentsList();
		for(Students s : stuList){
			stucoursesList.addAll(s.getCoursesList());
		}
		for(Courses c : stucoursesList){
			userStuCourses.add(c.getCourse_name());
		}
		courseSuggestion = new CourseSuggestionServicing();
		usersStuCourses = courseSuggestion.matchedUserSkillCoursesByJobTitle(userEntity.getId());
		for(int i = 0; i < usersStuCourses.size(); i++){
			if(! userStuCourses.contains(usersStuCourses.get(i))){
				userStuSuggests.add(usersStuCourses.get(i));
			}
		}
		list.setListthree(userStuSuggests);
		return list;
	} 
	
	public ResponseCombinedList goalsCompanyNameCourses(User userEntity){
		ResponseCombinedList list = new ResponseCombinedList();
		Collection<Highschool> hslist = new ArrayList<Highschool>();
		Collection<Courses> hscoursesList = new ArrayList<Courses>();
		List<String> userHSCourses = new ArrayList<String>();
		List<String> usersHSCourses = new ArrayList<String>();
		List<String> userHSSuggests = new ArrayList<String>();
		hslist = userEntity.getHighschoolList();
		for(Highschool hs : hslist){
			hscoursesList.addAll(hs.getCoursesList());
		}
		for(Courses c : hscoursesList){
			userHSCourses.add(c.getCourse_name());
		}
		courseSuggestion = new CourseSuggestionServicing();
		usersHSCourses = courseSuggestion.matchedUserHSCoursesByCompanyName(userEntity.getId());
		for(int i =0; i < usersHSCourses.size(); i++){
			if(!userHSCourses.contains(usersHSCourses.get(i))){
				userHSSuggests.add(usersHSCourses.get(i));
			}
		}
		list.setListone(userHSSuggests);
		
		Collection<Qualification> qualList = new ArrayList<Qualification>();
		Collection<Courses> unicoursesList = new ArrayList<Courses>();
		List<String> userUniCourses = new ArrayList<String>();
		List<String> usersUniCourses = new ArrayList<String>();
		List<String> userUniSuggests = new ArrayList<String>();
		qualList = userEntity.getUniversityList();
		for(Qualification q : qualList){
			unicoursesList.addAll(q.getCoursesList());
		}
		for(Courses c : unicoursesList){
			userUniCourses.add(c.getCourse_name());
		}
		courseSuggestion = new CourseSuggestionServicing();
		usersUniCourses = courseSuggestion.matchedUserUniCoursesByCompanyName(userEntity.getId());
		for(int i = 0; i < usersUniCourses.size(); i++){
			if(! userUniCourses.contains(usersUniCourses.get(i))){
				userUniSuggests.add(usersUniCourses.get(i));
			}
		}
		list.setListtwo(userUniSuggests);
		
		Collection<Students> stuList = new ArrayList<Students>();
		Collection<Courses> stucoursesList = new ArrayList<Courses>();
		List<String> userStuCourses = new ArrayList<String>();
		List<String> usersStuCourses = new ArrayList<String>();
		List<String> userStuSuggests = new ArrayList<String>();
		stuList = userEntity.getStudentsList();
		for(Students s : stuList){
			stucoursesList.addAll(s.getCoursesList());
		}
		for(Courses c : stucoursesList){
			userStuCourses.add(c.getCourse_name());
		}
		courseSuggestion = new CourseSuggestionServicing();
		usersStuCourses = courseSuggestion.matchedUserSkillCoursesByCompanyName(userEntity.getId());
		for(int i = 0; i < usersStuCourses.size(); i++){
			if(! userStuCourses.contains(usersStuCourses.get(i))){
				userStuSuggests.add(usersStuCourses.get(i));
			}
		}
		list.setListthree(userStuSuggests);
		return list;
	}
	
	public ResponseCombinedList goalsCompanyIndustryCourses(User userEntity){
		ResponseCombinedList list = new ResponseCombinedList();
		Collection<Highschool> hslist = new ArrayList<Highschool>();
		Collection<Courses> hscoursesList = new ArrayList<Courses>();
		List<String> userHSCourses = new ArrayList<String>();
		List<String> usersHSCourses = new ArrayList<String>();
		List<String> userHSSuggests = new ArrayList<String>();
		hslist = userEntity.getHighschoolList();
		for(Highschool hs : hslist){
			hscoursesList.addAll(hs.getCoursesList());
		}
		for(Courses c : hscoursesList){
			userHSCourses.add(c.getCourse_name());
		}
		courseSuggestion = new CourseSuggestionServicing();
		usersHSCourses = courseSuggestion.matchedUserHSCoursesByCompanyIndustry(userEntity.getId());
		for(int i =0; i < usersHSCourses.size(); i++){
			if(!userHSCourses.contains(usersHSCourses.get(i))){
				userHSSuggests.add(usersHSCourses.get(i));
			}
		}
		list.setListone(userHSSuggests);
		
		Collection<Qualification> qualList = new ArrayList<Qualification>();
		Collection<Courses> unicoursesList = new ArrayList<Courses>();
		List<String> userUniCourses = new ArrayList<String>();
		List<String> usersUniCourses = new ArrayList<String>();
		List<String> userUniSuggests = new ArrayList<String>();
		qualList = userEntity.getUniversityList();
		for(Qualification q : qualList){
			unicoursesList.addAll(q.getCoursesList());
		}
		for(Courses c : unicoursesList){
			userUniCourses.add(c.getCourse_name());
		}
		courseSuggestion = new CourseSuggestionServicing();
		usersUniCourses = courseSuggestion.matchedUserUniCoursesByCompanyIndustry(userEntity.getId());
		for(int i = 0; i < usersUniCourses.size(); i++){
			if(! userUniCourses.contains(usersUniCourses.get(i))){
				userUniSuggests.add(usersUniCourses.get(i));
			}
		}
		list.setListtwo(userUniSuggests);
		
		Collection<Students> stuList = new ArrayList<Students>();
		Collection<Courses> stucoursesList = new ArrayList<Courses>();
		List<String> userStuCourses = new ArrayList<String>();
		List<String> usersStuCourses = new ArrayList<String>();
		List<String> userStuSuggests = new ArrayList<String>();
		stuList = userEntity.getStudentsList();
		for(Students s : stuList){
			stucoursesList.addAll(s.getCoursesList());
		}
		for(Courses c : stucoursesList){
			userStuCourses.add(c.getCourse_name());
		}
		courseSuggestion = new CourseSuggestionServicing();
		usersStuCourses = courseSuggestion.matchedUserSkillCoursesByCompanyIndustry(userEntity.getId());
		for(int i = 0; i < usersStuCourses.size(); i++){
			if(! userStuCourses.contains(usersStuCourses.get(i))){
				userStuSuggests.add(usersStuCourses.get(i));
			}
		}
		list.setListthree(userStuSuggests);
		return list;
	}
	
	public ResponseCombinedList goalsMajorsCourses(User userEntity){
		ResponseCombinedList list = new ResponseCombinedList();
		Collection<Highschool> hslist = new ArrayList<Highschool>();
		Collection<Courses> hscoursesList = new ArrayList<Courses>();
		List<String> userHSCourses = new ArrayList<String>();
		List<String> usersHSCourses = new ArrayList<String>();
		List<String> userHSSuggests = new ArrayList<String>();
		hslist = userEntity.getHighschoolList();
		for(Highschool hs : hslist){
			hscoursesList.addAll(hs.getCoursesList());
		}
		for(Courses c : hscoursesList){
			userHSCourses.add(c.getCourse_name());
		}
		courseSuggestion = new CourseSuggestionServicing();
		usersHSCourses = courseSuggestion.matchedUserHSCoursesByMajors(userEntity.getId());
		for(int i =0; i < usersHSCourses.size(); i++){
			if(!userHSCourses.contains(usersHSCourses.get(i))){
				userHSSuggests.add(usersHSCourses.get(i));
			}
		}
		list.setListone(userHSSuggests);
		
		Collection<Qualification> qualList = new ArrayList<Qualification>();
		Collection<Courses> unicoursesList = new ArrayList<Courses>();
		List<String> userUniCourses = new ArrayList<String>();
		List<String> usersUniCourses = new ArrayList<String>();
		List<String> userUniSuggests = new ArrayList<String>();
		qualList = userEntity.getUniversityList();
		for(Qualification q : qualList){
			unicoursesList.addAll(q.getCoursesList());
		}
		for(Courses c : unicoursesList){
			userUniCourses.add(c.getCourse_name());
		}
		courseSuggestion = new CourseSuggestionServicing();
		usersUniCourses = courseSuggestion.matchedUserUniCoursesByMajors(userEntity.getId());
		for(int i = 0; i < usersUniCourses.size(); i++){
			if(! userUniCourses.contains(usersUniCourses.get(i))){
				userUniSuggests.add(usersUniCourses.get(i));
			}
		}
		list.setListtwo(userUniSuggests);
		
		Collection<Students> stuList = new ArrayList<Students>();
		Collection<Courses> stucoursesList = new ArrayList<Courses>();
		List<String> userStuCourses = new ArrayList<String>();
		List<String> usersStuCourses = new ArrayList<String>();
		List<String> userStuSuggests = new ArrayList<String>();
		stuList = userEntity.getStudentsList();
		for(Students s : stuList){
			stucoursesList.addAll(s.getCoursesList());
		}
		for(Courses c : stucoursesList){
			userStuCourses.add(c.getCourse_name());
		}
		courseSuggestion = new CourseSuggestionServicing();
		usersStuCourses = courseSuggestion.matchedUserSkillCoursesByMajors(userEntity.getId());
		for(int i = 0; i < usersStuCourses.size(); i++){
			if(! userStuCourses.contains(usersStuCourses.get(i))){
				userStuSuggests.add(usersStuCourses.get(i));
			}
		}
		list.setListthree(userStuSuggests);
		return list;
	}
	
}
