/**
 * 
 */
package careers.nebula.ben.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import careers.nebula.ben.db.enitity.Experiences;
import careers.nebula.ben.db.enitity.Extracurricular;
import careers.nebula.ben.db.enitity.Highschool;
import careers.nebula.ben.db.enitity.Industry;
import careers.nebula.ben.db.enitity.Interests;
import careers.nebula.ben.db.enitity.Keywords;
import careers.nebula.ben.db.enitity.Languages;
import careers.nebula.ben.db.enitity.Locations;
import careers.nebula.ben.db.enitity.Majors;
import careers.nebula.ben.db.enitity.Minors;
import careers.nebula.ben.db.enitity.Qualification;
import careers.nebula.ben.db.enitity.TestResult;
import careers.nebula.ben.db.enitity.Universities;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.db.repository.UserProfileRepo;
import careers.nebula.ben.db.repository.UserRepo;
import careers.nebula.ben.information.ExperienceInformation;
import careers.nebula.ben.information.LocationInformation;
import careers.nebula.ben.information.QualificationsInformation;
import careers.nebula.ben.pojo.iws.UserDataPojo;
import careers.nebula.ben.pojos.ResponseCombinedList;

/**
 * @author Ankit_Nebula
 *
 */
public class ComparePeersServicing {
	
	private UserRepo userRepo;
	private User userEntity;
	private Experiences expEntity;
	private UserProfileRepo userpro;
	private QualificationsInformation qualInfo;
	private HelperMethods methods;
	private LocationInformation locInfo;
	private ExperienceInformation expInfo;
	private TestResult testEntity;
	
	public List<User> userWithsameHighestQualifications(int id){
		userEntity = new User();
		userRepo = new UserRepo();
		userpro = new UserProfileRepo();
		userEntity = userRepo.getUserData(id);
		List<User> userList = new ArrayList<User>();
		userList = userpro.SameHighestQualifications(userEntity.getHighestQualification());
//		for(User u : userList){
//			System.out.println(u.getGoals());
//		}	
		return userList;
	}
	
	public List<User> userWithsameAge(int id){
		userEntity = new User();
		userRepo = new UserRepo();
		userpro = new UserProfileRepo();
		userEntity = userRepo.getUserData(id);
		List<User> userList = new ArrayList<User>();
		userList = userpro.SameAge(userEntity.getAge());
//		for(User u : userList){
//			Integer age = methods.ageCalculator(u.getDob());
//		}	
		return userList;
	}
	
	public List<UserDataPojo> userWithsameQualifications(int id){
		userEntity = new User();
		userRepo = new UserRepo();
		userpro = new UserProfileRepo();
		userEntity = userRepo.getUserData(id);
		List<Qualification> qualList = new ArrayList<Qualification>();
		List<UserDataPojo> userdataList = new ArrayList<UserDataPojo>();
		qualList =userpro.SameQualifications(userEntity.getHighestQualification());
		for(Qualification q : qualList){
			userdataList.add(qualInfo.getUserByQualId(q.getId()));
		}
		return userdataList;	
	}
	
	public List<User> userWithsameGoals(int id){
		userEntity = new User();
		userRepo = new UserRepo();
		userpro = new UserProfileRepo();
		userEntity = userRepo.getUserData(id);
		List<User> userList = new ArrayList<User>();
		userList = userpro.SameGoals(userEntity.getGoals());
//		for(User u : userList){
//			System.out.println(u.getGoals());
//		}	
		return userList;
	}
	
	public List<UserDataPojo> userWithsameMajors(int id){
		userEntity = new User();
		userRepo = new UserRepo();
		userpro = new UserProfileRepo();
		qualInfo = new QualificationsInformation();
		userEntity = userRepo.getUserData(id);
		Collection<Qualification> qualList = new ArrayList<Qualification>();
		qualList = userEntity.getUniversityList();
		List<Integer> majorIds = new ArrayList<Integer>();
		List<Integer> qualIds = new ArrayList<Integer>();
		Collection<Majors> majorList = new ArrayList<Majors>();
		List<UserDataPojo> userdataList = new ArrayList<UserDataPojo>();
		for(Qualification q : qualList){
			majorList = q.getMajorList();
			for(Majors m : majorList){
				majorIds.add(m.getId());
			}
		}
		for(Integer i : majorIds){
			qualIds.addAll(userpro.SameMajorIds(i));
		}
		for(Integer i : qualIds){
			userdataList.add(qualInfo.getUserByQualId(i));
		}
		return userdataList;
	}

	public List<UserDataPojo> userWithsameMinors(int id){
		userEntity = new User();
		userRepo = new UserRepo();
		userpro = new UserProfileRepo();
		qualInfo = new QualificationsInformation();
		userEntity = userRepo.getUserData(id);
		Collection<Qualification> qualList = new ArrayList<Qualification>();
		qualList = userEntity.getUniversityList();
		List<Integer> minorIds = new ArrayList<Integer>();
		List<Integer> qualIds = new ArrayList<Integer>();
		Collection<Minors> majorList = new ArrayList<Minors>();
		List<UserDataPojo> userdataList = new ArrayList<UserDataPojo>();
		for(Qualification q : qualList){
			majorList = q.getMinorList();
			for(Minors m : majorList){
				minorIds.add(m.getId());
			}
		}
		for(Integer i : minorIds){
			qualIds.addAll(userpro.SameMinorIds(i));
		}
		for(Integer i : qualIds){
			userdataList.add(qualInfo.getUserByQualId(i));
		}
		return userdataList;
	}
	
	public List<UserDataPojo> usersWithSameUni(int id){
		userEntity = new User();
		userRepo = new UserRepo();
		userpro = new UserProfileRepo();
		qualInfo = new QualificationsInformation();
		userEntity = userRepo.getUserData(id);
		Collection<Qualification> qualList = new ArrayList<Qualification>();
		qualList = userEntity.getUniversityList();
		List<Integer> uniIds = new ArrayList<Integer>();
		List<Integer> qualIds = new ArrayList<Integer>();
		Collection<Universities> uniList = new ArrayList<Universities>();
		List<UserDataPojo> userdataList = new ArrayList<UserDataPojo>();
		for(Qualification q : qualList){
			uniList = q.getUniNameList();
			for(Universities m : uniList){
				uniIds.add(m.getId());
			}
		}
		for(Integer i : uniIds){
			qualIds.addAll(userpro.SameUniversity(i));
		}
		for(Integer i : qualIds){
			userdataList.add(qualInfo.getUserByQualId(i));
		}
		return userdataList;
	}
	
	public List<UserDataPojo> usersWithSameJobTitle(int id){
		userEntity = new User();
		userRepo = new UserRepo();
		userpro = new UserProfileRepo();
		expInfo = new ExperienceInformation();
		userEntity = userRepo.getUserData(id);
		Collection<Experiences> expList = new ArrayList<Experiences>();
		expList = userEntity.getExperienceList();
		List<Experiences> experience = new ArrayList<Experiences>();
		List<UserDataPojo> userdataList = new ArrayList<UserDataPojo>();
		for(Experiences q : expList){
			String temp = q.getJob_title();
			experience.addAll(userpro.SameExperience(temp));
		}
		for(Experiences e : experience){
			userdataList.add(expInfo.getUserByExpId(e.getId()));
		}
		return userdataList;
	}
	
	public List<UserDataPojo> usersWithSameLocation(int id){
		userEntity = new User();
		userRepo = new UserRepo();
		userpro = new UserProfileRepo();
		locInfo = new LocationInformation();
		userEntity = userRepo.getUserData(id);
		Collection<Locations> locationList = new ArrayList<Locations>();
		locationList = userEntity.getLocationList();
		List<String> locStates = new ArrayList<String>();
		List<Locations> locList = new ArrayList<Locations>();
		List<UserDataPojo> userdataList = new ArrayList<UserDataPojo>();
		for(Locations l : locationList){
			locStates.add(l.getState());
		}
		for(String s : locStates){
			locList.addAll(userpro.SameLocations(s));
		}
		for(Locations l : locList){
			userdataList.add(locInfo.getUserByLocId(l.getId()));
		}
		return userdataList;
	}
	
	public List<User> usersWithSameQualificationAndMajors(int id){
		userEntity = new User();
		methods = new HelperMethods();
		List<UserDataPojo> majors = new ArrayList<UserDataPojo>();
		majors = userWithsameMajors(id);
		List<UserDataPojo> qualification = new ArrayList<UserDataPojo>();
		List<User> userList = new ArrayList<User>();
		qualification = userWithsameQualifications(id);
		List<Integer> majorIds = new ArrayList<Integer>();
		List<Integer> qualIds = new ArrayList<Integer>();
		for(UserDataPojo u : majors){
			majorIds.add(u.getId());
		}
		for(UserDataPojo u : qualification){
			qualIds.add(u.getId());
		}
		List<Integer> intersection = new ArrayList<Integer>();
		intersection = methods.intersection(majorIds, qualIds);
		for(Integer i : intersection){
			userEntity = userRepo.getUserData(i);
			userList.add(userEntity);
		}
		return userList;
	}
	
	public List<User> usersWithSameQualificationAndMinors(int id){
		userEntity = new User();
		methods = new HelperMethods();
		List<UserDataPojo> minors = new ArrayList<UserDataPojo>();
		minors = userWithsameMinors(id);
		List<UserDataPojo> qualification = new ArrayList<UserDataPojo>();
		List<User> userList = new ArrayList<User>();
		qualification = userWithsameQualifications(id);
		List<Integer> minorIds = new ArrayList<Integer>();
		List<Integer> qualIds = new ArrayList<Integer>();
		for(UserDataPojo u : minors){
			minorIds.add(u.getId());
		}
		for(UserDataPojo u : qualification){
			qualIds.add(u.getId());
		}
		List<Integer> intersection = new ArrayList<Integer>();
		intersection = methods.intersection(minorIds, qualIds);
		for(Integer i : intersection){
			userEntity = userRepo.getUserData(i);
			userList.add(userEntity);
		}
		return userList;
	}
	
	public List<User> usersWithSameQualificationAndSchools(int id){
		userEntity = new User();
		methods = new HelperMethods();
		List<UserDataPojo> schools = new ArrayList<UserDataPojo>();
		schools = usersWithSameUni(id);
		List<UserDataPojo> qualification = new ArrayList<UserDataPojo>();
		List<User> userList = new ArrayList<User>();
		qualification = userWithsameQualifications(id);
		List<Integer> uniIds = new ArrayList<Integer>();
		List<Integer> qualIds = new ArrayList<Integer>();
		for(UserDataPojo u : schools){
			uniIds.add(u.getId());
		}
		for(UserDataPojo u : qualification){
			qualIds.add(u.getId());
		}
		List<Integer> intersection = new ArrayList<Integer>();
		intersection = methods.intersection(uniIds, qualIds);
		for(Integer i : intersection){
			userEntity = userRepo.getUserData(i);
			userList.add(userEntity);
		}
		return userList;
	}
	
	public List<User> usersWithSameMajorAndSchools(int id){
		userEntity = new User();
		methods = new HelperMethods();
		List<UserDataPojo> schools = new ArrayList<UserDataPojo>();
		schools = usersWithSameUni(id);
		List<UserDataPojo> majors = new ArrayList<UserDataPojo>();
		List<User> userList = new ArrayList<User>();
		majors = userWithsameMajors(id);
		List<Integer> uniIds = new ArrayList<Integer>();
		List<Integer> qualIds = new ArrayList<Integer>();
		for(UserDataPojo u : schools){
			uniIds.add(u.getId());
		}
		for(UserDataPojo u : majors){
			qualIds.add(u.getId());
		}
		List<Integer> intersection = new ArrayList<Integer>();
		intersection = methods.intersection(uniIds, qualIds);
		for(Integer i : intersection){
			userEntity = userRepo.getUserData(i);
			userList.add(userEntity);
		}
		return userList;
	}
	
	public List<User> usersWithSameMinorsAndSchools(int id){
		userEntity = new User();
		methods = new HelperMethods();
		List<UserDataPojo> schools = new ArrayList<UserDataPojo>();
		schools = usersWithSameUni(id);
		List<UserDataPojo> minors = new ArrayList<UserDataPojo>();
		List<User> userList = new ArrayList<User>();
		minors = userWithsameMinors(id);
		List<Integer> uniIds = new ArrayList<Integer>();
		List<Integer> qualIds = new ArrayList<Integer>();
		for(UserDataPojo u : schools){
			uniIds.add(u.getId());
		}
		for(UserDataPojo u : minors){
			qualIds.add(u.getId());
		}
		List<Integer> intersection = new ArrayList<Integer>();
		intersection = methods.intersection(uniIds, qualIds);
		for(Integer i : intersection){
			userEntity = userRepo.getUserData(i);
			userList.add(userEntity);
		}
		return userList;
	}
	
	public List<User> usersWithSameMinorsAndMajors(int id){
		userEntity = new User();
		methods = new HelperMethods();
		List<UserDataPojo> majors = new ArrayList<UserDataPojo>();
		majors = userWithsameMajors(id);
		List<UserDataPojo> minors = new ArrayList<UserDataPojo>();
		List<User> userList = new ArrayList<User>();
		minors = userWithsameMinors(id);
		List<Integer> uniIds = new ArrayList<Integer>();
		List<Integer> qualIds = new ArrayList<Integer>();
		for(UserDataPojo u : majors){
			uniIds.add(u.getId());
		}
		for(UserDataPojo u : minors){
			qualIds.add(u.getId());
		}
		List<Integer> intersection = new ArrayList<Integer>();
		intersection = methods.intersection(uniIds, qualIds);
		for(Integer i : intersection){
			userEntity = userRepo.getUserData(i);
			userList.add(userEntity);
		}
		return userList;
	}
	
	public List<User> usersWithSameLocationAndMajors(int id){
		userEntity = new User();
		methods = new HelperMethods();
		List<UserDataPojo> majors = new ArrayList<UserDataPojo>();
		majors = userWithsameMajors(id);
		List<UserDataPojo> location = new ArrayList<UserDataPojo>();
		List<User> userList = new ArrayList<User>();
		location = usersWithSameLocation(id);
		List<Integer> uniIds = new ArrayList<Integer>();
		List<Integer> qualIds = new ArrayList<Integer>();
		for(UserDataPojo u : majors){
			uniIds.add(u.getId());
		}
		for(UserDataPojo u : location){
			qualIds.add(u.getId());
		}
		List<Integer> intersection = new ArrayList<Integer>();
		intersection = methods.intersection(uniIds, qualIds);
		for(Integer i : intersection){
			userEntity = userRepo.getUserData(i);
			userList.add(userEntity);
		}
		return userList;
	}
	
