/**
 * 
 */
package careers.nebula.ben.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import careers.nebula.ben.db.enitity.Companies;
import careers.nebula.ben.db.enitity.Courses;
import careers.nebula.ben.db.enitity.Experiences;
import careers.nebula.ben.db.enitity.Highschool;
import careers.nebula.ben.db.enitity.Industry;
import careers.nebula.ben.db.enitity.Majors;
import careers.nebula.ben.db.enitity.Qualification;
import careers.nebula.ben.db.enitity.Universities;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.db.repository.EducationalRepo;
import careers.nebula.ben.db.repository.UserProfileRepo;
import careers.nebula.ben.db.repository.UserRepo;
import careers.nebula.ben.information.ExperienceInformation;
import careers.nebula.ben.information.QualificationsInformation;
import careers.nebula.ben.pojo.iws.ExperiencesDataPojo;
import careers.nebula.ben.pojo.iws.UserDataPojo;

/**
 * @author Ankit_Nebula
 *
 */
public class CourseSuggestionServicing {

	private UserRepo userRepo;
	private User userEntity;
	private UserProfileRepo userpro;
	private QualificationsInformation qualInfo;
	private ExperienceInformation expInfo;
	private UserDataPojo userdatapojo;
	private ExperiencesDataPojo expDataPojo;
	private EducationalRepo edurepo;
	private Courses courseEntity;
	
	public List<User> userGoalsMajorMatching(int id){
		List<User> userList = new ArrayList<User>();
		List<Integer> uniIds = new ArrayList<Integer>();
		List<Integer> userIds = new ArrayList<Integer>();
		List<Integer> qualIds = new ArrayList<Integer>();
		userEntity = new User();
		userRepo = new UserRepo();
		userEntity = userRepo.getUserData(id);
		String goals = userEntity.getGoals();
		List<Majors> allMajors = new ArrayList<Majors>();
		userpro = new UserProfileRepo();
		allMajors = userpro.getAllMajorData();
		for(Majors m : allMajors){
			if(goals.toLowerCase().contains(m.getName()) == true){
				uniIds.add(m.getId());
			}
		}
		for(Integer i : uniIds){
			qualInfo = new QualificationsInformation();
			qualIds.addAll(qualInfo.getQualByMajorId(i));
		}
		for(Integer i : qualIds){
			qualInfo = new QualificationsInformation();
			userdatapojo = new UserDataPojo();
			userdatapojo = qualInfo.getUserByQualId(i);
			userIds.add(userdatapojo.getId());
		}
	     int size = userIds.size();
	     for (int i = 0; i < size - 1; i++) {
	         for (int j = i + 1; j < size; j++) {
	             if (!userIds.get(j).equals(userIds.get(i)))
	                 continue;
	             userIds.remove(j);
	             j--; 
	             size--;
	         } 
	     }  
		for(Integer i : userIds){
			userRepo = new UserRepo();
			userList.add(userRepo.getUserData(i));
		}
		return userList;	
	}
	
	public List<User> userGoalsUniNameMatching(int id){
		List<User> userList = new ArrayList<User>();
		List<Integer> uniIds = new ArrayList<Integer>();
		List<Integer> userIds = new ArrayList<Integer>();
		List<Integer> qualIds = new ArrayList<Integer>();
		userEntity = new User();
		userRepo = new UserRepo();
		userEntity = userRepo.getUserData(id);
		String goals = userEntity.getGoals();
		List<Universities> allUnis = new ArrayList<Universities>();
		userpro = new UserProfileRepo();
		allUnis = userpro.getAllQualificationData();
		for(Universities c : allUnis){
			if(goals.toLowerCase().contains(c.getUni_name()) == true){
				uniIds.add(c.getId());
			}
		}
		for(Integer i : uniIds){
			qualInfo = new QualificationsInformation();
			qualIds.addAll(qualInfo.getQualByUniId(i));
		}
		for(Integer i : qualIds){
			qualInfo = new QualificationsInformation();
			userdatapojo = new UserDataPojo();
			userdatapojo = qualInfo.getUserByQualId(i);
			userIds.add(userdatapojo.getId());
		}
	     int size = userIds.size();
	     for (int i = 0; i < size - 1; i++) {
	         for (int j = i + 1; j < size; j++) {
	             if (!userIds.get(j).equals(userIds.get(i)))
	                 continue;
	             userIds.remove(j);
	             j--; 
	             size--;
	         } 
	     }  
		for(Integer i : userIds){
			userRepo = new UserRepo();
			userList.add(userRepo.getUserData(i));
		}
		return userList;
	}
	
