/**
 * 
 */
package careers.nebula.ben.information;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import careers.nebula.ben.db.enitity.Companies;
import careers.nebula.ben.db.enitity.Experiences;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.db.repository.ExperienceRepo;
import careers.nebula.ben.db.repository.UserProfileRepo;
import careers.nebula.ben.db.repository.UserRepo;
import careers.nebula.ben.pojo.iws.CompaniesDataPojo;
import careers.nebula.ben.pojo.iws.ExperiencesDataPojo;
import careers.nebula.ben.pojo.iws.UserDataPojo;
import careers.nebula.ben.pojos.ResponseIntegerList;
import careers.nebula.ben.service.HelperMethods;

/**
 * @author Ankit_Nebula
 *
 */
public class ExperienceInformation {

	private UserRepo userRepo;
	private User userEntity;
	private Experiences expEntity;
	private ExperiencesDataPojo experiencesDataPojo;
	private ExperienceRepo exprepo;
	private Companies compEntity;
	private CompaniesDataPojo companiesDataPojo;
	private UserProfileRepo userpro;
	private UserInformation userInfo;
	private UserDataPojo userdatapojo;
	private HelperMethods helper;
	
	public Experiences insertUserExperience(int id, ExperiencesDataPojo experienceDataPojo){	
		userEntity = new User();
		userRepo = new UserRepo();
		expEntity = new Experiences();
		helper = new HelperMethods();
		userEntity = userRepo.getUserData(id);
		expEntity.setJob_title(experienceDataPojo.getJob_title());
		expEntity.setJob_responsibilities(experienceDataPojo.getJob_responsibilities());
		expEntity.setTime_spent(helper.timeSpentCalculator(experienceDataPojo.getStart_date(), experienceDataPojo.getEnd_date()));
		expEntity.setManager_rating(experienceDataPojo.getManager_rating());
		expEntity.setExperience_rating(experienceDataPojo.getExperience_rating());
		expEntity.setStart_date(experienceDataPojo.getEnd_date());
		expEntity.setMost_recent(experienceDataPojo.getMost_recent());
		expEntity.setEnd_date(experienceDataPojo.getEnd_date());
		expEntity.setHourly_rate(experienceDataPojo.getHourly_rate());
		userEntity.getExperienceList().add(expEntity);
		exprepo = new ExperienceRepo();
		exprepo.InsertUserExperience(userEntity, expEntity);
		return expEntity;
	}


	public ExperiencesDataPojo getExperienceById(int id) {
		exprepo = new ExperienceRepo();
		expEntity = new Experiences();
		experiencesDataPojo = new ExperiencesDataPojo();
		expEntity = exprepo.getExperienceData(id);
		experiencesDataPojo.setId(expEntity.getId());
		experiencesDataPojo.setJob_title(expEntity.getJob_title());
		experiencesDataPojo.setMost_recent(expEntity.getMost_recent());
		experiencesDataPojo.setJob_responsibilities(expEntity.getJob_responsibilities());
		experiencesDataPojo.setTime_spent(expEntity.getTime_spent());
		experiencesDataPojo.setManager_rating(expEntity.getManager_rating());
		experiencesDataPojo.setExperience_rating(expEntity.getExperience_rating());
		experiencesDataPojo.setStart_date(expEntity.getStart_date());
		experiencesDataPojo.setEnd_date(expEntity.getEnd_date());
		experiencesDataPojo.setHourly_rate(expEntity.getHourly_rate());
		return experiencesDataPojo;
	}
	
	public ResponseIntegerList getUserExperienceList(int id) {
		userRepo = new UserRepo();
		exprepo = new ExperienceRepo();
		expEntity = new Experiences();
		experiencesDataPojo = new ExperiencesDataPojo();
		int exp_id = 0;
		userEntity = userRepo.getUserData(id);
		Collection<Experiences> expList = new ArrayList<Experiences>();
		List<Integer> idlist = new ArrayList<Integer>();
		expList = userEntity.getExperienceList();
		for (Experiences obj : expList) {
			exp_id = obj.getId();
			idlist.add(exp_id);
			   }
		ResponseIntegerList list = new ResponseIntegerList();
		list.setList(idlist);
		return list;
	}
	
