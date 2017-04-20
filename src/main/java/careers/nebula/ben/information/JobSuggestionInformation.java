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
import careers.nebula.ben.db.enitity.Industry;
import careers.nebula.ben.db.enitity.Jobs;
import careers.nebula.ben.db.enitity.Keywords;
import careers.nebula.ben.db.enitity.Majors;
import careers.nebula.ben.db.enitity.Qualification;
import careers.nebula.ben.db.enitity.Students;
import careers.nebula.ben.db.enitity.Universities;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.db.repository.UserProfileRepo;
import careers.nebula.ben.db.repository.UserRepo;
import careers.nebula.ben.pojos.RespondJobsCombinedList;
import careers.nebula.ben.pojos.ResponseCombinedList;
import careers.nebula.ben.service.CourseSuggestionServicing;
import careers.nebula.ben.service.JobSuggestionService;

/**
 * @author medlclouddev
 *
 */
public class JobSuggestionInformation {
	private JobSuggestionService jobService;
	private UserRepo userRepo;
	private User userEntity;
	private UserProfileRepo userpro;
	
	
	//Goals type:
	//1. I would like to pursue an experience in JOT TITLE.
	//2. I would like to join COMPANY NAME for an experience.
	//3. I seeking opportunities in the field of INDUSTRY. 
	public RespondJobsCombinedList getGoalsType(int id){
		RespondJobsCombinedList list = new RespondJobsCombinedList();
		userEntity = new User();
		userRepo = new UserRepo();
		userEntity = userRepo.getUserData(id);
		String goals = userEntity.getGoals();
		List<Jobs> allJobs = new ArrayList<Jobs>();
		userpro = new UserProfileRepo();
		allJobs = userpro.getAllJobsData();
		for(Jobs c : allJobs){
			if(goals.toLowerCase().contains(c.getTitle()) == true){
				return goalsJobTitleJobs(userEntity, c.getTitle());
			}
		}
		List<Companies> allcompanies = new ArrayList<Companies>();
		userpro = new UserProfileRepo();
		allcompanies = userpro.getAllCompanyData();
		for(Companies c : allcompanies){
			if(goals.toLowerCase().contains(c.getCompany_industry()) == true){
				return goalsCompanyIndustryJobs(userEntity, c.getCompany_industry());
			}
		}
		List<Companies> allcompaniesN = new ArrayList<Companies>();
		userpro = new UserProfileRepo();
		allcompaniesN = userpro.getAllCompanyData();
		for(Companies c : allcompaniesN){
			if(goals.toLowerCase().contains(c.getCompany_name()) == true){
				return goalsCompanyNameJobs(userEntity, c.getCompany_name());
			}
		}
		return list;
	}


	private RespondJobsCombinedList goalsCompanyNameJobs(User userEntity, String companyName) {
		RespondJobsCombinedList list = new RespondJobsCombinedList();
		
		//all open jobs at this company 
		List<Jobs> openJobs = new ArrayList<Jobs>(); 
		List<Jobs> suggestedJobs = new ArrayList<Jobs>(); 
		userpro = new UserProfileRepo();
		openJobs = userpro.getAllJobsData();
		for(Jobs j : openJobs){
			Collection<Companies> compList = new ArrayList<Companies>();
			compList = j.getCompanyList();
			for(Companies c : compList){
				if(c.getCompany_name() == companyName){
					suggestedJobs.add(j);
				}
			}
		}
		list.setListone(suggestedJobs);
		
		//past job title suggests		
		Collection<Experiences> expList = new ArrayList<Experiences>();
		List<String> userJobTitles = new ArrayList<String>();
		List<Jobs> openOldJobs = new ArrayList<Jobs>();
		expList = userEntity.getExperienceList();
		for(Experiences e : expList){
			userJobTitles.add(e.getJob_title());
		}
		for(String s : userJobTitles){
			userpro = new UserProfileRepo();
			openOldJobs.addAll(userpro.getJobsByTitle(s));
		}
		list.setListtwo(openOldJobs);
		
		//match user keywords with any open jobs keywords.
		Collection<Keywords> userKeywords = new ArrayList<Keywords>();
		List<Jobs> keywordJobs = new ArrayList<Jobs>();
		userKeywords = userEntity.getKeywordList();
		for(Jobs j : openJobs){			
			for(Keywords k : userKeywords){
				if(j.getKeywordList().contains(k.getName())){
					keywordJobs.add(j);
				}
			}
		}
		list.setListthree(keywordJobs);
		
		
		//match user industry with any open jobs industries.
		Collection<Industry> userIndustry = new ArrayList<Industry>();
		List<Jobs> IndustryJobs = new ArrayList<Jobs>();
		userIndustry = userEntity.getIndustryList();
		for(Jobs j : openJobs){			
			for(Industry i : userIndustry){
				if(j.getIndustryList().contains(i.getName())){
					IndustryJobs.add(j);
				}
			}
		}
		list.setListthree(IndustryJobs);

		return list;
	}