	public List<User> userGoalsJobTitleMatching(int id){
		List<User> userList = new ArrayList<User>();
		List<Experiences> expList = new ArrayList<Experiences>();
		List<Integer> userIds = new ArrayList<Integer>();
		userEntity = new User();
		userRepo = new UserRepo();
		userEntity = userRepo.getUserData(id);
		String goals = userEntity.getGoals();
		List<Experiences> allExperiences = new ArrayList<Experiences>();
		userpro = new UserProfileRepo();
		allExperiences = userpro.getAllExperienceData();
		for(Experiences c : allExperiences){
			if(goals.toLowerCase().contains(c.getJob_title()) == true){
				expList.add(c);
			}
		}
		if(expList.isEmpty() == false){
			for(Experiences e : expList){
				expInfo = new ExperienceInformation();
				userdatapojo = new UserDataPojo();
				userdatapojo = expInfo.getUserByExpId(e.getId());
				userIds.add(userdatapojo.getId());
			}
		} else{
			System.out.println("no job title found in this Users Goals");
		}
	     int size = userIds.size();
	     for (int i = 0; i < size - 1; i++) {
	         for (int j = i + 1; j < size; j++) {
	             if (!userIds.get(j).equals(userIds.get(i)))
	                 continue;
	             userIds.remove(j);
	             j--; 
	             size--;
	         } 
	     }  
		for(Integer i : userIds){
			userRepo = new UserRepo();
			userList.add(userRepo.getUserData(i));
		}
		return userList;
	}

	public List<User> userGoalsCompanyNameMatching(int id){
		List<User> userList = new ArrayList<User>();
		List<Companies> companyList = new ArrayList<Companies>();
		List<Integer> userIds = new ArrayList<Integer>();
		List<Integer> expIds = new ArrayList<Integer>();
		userEntity = new User();
		userRepo = new UserRepo();
		userEntity = userRepo.getUserData(id);
		String goals = userEntity.getGoals();
		List<Companies> allcompanies = new ArrayList<Companies>();
		userpro = new UserProfileRepo();
		allcompanies = userpro.getAllCompanyData();
		for(Companies c : allcompanies){
			if(goals.toLowerCase().contains(c.getCompany_name()) == true){
				companyList.add(c);
			}
		}
		if(companyList.isEmpty() == false){
			for(Companies c : companyList){
				expInfo = new ExperienceInformation();
				expDataPojo = new ExperiencesDataPojo();
				expDataPojo = expInfo.getExperienceByCompanyId(c.getId());
				expIds.add(expDataPojo.getId());
			}
		} else{
			System.out.println("no job title found in this Users Goals");
		}
		for(Integer i : expIds){
			expInfo = new ExperienceInformation();
			userdatapojo = new UserDataPojo();
			userdatapojo = expInfo.getUserByExpId(i);
			userIds.add(userdatapojo.getId());
		}
		for(Integer i : userIds){
			userRepo = new UserRepo();
			userList.add(userRepo.getUserData(i));
		}
		return userList;
	}