	public UserDataPojo getUserByExpId(int id){
		int user_id = 0;
		exprepo = new ExperienceRepo();
		expEntity = new Experiences();
		expEntity = exprepo.getExperienceData(id);
		Collection<User> userList = new ArrayList<User>();
		userList = expEntity.getUserList();
		for(User u : userList){
			user_id = u.getId();
		}
		userdatapojo = new UserDataPojo();
		userInfo = new UserInformation();
		userdatapojo = userInfo.getPrimaryUserInfo(user_id); 
		return userdatapojo;
	}
	
	public Experiences updateExperienceById(ExperiencesDataPojo experienceDataPojo){
		expEntity = new Experiences();
		helper = new HelperMethods();
		exprepo = new ExperienceRepo();
		int id = experienceDataPojo.getId();
		expEntity = exprepo.getExperienceData(id);
		expEntity.setId(experienceDataPojo.getId());
		if(experienceDataPojo.getJob_title() == null){
			expEntity.setJob_title(expEntity.getJob_title());
		} else {
			expEntity.setJob_title(experienceDataPojo.getJob_title());
		}
		if(experienceDataPojo.getMost_recent() == null){
			expEntity.setMost_recent(expEntity.getMost_recent());
		} else {
			expEntity.setMost_recent(experienceDataPojo.getMost_recent());
		}
		if(experienceDataPojo.getJob_responsibilities() == null){
			expEntity.setJob_responsibilities(expEntity.getJob_responsibilities());
		} else {
			expEntity.setJob_responsibilities(experienceDataPojo.getJob_responsibilities());
		}
		if(experienceDataPojo.getTime_spent() == null){
			expEntity.setTime_spent(expEntity.getTime_spent());
		} else {
			expEntity.setTime_spent(helper.timeSpentCalculator(experienceDataPojo.getStart_date(), experienceDataPojo.getEnd_date()));
		}
		if(experienceDataPojo.getManager_rating() == null){
			expEntity.setManager_rating(expEntity.getManager_rating());
		} else {
			expEntity.setManager_rating(experienceDataPojo.getManager_rating());
		}
		if(experienceDataPojo.getExperience_rating() == null){
			expEntity.setExperience_rating(expEntity.getExperience_rating());
		} else {
			expEntity.setExperience_rating(experienceDataPojo.getExperience_rating());
		}
		if(experienceDataPojo.getStart_date() == null){
			expEntity.setStart_date(expEntity.getStart_date());
		} else {
			expEntity.setStart_date(experienceDataPojo.getStart_date());
		}
		if(experienceDataPojo.getEnd_date() == null){
			expEntity.setEnd_date(expEntity.getEnd_date());
		} else {
			expEntity.setEnd_date(experienceDataPojo.getEnd_date());
		}
		if(experienceDataPojo.getHourly_rate() == null){
			expEntity.setHourly_rate(expEntity.getHourly_rate());
		} else {
			expEntity.setHourly_rate(experienceDataPojo.getHourly_rate());
		}
		exprepo = new ExperienceRepo();
		exprepo.updateExperienceData(expEntity);
		return expEntity;
	}
	