	public List<User> usersWithSameQualificationsAndlocation(int id){
		userEntity = new User();
		methods = new HelperMethods();
		List<UserDataPojo> location = new ArrayList<UserDataPojo>();
		location = usersWithSameLocation(id);
		List<UserDataPojo> qual = new ArrayList<UserDataPojo>();
		List<User> userList = new ArrayList<User>();
		qual = userWithsameQualifications(id);
		List<Integer> uniIds = new ArrayList<Integer>();
		List<Integer> qualIds = new ArrayList<Integer>();
		for(UserDataPojo u : location){
			uniIds.add(u.getId());
		}
		for(UserDataPojo u : qual){
			qualIds.add(u.getId());
		}
		List<Integer> intersection = new ArrayList<Integer>();
		intersection = methods.intersection(uniIds, qualIds);
		for(Integer i : intersection){
			userEntity = userRepo.getUserData(i);
			userList.add(userEntity);
		}
		return userList;
	}
	
	public List<User> usersWithSameJobTitleAndlocation(int id){
		userEntity = new User();
		methods = new HelperMethods();
		List<UserDataPojo> location = new ArrayList<UserDataPojo>();
		location = usersWithSameLocation(id);
		List<UserDataPojo> job = new ArrayList<UserDataPojo>();
		List<User> userList = new ArrayList<User>();
		job = usersWithSameJobTitle(id);
		List<Integer> uniIds = new ArrayList<Integer>();
		List<Integer> qualIds = new ArrayList<Integer>();
		for(UserDataPojo u : location){
			uniIds.add(u.getId());
		}
		for(UserDataPojo u : job){
			qualIds.add(u.getId());
		}
		List<Integer> intersection = new ArrayList<Integer>();
		intersection = methods.intersection(uniIds, qualIds);
		for(Integer i : intersection){
			userEntity = userRepo.getUserData(i);
			userList.add(userEntity);
		}
		return userList;
	}
	
	public List<User> usersWithSameAgeAndJobTitle(int id){
		userEntity = new User();
		methods = new HelperMethods();
		List<User> age = new ArrayList<User>();
		age = userWithsameAge(id);
		List<UserDataPojo> job = new ArrayList<UserDataPojo>();
		List<User> userList = new ArrayList<User>();
		job = usersWithSameJobTitle(id);
		List<Integer> uniIds = new ArrayList<Integer>();
		List<Integer> qualIds = new ArrayList<Integer>();
		for(User u : age){
			uniIds.add(u.getId());
		}
		for(UserDataPojo u : job){
			qualIds.add(u.getId());
		}
		List<Integer> intersection = new ArrayList<Integer>();
		intersection = methods.intersection(uniIds, qualIds);
		for(Integer i : intersection){
			userEntity = userRepo.getUserData(i);
			userList.add(userEntity);
		}
		return userList;
	}
	