	public List<User> userGoalsCompanyIndustryMatching(int id){
		List<User> userList = new ArrayList<User>();
		List<Companies> companyList = new ArrayList<Companies>();
		List<Integer> userIds = new ArrayList<Integer>();
		List<Integer> expIds = new ArrayList<Integer>();
		userEntity = new User();
		userRepo = new UserRepo();
		userEntity = userRepo.getUserData(id);
		String goals = userEntity.getGoals();
		List<Companies> allcompanies = new ArrayList<Companies>();
		userpro = new UserProfileRepo();
		allcompanies = userpro.getAllCompanyData();
		for(Companies c : allcompanies){
			if(goals.toLowerCase().contains(c.getCompany_industry()) == true){
				companyList.add(c);
			}
		}
		if(companyList.isEmpty() == false){
			for(Companies c : companyList){
				expInfo = new ExperienceInformation();
				expDataPojo = new ExperiencesDataPojo();
				expDataPojo = expInfo.getExperienceByCompanyId(c.getId());
				expIds.add(expDataPojo.getId());
			}
		} else{
			System.out.println("no job title found in this Users Goals");
		}
		for(Integer i : expIds){
			expInfo = new ExperienceInformation();
			userdatapojo = new UserDataPojo();
			userdatapojo = expInfo.getUserByExpId(i);
			userIds.add(userdatapojo.getId());
		}
		for(Integer i : userIds){
			userRepo = new UserRepo();
			userList.add(userRepo.getUserData(i));
		}
		return userList;
	}
	
	public List<String> matchedUserSkillCoursesByJobTitle(int id){
		
		List<User> matchedUsers = new ArrayList<User>();
		List<Integer> skillIds = new ArrayList<Integer>();
		List<Integer> courseIds = new ArrayList<Integer>();
		List<Courses> courseNames = new ArrayList<Courses>();
		Collection<Industry> industryList = new ArrayList<Industry>();
		matchedUsers = userGoalsJobTitleMatching(id);
		for(User u : matchedUsers){
			industryList.addAll(u.getIndustryList());
		}
		for(Industry i : industryList){
			skillIds.add(i.getId());
		}
	     int size = skillIds.size();
	     for (int i = 0; i < size - 1; i++) {
	         for (int j = i + 1; j < size; j++) {
	             if (!skillIds.get(j).equals(skillIds.get(i)))
	                 continue;
	             skillIds.remove(j);
	             j--; 
	             size--;
	         } 
	     } 
	     for(Integer i : skillIds){
	    	 userpro = new UserProfileRepo();
	    	 courseIds.addAll(userpro.SameIndustryCourse(i));
	     }
	     for (int i = 0; i < courseIds.size() - 1; i++) {
	         for (int j = i + 1; j < courseIds.size(); j++) {
	             if (!courseIds.get(j).equals(courseIds.get(i)))
	                 continue;
	             courseIds.remove(j);
	             j--; 
	             size--;
	         } 
	     } 
	     for(Integer i : courseIds){
	    	courseEntity = new Courses();
	    	edurepo = new EducationalRepo();
	    	courseEntity = edurepo.getCourseData(i);
	    	courseNames.add(courseEntity);
	     }
	     List<String> userSkillCourses = new ArrayList<String>();
	     for(Courses c : courseNames){
	    	 userSkillCourses.add(c.getCourse_name());
	     }
		return userSkillCourses;
	}
	
	public List<String> matchedUserHSCoursesByJobTitle(int id){
		List<User> matchedUsers = new ArrayList<User>();
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		List<Integer> courseIds = new ArrayList<Integer>();
		List<Courses> courseNames = new ArrayList<Courses>();
		Collection<Courses> courseList = new ArrayList<Courses>();
		matchedUsers = userGoalsJobTitleMatching(id);
		for(User u : matchedUsers){
			hsList.addAll(u.getHighschoolList());
		}
		for(Highschool hs : hsList){
			courseList.addAll(hs.getCoursesList());
		}
		for(Courses c : courseList){
			courseIds.add(c.getId());
		}
	     int size = courseIds.size();
	     for (int i = 0; i < size - 1; i++) {
	         for (int j = i + 1; j < size; j++) {
	             if (!courseIds.get(j).equals(courseIds.get(i)))
	                 continue;
	             courseIds.remove(j);
	             j--; 
	             size--;
	         } 
	     } 
	     for(Integer i : courseIds){
		    	courseEntity = new Courses();
		    	edurepo = new EducationalRepo();
	    	courseEntity = edurepo.getCourseData(i);
	    	courseNames.add(courseEntity);
	     }
	     List<String> userHSCourses = new ArrayList<String>();
	     for(Courses c : courseNames){
	    	 userHSCourses.add(c.getCourse_name());
	     }
		return userHSCourses;
	}
	