	public Companies insertUsrExpCompany(int id,  CompaniesDataPojo companiesDataPojo){	
		userEntity = new User();
		expEntity = new Experiences();
		compEntity = new Companies();
		userRepo = new UserRepo();
		userEntity = userRepo.getUserData(id);
		int experience_id = 0;
		Collection<Experiences> experienceList = new ArrayList<Experiences>();
		experienceList = userEntity.getExperienceList();
		for (Experiences obj : experienceList) {
			experience_id = obj.getId();
		}
		exprepo = new ExperienceRepo();
		expEntity = exprepo.getExperienceData(experience_id);
		List<Companies> companyList = new ArrayList<Companies>();
		userpro = new UserProfileRepo();
		companyList = userpro.SameCompanyName(companiesDataPojo.getCompany_name());
		if(companyList.size() != 0){
			for(Companies c : companyList){
				compEntity = c;
			}
			expEntity.getCompanyList().add(compEntity);
			exprepo = new ExperienceRepo();
			exprepo.updateExperienceData(expEntity);
		} else {
			compEntity.setCompany_name(companiesDataPojo.getCompany_name());
			compEntity.setCompany_rating(companiesDataPojo.getCompany_rating());
			compEntity.setCompany_industry(companiesDataPojo.getCompany_industry());
			compEntity.setCompany_worth(companiesDataPojo.getCompany_worth());
			expEntity.getCompanyList().add(compEntity);
			exprepo = new ExperienceRepo();
			exprepo.InsertUsrExpCompData(expEntity, compEntity);
		}
		return compEntity;
	}
	
	public CompaniesDataPojo getCompanyById(int id) {
		exprepo = new ExperienceRepo();
		compEntity = new Companies();
		companiesDataPojo = new CompaniesDataPojo();
		compEntity = exprepo.getCompanyData(id);
		companiesDataPojo.setId(compEntity.getId());
		companiesDataPojo.setCompany_name(compEntity.getCompany_name());
		companiesDataPojo.setCompany_rating(compEntity.getCompany_rating());
		companiesDataPojo.setCompany_industry(compEntity.getCompany_industry());
		companiesDataPojo.setCompany_worth(compEntity.getCompany_worth());
		return companiesDataPojo;
	}
	
	public CompaniesDataPojo getExperienceCompany(int id) {
		userRepo = new UserRepo();
		exprepo = new ExperienceRepo();
		expEntity = new Experiences();
		companiesDataPojo = new CompaniesDataPojo();
		int comp_id = 0;
		expEntity = exprepo.getExperienceData(id);
		Collection<Companies> compList = new ArrayList<Companies>();
		compList = expEntity.getCompanyList();
		for (Companies obj : compList) {
			comp_id = obj.getId();
			   }
		companiesDataPojo = getCompanyById(comp_id);
		return companiesDataPojo;
	}
	
	public ExperiencesDataPojo getExperienceByCompanyId(int id) {
		userRepo = new UserRepo();
		exprepo = new ExperienceRepo();
		compEntity = new Companies();
		experiencesDataPojo = new ExperiencesDataPojo();
		int exp_id = 0;
		compEntity = exprepo.getCompanyData(id);
		Collection<Experiences> expList = new ArrayList<Experiences>();
		expList = compEntity.getExperienceList();
		for (Experiences obj : expList) {
			exp_id = obj.getId();
			   }
		experiencesDataPojo = getExperienceById(exp_id);
		return experiencesDataPojo;
	}
	
	public Companies updateCompanyById(CompaniesDataPojo companiesDataPojo){
		compEntity = new Companies();
		exprepo = new ExperienceRepo();
		int id = companiesDataPojo.getId();
		compEntity = exprepo.getCompanyData(id);
		compEntity.setId(companiesDataPojo.getId());
		if(companiesDataPojo.getCompany_name() == null){
			compEntity.setCompany_name(compEntity.getCompany_name());
		} else {
			compEntity.setCompany_name(companiesDataPojo.getCompany_name());
		}
		if(companiesDataPojo.getCompany_rating() == 0){
			compEntity.setCompany_rating(compEntity.getCompany_rating());
		} else {
			compEntity.setCompany_rating(companiesDataPojo.getCompany_rating());
		}
		if(companiesDataPojo.getCompany_industry() == null){
			compEntity.setCompany_industry(compEntity.getCompany_industry());
		} else {
			compEntity.setCompany_industry(companiesDataPojo.getCompany_industry());
		}
		if(companiesDataPojo.getCompany_worth() == null){
			compEntity.setCompany_worth(compEntity.getCompany_worth());
		} else {
			compEntity.setCompany_worth(companiesDataPojo.getCompany_worth());
		}
		exprepo = new ExperienceRepo();
		exprepo.updateCompanyData(compEntity);
		return compEntity;
	}
}