	private RespondJobsCombinedList goalsCompanyIndustryJobs(User userEntity, String companyIndustry) {
		RespondJobsCombinedList list = new RespondJobsCombinedList();
		
		//all open jobs at this company 
		List<Jobs> openJobs = new ArrayList<Jobs>(); 
		List<Jobs> suggestedJobs = new ArrayList<Jobs>(); 
		userpro = new UserProfileRepo();
		openJobs = userpro.getAllJobsData();
		for(Jobs j : openJobs){
			Collection<Companies> compList = new ArrayList<Companies>();
			compList = j.getCompanyList();
			for(Companies c : compList){
				if(c.getCompany_industry() == companyIndustry){
					suggestedJobs.add(j);
				}
			}
		}
		list.setListone(suggestedJobs);
		
		//past job title suggests		
		Collection<Experiences> expList = new ArrayList<Experiences>();
		List<String> userJobTitles = new ArrayList<String>();
		List<Jobs> openOldJobs = new ArrayList<Jobs>();
		expList = userEntity.getExperienceList();
		for(Experiences e : expList){
			userJobTitles.add(e.getJob_title());
		}
		for(String s : userJobTitles){
			userpro = new UserProfileRepo();
			openOldJobs.addAll(userpro.getJobsByTitle(s));
		}
		list.setListtwo(openOldJobs);
		
		//match user keywords with any open jobs keywords.
		Collection<Keywords> userKeywords = new ArrayList<Keywords>();
		List<Jobs> keywordJobs = new ArrayList<Jobs>();
		userKeywords = userEntity.getKeywordList();
		for(Jobs j : openJobs){			
			for(Keywords k : userKeywords){
				if(j.getKeywordList().contains(k.getName())){
					keywordJobs.add(j);
				}
			}
		}
		list.setListthree(keywordJobs);
		
		
		//match user industry with any open jobs industries.
		Collection<Industry> userIndustry = new ArrayList<Industry>();
		List<Jobs> IndustryJobs = new ArrayList<Jobs>();
		userIndustry = userEntity.getIndustryList();
		for(Jobs j : openJobs){			
			for(Industry i : userIndustry){
				if(j.getIndustryList().contains(i.getName())){
					IndustryJobs.add(j);
				}
			}
		}
		list.setListthree(IndustryJobs);

		return list;
	}


	private RespondJobsCombinedList goalsJobTitleJobs(User userEntity, String jobTitle) {
		RespondJobsCombinedList list = new RespondJobsCombinedList();
		
		//all open jobs by seek title.
		List<Jobs> openJobs = new ArrayList<Jobs>();
		userpro = new UserProfileRepo();
		openJobs = userpro.getJobsByTitle(jobTitle);
		list.setListone(openJobs);
		
		//past job title suggests		
		Collection<Experiences> expList = new ArrayList<Experiences>();
		List<String> userJobTitles = new ArrayList<String>();
		List<Jobs> openOldJobs = new ArrayList<Jobs>();
		expList = userEntity.getExperienceList();
		for(Experiences e : expList){
			userJobTitles.add(e.getJob_title());
		}
		for(String s : userJobTitles){
			userpro = new UserProfileRepo();
			openOldJobs.addAll(userpro.getJobsByTitle(s));
		}
		list.setListtwo(openOldJobs);
		
		//match user keywords with any open jobs keywords.
		Collection<Keywords> userKeywords = new ArrayList<Keywords>();
		List<Jobs> keywordJobs = new ArrayList<Jobs>();
		userKeywords = userEntity.getKeywordList();
		for(Jobs j : openJobs){			
			for(Keywords k : userKeywords){
				if(j.getKeywordList().contains(k.getName())){
					keywordJobs.add(j);
				}
			}
		}
		list.setListthree(keywordJobs);
		
		
		//match user industry with any open jobs industries.
		Collection<Industry> userIndustry = new ArrayList<Industry>();
		List<Jobs> IndustryJobs = new ArrayList<Jobs>();
		userIndustry = userEntity.getIndustryList();
		for(Jobs j : openJobs){			
			for(Industry i : userIndustry){
				if(j.getIndustryList().contains(i.getName())){
					IndustryJobs.add(j);
				}
			}
		}
		list.setListthree(IndustryJobs);

		return list;
	}
}