	public List<String> matchedUserUniCoursesByJobTitle(int id){
		List<User> matchedUsers = new ArrayList<User>();
		Collection<Qualification> qualList = new ArrayList<Qualification>();
		List<Integer> courseIds = new ArrayList<Integer>();
		List<Courses> courseNames = new ArrayList<Courses>();
		Collection<Courses> courseList = new ArrayList<Courses>();
		matchedUsers = userGoalsJobTitleMatching(id);
		for(User u : matchedUsers){
			qualList.addAll(u.getUniversityList());
		}
		for(Qualification q : qualList){
			courseList.addAll(q.getCoursesList());
		}
		for(Courses c : courseList){
			courseIds.add(c.getId());
		}
	     int size = courseIds.size();
	     for (int i = 0; i < size - 1; i++) {
	         for (int j = i + 1; j < size; j++) {
	             if (!courseIds.get(j).equals(courseIds.get(i)))
	                 continue;
	             courseIds.remove(j);
	             j--; 
	             size--;
	         } 
	     } 
	     for(Integer i : courseIds){
	    	courseEntity = new Courses();
	    	edurepo = new EducationalRepo();
	    	courseEntity = edurepo.getCourseData(i);
	    	courseNames.add(courseEntity);
	     }
	     List<String> userUniCourses = new ArrayList<String>();
	     for(Courses c : courseNames){
	    	 userUniCourses.add(c.getCourse_name());
	     }
		return userUniCourses;
	}

	public List<String> matchedUserSkillCoursesByMajors(int id){
		List<User> matchedUsers = new ArrayList<User>();
		List<Integer> skillIds = new ArrayList<Integer>();
		List<Integer> courseIds = new ArrayList<Integer>();
		List<Courses> courseNames = new ArrayList<Courses>();
		Collection<Industry> industryList = new ArrayList<Industry>();
		matchedUsers = userGoalsMajorMatching(id);
		for(User u : matchedUsers){
			industryList.addAll(u.getIndustryList());
		}
		for(Industry i : industryList){
			skillIds.add(i.getId());
		}
	     int size = skillIds.size();
	     for (int i = 0; i < size - 1; i++) {
	         for (int j = i + 1; j < size; j++) {
	             if (!skillIds.get(j).equals(skillIds.get(i)))
	                 continue;
	             skillIds.remove(j);
	             j--; 
	             size--;
	         } 
	     } 
	     for(Integer i : skillIds){
	    	 userpro = new UserProfileRepo();
	    	 courseIds.addAll(userpro.SameIndustryCourse(i));
	     }
	     for (int i = 0; i < courseIds.size() - 1; i++) {
	         for (int j = i + 1; j < courseIds.size(); j++) {
	             if (!courseIds.get(j).equals(courseIds.get(i)))
	                 continue;
	             courseIds.remove(j);
	             j--; 
	             size--;
	         } 
	     } 
	     for(Integer i : courseIds){
		    	courseEntity = new Courses();
		    	edurepo = new EducationalRepo();
	    	courseEntity = edurepo.getCourseData(i);
	    	courseNames.add(courseEntity);
	     }
	     List<String> userSkillCourses = new ArrayList<String>();
	     for(Courses c : courseNames){
	    	 userSkillCourses.add(c.getCourse_name());
	     }
		return userSkillCourses;
	}
	
	public List<String> matchedUserHSCoursesByMajors(int id){
		List<User> matchedUsers = new ArrayList<User>();
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		List<Integer> courseIds = new ArrayList<Integer>();
		List<Courses> courseNames = new ArrayList<Courses>();
		Collection<Courses> courseList = new ArrayList<Courses>();
		matchedUsers = userGoalsMajorMatching(id);
		for(User u : matchedUsers){
			hsList.addAll(u.getHighschoolList());
		}
		for(Highschool hs : hsList){
			courseList.addAll(hs.getCoursesList());
		}
		for(Courses c : courseList){
			courseIds.add(c.getId());
		}
	     int size = courseIds.size();
	     for (int i = 0; i < size - 1; i++) {
	         for (int j = i + 1; j < size; j++) {
	             if (!courseIds.get(j).equals(courseIds.get(i)))
	                 continue;
	             courseIds.remove(j);
	             j--; 
	             size--;
	         } 
	     } 
	     for(Integer i : courseIds){
		    	courseEntity = new Courses();
		    	edurepo = new EducationalRepo();
	    	courseEntity = edurepo.getCourseData(i);
	    	courseNames.add(courseEntity);
	     }
	     List<String> userHSCourses = new ArrayList<String>();
	     for(Courses c : courseNames){
	    	 userHSCourses.add(c.getCourse_name());
	     }
		return userHSCourses;
	}
	