	public List<String> qualificationMajorUserExtracurricular(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameQualificationAndMajors(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> extraSkills = new ArrayList<String>();
		for(User u : userList){
			extraList = u.getExtracurricularList();
			for(Extracurricular e : extraList){
				extraSkills.add(e.getName());
			}
		}	
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return extraSkills;
	}
	
	public List<String> qualificationMajorUserIndustry(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameQualificationAndMajors(id);
		Collection<Industry> industryList = new ArrayList<Industry>();
		List<String> industrySkills = new ArrayList<String>();
		for(User u : userList){
			industryList = u.getIndustryList();
			for(Industry e : industryList){
				industrySkills.add(e.getName());
			}
		}	
//		for(String s : industrySkills){
//			System.out.println(s);
//		}
		return industrySkills;
	}
	
	public List<String> qualificationMajorUserInterests(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameQualificationAndMajors(id);
		Collection<Interests> interestList = new ArrayList<Interests>();
		List<String> interestSkills = new ArrayList<String>();
		for(User u : userList){
			interestList = u.getInterestList();
			for(Interests e : interestList){
				interestSkills.add(e.getName());
			}
		}	
//		for(String s : interestSkills){
//			System.out.println(s);
//		}
		return interestSkills;
	}
	
	public List<String> qualificationMajorUserLanguages(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameQualificationAndMajors(id);
		Collection<Languages> languageList = new ArrayList<Languages>();
		List<String> languageSkills = new ArrayList<String>();
		for(User u : userList){
			languageList = u.getLanguageList();
			for(Languages e : languageList){
				languageSkills.add(e.getName());
			}
		}	
//		for(String s : languageSkills){
//			System.out.println(s);
//		}
		return languageSkills;
	}
	
	public List<String> qualificationMajorUserKeywords(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameQualificationAndMajors(id);
		Collection<Keywords> keywordList = new ArrayList<Keywords>();
		List<String> keywordSkills = new ArrayList<String>();
		for(User u : userList){
			keywordList = u.getKeywordList();
			for(Keywords e : keywordList){
				keywordSkills.add(e.getName());
			}
		}	
//		for(String s : keywordSkills){
//			System.out.println(s);
//		}
		return keywordSkills;
	}
	
	public List<String> qualificationMinorsUserExtracurricular(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameQualificationAndMinors(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> extraSkills = new ArrayList<String>();
		for(User u : userList){
			extraList = u.getExtracurricularList();
			for(Extracurricular e : extraList){
				extraSkills.add(e.getName());
			}
		}	
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return extraSkills;
	}
	
	public List<String> qualificationMinorsUserIndustry(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameQualificationAndMinors(id);
		Collection<Industry> industryList = new ArrayList<Industry>();
		List<String> industrySkills = new ArrayList<String>();
		for(User u : userList){
			industryList = u.getIndustryList();
			for(Industry e : industryList){
				industrySkills.add(e.getName());
			}
		}	
//		for(String s : industrySkills){
//			System.out.println(s);
//		}
		return industrySkills;
	}
	
	public List<String> qualificationMinorsUserInterests(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameQualificationAndMinors(id);
		Collection<Interests> interestList = new ArrayList<Interests>();
		List<String> interestSkills = new ArrayList<String>();
		for(User u : userList){
			interestList = u.getInterestList();
			for(Interests e : interestList){
				interestSkills.add(e.getName());
			}
		}	
//		for(String s : interestSkills){
//			System.out.println(s);
//		}
		return interestSkills;
	}
	
	public List<String> qualificationMinorsUserLanguages(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameQualificationAndMinors(id);
		Collection<Languages> languageList = new ArrayList<Languages>();
		List<String> languageSkills = new ArrayList<String>();
		for(User u : userList){
			languageList = u.getLanguageList();
			for(Languages e : languageList){
				languageSkills.add(e.getName());
			}
		}	
//		for(String s : languageSkills){
//			System.out.println(s);
//		}
		return languageSkills;
	}
	
	public List<String> qualificationMinorsUserKeywords(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameQualificationAndMinors(id);
		Collection<Keywords> keywordList = new ArrayList<Keywords>();
		List<String> keywordSkills = new ArrayList<String>();
		for(User u : userList){
			keywordList = u.getKeywordList();
			for(Keywords e : keywordList){
				keywordSkills.add(e.getName());
			}
		}	
//		for(String s : keywordSkills){
//			System.out.println(s);
//		}
		return keywordSkills;
	}
	
	public List<String> qualificationSchoolUserExtracurricular(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameQualificationAndSchools(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> extraSkills = new ArrayList<String>();
		for(User u : userList){
			extraList = u.getExtracurricularList();
			for(Extracurricular e : extraList){
				extraSkills.add(e.getName());
			}
		}	
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return extraSkills;
	}
	
	public List<String> qualificationSchoolUserIndustry(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameQualificationAndSchools(id);
		Collection<Industry> industryList = new ArrayList<Industry>();
		List<String> industrySkills = new ArrayList<String>();
		for(User u : userList){
			industryList = u.getIndustryList();
			for(Industry e : industryList){
				industrySkills.add(e.getName());
			}
		}	
//		for(String s : industrySkills){
//			System.out.println(s);
//		}
		return industrySkills;
	}
	
	public List<String> qualificationSchoolUserInterests(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameQualificationAndSchools(id);
		Collection<Interests> interestList = new ArrayList<Interests>();
		List<String> interestSkills = new ArrayList<String>();
		for(User u : userList){
			interestList = u.getInterestList();
			for(Interests e : interestList){
				interestSkills.add(e.getName());
			}
		}	
//		for(String s : interestSkills){
//			System.out.println(s);
//		}
		return interestSkills;
	}
	
	public List<String> qualificationSchoolUserLanguages(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameQualificationAndSchools(id);
		Collection<Languages> languageList = new ArrayList<Languages>();
		List<String> languageSkills = new ArrayList<String>();
		for(User u : userList){
			languageList = u.getLanguageList();
			for(Languages e : languageList){
				languageSkills.add(e.getName());
			}
		}	
//		for(String s : languageSkills){
//			System.out.println(s);
//		}
		return languageSkills;
	}
	
	public List<String> qualificationSchoolUserKeywords(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameQualificationAndMajors(id);
		Collection<Keywords> keywordList = new ArrayList<Keywords>();
		List<String> keywordSkills = new ArrayList<String>();
		for(User u : userList){
			keywordList = u.getKeywordList();
			for(Keywords e : keywordList){
				keywordSkills.add(e.getName());
			}
		}	
//		for(String s : keywordSkills){
//			System.out.println(s);
//		}
		return keywordSkills;
	}
	
	public List<String> majorMinorUserExtracurricular(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameMinorsAndMajors(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> extraSkills = new ArrayList<String>();
		for(User u : userList){
			extraList = u.getExtracurricularList();
			for(Extracurricular e : extraList){
				extraSkills.add(e.getName());
			}
		}	
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return extraSkills;
	}
	
	public List<String> majorMinorUserIndustry(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameMinorsAndMajors(id);
		Collection<Industry> industryList = new ArrayList<Industry>();
		List<String> industrySkills = new ArrayList<String>();
		for(User u : userList){
			industryList = u.getIndustryList();
			for(Industry e : industryList){
				industrySkills.add(e.getName());
			}
		}	
//		for(String s : industrySkills){
//			System.out.println(s);
//		}
		return industrySkills;
	}
	
	public List<String> majorMinorUserInterests(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameMinorsAndMajors(id);
		Collection<Interests> interestList = new ArrayList<Interests>();
		List<String> interestSkills = new ArrayList<String>();
		for(User u : userList){
			interestList = u.getInterestList();
			for(Interests e : interestList){
				interestSkills.add(e.getName());
			}
		}	
//		for(String s : interestSkills){
//			System.out.println(s);
//		}
		return interestSkills;
	}
	
	public List<String> majorMinorUserLanguages(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameMinorsAndMajors(id);
		Collection<Languages> languageList = new ArrayList<Languages>();
		List<String> languageSkills = new ArrayList<String>();
		for(User u : userList){
			languageList = u.getLanguageList();
			for(Languages e : languageList){
				languageSkills.add(e.getName());
			}
		}	
//		for(String s : languageSkills){
//			System.out.println(s);
//		}
		return languageSkills;
	}
	
	public List<String> majorMinorUserKeywords(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameMinorsAndMajors(id);
		Collection<Keywords> keywordList = new ArrayList<Keywords>();
		List<String> keywordSkills = new ArrayList<String>();
		for(User u : userList){
			keywordList = u.getKeywordList();
			for(Keywords e : keywordList){
				keywordSkills.add(e.getName());
			}
		}	
//		for(String s : keywordSkills){
//			System.out.println(s);
//		}
		return keywordSkills;
	}
	
	public List<String> schoolMajorUserExtracurricular(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameMajorAndSchools(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> extraSkills = new ArrayList<String>();
		for(User u : userList){
			extraList = u.getExtracurricularList();
			for(Extracurricular e : extraList){
				extraSkills.add(e.getName());
			}
		}	
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return extraSkills;
	}
	
	public List<String> schoolMajorUserIndustry(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameMajorAndSchools(id);
		Collection<Industry> industryList = new ArrayList<Industry>();
		List<String> industrySkills = new ArrayList<String>();
		for(User u : userList){
			industryList = u.getIndustryList();
			for(Industry e : industryList){
				industrySkills.add(e.getName());
			}
		}	
//		for(String s : industrySkills){
//			System.out.println(s);
//		}
		return industrySkills;
	}
	
	public List<String> schoolMajorUserInterests(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameMajorAndSchools(id);
		Collection<Interests> interestList = new ArrayList<Interests>();
		List<String> interestSkills = new ArrayList<String>();
		for(User u : userList){
			interestList = u.getInterestList();
			for(Interests e : interestList){
				interestSkills.add(e.getName());
			}
		}	
//		for(String s : interestSkills){
//			System.out.println(s);
//		}
		return interestSkills;
	}
	
	public List<String> schoolMajorUserLanguages(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameMajorAndSchools(id);
		Collection<Languages> languageList = new ArrayList<Languages>();
		List<String> languageSkills = new ArrayList<String>();
		for(User u : userList){
			languageList = u.getLanguageList();
			for(Languages e : languageList){
				languageSkills.add(e.getName());
			}
		}	
//		for(String s : languageSkills){
//			System.out.println(s);
//		}
		return languageSkills;
	}
	
	public List<String> schoolMajorUserKeywords(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameMajorAndSchools(id);
		Collection<Keywords> keywordList = new ArrayList<Keywords>();
		List<String> keywordSkills = new ArrayList<String>();
		for(User u : userList){
			keywordList = u.getKeywordList();
			for(Keywords e : keywordList){
				keywordSkills.add(e.getName());
			}
		}	
//		for(String s : keywordSkills){
//			System.out.println(s);
//		}
		return keywordSkills;
	}
	
	public List<String> schoolMinorUserExtracurricular(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameMinorsAndSchools(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> extraSkills = new ArrayList<String>();
		for(User u : userList){
			extraList = u.getExtracurricularList();
			for(Extracurricular e : extraList){
				extraSkills.add(e.getName());
			}
		}	
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return extraSkills;
	}
	
	public List<String> schoolMinorUserIndustry(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameMinorsAndSchools(id);
		Collection<Industry> industryList = new ArrayList<Industry>();
		List<String> industrySkills = new ArrayList<String>();
		for(User u : userList){
			industryList = u.getIndustryList();
			for(Industry e : industryList){
				industrySkills.add(e.getName());
			}
		}	
//		for(String s : industrySkills){
//			System.out.println(s);
//		}
		return industrySkills;
	}
	
	public List<String> schoolMinorUserInterests(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameMinorsAndSchools(id);
		Collection<Interests> interestList = new ArrayList<Interests>();
		List<String> interestSkills = new ArrayList<String>();
		for(User u : userList){
			interestList = u.getInterestList();
			for(Interests e : interestList){
				interestSkills.add(e.getName());
			}
		}	
//		for(String s : interestSkills){
//			System.out.println(s);
//		}
		return interestSkills;
	}
	
	public List<String> schoolMinorUserLanguages(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameMinorsAndSchools(id);
		Collection<Languages> languageList = new ArrayList<Languages>();
		List<String> languageSkills = new ArrayList<String>();
		for(User u : userList){
			languageList = u.getLanguageList();
			for(Languages e : languageList){
				languageSkills.add(e.getName());
			}
		}	
//		for(String s : languageSkills){
//			System.out.println(s);
//		}
		return languageSkills;
	}
	
	public List<String> schoolMinorUserKeywords(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameMinorsAndSchools(id);
		Collection<Keywords> keywordList = new ArrayList<Keywords>();
		List<String> keywordSkills = new ArrayList<String>();
		for(User u : userList){
			keywordList = u.getKeywordList();
			for(Keywords e : keywordList){
				keywordSkills.add(e.getName());
			}
		}	
//		for(String s : keywordSkills){
//			System.out.println(s);
//		}
		return keywordSkills;
	}
	
	public List<String> qualificationLocationUserExtracurricular(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameQualificationsAndlocation(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> extraSkills = new ArrayList<String>();
		for(User u : userList){
			extraList = u.getExtracurricularList();
			for(Extracurricular e : extraList){
				extraSkills.add(e.getName());
			}
		}	
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return extraSkills;
	}
	
	public List<String> qualificationLocationUserIndustry(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameQualificationsAndlocation(id);
		Collection<Industry> industryList = new ArrayList<Industry>();
		List<String> industrySkills = new ArrayList<String>();
		for(User u : userList){
			industryList = u.getIndustryList();
			for(Industry e : industryList){
				industrySkills.add(e.getName());
			}
		}	
//		for(String s : industrySkills){
//			System.out.println(s);
//		}
		return industrySkills;
	}
	
	public List<String> qualificationLocationUserInterests(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameQualificationsAndlocation(id);
		Collection<Interests> interestList = new ArrayList<Interests>();
		List<String> interestSkills = new ArrayList<String>();
		for(User u : userList){
			interestList = u.getInterestList();
			for(Interests e : interestList){
				interestSkills.add(e.getName());
			}
		}	
//		for(String s : interestSkills){
//			System.out.println(s);
//		}
		return interestSkills;
	}
	
	public List<String> qualificationLocationUserLanguages(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameQualificationsAndlocation(id);
		Collection<Languages> languageList = new ArrayList<Languages>();
		List<String> languageSkills = new ArrayList<String>();
		for(User u : userList){
			languageList = u.getLanguageList();
			for(Languages e : languageList){
				languageSkills.add(e.getName());
			}
		}	
//		for(String s : languageSkills){
//			System.out.println(s);
//		}
		return languageSkills;
	}
	
	public List<String> qualificationLocationUserKeywords(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameQualificationsAndlocation(id);
		Collection<Keywords> keywordList = new ArrayList<Keywords>();
		List<String> keywordSkills = new ArrayList<String>();
		for(User u : userList){
			keywordList = u.getKeywordList();
			for(Keywords e : keywordList){
				keywordSkills.add(e.getName());
			}
		}	
//		for(String s : keywordSkills){
//			System.out.println(s);
//		}
		return keywordSkills;
	}
	
	public List<String> locationMajorUserExtracurricular(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameLocationAndMajors(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> extraSkills = new ArrayList<String>();
		for(User u : userList){
			extraList = u.getExtracurricularList();
			for(Extracurricular e : extraList){
				extraSkills.add(e.getName());
			}
		}	
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return extraSkills;
	}
	
	public List<String> locationMajorUserIndustry(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameLocationAndMajors(id);
		Collection<Industry> industryList = new ArrayList<Industry>();
		List<String> industrySkills = new ArrayList<String>();
		for(User u : userList){
			industryList = u.getIndustryList();
			for(Industry e : industryList){
				industrySkills.add(e.getName());
			}
		}	
//		for(String s : industrySkills){
//			System.out.println(s);
//		}
		return industrySkills;
	}
	
	public List<String> locationMajorUserInterests(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameLocationAndMajors(id);
		Collection<Interests> interestList = new ArrayList<Interests>();
		List<String> interestSkills = new ArrayList<String>();
		for(User u : userList){
			interestList = u.getInterestList();
			for(Interests e : interestList){
				interestSkills.add(e.getName());
			}
		}	
//		for(String s : interestSkills){
//			System.out.println(s);
//		}
		return interestSkills;
	}
	
	public List<String> locationMajorUserLanguages(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameLocationAndMajors(id);
		Collection<Languages> languageList = new ArrayList<Languages>();
		List<String> languageSkills = new ArrayList<String>();
		for(User u : userList){
			languageList = u.getLanguageList();
			for(Languages e : languageList){
				languageSkills.add(e.getName());
			}
		}	
//		for(String s : languageSkills){
//			System.out.println(s);
//		}
		return languageSkills;
	}
	
	public List<String> locationMajorUserKeywords(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameLocationAndMajors(id);
		Collection<Keywords> keywordList = new ArrayList<Keywords>();
		List<String> keywordSkills = new ArrayList<String>();
		for(User u : userList){
			keywordList = u.getKeywordList();
			for(Keywords e : keywordList){
				keywordSkills.add(e.getName());
			}
		}	
//		for(String s : keywordSkills){
//			System.out.println(s);
//		}
		return keywordSkills;
	}
	
	public List<String> jobTitleLocationUserExtracurricular(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameJobTitleAndlocation(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> extraSkills = new ArrayList<String>();
		for(User u : userList){
			extraList = u.getExtracurricularList();
			for(Extracurricular e : extraList){
				extraSkills.add(e.getName());
			}
		}	
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return extraSkills;
	}
	
	public List<String> jobTitleLocationUserIndustry(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameJobTitleAndlocation(id);
		Collection<Industry> industryList = new ArrayList<Industry>();
		List<String> industrySkills = new ArrayList<String>();
		for(User u : userList){
			industryList = u.getIndustryList();
			for(Industry e : industryList){
				industrySkills.add(e.getName());
			}
		}	
//		for(String s : industrySkills){
//			System.out.println(s);
//		}
		return industrySkills;
	}
	
	public List<String> jobTitleLocationUserInterests(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameJobTitleAndlocation(id);
		Collection<Interests> interestList = new ArrayList<Interests>();
		List<String> interestSkills = new ArrayList<String>();
		for(User u : userList){
			interestList = u.getInterestList();
			for(Interests e : interestList){
				interestSkills.add(e.getName());
			}
		}	
//		for(String s : interestSkills){
//			System.out.println(s);
//		}
		return interestSkills;
	}
	
	public List<String> jobTitleLocationUserLanguages(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameJobTitleAndlocation(id);
		Collection<Languages> languageList = new ArrayList<Languages>();
		List<String> languageSkills = new ArrayList<String>();
		for(User u : userList){
			languageList = u.getLanguageList();
			for(Languages e : languageList){
				languageSkills.add(e.getName());
			}
		}	
//		for(String s : languageSkills){
//			System.out.println(s);
//		}
		return languageSkills;
	}
	
	public List<String> jobTitleLocationUserKeywords(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameJobTitleAndlocation(id);
		Collection<Keywords> keywordList = new ArrayList<Keywords>();
		List<String> keywordSkills = new ArrayList<String>();
		for(User u : userList){
			keywordList = u.getKeywordList();
			for(Keywords e : keywordList){
				keywordSkills.add(e.getName());
			}
		}	
//		for(String s : keywordSkills){
//			System.out.println(s);
//		}
		return keywordSkills;
	}
	
	public List<String> jobTitleAgeUserExtracurricular(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameAgeAndJobTitle(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> extraSkills = new ArrayList<String>();
		for(User u : userList){
			extraList = u.getExtracurricularList();
			for(Extracurricular e : extraList){
				extraSkills.add(e.getName());
			}
		}	
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return extraSkills;
	}
	
	public List<String> jobTitleAgeUserIndustry(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameAgeAndJobTitle(id);
		Collection<Industry> industryList = new ArrayList<Industry>();
		List<String> industrySkills = new ArrayList<String>();
		for(User u : userList){
			industryList = u.getIndustryList();
			for(Industry e : industryList){
				industrySkills.add(e.getName());
			}
		}	
//		for(String s : industrySkills){
//			System.out.println(s);
//		}
		return industrySkills;
	}
	
	public List<String> jobTitleAgeUserInterests(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameAgeAndJobTitle(id);
		Collection<Interests> interestList = new ArrayList<Interests>();
		List<String> interestSkills = new ArrayList<String>();
		for(User u : userList){
			interestList = u.getInterestList();
			for(Interests e : interestList){
				interestSkills.add(e.getName());
			}
		}	
//		for(String s : interestSkills){
//			System.out.println(s);
//		}
		return interestSkills;
	}
	
	public List<String> jobTitleAgeUserLanguages(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameAgeAndJobTitle(id);
		Collection<Languages> languageList = new ArrayList<Languages>();
		List<String> languageSkills = new ArrayList<String>();
		for(User u : userList){
			languageList = u.getLanguageList();
			for(Languages e : languageList){
				languageSkills.add(e.getName());
			}
		}	
//		for(String s : languageSkills){
//			System.out.println(s);
//		}
		return languageSkills;
	}
	
	public List<String> jobTitleAgeUserKeywords(int id){
		List<User> userList = new ArrayList<User>();
		userList = usersWithSameAgeAndJobTitle(id);
		Collection<Keywords> keywordList = new ArrayList<Keywords>();
		List<String> keywordSkills = new ArrayList<String>();
		for(User u : userList){
			keywordList = u.getKeywordList();
			for(Keywords e : keywordList){
				keywordSkills.add(e.getName());
			}
		}	
//		for(String s : keywordSkills){
//			System.out.println(s);
//		}
		return keywordSkills;
	}

	public List<String> ageUserExtracurricular(int id){
		List<User> userList = new ArrayList<User>();
		userList = userWithsameAge(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> extraSkills = new ArrayList<String>();
		for(User u : userList){
			extraList = u.getExtracurricularList();
			for(Extracurricular e : extraList){
				extraSkills.add(e.getName());
			}
		}	
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return extraSkills;
	}
	
	public List<String> ageUserIndustry(int id){
		List<User> userList = new ArrayList<User>();
		userList = userWithsameAge(id);
		Collection<Industry> industryList = new ArrayList<Industry>();
		List<String> industrySkills = new ArrayList<String>();
		for(User u : userList){
			industryList = u.getIndustryList();
			for(Industry e : industryList){
				industrySkills.add(e.getName());
			}
		}	
//		for(String s : industrySkills){
//			System.out.println(s);
//		}
		return industrySkills;
	}
	
	public List<String> ageUserInterests(int id){
		List<User> userList = new ArrayList<User>();
		userList = userWithsameAge(id);
		Collection<Interests> interestList = new ArrayList<Interests>();
		List<String> interestSkills = new ArrayList<String>();
		for(User u : userList){
			interestList = u.getInterestList();
			for(Interests e : interestList){
				interestSkills.add(e.getName());
			}
		}	
//		for(String s : interestSkills){
//			System.out.println(s);
//		}
		return interestSkills;
	}
	
	public List<String> ageUserLanguages(int id){
		List<User> userList = new ArrayList<User>();
		userList = userWithsameAge(id);
		Collection<Languages> languageList = new ArrayList<Languages>();
		List<String> languageSkills = new ArrayList<String>();
		for(User u : userList){
			languageList = u.getLanguageList();
			for(Languages e : languageList){
				languageSkills.add(e.getName());
			}
		}	
//		for(String s : languageSkills){
//			System.out.println(s);
//		}
		return languageSkills;
	}
	
	public List<String> ageUserKeywords(int id){
		List<User> userList = new ArrayList<User>();
		userList = userWithsameAge(id);
		Collection<Keywords> keywordList = new ArrayList<Keywords>();
		List<String> keywordSkills = new ArrayList<String>();
		for(User u : userList){
			keywordList = u.getKeywordList();
			for(Keywords e : keywordList){
				keywordSkills.add(e.getName());
			}
		}	
//		for(String s : keywordSkills){
//			System.out.println(s);
//		}
		return keywordSkills;
	}
	
	public List<String> goalsUserExtracurricular(int id){
		List<User> userList = new ArrayList<User>();
		userList = userWithsameGoals(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> extraSkills = new ArrayList<String>();
		for(User u : userList){
			extraList = u.getExtracurricularList();
			for(Extracurricular e : extraList){
				extraSkills.add(e.getName());
			}
		}	
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return extraSkills;
	}
	
	public List<String> goalsUserIndustry(int id){
		List<User> userList = new ArrayList<User>();
		userList = userWithsameGoals(id);
		Collection<Industry> industryList = new ArrayList<Industry>();
		List<String> industrySkills = new ArrayList<String>();
		for(User u : userList){
			industryList = u.getIndustryList();
			for(Industry e : industryList){
				industrySkills.add(e.getName());
			}
		}	
//		for(String s : industrySkills){
//			System.out.println(s);
//		}
		return industrySkills;
	}
	
	public List<String> goalsUserInterests(int id){
		List<User> userList = new ArrayList<User>();
		userList = userWithsameGoals(id);
		Collection<Interests> interestList = new ArrayList<Interests>();
		List<String> interestSkills = new ArrayList<String>();
		for(User u : userList){
			interestList = u.getInterestList();
			for(Interests e : interestList){
				interestSkills.add(e.getName());
			}
		}	
//		for(String s : interestSkills){
//			System.out.println(s);
//		}
		return interestSkills;
	}
	
	public List<String> goalsUserLanguages(int id){
		List<User> userList = new ArrayList<User>();
		userList = userWithsameGoals(id);
		Collection<Languages> languageList = new ArrayList<Languages>();
		List<String> languageSkills = new ArrayList<String>();
		for(User u : userList){
			languageList = u.getLanguageList();
			for(Languages e : languageList){
				languageSkills.add(e.getName());
			}
		}	
//		for(String s : languageSkills){
//			System.out.println(s);
//		}
		return languageSkills;
	}
	
	public List<String> goalsUserKeywords(int id){
		List<User> userList = new ArrayList<User>();
		userList = userWithsameGoals(id);
		Collection<Keywords> keywordList = new ArrayList<Keywords>();
		List<String> keywordSkills = new ArrayList<String>();
		for(User u : userList){
			keywordList = u.getKeywordList();
			for(Keywords e : keywordList){
				keywordSkills.add(e.getName());
			}
		}	
//		for(String s : keywordSkills){
//			System.out.println(s);
//		}
		return keywordSkills;
	}

	public List<String> majorUserExtracurricular(int id){
		List<UserDataPojo> userList = new ArrayList<UserDataPojo>();
		userList = userWithsameMajors(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> extraSkills = new ArrayList<String>();
		for(UserDataPojo u : userList){
			extraList = u.getExtracurricularList();
			for(Extracurricular e : extraList){
				extraSkills.add(e.getName());
			}
		}	
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
			return extraSkills;
	}
	
	public List<String> majorUserIndustry(int id){
		List<UserDataPojo> userList = new ArrayList<UserDataPojo>();
		userList = userWithsameMajors(id);
		Collection<Industry> industryList = new ArrayList<Industry>();
		List<String> industrySkills = new ArrayList<String>();
		for(UserDataPojo u : userList){
			industryList = u.getIndustryList();
			for(Industry e : industryList){
				industrySkills.add(e.getName());
			}
		}	
//		for(String s : industrySkills){
//			System.out.println(s);
//		}
		return industrySkills;
	}
	
	public List<String> majorUserInterests(int id){
		List<UserDataPojo> userList = new ArrayList<UserDataPojo>();
		userList = userWithsameMajors(id);
		Collection<Interests> interestList = new ArrayList<Interests>();
		List<String> interestSkills = new ArrayList<String>();
		for(UserDataPojo u : userList){
			interestList = u.getInterestList();
			for(Interests e : interestList){
				interestSkills.add(e.getName());
			}
		}	
//		for(String s : interestSkills){
//			System.out.println(s);
//		}
		return interestSkills;
	}
	
	public List<String> majorUserLanguages(int id){
		List<UserDataPojo> userList = new ArrayList<UserDataPojo>();
		userList = userWithsameMajors(id);
		Collection<Languages> languageList = new ArrayList<Languages>();
		List<String> languageSkills = new ArrayList<String>();
		for(UserDataPojo u : userList){
			languageList = u.getLanguageList();
			for(Languages e : languageList){
				languageSkills.add(e.getName());
			}
		}	
//		for(String s : languageSkills){
//			System.out.println(s);
//		}
		return languageSkills;
	}
	
	public List<String> majorUserKeywords(int id){
		List<UserDataPojo> userList = new ArrayList<UserDataPojo>();
		userList = userWithsameMajors(id);
		Collection<Keywords> keywordList = new ArrayList<Keywords>();
		List<String> keywordSkills = new ArrayList<String>();
		for(UserDataPojo u : userList){
			keywordList = u.getKeywordList();
			for(Keywords e : keywordList){
				keywordSkills.add(e.getName());
			}
		}	
//		for(String s : keywordSkills){
//			System.out.println(s);
//		}
		return keywordSkills;
	}
	
	public List<String> minorUserExtracurricular(int id){
		List<UserDataPojo> userList = new ArrayList<UserDataPojo>();
		userList = userWithsameMinors(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> extraSkills = new ArrayList<String>();
		for(UserDataPojo u : userList){
			extraList = u.getExtracurricularList();
			for(Extracurricular e : extraList){
				extraSkills.add(e.getName());
			}
		}	
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return extraSkills;
	}
	
	public List<String> minorUserIndustry(int id){
		List<UserDataPojo> userList = new ArrayList<UserDataPojo>();
		userList =  userWithsameMinors(id);
		Collection<Industry> industryList = new ArrayList<Industry>();
		List<String> industrySkills = new ArrayList<String>();
		for(UserDataPojo u : userList){
			industryList = u.getIndustryList();
			for(Industry e : industryList){
				industrySkills.add(e.getName());
			}
		}	
//		for(String s : industrySkills){
//			System.out.println(s);
//		}
		return industrySkills;
	}
	
	public List<String> minorUserInterests(int id){
		List<UserDataPojo> userList = new ArrayList<UserDataPojo>();
		userList =  userWithsameMinors(id);
		Collection<Interests> interestList = new ArrayList<Interests>();
		List<String> interestSkills = new ArrayList<String>();
		for(UserDataPojo u : userList){
			interestList = u.getInterestList();
			for(Interests e : interestList){
				interestSkills.add(e.getName());
			}
		}	
//		for(String s : interestSkills){
//			System.out.println(s);
//		}
		return interestSkills;
	}
	
	public List<String> minorUserLanguages(int id){
		List<UserDataPojo> userList = new ArrayList<UserDataPojo>();
		userList =  userWithsameMinors(id);
		Collection<Languages> languageList = new ArrayList<Languages>();
		List<String> languageSkills = new ArrayList<String>();
		for(UserDataPojo u : userList){
			languageList = u.getLanguageList();
			for(Languages e : languageList){
				languageSkills.add(e.getName());
			}
		}	
//		for(String s : languageSkills){
//			System.out.println(s);
//		}
		return languageSkills;
	}
	
	public List<String> minorUserKeywords(int id){
		List<UserDataPojo> userList = new ArrayList<UserDataPojo>();
		userList =  userWithsameMinors(id);
		Collection<Keywords> keywordList = new ArrayList<Keywords>();
		List<String> keywordSkills = new ArrayList<String>();
		for(UserDataPojo u : userList){
			keywordList = u.getKeywordList();
			for(Keywords e : keywordList){
				keywordSkills.add(e.getName());
			}
		}	
//		for(String s : keywordSkills){
//			System.out.println(s);
//		}
		return keywordSkills;
	}
	
	public ResponseCombinedList qualificationMajorUserExperience(int id){
		methods = new HelperMethods();
		List<User> userList = new ArrayList<User>();
		expEntity = new Experiences();
		userList = usersWithSameQualificationAndMajors(id);
		Collection<Experiences> expList = new ArrayList<Experiences>();
		List<String> jobTitleList = new ArrayList<String>();
		List<Double> wagesList = new ArrayList<Double>();
		Double wagesSum = 0.0;
		Double wagesAverage = 0.0;
		Integer experienceCount = 0;
		Integer start_year = 0;
		Integer end_year = 0;
		Integer yearsWorked = 0;
		for(User u : userList){
			expList = u.getExperienceList();
			experienceCount = expList.size();
			expEntity = expList.iterator().next();
			start_year = methods.yearCalculator(expEntity.getStart_date());
			for(Experiences e : expList){
				jobTitleList.add(e.getJob_title());
				if(e.getMost_recent() == true){
				wagesList.add(e.getHourly_rate());
				if(e.getEnd_date().equals("Present")){
					LocalDate today = LocalDate.now();
					end_year = today.getYear();
				} else {
					end_year = methods.yearCalculator(e.getEnd_date());
					 }		
				}
			}
		}
		for(Double d : wagesList){
			wagesSum += d;
		}
		wagesAverage = wagesSum/wagesList.size();
		yearsWorked = end_year-start_year;
		ResponseCombinedList list = new ResponseCombinedList();
		list.setInt1(yearsWorked);
		list.setInt2(experienceCount);
		list.setDouble1(wagesAverage);
		list.setListone(jobTitleList);
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return list;
	}

	public ResponseCombinedList qualificationMinorUserExperience(int id){
		methods = new HelperMethods();
		List<User> userList = new ArrayList<User>();
		expEntity = new Experiences();
		userList = usersWithSameQualificationAndMinors(id);
		Collection<Experiences> expList = new ArrayList<Experiences>();
		List<String> jobTitleList = new ArrayList<String>();
		List<Double> wagesList = new ArrayList<Double>();
		Double wagesSum = 0.0;
		Double wagesAverage = 0.0;
		Integer experienceCount = 0;
		Integer start_year = 0;
		Integer end_year = 0;
		Integer yearsWorked = 0;
		for(User u : userList){
			expList = u.getExperienceList();
			experienceCount = expList.size();
			expEntity = expList.iterator().next();
			start_year = methods.yearCalculator(expEntity.getStart_date());
			for(Experiences e : expList){
				jobTitleList.add(e.getJob_title());
				if(e.getMost_recent() == true){
				wagesList.add(e.getHourly_rate());
				if(e.getEnd_date().equals("Present")){
					LocalDate today = LocalDate.now();
					end_year = today.getYear();
				} else {
					end_year = methods.yearCalculator(e.getEnd_date());
					 }		
				}
			}
		}
		for(Double d : wagesList){
			wagesSum += d;
		}
		wagesAverage = wagesSum/wagesList.size();
		yearsWorked = end_year-start_year;
		ResponseCombinedList list = new ResponseCombinedList();
		list.setInt1(yearsWorked);
		list.setInt2(experienceCount);
		list.setDouble1(wagesAverage);
		list.setListone(jobTitleList);
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return list;
	}

	public ResponseCombinedList qualificationSchoolsUserExperience(int id){
		methods = new HelperMethods();
		List<User> userList = new ArrayList<User>();
		expEntity = new Experiences();
		userList = usersWithSameQualificationAndSchools(id);
		Collection<Experiences> expList = new ArrayList<Experiences>();
		List<String> jobTitleList = new ArrayList<String>();
		List<Double> wagesList = new ArrayList<Double>();
		Double wagesSum = 0.0;
		Double wagesAverage = 0.0;
		Integer experienceCount = 0;
		Integer start_year = 0;
		Integer end_year = 0;
		Integer yearsWorked = 0;
		for(User u : userList){
			expList = u.getExperienceList();
			experienceCount = expList.size();
			expEntity = expList.iterator().next();
			start_year = methods.yearCalculator(expEntity.getStart_date());
			for(Experiences e : expList){
				jobTitleList.add(e.getJob_title());
				if(e.getMost_recent() == true){
				wagesList.add(e.getHourly_rate());
				if(e.getEnd_date().equals("Present")){
					LocalDate today = LocalDate.now();
					end_year = today.getYear();
				} else {
					end_year = methods.yearCalculator(e.getEnd_date());
					 }		
				}
			}
		}
		for(Double d : wagesList){
			wagesSum += d;
		}
		wagesAverage = wagesSum/wagesList.size();
		yearsWorked = end_year-start_year;
		ResponseCombinedList list = new ResponseCombinedList();
		list.setInt1(yearsWorked);
		list.setInt2(experienceCount);
		list.setDouble1(wagesAverage);
		list.setListone(jobTitleList);
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return list;
	}

	public ResponseCombinedList majorMinorUserExperience(int id){
		methods = new HelperMethods();
		List<User> userList = new ArrayList<User>();
		expEntity = new Experiences();
		userList = usersWithSameMinorsAndMajors(id);
		Collection<Experiences> expList = new ArrayList<Experiences>();
		List<String> jobTitleList = new ArrayList<String>();
		List<Double> wagesList = new ArrayList<Double>();
		Double wagesSum = 0.0;
		Double wagesAverage = 0.0;
		Integer experienceCount = 0;
		Integer start_year = 0;
		Integer end_year = 0;
		Integer yearsWorked = 0;
		for(User u : userList){
			expList = u.getExperienceList();
			experienceCount = expList.size();
			expEntity = expList.iterator().next();
			start_year = methods.yearCalculator(expEntity.getStart_date());
			for(Experiences e : expList){
				jobTitleList.add(e.getJob_title());
				if(e.getMost_recent() == true){
				wagesList.add(e.getHourly_rate());
				if(e.getEnd_date().equals("Present")){
					LocalDate today = LocalDate.now();
					end_year = today.getYear();
				} else {
					end_year = methods.yearCalculator(e.getEnd_date());
					 }		
				}
			}
		}
		for(Double d : wagesList){
			wagesSum += d;
		}
		wagesAverage = wagesSum/wagesList.size();
		yearsWorked = end_year-start_year;
		ResponseCombinedList list = new ResponseCombinedList();
		list.setInt1(yearsWorked);
		list.setInt2(experienceCount);
		list.setDouble1(wagesAverage);
		list.setListone(jobTitleList);
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return list;
	}
	
	public ResponseCombinedList schoolMinorUserExperience(int id){
		methods = new HelperMethods();
		List<User> userList = new ArrayList<User>();
		expEntity = new Experiences();
		userList = usersWithSameMinorsAndSchools(id);
		Collection<Experiences> expList = new ArrayList<Experiences>();
		List<String> jobTitleList = new ArrayList<String>();
		List<Double> wagesList = new ArrayList<Double>();
		Double wagesSum = 0.0;
		Double wagesAverage = 0.0;
		Integer experienceCount = 0;
		Integer start_year = 0;
		Integer end_year = 0;
		Integer yearsWorked = 0;
		for(User u : userList){
			expList = u.getExperienceList();
			experienceCount = expList.size();
			expEntity = expList.iterator().next();
			start_year = methods.yearCalculator(expEntity.getStart_date());
			for(Experiences e : expList){
				jobTitleList.add(e.getJob_title());
				if(e.getMost_recent() == true){
				wagesList.add(e.getHourly_rate());
				if(e.getEnd_date().equals("Present")){
					LocalDate today = LocalDate.now();
					end_year = today.getYear();
				} else {
					end_year = methods.yearCalculator(e.getEnd_date());
					 }		
				}
			}
		}
		for(Double d : wagesList){
			wagesSum += d;
		}
		wagesAverage = wagesSum/wagesList.size();
		yearsWorked = end_year-start_year;
		ResponseCombinedList list = new ResponseCombinedList();
		list.setInt1(yearsWorked);
		list.setInt2(experienceCount);
		list.setDouble1(wagesAverage);
		list.setListone(jobTitleList);
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return list;
	}

	public ResponseCombinedList schoolMajorsUserExperience(int id){
		methods = new HelperMethods();
		List<User> userList = new ArrayList<User>();
		expEntity = new Experiences();
		userList = usersWithSameMajorAndSchools(id);
		Collection<Experiences> expList = new ArrayList<Experiences>();
		List<String> jobTitleList = new ArrayList<String>();
		List<Double> wagesList = new ArrayList<Double>();
		Double wagesSum = 0.0;
		Double wagesAverage = 0.0;
		Integer experienceCount = 0;
		Integer start_year = 0;
		Integer end_year = 0;
		Integer yearsWorked = 0;
		for(User u : userList){
			expList = u.getExperienceList();
			experienceCount = expList.size();
			expEntity = expList.iterator().next();
			start_year = methods.yearCalculator(expEntity.getStart_date());
			for(Experiences e : expList){
				jobTitleList.add(e.getJob_title());
				if(e.getMost_recent() == true){
				wagesList.add(e.getHourly_rate());
				if(e.getEnd_date().equals("Present")){
					LocalDate today = LocalDate.now();
					end_year = today.getYear();
				} else {
					end_year = methods.yearCalculator(e.getEnd_date());
					 }		
				}
			}
		}
		for(Double d : wagesList){
			wagesSum += d;
		}
		wagesAverage = wagesSum/wagesList.size();
		yearsWorked = end_year-start_year;
		ResponseCombinedList list = new ResponseCombinedList();
		list.setInt1(yearsWorked);
		list.setInt2(experienceCount);
		list.setDouble1(wagesAverage);
		list.setListone(jobTitleList);
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return list;
	}

	public ResponseCombinedList qualificationLocationUserExperience(int id){
		methods = new HelperMethods();
		List<User> userList = new ArrayList<User>();
		expEntity = new Experiences();
		userList = usersWithSameQualificationsAndlocation(id);
		Collection<Experiences> expList = new ArrayList<Experiences>();
		List<String> jobTitleList = new ArrayList<String>();
		List<Double> wagesList = new ArrayList<Double>();
		Double wagesSum = 0.0;
		Double wagesAverage = 0.0;
		Integer experienceCount = 0;
		Integer start_year = 0;
		Integer end_year = 0;
		Integer yearsWorked = 0;
		for(User u : userList){
			expList = u.getExperienceList();
			experienceCount = expList.size();
			expEntity = expList.iterator().next();
			start_year = methods.yearCalculator(expEntity.getStart_date());
			for(Experiences e : expList){
				jobTitleList.add(e.getJob_title());
				if(e.getMost_recent() == true){
				wagesList.add(e.getHourly_rate());
				if(e.getEnd_date().equals("Present")){
					LocalDate today = LocalDate.now();
					end_year = today.getYear();
				} else {
					end_year = methods.yearCalculator(e.getEnd_date());
					 }		
				}
			}
		}
		for(Double d : wagesList){
			wagesSum += d;
		}
		wagesAverage = wagesSum/wagesList.size();
		yearsWorked = end_year-start_year;
		ResponseCombinedList list = new ResponseCombinedList();
		list.setInt1(yearsWorked);
		list.setInt2(experienceCount);
		list.setDouble1(wagesAverage);
		list.setListone(jobTitleList);
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return list;
	}
	
	public ResponseCombinedList locationMajorsUserExperience(int id){
		methods = new HelperMethods();
		List<User> userList = new ArrayList<User>();
		expEntity = new Experiences();
		userList = usersWithSameLocationAndMajors(id);
		Collection<Experiences> expList = new ArrayList<Experiences>();
		List<String> jobTitleList = new ArrayList<String>();
		List<Double> wagesList = new ArrayList<Double>();
		Double wagesSum = 0.0;
		Double wagesAverage = 0.0;
		Integer experienceCount = 0;
		Integer start_year = 0;
		Integer end_year = 0;
		Integer yearsWorked = 0;
		for(User u : userList){
			expList = u.getExperienceList();
			experienceCount = expList.size();
			expEntity = expList.iterator().next();
			start_year = methods.yearCalculator(expEntity.getStart_date());
			for(Experiences e : expList){
				jobTitleList.add(e.getJob_title());
				if(e.getMost_recent() == true){
				wagesList.add(e.getHourly_rate());
				if(e.getEnd_date().equals("Present")){
					LocalDate today = LocalDate.now();
					end_year = today.getYear();
				} else {
					end_year = methods.yearCalculator(e.getEnd_date());
					 }		
				}
			}
		}
		for(Double d : wagesList){
			wagesSum += d;
		}
		wagesAverage = wagesSum/wagesList.size();
		yearsWorked = end_year-start_year;
		ResponseCombinedList list = new ResponseCombinedList();
		list.setInt1(yearsWorked);
		list.setInt2(experienceCount);
		list.setDouble1(wagesAverage);
		list.setListone(jobTitleList);
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return list;
	}
	
	public ResponseCombinedList jobTitleAndLocationUserExperience(int id){
		methods = new HelperMethods();
		List<User> userList = new ArrayList<User>();
		expEntity = new Experiences();
		userList = usersWithSameJobTitleAndlocation(id);
		Collection<Experiences> expList = new ArrayList<Experiences>();
		List<String> jobTitleList = new ArrayList<String>();
		List<Double> wagesList = new ArrayList<Double>();
		Double wagesSum = 0.0;
		Double wagesAverage = 0.0;
		Integer experienceCount = 0;
		Integer start_year = 0;
		Integer end_year = 0;
		Integer yearsWorked = 0;
		for(User u : userList){
			expList = u.getExperienceList();
			experienceCount = expList.size();
			expEntity = expList.iterator().next();
			start_year = methods.yearCalculator(expEntity.getStart_date());
			for(Experiences e : expList){
				jobTitleList.add(e.getJob_title());
				if(e.getMost_recent() == true){
				wagesList.add(e.getHourly_rate());
				if(e.getEnd_date().equals("Present")){
					LocalDate today = LocalDate.now();
					end_year = today.getYear();
				} else {
					end_year = methods.yearCalculator(e.getEnd_date());
					 }		
				}
			}
		}
		for(Double d : wagesList){
			wagesSum += d;
		}
		wagesAverage = wagesSum/wagesList.size();
		yearsWorked = end_year-start_year;
		ResponseCombinedList list = new ResponseCombinedList();
		list.setInt1(yearsWorked);
		list.setInt2(experienceCount);
		list.setDouble1(wagesAverage);
		list.setListone(jobTitleList);
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return list;
	}
	
	public ResponseCombinedList ageJobTitleUserExperience(int id){
		methods = new HelperMethods();
		List<User> userList = new ArrayList<User>();
		expEntity = new Experiences();
		userList = usersWithSameAgeAndJobTitle(id);
		Collection<Experiences> expList = new ArrayList<Experiences>();
		List<String> jobTitleList = new ArrayList<String>();
		List<Double> wagesList = new ArrayList<Double>();
		Double wagesSum = 0.0;
		Double wagesAverage = 0.0;
		Integer experienceCount = 0;
		Integer start_year = 0;
		Integer end_year = 0;
		Integer yearsWorked = 0;
		for(User u : userList){
			expList = u.getExperienceList();
			experienceCount = expList.size();
			expEntity = expList.iterator().next();
			start_year = methods.yearCalculator(expEntity.getStart_date());
			for(Experiences e : expList){
				jobTitleList.add(e.getJob_title());
				if(e.getMost_recent() == true){
				wagesList.add(e.getHourly_rate());
				if(e.getEnd_date().equals("Present")){
					LocalDate today = LocalDate.now();
					end_year = today.getYear();
				} else {
					end_year = methods.yearCalculator(e.getEnd_date());
					 }		
				}
			}
		}
		for(Double d : wagesList){
			wagesSum += d;
		}
		wagesAverage = wagesSum/wagesList.size();
		yearsWorked = end_year-start_year;
		ResponseCombinedList list = new ResponseCombinedList();
		list.setInt1(yearsWorked);
		list.setInt2(experienceCount);
		list.setDouble1(wagesAverage);
		list.setListone(jobTitleList);
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return list;
	}
	
	public ResponseCombinedList ageUserExperience(int id){
		methods = new HelperMethods();
		List<User> userList = new ArrayList<User>();
		expEntity = new Experiences();
		userList = userWithsameAge(id);
		Collection<Experiences> expList = new ArrayList<Experiences>();
		List<String> jobTitleList = new ArrayList<String>();
		List<Double> wagesList = new ArrayList<Double>();
		Double wagesSum = 0.0;
		Double wagesAverage = 0.0;
		Integer experienceCount = 0;
		Integer start_year = 0;
		Integer end_year = 0;
		Integer yearsWorked = 0;
		for(User u : userList){
			expList = u.getExperienceList();
			experienceCount = expList.size();
			expEntity = expList.iterator().next();
			start_year = methods.yearCalculator(expEntity.getStart_date());
			for(Experiences e : expList){
				jobTitleList.add(e.getJob_title());
				if(e.getMost_recent() == true){
				wagesList.add(e.getHourly_rate());
				if(e.getEnd_date().equals("Present")){
					LocalDate today = LocalDate.now();
					end_year = today.getYear();
				} else {
					end_year = methods.yearCalculator(e.getEnd_date());
					 }		
				}
			}
		}
		for(Double d : wagesList){
			wagesSum += d;
		}
		wagesAverage = wagesSum/wagesList.size();
		yearsWorked = end_year-start_year;
		ResponseCombinedList list = new ResponseCombinedList();
		list.setInt1(yearsWorked);
		list.setInt2(experienceCount);
		list.setDouble1(wagesAverage);
		list.setListone(jobTitleList);
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return list;
	}
	
	public ResponseCombinedList goalsUserExperience(int id){
		methods = new HelperMethods();
		List<User> userList = new ArrayList<User>();
		expEntity = new Experiences();
		userList = userWithsameGoals(id);
		Collection<Experiences> expList = new ArrayList<Experiences>();
		List<String> jobTitleList = new ArrayList<String>();
		List<Double> wagesList = new ArrayList<Double>();
		Double wagesSum = 0.0;
		Double wagesAverage = 0.0;
		Integer experienceCount = 0;
		Integer start_year = 0;
		Integer end_year = 0;
		Integer yearsWorked = 0;
		for(User u : userList){
			expList = u.getExperienceList();
			experienceCount = expList.size();
			expEntity = expList.iterator().next();
			start_year = methods.yearCalculator(expEntity.getStart_date());
			for(Experiences e : expList){
				jobTitleList.add(e.getJob_title());
				if(e.getMost_recent() == true){
				wagesList.add(e.getHourly_rate());
				if(e.getEnd_date().equals("Present")){
					LocalDate today = LocalDate.now();
					end_year = today.getYear();
				} else {
					end_year = methods.yearCalculator(e.getEnd_date());
					 }		
				}
			}
		}
		for(Double d : wagesList){
			wagesSum += d;
		}
		wagesAverage = wagesSum/wagesList.size();
		yearsWorked = end_year-start_year;
		ResponseCombinedList list = new ResponseCombinedList();
		list.setInt1(yearsWorked);
		list.setInt2(experienceCount);
		list.setDouble1(wagesAverage);
		list.setListone(jobTitleList);
//		for(String s : extraSkills){
//			System.out.println(s);
//		}
		return list;
	}
	
	public Double qualificationMajorUserHS(int id){
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		userList = usersWithSameQualificationAndMajors(id);
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		for(User u : userList){
			hsList = u.getHighschoolList();
			for(Highschool hs : hsList){
				gpaList.add(hs.getGpa());
			}
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		gpaAverage = gpaSum/gpaList.size();
		return gpaAverage;
	}
	
	public Double qualificationMinorUserHS(int id){
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		userList = usersWithSameQualificationAndMinors(id);
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		for(User u : userList){
			hsList = u.getHighschoolList();
			for(Highschool hs : hsList){
				gpaList.add(hs.getGpa());
			}
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		gpaAverage = gpaSum/gpaList.size();
		return gpaAverage;
	}
	
	public Double qualificationSchoolUserHS(int id){
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		userList = usersWithSameQualificationAndSchools(id);
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		for(User u : userList){
			hsList = u.getHighschoolList();
			for(Highschool hs : hsList){
				gpaList.add(hs.getGpa());
			}
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		gpaAverage = gpaSum/gpaList.size();
		return gpaAverage;
	}
	
	public Double minorMajorUserHS(int id){
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		userList = usersWithSameMinorsAndMajors(id);
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		for(User u : userList){
			hsList = u.getHighschoolList();
			for(Highschool hs : hsList){
				gpaList.add(hs.getGpa());
			}
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		gpaAverage = gpaSum/gpaList.size();
		return gpaAverage;
	}
	
	public Double minorSchoolUserHS(int id){
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		userList = usersWithSameMinorsAndSchools(id);
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		for(User u : userList){
			hsList = u.getHighschoolList();
			for(Highschool hs : hsList){
				gpaList.add(hs.getGpa());
			}
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		gpaAverage = gpaSum/gpaList.size();
		return gpaAverage;
	}
	
	public Double majorSchoolUserHS(int id){
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		userList = usersWithSameMajorAndSchools(id);
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		for(User u : userList){
			hsList = u.getHighschoolList();
			for(Highschool hs : hsList){
				gpaList.add(hs.getGpa());
			}
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		gpaAverage = gpaSum/gpaList.size();
		return gpaAverage;
	}
	
	public Double qualificationLocationUserHS(int id){
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		userList = usersWithSameQualificationsAndlocation(id);
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		for(User u : userList){
			hsList = u.getHighschoolList();
			for(Highschool hs : hsList){
				gpaList.add(hs.getGpa());
			}
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		gpaAverage = gpaSum/gpaList.size();
		return gpaAverage;
	}
	
	public Double LocationMajorUserHS(int id){
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		userList = usersWithSameLocationAndMajors(id);
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		for(User u : userList){
			hsList = u.getHighschoolList();
			for(Highschool hs : hsList){
				gpaList.add(hs.getGpa());
			}
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		gpaAverage = gpaSum/gpaList.size();
		return gpaAverage;
	}
	
	public Double jobTitleLocationUserHS(int id){
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		userList = usersWithSameJobTitleAndlocation(id);
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		for(User u : userList){
			hsList = u.getHighschoolList();
			for(Highschool hs : hsList){
				gpaList.add(hs.getGpa());
			}
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		gpaAverage = gpaSum/gpaList.size();
		return gpaAverage;
	}
	
	public Double jobTitleAgeUserHS(int id){
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		userList = usersWithSameAgeAndJobTitle(id);
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		for(User u : userList){
			hsList = u.getHighschoolList();
			for(Highschool hs : hsList){
				gpaList.add(hs.getGpa());
			}
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		gpaAverage = gpaSum/gpaList.size();
		return gpaAverage;
	}
	
	public Double ageUserHS(int id){
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		userList = userWithsameAge(id);
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		for(User u : userList){
			hsList = u.getHighschoolList();
			for(Highschool hs : hsList){
				gpaList.add(hs.getGpa());
			}
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		gpaAverage = gpaSum/gpaList.size();
		return gpaAverage;
	}
	
	public Double goalsUserHS(int id){
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		userList = userWithsameGoals(id);
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		for(User u : userList){
			hsList = u.getHighschoolList();
			for(Highschool hs : hsList){
				gpaList.add(hs.getGpa());
			}
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		gpaAverage = gpaSum/gpaList.size();
		return gpaAverage;
	}
	
	public ResponseCombinedList qualificationMajorUserUni(int id){
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		List<Double> qualCountList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		Double qualificationCount = 0.0;
		Integer yearsSum = 0;
		Integer averageYearsSpent = 0;
		Double qualSum = 0.0;
		userList = usersWithSameQualificationAndMajors(id);
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		List<Integer> yearSpendList = new ArrayList<Integer>();
		for(User u : userList){
			uniList = u.getUniversityList();
			qualCountList.add((double) uniList.size());
			for(Qualification uni : uniList){
				if(uni.getMost_recent() == true){
					String startdate = uni.getYear_started();
					String enddate = uni.getYear_gradauted();
					methods = new HelperMethods();
					int start = methods.yearCalculator(startdate);
					int end = methods.yearCalculator(enddate);
					yearSpendList.add(end-start);
					gpaList.add(uni.getGpa());
				}
			}			
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		for(Integer i : yearSpendList){
			yearsSum += i;
		}
		for(Double i : qualCountList){
			qualSum += i;
		}
		qualificationCount = qualSum/qualCountList.size();
		averageYearsSpent = yearsSum/yearSpendList.size();
		gpaAverage = gpaSum/gpaList.size();
		ResponseCombinedList list = new ResponseCombinedList();
		list.setDouble2(qualificationCount);
		list.setInt1(averageYearsSpent);
		list.setDouble1(gpaAverage);
		return list;
	}

	public ResponseCombinedList qualificationMinorUserUni(int id){  
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		List<Double> qualCountList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		Double qualificationCount = 0.0;
		Integer yearsSum = 0;
		Integer averageYearsSpent = 0;
		Double qualSum = 0.0;
		userList = usersWithSameQualificationAndMinors(id);
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		List<Integer> yearSpendList = new ArrayList<Integer>();
		for(User u : userList){
			uniList = u.getUniversityList();
			qualCountList.add((double) uniList.size());
			for(Qualification uni : uniList){
				if(uni.getMost_recent() == true){
					String startdate = uni.getYear_started();
					String enddate = uni.getYear_gradauted();
					methods = new HelperMethods();
					int start = methods.yearCalculator(startdate);
					int end = methods.yearCalculator(enddate);
					yearSpendList.add(end-start);
					gpaList.add(uni.getGpa());
				}
			}			
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		for(Integer i : yearSpendList){
			yearsSum += i;
		}
		for(Double i : qualCountList){
			qualSum += i;
		}
		qualificationCount = qualSum/qualCountList.size();
		averageYearsSpent = yearsSum/yearSpendList.size();
		gpaAverage = gpaSum/gpaList.size();
		ResponseCombinedList list = new ResponseCombinedList();
		list.setDouble2(qualificationCount);
		list.setInt1(averageYearsSpent);
		list.setDouble1(gpaAverage);
		return list;
	}
	
	public ResponseCombinedList qualificationSchoolUserUni(int id){  
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		List<Double> qualCountList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		Double qualificationCount = 0.0;
		Integer yearsSum = 0;
		Integer averageYearsSpent = 0;
		Double qualSum = 0.0;
		userList = usersWithSameQualificationAndSchools(id);
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		List<Integer> yearSpendList = new ArrayList<Integer>();
		for(User u : userList){
			uniList = u.getUniversityList();
			qualCountList.add((double) uniList.size());
			for(Qualification uni : uniList){
				if(uni.getMost_recent() == true){
					String startdate = uni.getYear_started();
					String enddate = uni.getYear_gradauted();
					methods = new HelperMethods();
					int start = methods.yearCalculator(startdate);
					int end = methods.yearCalculator(enddate);
					yearSpendList.add(end-start);
					gpaList.add(uni.getGpa());
				}
			}			
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		for(Integer i : yearSpendList){
			yearsSum += i;
		}
		for(Double i : qualCountList){
			qualSum += i;
		}
		qualificationCount = qualSum/qualCountList.size();
		averageYearsSpent = yearsSum/yearSpendList.size();
		gpaAverage = gpaSum/gpaList.size();
		ResponseCombinedList list = new ResponseCombinedList();
		list.setDouble2(qualificationCount);
		list.setInt1(averageYearsSpent);
		list.setDouble1(gpaAverage);
		return list;
	}
	
	public ResponseCombinedList minorMajorUserUni(int id){  
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		List<Double> qualCountList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		Double qualificationCount = 0.0;
		Integer yearsSum = 0;
		Integer averageYearsSpent = 0;
		Double qualSum = 0.0;
		userList = usersWithSameMinorsAndMajors(id);
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		List<Integer> yearSpendList = new ArrayList<Integer>();
		for(User u : userList){
			uniList = u.getUniversityList();
			qualCountList.add((double) uniList.size());
			for(Qualification uni : uniList){
				if(uni.getMost_recent() == true){
					String startdate = uni.getYear_started();
					String enddate = uni.getYear_gradauted();
					methods = new HelperMethods();
					int start = methods.yearCalculator(startdate);
					int end = methods.yearCalculator(enddate);
					yearSpendList.add(end-start);
					gpaList.add(uni.getGpa());
				}
			}			
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		for(Integer i : yearSpendList){
			yearsSum += i;
		}
		for(Double i : qualCountList){
			qualSum += i;
		}
		qualificationCount = qualSum/qualCountList.size();
		averageYearsSpent = yearsSum/yearSpendList.size();
		gpaAverage = gpaSum/gpaList.size();
		ResponseCombinedList list = new ResponseCombinedList();
		list.setDouble2(qualificationCount);
		list.setInt1(averageYearsSpent);
		list.setDouble1(gpaAverage);
		return list;
	}
	
	public ResponseCombinedList minorSchoolUserUni(int id){  
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		List<Double> qualCountList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		Double qualificationCount = 0.0;
		Integer yearsSum = 0;
		Integer averageYearsSpent = 0;
		Double qualSum = 0.0;
		userList = usersWithSameMinorsAndSchools(id);
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		List<Integer> yearSpendList = new ArrayList<Integer>();
		for(User u : userList){
			uniList = u.getUniversityList();
			qualCountList.add((double) uniList.size());
			for(Qualification uni : uniList){
				if(uni.getMost_recent() == true){
					String startdate = uni.getYear_started();
					String enddate = uni.getYear_gradauted();
					methods = new HelperMethods();
					int start = methods.yearCalculator(startdate);
					int end = methods.yearCalculator(enddate);
					yearSpendList.add(end-start);
					gpaList.add(uni.getGpa());
				}
			}			
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		for(Integer i : yearSpendList){
			yearsSum += i;
		}
		for(Double i : qualCountList){
			qualSum += i;
		}
		qualificationCount = qualSum/qualCountList.size();
		averageYearsSpent = yearsSum/yearSpendList.size();
		gpaAverage = gpaSum/gpaList.size();
		ResponseCombinedList list = new ResponseCombinedList();
		list.setDouble2(qualificationCount);
		list.setInt1(averageYearsSpent);
		list.setDouble1(gpaAverage);
		return list;
	}
	
	public ResponseCombinedList majorSchoolUserUni(int id){  
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		List<Double> qualCountList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		Double qualificationCount = 0.0;
		Integer yearsSum = 0;
		Integer averageYearsSpent = 0;
		Double qualSum = 0.0;
		userList = usersWithSameMajorAndSchools(id);
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		List<Integer> yearSpendList = new ArrayList<Integer>();
		for(User u : userList){
			uniList = u.getUniversityList();
			qualCountList.add((double) uniList.size());
			for(Qualification uni : uniList){
				if(uni.getMost_recent() == true){
					String startdate = uni.getYear_started();
					String enddate = uni.getYear_gradauted();
					methods = new HelperMethods();
					int start = methods.yearCalculator(startdate);
					int end = methods.yearCalculator(enddate);
					yearSpendList.add(end-start);
					gpaList.add(uni.getGpa());
				}
			}			
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		for(Integer i : yearSpendList){
			yearsSum += i;
		}
		for(Double i : qualCountList){
			qualSum += i;
		}
		qualificationCount = qualSum/qualCountList.size();
		averageYearsSpent = yearsSum/yearSpendList.size();
		gpaAverage = gpaSum/gpaList.size();
		ResponseCombinedList list = new ResponseCombinedList();
		list.setDouble2(qualificationCount);
		list.setInt1(averageYearsSpent);
		list.setDouble1(gpaAverage);
		return list;
	}
	
	public ResponseCombinedList qualificationLocationUserUni(int id){   
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		List<Double> qualCountList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		Double qualificationCount = 0.0;
		Integer yearsSum = 0;
		Integer averageYearsSpent = 0;
		Double qualSum = 0.0;
		userList = usersWithSameQualificationsAndlocation(id);
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		List<Integer> yearSpendList = new ArrayList<Integer>();
		for(User u : userList){
			uniList = u.getUniversityList();
			qualCountList.add((double) uniList.size());
			for(Qualification uni : uniList){
				if(uni.getMost_recent() == true){
					String startdate = uni.getYear_started();
					String enddate = uni.getYear_gradauted();
					methods = new HelperMethods();
					int start = methods.yearCalculator(startdate);
					int end = methods.yearCalculator(enddate);
					yearSpendList.add(end-start);
					gpaList.add(uni.getGpa());
				}
			}			
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		for(Integer i : yearSpendList){
			yearsSum += i;
		}
		for(Double i : qualCountList){
			qualSum += i;
		}
		qualificationCount = qualSum/qualCountList.size();
		averageYearsSpent = yearsSum/yearSpendList.size();
		gpaAverage = gpaSum/gpaList.size();
		ResponseCombinedList list = new ResponseCombinedList();
		list.setDouble2(qualificationCount);
		list.setInt1(averageYearsSpent);
		list.setDouble1(gpaAverage);
		return list;
	}
	
	public ResponseCombinedList locationMajorUserUni(int id){  
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		List<Double> qualCountList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		Double qualificationCount = 0.0;
		Integer yearsSum = 0;
		Integer averageYearsSpent = 0;
		Double qualSum = 0.0;
		userList = usersWithSameLocationAndMajors(id);
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		List<Integer> yearSpendList = new ArrayList<Integer>();
		for(User u : userList){
			uniList = u.getUniversityList();
			qualCountList.add((double) uniList.size());
			for(Qualification uni : uniList){
				if(uni.getMost_recent() == true){
					String startdate = uni.getYear_started();
					String enddate = uni.getYear_gradauted();
					methods = new HelperMethods();
					int start = methods.yearCalculator(startdate);
					int end = methods.yearCalculator(enddate);
					yearSpendList.add(end-start);
					gpaList.add(uni.getGpa());
				}
			}			
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		for(Integer i : yearSpendList){
			yearsSum += i;
		}
		for(Double i : qualCountList){
			qualSum += i;
		}
		qualificationCount = qualSum/qualCountList.size();
		averageYearsSpent = yearsSum/yearSpendList.size();
		gpaAverage = gpaSum/gpaList.size();
		ResponseCombinedList list = new ResponseCombinedList();
		list.setDouble2(qualificationCount);
		list.setInt1(averageYearsSpent);
		list.setDouble1(gpaAverage);
		return list;
	}
	
	public ResponseCombinedList jobTitleLocationUserUni(int id){  
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		List<Double> qualCountList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		Double qualificationCount = 0.0;
		Integer yearsSum = 0;
		Integer averageYearsSpent = 0;
		Double qualSum = 0.0;
		userList = usersWithSameJobTitleAndlocation(id);
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		List<Integer> yearSpendList = new ArrayList<Integer>();
		for(User u : userList){
			uniList = u.getUniversityList();
			qualCountList.add((double) uniList.size());
			for(Qualification uni : uniList){
				if(uni.getMost_recent() == true){
					String startdate = uni.getYear_started();
					String enddate = uni.getYear_gradauted();
					methods = new HelperMethods();
					int start = methods.yearCalculator(startdate);
					int end = methods.yearCalculator(enddate);
					yearSpendList.add(end-start);
					gpaList.add(uni.getGpa());
				}
			}			
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		for(Integer i : yearSpendList){
			yearsSum += i;
		}
		for(Double i : qualCountList){
			qualSum += i;
		}
		qualificationCount = qualSum/qualCountList.size();
		averageYearsSpent = yearsSum/yearSpendList.size();
		gpaAverage = gpaSum/gpaList.size();
		ResponseCombinedList list = new ResponseCombinedList();
		list.setDouble2(qualificationCount);
		list.setInt1(averageYearsSpent);
		list.setDouble1(gpaAverage);
		return list;
	}
	
	public ResponseCombinedList jobTitleAgeUserUni(int id){  
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		List<Double> qualCountList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		Double qualificationCount = 0.0;
		Integer yearsSum = 0;
		Integer averageYearsSpent = 0;
		Double qualSum = 0.0;
		userList = usersWithSameAgeAndJobTitle(id);
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		List<Integer> yearSpendList = new ArrayList<Integer>();
		for(User u : userList){
			uniList = u.getUniversityList();
			qualCountList.add((double) uniList.size());
			for(Qualification uni : uniList){
				if(uni.getMost_recent() == true){
					String startdate = uni.getYear_started();
					String enddate = uni.getYear_gradauted();
					methods = new HelperMethods();
					int start = methods.yearCalculator(startdate);
					int end = methods.yearCalculator(enddate);
					yearSpendList.add(end-start);
					gpaList.add(uni.getGpa());
				}
			}			
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		for(Integer i : yearSpendList){
			yearsSum += i;
		}
		for(Double i : qualCountList){
			qualSum += i;
		}
		qualificationCount = qualSum/qualCountList.size();
		averageYearsSpent = yearsSum/yearSpendList.size();
		gpaAverage = gpaSum/gpaList.size();
		ResponseCombinedList list = new ResponseCombinedList();
		list.setDouble2(qualificationCount);
		list.setInt1(averageYearsSpent);
		list.setDouble1(gpaAverage);
		return list;
	}
	
	public ResponseCombinedList ageUserUni(int id){  
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		List<Double> qualCountList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		Double qualificationCount = 0.0;
		Integer yearsSum = 0;
		Integer averageYearsSpent = 0;
		Double qualSum = 0.0;
		userList = userWithsameAge(id);
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		List<Integer> yearSpendList = new ArrayList<Integer>();
		for(User u : userList){
			uniList = u.getUniversityList();
			qualCountList.add((double) uniList.size());
			for(Qualification uni : uniList){
				if(uni.getMost_recent() == true){
					String startdate = uni.getYear_started();
					String enddate = uni.getYear_gradauted();
					methods = new HelperMethods();
					int start = methods.yearCalculator(startdate);
					int end = methods.yearCalculator(enddate);
					yearSpendList.add(end-start);
					gpaList.add(uni.getGpa());
				}
			}			
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		for(Integer i : yearSpendList){
			yearsSum += i;
		}
		for(Double i : qualCountList){
			qualSum += i;
		}
		qualificationCount = qualSum/qualCountList.size();
		averageYearsSpent = yearsSum/yearSpendList.size();
		gpaAverage = gpaSum/gpaList.size();
		ResponseCombinedList list = new ResponseCombinedList();
		list.setDouble2(qualificationCount);
		list.setInt1(averageYearsSpent);
		list.setDouble1(gpaAverage);
		return list;
	}

	public ResponseCombinedList goalsUserUni(int id){  
		List<User> userList = new ArrayList<User>();
		List<Double> gpaList = new ArrayList<Double>();
		List<Double> qualCountList = new ArrayList<Double>();
		Double gpaSum = 0.0;
		Double gpaAverage = 0.0;
		Double qualificationCount = 0.0;
		Integer yearsSum = 0;
		Integer averageYearsSpent = 0;
		Double qualSum = 0.0;
		userList = userWithsameGoals(id);
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		List<Integer> yearSpendList = new ArrayList<Integer>();
		for(User u : userList){
			uniList = u.getUniversityList();
			qualCountList.add((double) uniList.size());
			for(Qualification uni : uniList){
				if(uni.getMost_recent() == true){
					String startdate = uni.getYear_started();
					String enddate = uni.getYear_gradauted();
					methods = new HelperMethods();
					int start = methods.yearCalculator(startdate);
					int end = methods.yearCalculator(enddate);
					yearSpendList.add(end-start);
					gpaList.add(uni.getGpa());
				}
			}			
		}
		for(Double d : gpaList){
			gpaSum += d;
		}
		for(Integer i : yearSpendList){
			yearsSum += i;
		}
		for(Double i : qualCountList){
			qualSum += i;
		}
		qualificationCount = qualSum/qualCountList.size();
		averageYearsSpent = yearsSum/yearSpendList.size();
		gpaAverage = gpaSum/gpaList.size();
		ResponseCombinedList list = new ResponseCombinedList();
		list.setDouble2(qualificationCount);
		list.setInt1(averageYearsSpent);
		list.setDouble1(gpaAverage);
		return list;
	}
	
	public TestResult qualificationMajorUserTestResult(int id){
		testEntity = new TestResult();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		List<User> userList = new ArrayList<User>();
		List<Integer> act = new ArrayList<Integer>();
		List<Integer> sat = new ArrayList<Integer>();
		List<Integer> clep = new ArrayList<Integer>();
		List<Integer> gmat = new ArrayList<Integer>();
		List<Integer> gre = new ArrayList<Integer>();
		List<Integer> lsat = new ArrayList<Integer>();
		List<Integer> mcat = new ArrayList<Integer>();
		userList = usersWithSameQualificationAndMajors(id);
		for(User u : userList){
			testList = u.getTestList();
			for(TestResult t : testList){
				act.add(t.getHighschool_ACT());
				sat.add(t.getHighschool_SAT());
				clep.add(t.getCollege_CLEP());
				gmat.add(t.getPostgrad_GMAT());
				gre.add(t.getPostgrad_GRE());
				lsat.add(t.getPostgrad_LSAT());
				mcat.add(t.getPostgrad_MCAT());
			}
		}
		int actsum = 0;
		for(Integer i : act){
			actsum+=i;
		}
		int actaverage = actsum/act.size();
		int satsum = 0;
		for(Integer i : sat){
			satsum+=i;
		}
		int sataverage = satsum/sat.size();
		int clepsum = 0;
		for(Integer i : clep){
			clepsum+=i;
		}
		int clepaverage = clepsum/clep.size();
		int gmatsum = 0;
		for(Integer i : gmat){
			gmatsum+=i;
		}
		int gmataverage = gmatsum/gmat.size();
		int gresum = 0;
		for(Integer i : gre){
			gresum+=i;
		}
		int greaverage = gresum/gre.size();
		int lsatsum = 0;
		for(Integer i : lsat){
			lsatsum+=i;
		}
		int lsataverage = lsatsum/lsat.size();
		int mcatsum = 0;
		for(Integer i : mcat){
			mcatsum+=i;
		}
		int mcataverage = mcatsum/mcat.size();
		testEntity.setCollege_CLEP(clepaverage);
		testEntity.setPostgrad_GMAT(gmataverage);
		testEntity.setHighschool_ACT(actaverage);
		testEntity.setHighschool_SAT(sataverage);
		testEntity.setPostgrad_GRE(greaverage);
		testEntity.setPostgrad_LSAT(lsataverage);
		testEntity.setPostgrad_MCAT(mcataverage);
		return testEntity;
	}

	public TestResult qualificationMinorUserTestResult(int id){
		testEntity = new TestResult();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		List<User> userList = new ArrayList<User>();
		List<Integer> act = new ArrayList<Integer>();
		List<Integer> sat = new ArrayList<Integer>();
		List<Integer> clep = new ArrayList<Integer>();
		List<Integer> gmat = new ArrayList<Integer>();
		List<Integer> gre = new ArrayList<Integer>();
		List<Integer> lsat = new ArrayList<Integer>();
		List<Integer> mcat = new ArrayList<Integer>();
		userList = usersWithSameQualificationAndMinors(id);
		for(User u : userList){
			testList = u.getTestList();
			for(TestResult t : testList){
				act.add(t.getHighschool_ACT());
				sat.add(t.getHighschool_SAT());
				clep.add(t.getCollege_CLEP());
				gmat.add(t.getPostgrad_GMAT());
				gre.add(t.getPostgrad_GRE());
				lsat.add(t.getPostgrad_LSAT());
				mcat.add(t.getPostgrad_MCAT());
			}
		}
		int actsum = 0;
		for(Integer i : act){
			actsum+=i;
		}
		int actaverage = actsum/act.size();
		int satsum = 0;
		for(Integer i : sat){
			satsum+=i;
		}
		int sataverage = satsum/sat.size();
		int clepsum = 0;
		for(Integer i : clep){
			clepsum+=i;
		}
		int clepaverage = clepsum/clep.size();
		int gmatsum = 0;
		for(Integer i : gmat){
			gmatsum+=i;
		}
		int gmataverage = gmatsum/gmat.size();
		int gresum = 0;
		for(Integer i : gre){
			gresum+=i;
		}
		int greaverage = gresum/gre.size();
		int lsatsum = 0;
		for(Integer i : lsat){
			lsatsum+=i;
		}
		int lsataverage = lsatsum/lsat.size();
		int mcatsum = 0;
		for(Integer i : mcat){
			mcatsum+=i;
		}
		int mcataverage = mcatsum/mcat.size();
		testEntity.setCollege_CLEP(clepaverage);
		testEntity.setPostgrad_GMAT(gmataverage);
		testEntity.setHighschool_ACT(actaverage);
		testEntity.setHighschool_SAT(sataverage);
		testEntity.setPostgrad_GRE(greaverage);
		testEntity.setPostgrad_LSAT(lsataverage);
		testEntity.setPostgrad_MCAT(mcataverage);
		return testEntity;
	}

	public TestResult qualificationSchoolUserTestResult(int id){
		testEntity = new TestResult();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		List<User> userList = new ArrayList<User>();
		List<Integer> act = new ArrayList<Integer>();
		List<Integer> sat = new ArrayList<Integer>();
		List<Integer> clep = new ArrayList<Integer>();
		List<Integer> gmat = new ArrayList<Integer>();
		List<Integer> gre = new ArrayList<Integer>();
		List<Integer> lsat = new ArrayList<Integer>();
		List<Integer> mcat = new ArrayList<Integer>();
		userList = usersWithSameQualificationAndSchools(id);
		for(User u : userList){
			testList = u.getTestList();
			for(TestResult t : testList){
				act.add(t.getHighschool_ACT());
				sat.add(t.getHighschool_SAT());
				clep.add(t.getCollege_CLEP());
				gmat.add(t.getPostgrad_GMAT());
				gre.add(t.getPostgrad_GRE());
				lsat.add(t.getPostgrad_LSAT());
				mcat.add(t.getPostgrad_MCAT());
			}
		}
		int actsum = 0;
		for(Integer i : act){
			actsum+=i;
		}
		int actaverage = actsum/act.size();
		int satsum = 0;
		for(Integer i : sat){
			satsum+=i;
		}
		int sataverage = satsum/sat.size();
		int clepsum = 0;
		for(Integer i : clep){
			clepsum+=i;
		}
		int clepaverage = clepsum/clep.size();
		int gmatsum = 0;
		for(Integer i : gmat){
			gmatsum+=i;
		}
		int gmataverage = gmatsum/gmat.size();
		int gresum = 0;
		for(Integer i : gre){
			gresum+=i;
		}
		int greaverage = gresum/gre.size();
		int lsatsum = 0;
		for(Integer i : lsat){
			lsatsum+=i;
		}
		int lsataverage = lsatsum/lsat.size();
		int mcatsum = 0;
		for(Integer i : mcat){
			mcatsum+=i;
		}
		int mcataverage = mcatsum/mcat.size();
		testEntity.setCollege_CLEP(clepaverage);
		testEntity.setPostgrad_GMAT(gmataverage);
		testEntity.setHighschool_ACT(actaverage);
		testEntity.setHighschool_SAT(sataverage);
		testEntity.setPostgrad_GRE(greaverage);
		testEntity.setPostgrad_LSAT(lsataverage);
		testEntity.setPostgrad_MCAT(mcataverage);
		return testEntity;
	}
	
	public TestResult minorMajorUserTestResult(int id){
		testEntity = new TestResult();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		List<User> userList = new ArrayList<User>();
		List<Integer> act = new ArrayList<Integer>();
		List<Integer> sat = new ArrayList<Integer>();
		List<Integer> clep = new ArrayList<Integer>();
		List<Integer> gmat = new ArrayList<Integer>();
		List<Integer> gre = new ArrayList<Integer>();
		List<Integer> lsat = new ArrayList<Integer>();
		List<Integer> mcat = new ArrayList<Integer>();
		userList = usersWithSameMinorsAndMajors(id);
		for(User u : userList){
			testList = u.getTestList();
			for(TestResult t : testList){
				act.add(t.getHighschool_ACT());
				sat.add(t.getHighschool_SAT());
				clep.add(t.getCollege_CLEP());
				gmat.add(t.getPostgrad_GMAT());
				gre.add(t.getPostgrad_GRE());
				lsat.add(t.getPostgrad_LSAT());
				mcat.add(t.getPostgrad_MCAT());
			}
		}
		int actsum = 0;
		for(Integer i : act){
			actsum+=i;
		}
		int actaverage = actsum/act.size();
		int satsum = 0;
		for(Integer i : sat){
			satsum+=i;
		}
		int sataverage = satsum/sat.size();
		int clepsum = 0;
		for(Integer i : clep){
			clepsum+=i;
		}
		int clepaverage = clepsum/clep.size();
		int gmatsum = 0;
		for(Integer i : gmat){
			gmatsum+=i;
		}
		int gmataverage = gmatsum/gmat.size();
		int gresum = 0;
		for(Integer i : gre){
			gresum+=i;
		}
		int greaverage = gresum/gre.size();
		int lsatsum = 0;
		for(Integer i : lsat){
			lsatsum+=i;
		}
		int lsataverage = lsatsum/lsat.size();
		int mcatsum = 0;
		for(Integer i : mcat){
			mcatsum+=i;
		}
		int mcataverage = mcatsum/mcat.size();
		testEntity.setCollege_CLEP(clepaverage);
		testEntity.setPostgrad_GMAT(gmataverage);
		testEntity.setHighschool_ACT(actaverage);
		testEntity.setHighschool_SAT(sataverage);
		testEntity.setPostgrad_GRE(greaverage);
		testEntity.setPostgrad_LSAT(lsataverage);
		testEntity.setPostgrad_MCAT(mcataverage);
		return testEntity;
	}
	
	public TestResult minorSchoolUserTestResult(int id){
		testEntity = new TestResult();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		List<User> userList = new ArrayList<User>();
		List<Integer> act = new ArrayList<Integer>();
		List<Integer> sat = new ArrayList<Integer>();
		List<Integer> clep = new ArrayList<Integer>();
		List<Integer> gmat = new ArrayList<Integer>();
		List<Integer> gre = new ArrayList<Integer>();
		List<Integer> lsat = new ArrayList<Integer>();
		List<Integer> mcat = new ArrayList<Integer>();
		userList = usersWithSameMinorsAndSchools(id);
		for(User u : userList){
			testList = u.getTestList();
			for(TestResult t : testList){
				act.add(t.getHighschool_ACT());
				sat.add(t.getHighschool_SAT());
				clep.add(t.getCollege_CLEP());
				gmat.add(t.getPostgrad_GMAT());
				gre.add(t.getPostgrad_GRE());
				lsat.add(t.getPostgrad_LSAT());
				mcat.add(t.getPostgrad_MCAT());
			}
		}
		int actsum = 0;
		for(Integer i : act){
			actsum+=i;
		}
		int actaverage = actsum/act.size();
		int satsum = 0;
		for(Integer i : sat){
			satsum+=i;
		}
		int sataverage = satsum/sat.size();
		int clepsum = 0;
		for(Integer i : clep){
			clepsum+=i;
		}
		int clepaverage = clepsum/clep.size();
		int gmatsum = 0;
		for(Integer i : gmat){
			gmatsum+=i;
		}
		int gmataverage = gmatsum/gmat.size();
		int gresum = 0;
		for(Integer i : gre){
			gresum+=i;
		}
		int greaverage = gresum/gre.size();
		int lsatsum = 0;
		for(Integer i : lsat){
			lsatsum+=i;
		}
		int lsataverage = lsatsum/lsat.size();
		int mcatsum = 0;
		for(Integer i : mcat){
			mcatsum+=i;
		}
		int mcataverage = mcatsum/mcat.size();
		testEntity.setCollege_CLEP(clepaverage);
		testEntity.setPostgrad_GMAT(gmataverage);
		testEntity.setHighschool_ACT(actaverage);
		testEntity.setHighschool_SAT(sataverage);
		testEntity.setPostgrad_GRE(greaverage);
		testEntity.setPostgrad_LSAT(lsataverage);
		testEntity.setPostgrad_MCAT(mcataverage);
		return testEntity;
	}
	
	public TestResult majorSchoolUserTestResult(int id){
		testEntity = new TestResult();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		List<User> userList = new ArrayList<User>();
		List<Integer> act = new ArrayList<Integer>();
		List<Integer> sat = new ArrayList<Integer>();
		List<Integer> clep = new ArrayList<Integer>();
		List<Integer> gmat = new ArrayList<Integer>();
		List<Integer> gre = new ArrayList<Integer>();
		List<Integer> lsat = new ArrayList<Integer>();
		List<Integer> mcat = new ArrayList<Integer>();
		userList = usersWithSameMajorAndSchools(id);
		for(User u : userList){
			testList = u.getTestList();
			for(TestResult t : testList){
				act.add(t.getHighschool_ACT());
				sat.add(t.getHighschool_SAT());
				clep.add(t.getCollege_CLEP());
				gmat.add(t.getPostgrad_GMAT());
				gre.add(t.getPostgrad_GRE());
				lsat.add(t.getPostgrad_LSAT());
				mcat.add(t.getPostgrad_MCAT());
			}
		}
		int actsum = 0;
		for(Integer i : act){
			actsum+=i;
		}
		int actaverage = actsum/act.size();
		int satsum = 0;
		for(Integer i : sat){
			satsum+=i;
		}
		int sataverage = satsum/sat.size();
		int clepsum = 0;
		for(Integer i : clep){
			clepsum+=i;
		}
		int clepaverage = clepsum/clep.size();
		int gmatsum = 0;
		for(Integer i : gmat){
			gmatsum+=i;
		}
		int gmataverage = gmatsum/gmat.size();
		int gresum = 0;
		for(Integer i : gre){
			gresum+=i;
		}
		int greaverage = gresum/gre.size();
		int lsatsum = 0;
		for(Integer i : lsat){
			lsatsum+=i;
		}
		int lsataverage = lsatsum/lsat.size();
		int mcatsum = 0;
		for(Integer i : mcat){
			mcatsum+=i;
		}
		int mcataverage = mcatsum/mcat.size();
		testEntity.setCollege_CLEP(clepaverage);
		testEntity.setPostgrad_GMAT(gmataverage);
		testEntity.setHighschool_ACT(actaverage);
		testEntity.setHighschool_SAT(sataverage);
		testEntity.setPostgrad_GRE(greaverage);
		testEntity.setPostgrad_LSAT(lsataverage);
		testEntity.setPostgrad_MCAT(mcataverage);
		return testEntity;
	}
	
	public TestResult qualificationLocationUserTestResult(int id){
		testEntity = new TestResult();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		List<User> userList = new ArrayList<User>();
		List<Integer> act = new ArrayList<Integer>();
		List<Integer> sat = new ArrayList<Integer>();
		List<Integer> clep = new ArrayList<Integer>();
		List<Integer> gmat = new ArrayList<Integer>();
		List<Integer> gre = new ArrayList<Integer>();
		List<Integer> lsat = new ArrayList<Integer>();
		List<Integer> mcat = new ArrayList<Integer>();
		userList = usersWithSameQualificationsAndlocation(id);
		for(User u : userList){
			testList = u.getTestList();
			for(TestResult t : testList){
				act.add(t.getHighschool_ACT());
				sat.add(t.getHighschool_SAT());
				clep.add(t.getCollege_CLEP());
				gmat.add(t.getPostgrad_GMAT());
				gre.add(t.getPostgrad_GRE());
				lsat.add(t.getPostgrad_LSAT());
				mcat.add(t.getPostgrad_MCAT());
			}
		}
		int actsum = 0;
		for(Integer i : act){
			actsum+=i;
		}
		int actaverage = actsum/act.size();
		int satsum = 0;
		for(Integer i : sat){
			satsum+=i;
		}
		int sataverage = satsum/sat.size();
		int clepsum = 0;
		for(Integer i : clep){
			clepsum+=i;
		}
		int clepaverage = clepsum/clep.size();
		int gmatsum = 0;
		for(Integer i : gmat){
			gmatsum+=i;
		}
		int gmataverage = gmatsum/gmat.size();
		int gresum = 0;
		for(Integer i : gre){
			gresum+=i;
		}
		int greaverage = gresum/gre.size();
		int lsatsum = 0;
		for(Integer i : lsat){
			lsatsum+=i;
		}
		int lsataverage = lsatsum/lsat.size();
		int mcatsum = 0;
		for(Integer i : mcat){
			mcatsum+=i;
		}
		int mcataverage = mcatsum/mcat.size();
		testEntity.setCollege_CLEP(clepaverage);
		testEntity.setPostgrad_GMAT(gmataverage);
		testEntity.setHighschool_ACT(actaverage);
		testEntity.setHighschool_SAT(sataverage);
		testEntity.setPostgrad_GRE(greaverage);
		testEntity.setPostgrad_LSAT(lsataverage);
		testEntity.setPostgrad_MCAT(mcataverage);
		return testEntity;
	}
	
	public TestResult locationMajorUserTestResult(int id){
		testEntity = new TestResult();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		List<User> userList = new ArrayList<User>();
		List<Integer> act = new ArrayList<Integer>();
		List<Integer> sat = new ArrayList<Integer>();
		List<Integer> clep = new ArrayList<Integer>();
		List<Integer> gmat = new ArrayList<Integer>();
		List<Integer> gre = new ArrayList<Integer>();
		List<Integer> lsat = new ArrayList<Integer>();
		List<Integer> mcat = new ArrayList<Integer>();
		userList = usersWithSameLocationAndMajors(id);
		for(User u : userList){
			testList = u.getTestList();
			for(TestResult t : testList){
				act.add(t.getHighschool_ACT());
				sat.add(t.getHighschool_SAT());
				clep.add(t.getCollege_CLEP());
				gmat.add(t.getPostgrad_GMAT());
				gre.add(t.getPostgrad_GRE());
				lsat.add(t.getPostgrad_LSAT());
				mcat.add(t.getPostgrad_MCAT());
			}
		}
		int actsum = 0;
		for(Integer i : act){
			actsum+=i;
		}
		int actaverage = actsum/act.size();
		int satsum = 0;
		for(Integer i : sat){
			satsum+=i;
		}
		int sataverage = satsum/sat.size();
		int clepsum = 0;
		for(Integer i : clep){
			clepsum+=i;
		}
		int clepaverage = clepsum/clep.size();
		int gmatsum = 0;
		for(Integer i : gmat){
			gmatsum+=i;
		}
		int gmataverage = gmatsum/gmat.size();
		int gresum = 0;
		for(Integer i : gre){
			gresum+=i;
		}
		int greaverage = gresum/gre.size();
		int lsatsum = 0;
		for(Integer i : lsat){
			lsatsum+=i;
		}
		int lsataverage = lsatsum/lsat.size();
		int mcatsum = 0;
		for(Integer i : mcat){
			mcatsum+=i;
		}
		int mcataverage = mcatsum/mcat.size();
		testEntity.setCollege_CLEP(clepaverage);
		testEntity.setPostgrad_GMAT(gmataverage);
		testEntity.setHighschool_ACT(actaverage);
		testEntity.setHighschool_SAT(sataverage);
		testEntity.setPostgrad_GRE(greaverage);
		testEntity.setPostgrad_LSAT(lsataverage);
		testEntity.setPostgrad_MCAT(mcataverage);
		return testEntity;
	}
	
	public TestResult jobTitleLocationUserTestResult(int id){
		testEntity = new TestResult();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		List<User> userList = new ArrayList<User>();
		List<Integer> act = new ArrayList<Integer>();
		List<Integer> sat = new ArrayList<Integer>();
		List<Integer> clep = new ArrayList<Integer>();
		List<Integer> gmat = new ArrayList<Integer>();
		List<Integer> gre = new ArrayList<Integer>();
		List<Integer> lsat = new ArrayList<Integer>();
		List<Integer> mcat = new ArrayList<Integer>();
		userList = usersWithSameJobTitleAndlocation(id);
		for(User u : userList){
			testList = u.getTestList();
			for(TestResult t : testList){
				act.add(t.getHighschool_ACT());
				sat.add(t.getHighschool_SAT());
				clep.add(t.getCollege_CLEP());
				gmat.add(t.getPostgrad_GMAT());
				gre.add(t.getPostgrad_GRE());
				lsat.add(t.getPostgrad_LSAT());
				mcat.add(t.getPostgrad_MCAT());
			}
		}
		int actsum = 0;
		for(Integer i : act){
			actsum+=i;
		}
		int actaverage = actsum/act.size();
		int satsum = 0;
		for(Integer i : sat){
			satsum+=i;
		}
		int sataverage = satsum/sat.size();
		int clepsum = 0;
		for(Integer i : clep){
			clepsum+=i;
		}
		int clepaverage = clepsum/clep.size();
		int gmatsum = 0;
		for(Integer i : gmat){
			gmatsum+=i;
		}
		int gmataverage = gmatsum/gmat.size();
		int gresum = 0;
		for(Integer i : gre){
			gresum+=i;
		}
		int greaverage = gresum/gre.size();
		int lsatsum = 0;
		for(Integer i : lsat){
			lsatsum+=i;
		}
		int lsataverage = lsatsum/lsat.size();
		int mcatsum = 0;
		for(Integer i : mcat){
			mcatsum+=i;
		}
		int mcataverage = mcatsum/mcat.size();
		testEntity.setCollege_CLEP(clepaverage);
		testEntity.setPostgrad_GMAT(gmataverage);
		testEntity.setHighschool_ACT(actaverage);
		testEntity.setHighschool_SAT(sataverage);
		testEntity.setPostgrad_GRE(greaverage);
		testEntity.setPostgrad_LSAT(lsataverage);
		testEntity.setPostgrad_MCAT(mcataverage);
		return testEntity;
	}
	
	public TestResult jobTitleAgeUserTestResult(int id){
		testEntity = new TestResult();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		List<User> userList = new ArrayList<User>();
		List<Integer> act = new ArrayList<Integer>();
		List<Integer> sat = new ArrayList<Integer>();
		List<Integer> clep = new ArrayList<Integer>();
		List<Integer> gmat = new ArrayList<Integer>();
		List<Integer> gre = new ArrayList<Integer>();
		List<Integer> lsat = new ArrayList<Integer>();
		List<Integer> mcat = new ArrayList<Integer>();
		userList = usersWithSameAgeAndJobTitle(id);
		for(User u : userList){
			testList = u.getTestList();
			for(TestResult t : testList){
				act.add(t.getHighschool_ACT());
				sat.add(t.getHighschool_SAT());
				clep.add(t.getCollege_CLEP());
				gmat.add(t.getPostgrad_GMAT());
				gre.add(t.getPostgrad_GRE());
				lsat.add(t.getPostgrad_LSAT());
				mcat.add(t.getPostgrad_MCAT());
			}
		}
		int actsum = 0;
		for(Integer i : act){
			actsum+=i;
		}
		int actaverage = actsum/act.size();
		int satsum = 0;
		for(Integer i : sat){
			satsum+=i;
		}
		int sataverage = satsum/sat.size();
		int clepsum = 0;
		for(Integer i : clep){
			clepsum+=i;
		}
		int clepaverage = clepsum/clep.size();
		int gmatsum = 0;
		for(Integer i : gmat){
			gmatsum+=i;
		}
		int gmataverage = gmatsum/gmat.size();
		int gresum = 0;
		for(Integer i : gre){
			gresum+=i;
		}
		int greaverage = gresum/gre.size();
		int lsatsum = 0;
		for(Integer i : lsat){
			lsatsum+=i;
		}
		int lsataverage = lsatsum/lsat.size();
		int mcatsum = 0;
		for(Integer i : mcat){
			mcatsum+=i;
		}
		int mcataverage = mcatsum/mcat.size();
		testEntity.setCollege_CLEP(clepaverage);
		testEntity.setPostgrad_GMAT(gmataverage);
		testEntity.setHighschool_ACT(actaverage);
		testEntity.setHighschool_SAT(sataverage);
		testEntity.setPostgrad_GRE(greaverage);
		testEntity.setPostgrad_LSAT(lsataverage);
		testEntity.setPostgrad_MCAT(mcataverage);
		return testEntity;
	}
	
	public TestResult ageUserTestResult(int id){
		testEntity = new TestResult();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		List<User> userList = new ArrayList<User>();
		List<Integer> act = new ArrayList<Integer>();
		List<Integer> sat = new ArrayList<Integer>();
		List<Integer> clep = new ArrayList<Integer>();
		List<Integer> gmat = new ArrayList<Integer>();
		List<Integer> gre = new ArrayList<Integer>();
		List<Integer> lsat = new ArrayList<Integer>();
		List<Integer> mcat = new ArrayList<Integer>();
		userList = userWithsameAge(id);
		for(User u : userList){
			testList = u.getTestList();
			for(TestResult t : testList){
				act.add(t.getHighschool_ACT());
				sat.add(t.getHighschool_SAT());
				clep.add(t.getCollege_CLEP());
				gmat.add(t.getPostgrad_GMAT());
				gre.add(t.getPostgrad_GRE());
				lsat.add(t.getPostgrad_LSAT());
				mcat.add(t.getPostgrad_MCAT());
			}
		}
		int actsum = 0;
		for(Integer i : act){
			actsum+=i;
		}
		int actaverage = actsum/act.size();
		int satsum = 0;
		for(Integer i : sat){
			satsum+=i;
		}
		int sataverage = satsum/sat.size();
		int clepsum = 0;
		for(Integer i : clep){
			clepsum+=i;
		}
		int clepaverage = clepsum/clep.size();
		int gmatsum = 0;
		for(Integer i : gmat){
			gmatsum+=i;
		}
		int gmataverage = gmatsum/gmat.size();
		int gresum = 0;
		for(Integer i : gre){
			gresum+=i;
		}
		int greaverage = gresum/gre.size();
		int lsatsum = 0;
		for(Integer i : lsat){
			lsatsum+=i;
		}
		int lsataverage = lsatsum/lsat.size();
		int mcatsum = 0;
		for(Integer i : mcat){
			mcatsum+=i;
		}
		int mcataverage = mcatsum/mcat.size();
		testEntity.setCollege_CLEP(clepaverage);
		testEntity.setPostgrad_GMAT(gmataverage);
		testEntity.setHighschool_ACT(actaverage);
		testEntity.setHighschool_SAT(sataverage);
		testEntity.setPostgrad_GRE(greaverage);
		testEntity.setPostgrad_LSAT(lsataverage);
		testEntity.setPostgrad_MCAT(mcataverage);
		return testEntity;
	}
	
	public TestResult goalsUserTestResult(int id){
		testEntity = new TestResult();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		List<User> userList = new ArrayList<User>();
		List<Integer> act = new ArrayList<Integer>();
		List<Integer> sat = new ArrayList<Integer>();
		List<Integer> clep = new ArrayList<Integer>();
		List<Integer> gmat = new ArrayList<Integer>();
		List<Integer> gre = new ArrayList<Integer>();
		List<Integer> lsat = new ArrayList<Integer>();
		List<Integer> mcat = new ArrayList<Integer>();
		userList = userWithsameGoals(id);
		for(User u : userList){
			testList = u.getTestList();
			for(TestResult t : testList){
				act.add(t.getHighschool_ACT());
				sat.add(t.getHighschool_SAT());
				clep.add(t.getCollege_CLEP());
				gmat.add(t.getPostgrad_GMAT());
				gre.add(t.getPostgrad_GRE());
				lsat.add(t.getPostgrad_LSAT());
				mcat.add(t.getPostgrad_MCAT());
			}
		}
		int actsum = 0;
		for(Integer i : act){
			actsum+=i;
		}
		int actaverage = actsum/act.size();
		int satsum = 0;
		for(Integer i : sat){
			satsum+=i;
		}
		int sataverage = satsum/sat.size();
		int clepsum = 0;
		for(Integer i : clep){
			clepsum+=i;
		}
		int clepaverage = clepsum/clep.size();
		int gmatsum = 0;
		for(Integer i : gmat){
			gmatsum+=i;
		}
		int gmataverage = gmatsum/gmat.size();
		int gresum = 0;
		for(Integer i : gre){
			gresum+=i;
		}
		int greaverage = gresum/gre.size();
		int lsatsum = 0;
		for(Integer i : lsat){
			lsatsum+=i;
		}
		int lsataverage = lsatsum/lsat.size();
		int mcatsum = 0;
		for(Integer i : mcat){
			mcatsum+=i;
		}
		int mcataverage = mcatsum/mcat.size();
		testEntity.setCollege_CLEP(clepaverage);
		testEntity.setPostgrad_GMAT(gmataverage);
		testEntity.setHighschool_ACT(actaverage);
		testEntity.setHighschool_SAT(sataverage);
		testEntity.setPostgrad_GRE(greaverage);
		testEntity.setPostgrad_LSAT(lsataverage);
		testEntity.setPostgrad_MCAT(mcataverage);
		return testEntity;
	}
	
}


           