	public List<String> matchedUserUniCoursesByMajors(int id){
		List<User> matchedUsers = new ArrayList<User>();
		Collection<Qualification> qualList = new ArrayList<Qualification>();
		List<Integer> courseIds = new ArrayList<Integer>();
		List<Courses> courseNames = new ArrayList<Courses>();
		Collection<Courses> courseList = new ArrayList<Courses>();
		matchedUsers = userGoalsMajorMatching(id);
		for(User u : matchedUsers){
			qualList.addAll(u.getUniversityList());
		}
		for(Qualification q : qualList){
			courseList.addAll(q.getCoursesList());
		}
		for(Courses c : courseList){
			courseIds.add(c.getId());
		}
	     int size = courseIds.size();
	     for (int i = 0; i < size - 1; i++) {
	         for (int j = i + 1; j < size; j++) {
	             if (!courseIds.get(j).equals(courseIds.get(i)))
	                 continue;
	             courseIds.remove(j);
	             j--; 
	             size--;
	         } 
	     } 
	     for(Integer i : courseIds){
		    	courseEntity = new Courses();
		    	edurepo = new EducationalRepo();
	    	courseEntity = edurepo.getCourseData(i);
	    	courseNames.add(courseEntity);
	     }
	     List<String> userUniCourses = new ArrayList<String>();
	     for(Courses c : courseNames){
	    	 userUniCourses.add(c.getCourse_name());
	     }
		return userUniCourses;
	}

	public List<String> matchedUserSkillCoursesByUniName(int id){
		List<User> matchedUsers = new ArrayList<User>();
		List<Integer> skillIds = new ArrayList<Integer>();
		List<Integer> courseIds = new ArrayList<Integer>();
		List<Courses> courseNames = new ArrayList<Courses>();
		Collection<Industry> industryList = new ArrayList<Industry>();
		matchedUsers = userGoalsUniNameMatching(id);
		for(User u : matchedUsers){
			industryList.addAll(u.getIndustryList());
		}
		for(Industry i : industryList){
			skillIds.add(i.getId());
		}
	     int size = skillIds.size();
	     for (int i = 0; i < size - 1; i++) {
	         for (int j = i + 1; j < size; j++) {
	             if (!skillIds.get(j).equals(skillIds.get(i)))
	                 continue;
	             skillIds.remove(j);
	             j--; 
	             size--;
	         } 
	     } 
	     for(Integer i : skillIds){
	    	 userpro = new UserProfileRepo();
	    	 courseIds.addAll(userpro.SameIndustryCourse(i));
	     }
	     for (int i = 0; i < courseIds.size() - 1; i++) {
	         for (int j = i + 1; j < courseIds.size(); j++) {
	             if (!courseIds.get(j).equals(courseIds.get(i)))
	                 continue;
	             courseIds.remove(j);
	             j--; 
	             size--;
	         } 
	     } 
	     for(Integer i : courseIds){
		    	courseEntity = new Courses();
		    	edurepo = new EducationalRepo();
	    	courseEntity = edurepo.getCourseData(i);
	    	courseNames.add(courseEntity);
	     }
	     List<String> userSkillCourses = new ArrayList<String>();
	     for(Courses c : courseNames){
	    	 userSkillCourses.add(c.getCourse_name());
	     }
		return userSkillCourses;
	}
	
	public List<String> matchedUserHSCoursesByUniName(int id){
		List<User> matchedUsers = new ArrayList<User>();
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		List<Integer> courseIds = new ArrayList<Integer>();
		List<Courses> courseNames = new ArrayList<Courses>();
		Collection<Courses> courseList = new ArrayList<Courses>();
		matchedUsers = userGoalsUniNameMatching(id);
		for(User u : matchedUsers){
			hsList.addAll(u.getHighschoolList());
		}
		for(Highschool hs : hsList){
			courseList.addAll(hs.getCoursesList());
		}
		for(Courses c : courseList){
			courseIds.add(c.getId());
		}
	     int size = courseIds.size();
	     for (int i = 0; i < size - 1; i++) {
	         for (int j = i + 1; j < size; j++) {
	             if (!courseIds.get(j).equals(courseIds.get(i)))
	                 continue;
	             courseIds.remove(j);
	             j--; 
	             size--;
	         } 
	     } 
	     for(Integer i : courseIds){
		    	courseEntity = new Courses();
		    	edurepo = new EducationalRepo();
	    	courseEntity = edurepo.getCourseData(i);
	    	courseNames.add(courseEntity);
	     }
	     List<String> userHSCourses = new ArrayList<String>();
	     for(Courses c : courseNames){
	    	 userHSCourses.add(c.getCourse_name());
	     }
		return userHSCourses;
	}
	
	public List<String> matchedUserUniCoursesByUniName(int id){
		List<User> matchedUsers = new ArrayList<User>();
		Collection<Qualification> qualList = new ArrayList<Qualification>();
		List<Integer> courseIds = new ArrayList<Integer>();
		List<Courses> courseNames = new ArrayList<Courses>();
		Collection<Courses> courseList = new ArrayList<Courses>();
		matchedUsers = userGoalsUniNameMatching(id);
		for(User u : matchedUsers){
			qualList.addAll(u.getUniversityList());
		}
		for(Qualification q : qualList){
			courseList.addAll(q.getCoursesList());
		}
		for(Courses c : courseList){
			courseIds.add(c.getId());
		}
	     int size = courseIds.size();
	     for (int i = 0; i < size - 1; i++) {
	         for (int j = i + 1; j < size; j++) {
	             if (!courseIds.get(j).equals(courseIds.get(i)))
	                 continue;
	             courseIds.remove(j);
	             j--; 
	             size--;
	         } 
	     } 
	     for(Integer i : courseIds){
		    	courseEntity = new Courses();
		    	edurepo = new EducationalRepo();
	    	courseEntity = edurepo.getCourseData(i);
	    	courseNames.add(courseEntity);
	     }
	     List<String> userUniCourses = new ArrayList<String>();
	     for(Courses c : courseNames){
	    	 userUniCourses.add(c.getCourse_name());
	     }
		return userUniCourses;
	}

	public List<String> matchedUserSkillCoursesByCompanyName(int id){
		courseEntity = new Courses();
		List<User> matchedUsers = new ArrayList<User>();
		List<Integer> skillIds = new ArrayList<Integer>();
		List<Integer> courseIds = new ArrayList<Integer>();
		List<Courses> courseNames = new ArrayList<Courses>();
		Collection<Industry> industryList = new ArrayList<Industry>();
		matchedUsers = userGoalsCompanyNameMatching(id);
		for(User u : matchedUsers){
			industryList.addAll(u.getIndustryList());
		}
		for(Industry i : industryList){
			skillIds.add(i.getId());
		}
	     int size = skillIds.size();
	     for (int i = 0; i < size - 1; i++) {
	         for (int j = i + 1; j < size; j++) {
	             if (!skillIds.get(j).equals(skillIds.get(i)))
	                 continue;
	             skillIds.remove(j);
	             j--; 
	             size--;
	         } 
	     } 
	     for(Integer i : skillIds){
	    	 userpro = new UserProfileRepo();
	    	 courseIds.addAll(userpro.SameIndustryCourse(i));
	     }
	     for (int i = 0; i < courseIds.size() - 1; i++) {
	         for (int j = i + 1; j < courseIds.size(); j++) {
	             if (!courseIds.get(j).equals(courseIds.get(i)))
	                 continue;
	             courseIds.remove(j);
	             j--; 
	             size--;
	         } 
	     } 
	     for(Integer i : courseIds){
		    	courseEntity = new Courses();
		    	edurepo = new EducationalRepo();
	    	courseEntity = edurepo.getCourseData(i);
	    	courseNames.add(courseEntity);
	     }
	     List<String> userSkillCourses = new ArrayList<String>();
	     for(Courses c : courseNames){
	    	 userSkillCourses.add(c.getCourse_name());
	     }
		return userSkillCourses;
	}
	
	public List<String> matchedUserHSCoursesByCompanyName(int id){
		List<User> matchedUsers = new ArrayList<User>();
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		List<Integer> courseIds = new ArrayList<Integer>();
		List<Courses> courseNames = new ArrayList<Courses>();
		Collection<Courses> courseList = new ArrayList<Courses>();
		matchedUsers = userGoalsCompanyNameMatching(id);
		for(User u : matchedUsers){
			hsList.addAll(u.getHighschoolList());
		}
		for(Highschool hs : hsList){
			courseList.addAll(hs.getCoursesList());
		}
		for(Courses c : courseList){
			courseIds.add(c.getId());
		}
	     int size = courseIds.size();
	     for (int i = 0; i < size - 1; i++) {
	         for (int j = i + 1; j < size; j++) {
	             if (!courseIds.get(j).equals(courseIds.get(i)))
	                 continue;
	             courseIds.remove(j);
	             j--; 
	             size--;
	         } 
	     } 
	     for(Integer i : courseIds){
		    	courseEntity = new Courses();
		    	edurepo = new EducationalRepo();
	    	courseEntity = edurepo.getCourseData(i);
	    	courseNames.add(courseEntity);
	     }
	     List<String> userHSCourses = new ArrayList<String>();
	     for(Courses c : courseNames){
	    	 userHSCourses.add(c.getCourse_name());
	     }
		return userHSCourses;
	}
	
	public List<String> matchedUserUniCoursesByCompanyName(int id){
		List<User> matchedUsers = new ArrayList<User>();
		Collection<Qualification> qualList = new ArrayList<Qualification>();
		List<Integer> courseIds = new ArrayList<Integer>();
		List<Courses> courseNames = new ArrayList<Courses>();
		Collection<Courses> courseList = new ArrayList<Courses>();
		matchedUsers = userGoalsCompanyNameMatching(id);
		for(User u : matchedUsers){
			qualList.addAll(u.getUniversityList());
		}
		for(Qualification q : qualList){
			courseList.addAll(q.getCoursesList());
		}
		for(Courses c : courseList){
			courseIds.add(c.getId());
		}
	     int size = courseIds.size();
	     for (int i = 0; i < size - 1; i++) {
	         for (int j = i + 1; j < size; j++) {
	             if (!courseIds.get(j).equals(courseIds.get(i)))
	                 continue;
	             courseIds.remove(j);
	             j--; 
	             size--;
	         } 
	     } 
	     for(Integer i : courseIds){
		    	courseEntity = new Courses();
		    	edurepo = new EducationalRepo();
	    	courseEntity = edurepo.getCourseData(i);
	    	courseNames.add(courseEntity);
	     }
	     List<String> userUniCourses = new ArrayList<String>();
	     for(Courses c : courseNames){
	    	 userUniCourses.add(c.getCourse_name());
	     }
		return userUniCourses;
	}

	public List<String> matchedUserSkillCoursesByCompanyIndustry(int id){
		courseEntity = new Courses();
		List<User> matchedUsers = new ArrayList<User>();
		List<Integer> skillIds = new ArrayList<Integer>();
		List<Integer> courseIds = new ArrayList<Integer>();
		List<Courses> courseNames = new ArrayList<Courses>();
		Collection<Industry> industryList = new ArrayList<Industry>();
		matchedUsers = userGoalsCompanyIndustryMatching(id);
		for(User u : matchedUsers){
			industryList.addAll(u.getIndustryList());
		}
		for(Industry i : industryList){
			skillIds.add(i.getId());
		}
	     int size = skillIds.size();
	     for (int i = 0; i < size - 1; i++) {
	         for (int j = i + 1; j < size; j++) {
	             if (!skillIds.get(j).equals(skillIds.get(i)))
	                 continue;
	             skillIds.remove(j);
	             j--; 
	             size--;
	         } 
	     } 
	     for(Integer i : skillIds){
	    	 userpro = new UserProfileRepo();
	    	 courseIds.addAll(userpro.SameIndustryCourse(i));
	     }
	     for (int i = 0; i < courseIds.size() - 1; i++) {
	         for (int j = i + 1; j < courseIds.size(); j++) {
	             if (!courseIds.get(j).equals(courseIds.get(i)))
	                 continue;
	             courseIds.remove(j);
	             j--; 
	             size--;
	         } 
	     } 
	     for(Integer i : courseIds){
		    	courseEntity = new Courses();
		    	edurepo = new EducationalRepo();
	    	courseEntity = edurepo.getCourseData(i);
	    	courseNames.add(courseEntity);
	     }
	     List<String> userSkillCourses = new ArrayList<String>();
	     for(Courses c : courseNames){
	    	 userSkillCourses.add(c.getCourse_name());
	     }
		return userSkillCourses;
	}
	
	public List<String> matchedUserHSCoursesByCompanyIndustry(int id){
		List<User> matchedUsers = new ArrayList<User>();
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		List<Integer> courseIds = new ArrayList<Integer>();
		List<Courses> courseNames = new ArrayList<Courses>();
		Collection<Courses> courseList = new ArrayList<Courses>();
		matchedUsers = userGoalsCompanyIndustryMatching(id);
		for(User u : matchedUsers){
			hsList.addAll(u.getHighschoolList());
		}
		for(Highschool hs : hsList){
			courseList.addAll(hs.getCoursesList());
		}
		for(Courses c : courseList){
			courseIds.add(c.getId());
		}
	     int size = courseIds.size();
	     for (int i = 0; i < size - 1; i++) {
	         for (int j = i + 1; j < size; j++) {
	             if (!courseIds.get(j).equals(courseIds.get(i)))
	                 continue;
	             courseIds.remove(j);
	             j--; 
	             size--;
	         } 
	     } 
	     for(Integer i : courseIds){
		    	courseEntity = new Courses();
		    	edurepo = new EducationalRepo();
	    	courseEntity = edurepo.getCourseData(i);
	    	courseNames.add(courseEntity);
	     }
	     List<String> userHSCourses = new ArrayList<String>();
	     for(Courses c : courseNames){
	    	 userHSCourses.add(c.getCourse_name());
	     }
		return userHSCourses;
	}
	
	public List<String> matchedUserUniCoursesByCompanyIndustry(int id){
		List<User> matchedUsers = new ArrayList<User>();
		Collection<Qualification> qualList = new ArrayList<Qualification>();
		List<Integer> courseIds = new ArrayList<Integer>();
		List<Courses> courseNames = new ArrayList<Courses>();
		Collection<Courses> courseList = new ArrayList<Courses>();
		matchedUsers = userGoalsCompanyIndustryMatching(id);
		for(User u : matchedUsers){
			qualList.addAll(u.getUniversityList());
		}
		for(Qualification q : qualList){
			courseList.addAll(q.getCoursesList());
		}
		for(Courses c : courseList){
			courseIds.add(c.getId());
		}
	     int size = courseIds.size();
	     for (int i = 0; i < size - 1; i++) {
	         for (int j = i + 1; j < size; j++) {
	             if (!courseIds.get(j).equals(courseIds.get(i)))
	                 continue;
	             courseIds.remove(j);
	             j--; 
	             size--;
	         } 
	     } 
	     for(Integer i : courseIds){
		    	courseEntity = new Courses();
		    	edurepo = new EducationalRepo();
	    	courseEntity = edurepo.getCourseData(i);
	    	courseNames.add(courseEntity);
	     }
	     List<String> userUniCourses = new ArrayList<String>();
	     for(Courses c : courseNames){
	    	 userUniCourses.add(c.getCourse_name());
	     }
		return userUniCourses;
	}

}
