/**
 * 
 */
package careers.nebula.ben.information;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import careers.nebula.ben.db.enitity.Courses;
import careers.nebula.ben.db.enitity.Extracurricular;
import careers.nebula.ben.db.enitity.Industry;
import careers.nebula.ben.db.enitity.Interests;
import careers.nebula.ben.db.enitity.Keywords;
import careers.nebula.ben.db.enitity.Languages;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.db.repository.EducationalRepo;
import careers.nebula.ben.db.repository.SkillsRepo;
import careers.nebula.ben.db.repository.UserProfileRepo;
import careers.nebula.ben.db.repository.UserRepo;
import careers.nebula.ben.pojo.iws.ExtracurricularDataPojo;
import careers.nebula.ben.pojo.iws.IndustryDataPojo;
import careers.nebula.ben.pojo.iws.InterestsDataPojo;
import careers.nebula.ben.pojo.iws.KeywordsDataPojo;
import careers.nebula.ben.pojo.iws.LanguagesDataPojo;
import careers.nebula.ben.pojos.ResponseIntegerList;

/**
 * @author Ankit_Nebula
 *
 */
public class SkillsInformation {

	private Extracurricular extraEntity;
	private User userEntity;
	private UserRepo userRepo;
	private SkillsRepo skillsRepo;
	private ExtracurricularDataPojo extracurricularDataPojo;
	private Languages languageEntity;
	private LanguagesDataPojo languageDataPojo;
	private InterestsDataPojo interestDataPojo;
	private Interests interestEntity;
	private IndustryDataPojo industryDataPojo;
	private Industry indusEntity;
	private KeywordsDataPojo keywordsDataPojo;
	private Keywords keywordEntity;
	private UserProfileRepo userpro;
	private Courses coEntity;
	private EducationalRepo edurepo;
	
	public ExtracurricularDataPojo insertExtracurricularInfo(int id, ExtracurricularDataPojo extracurricularDataPojo) {
		extraEntity = new Extracurricular();
		userEntity = new User();
		userRepo = new UserRepo();
		userEntity = userRepo.getUserData(id);
		userpro = new UserProfileRepo();
		List<Extracurricular> extraList = new ArrayList<Extracurricular>();
		extraList = userpro.SameExtracurricular(extracurricularDataPojo.getName());
		if(extraList.size() != 0){
			for(Extracurricular e : extraList){
				extraEntity = e;
			}
			userEntity.getExtracurricularList().add(extraEntity);
			userRepo = new UserRepo();
			userRepo.updateUserdata(userEntity);
		} else {
			extraEntity.setName(extracurricularDataPojo.getName());
			userEntity.getExtracurricularList().add(extraEntity);
			skillsRepo = new SkillsRepo();
			skillsRepo.InsertExtracurricularSkill(userEntity, extraEntity);
		}
		return extracurricularDataPojo;
	}

	public ExtracurricularDataPojo getExtracurricularById(int id) {
		skillsRepo = new SkillsRepo();
		extraEntity = new Extracurricular();
		extracurricularDataPojo = new ExtracurricularDataPojo();
		extraEntity = skillsRepo.getExtracurricularData(id);
		extracurricularDataPojo.setId(extraEntity.getId());
		extracurricularDataPojo.setName(extraEntity.getName());
		return extracurricularDataPojo;
	}
	
	public ResponseIntegerList getUserExtracurricularList(int id) {
		userRepo = new UserRepo();
		extracurricularDataPojo = new ExtracurricularDataPojo();
		int extra_id = 0;
		userEntity = userRepo.getUserData(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<Integer> idList = new ArrayList<Integer>();
		extraList = userEntity.getExtracurricularList();
		for (Extracurricular obj : extraList) {
			extra_id = obj.getId();
			idList.add(extra_id);
			   }
		ResponseIntegerList list = new ResponseIntegerList();
		list.setList(idList);
		return list;
	}
	
	public Extracurricular updateExtracurricularById(ExtracurricularDataPojo extracurricularDataPojo){
		extraEntity = new Extracurricular();
		skillsRepo = new SkillsRepo();
		extraEntity = skillsRepo.getExtracurricularData(extracurricularDataPojo.getId());
		extraEntity.setId(extracurricularDataPojo.getId());
		if(extracurricularDataPojo.getName() == null){
			extraEntity.setName(extraEntity.getName());
		} else {
			extraEntity.setName(extracurricularDataPojo.getName());
		}
		skillsRepo = new SkillsRepo();
		skillsRepo.updateExtracurricularData(extraEntity);
		return extraEntity;
	}
	
	public LanguagesDataPojo insertLanguageInfo(int id, LanguagesDataPojo languageDataPojo) {
		languageEntity = new Languages();
		userEntity = new User();
		userRepo = new UserRepo();
		userEntity = userRepo.getUserData(id);
		userpro = new UserProfileRepo();
		List<Languages> languageList = new ArrayList<Languages>();
		languageList = userpro.SameLanguages(languageDataPojo.getName());
		if(languageList.size() != 0){
			for(Languages l : languageList){
				languageEntity = l;
			}
			userEntity.getLanguageList().add(languageEntity);
			userRepo = new UserRepo();
			userRepo.updateUserdata(userEntity);
		} else {
			languageEntity.setName(languageDataPojo.getName());
			userEntity.getLanguageList().add(languageEntity);
			skillsRepo = new SkillsRepo();
			skillsRepo.InsertLanguageSkill(userEntity, languageEntity);
		}
		return languageDataPojo;
	}
	
	public LanguagesDataPojo getLanguageById(int id) {
		skillsRepo = new SkillsRepo();
		languageEntity = new Languages();
		languageDataPojo = new LanguagesDataPojo();
		languageEntity = skillsRepo.getLanguageData(id);
		languageDataPojo.setId(languageEntity.getId());
		languageDataPojo.setName(languageEntity.getName());
		return languageDataPojo;
	}
	
	public ResponseIntegerList getUserLanguageList(int id) {
		userRepo = new UserRepo();
		languageDataPojo = new LanguagesDataPojo();
		int language_id = 0;
		userEntity = userRepo.getUserData(id);
		Collection<Languages> languageList = new ArrayList<Languages>();
		List<Integer> idList = new ArrayList<Integer>();
		languageList = userEntity.getLanguageList();
		for (Languages obj : languageList) {
			language_id = obj.getId();
			idList.add(language_id);
			   }
		ResponseIntegerList list = new ResponseIntegerList();
		list.setList(idList);
		return list;
	}
	
	public Languages updateLanguageById(LanguagesDataPojo languageDataPojo){
		languageEntity = new Languages();
		skillsRepo = new SkillsRepo();
		languageEntity = skillsRepo.getLanguageData(languageDataPojo.getId());
		languageEntity.setId(languageDataPojo.getId());
		if(languageDataPojo.getName() == null){
			languageEntity.setName(languageEntity.getName());
		} else {
			languageEntity.setName(languageDataPojo.getName());
		}
		skillsRepo = new SkillsRepo();
		skillsRepo.updateLaguageData(languageEntity);
		return languageEntity;
	}

	public InterestsDataPojo insertInterestInfo(int id, InterestsDataPojo interestDataPojo) {
		interestEntity = new Interests();
		userEntity = new User();
		userRepo = new UserRepo();
		userpro = new UserProfileRepo();
		userEntity = userRepo.getUserData(id);
		List<Interests> interestList = new ArrayList<Interests>();
		interestList = userpro.SameInterests(interestDataPojo.getName());
		if(interestList.size() != 0){
			for(Interests i : interestList){
				interestEntity = i;
			}
			userEntity.getInterestList().add(interestEntity);
			userRepo = new UserRepo();
			userRepo.updateUserdata(userEntity);
		} else {
			interestEntity.setName(interestDataPojo.getName());
			userEntity.getInterestList().add(interestEntity);
			skillsRepo = new SkillsRepo();
			skillsRepo.InsertInterestsData(userEntity, interestEntity);
		}
		return interestDataPojo;
	}
	
	public InterestsDataPojo getInterestById(int id) {
		skillsRepo = new SkillsRepo();
		interestEntity = new Interests();
		interestDataPojo = new InterestsDataPojo();
		interestEntity = skillsRepo.getInterestData(id);
		interestDataPojo.setId(interestEntity.getId());
		interestDataPojo.setName(interestEntity.getName());
		return interestDataPojo;
	}
	
	public ResponseIntegerList getUserInterestList(int id) {
		userRepo = new UserRepo();
		interestDataPojo = new InterestsDataPojo();
		int interest_id = 0;
		userEntity = userRepo.getUserData(id);
		Collection<Interests> interestList = new ArrayList<Interests>();
		List<Integer> idList = new ArrayList<Integer>();
		interestList = userEntity.getInterestList();
		for (Interests obj : interestList) {
			interest_id = obj.getId();
			idList.add(interest_id);
			   }
		ResponseIntegerList list = new ResponseIntegerList();
		list.setList(idList);
		return list;
	}
	
	public Interests updateInterestById(InterestsDataPojo interestDataPojo){
		interestEntity = new Interests();
		skillsRepo = new SkillsRepo();
		interestEntity = skillsRepo.getInterestData(interestDataPojo.getId());
		interestEntity.setId(interestDataPojo.getId());
		if(interestDataPojo.getName() == null){
			interestEntity.setName(interestEntity.getName());
		} else {
			interestEntity.setName(interestDataPojo.getName());
		}
		skillsRepo = new SkillsRepo();
		skillsRepo.updateInterestData(interestEntity);
		return interestEntity;
	}
	
	public IndustryDataPojo insertIndustryInfo(int id, IndustryDataPojo industryDataPojo) {
		indusEntity = new Industry();
		userEntity = new User();
		userRepo = new UserRepo();
		userpro = new UserProfileRepo();
		userEntity = userRepo.getUserData(id);
		List<Industry> industryList = new ArrayList<Industry>();
		industryList = userpro.SameIndustry(industryDataPojo.getName());
		if(industryList.size() != 0){
			for(Industry i : industryList){
				indusEntity = i;
			}
			userEntity.getIndustryList().add(indusEntity);
			userRepo = new UserRepo();
			userRepo.updateUserdata(userEntity);
		} else {
			indusEntity.setName(industryDataPojo.getName());
			userEntity.getIndustryList().add(indusEntity);
			skillsRepo = new SkillsRepo();
			skillsRepo.InsertIndustryData(userEntity, indusEntity);
		}
		return industryDataPojo;
	}
	
	public IndustryDataPojo getIndustryById(int id) {
		skillsRepo = new SkillsRepo();
		indusEntity = new Industry();
		industryDataPojo = new IndustryDataPojo();
		indusEntity = skillsRepo.getIndustryData(id);
		industryDataPojo.setId(indusEntity.getId());
		industryDataPojo.setName(indusEntity.getName());
		return industryDataPojo;
	}
	
	public ResponseIntegerList getUserIndustryList(int id) {
		userRepo = new UserRepo();
		industryDataPojo = new IndustryDataPojo();
		int industry_id = 0;
		userEntity = userRepo.getUserData(id);
		Collection<Industry> industryList = new ArrayList<Industry>();
		List<Integer> idList = new ArrayList<Integer>();
		industryList = userEntity.getIndustryList();
		for (Industry obj : industryList) {
			industry_id = obj.getId();
			idList.add(industry_id);
			   }
		ResponseIntegerList list = new ResponseIntegerList();
		list.setList(idList);
		return list;
	}
	
	public Industry updateIndustryById(IndustryDataPojo industryDataPojo){
		indusEntity = new Industry();
		skillsRepo = new SkillsRepo();
		indusEntity = skillsRepo.getIndustryData(industryDataPojo.getId());
		indusEntity.setId(industryDataPojo.getId());
		if(industryDataPojo.getName() == null){
			indusEntity.setName(indusEntity.getName());
		} else {
			indusEntity.setName(industryDataPojo.getName());
		}
		skillsRepo = new SkillsRepo();
		skillsRepo.updateIndustryData(indusEntity);
		return indusEntity;
	}
	
	public KeywordsDataPojo insertKeywordInfo(int id, KeywordsDataPojo keywordsDataPojo) {
		keywordEntity = new Keywords();
		userEntity = new User();
		userRepo = new UserRepo();
		userEntity = userRepo.getUserData(id);
		userpro = new UserProfileRepo();
		List<Keywords> keywordList = new ArrayList<Keywords>();
		keywordList = userpro.SameKeywords(keywordsDataPojo.getName());
		if(keywordList.size() != 0){
			for(Keywords k : keywordList){
				keywordEntity = k;
			}
			userEntity.getKeywordList().add(keywordEntity);
			userRepo = new UserRepo();
			userRepo.updateUserdata(userEntity);
		} else {
			keywordEntity.setName(keywordsDataPojo.getName());
			userEntity.getKeywordList().add(keywordEntity);
			skillsRepo = new SkillsRepo();
			skillsRepo.InsertKeywordData(userEntity, keywordEntity);
		}
		return keywordsDataPojo;
	}
	
	public KeywordsDataPojo getKeywordById(int id) {
		skillsRepo = new SkillsRepo();
		keywordEntity = new Keywords();
		keywordsDataPojo = new KeywordsDataPojo();
		keywordEntity = skillsRepo.getKeywordData(id);
		keywordsDataPojo.setId(keywordEntity.getId());
		keywordsDataPojo.setName(keywordEntity.getName());
		return keywordsDataPojo;
	}
	
	public ResponseIntegerList getUserKeywordList(int id) {
		userRepo = new UserRepo();
		keywordsDataPojo = new KeywordsDataPojo();
		int key_id = 0;
		userEntity = userRepo.getUserData(id);
		Collection<Keywords> keywordList = new ArrayList<Keywords>();
		List<Integer> idList = new ArrayList<Integer>();
		keywordList = userEntity.getKeywordList();
		for (Keywords obj : keywordList) {
			key_id = obj.getId();
			idList.add(key_id);
			   }
		ResponseIntegerList list = new ResponseIntegerList();
		list.setList(idList);
		return list;
	}
	
	public Keywords updateKeywordById(KeywordsDataPojo keywordsDataPojo){
		keywordEntity = new Keywords();
		skillsRepo = new SkillsRepo();
		keywordEntity = skillsRepo.getKeywordData(keywordsDataPojo.getId());
		keywordEntity.setId(keywordsDataPojo.getId());
		if(keywordsDataPojo.getName() == null){
			keywordEntity.setName(keywordEntity.getName());
		} else {
			keywordEntity.setName(keywordsDataPojo.getName());
		}
		skillsRepo = new SkillsRepo();
		skillsRepo.updateKeywordData(keywordEntity);
		return keywordEntity;
	}
	
	public IndustryDataPojo insertCourseSkills(int id, IndustryDataPojo industryDataPojo){
		indusEntity = new Industry();
		coEntity = new Courses();
		edurepo = new EducationalRepo();
		userpro = new UserProfileRepo();
		coEntity = edurepo.getCourseData(id);
		List<Industry> industryList = new ArrayList<Industry>();
		industryList = userpro.SameIndustry(industryDataPojo.getName());
		if(industryList.size() != 0){
			for(Industry i : industryList){
				indusEntity = i;
			}
			coEntity.getIndustryList().add(indusEntity);
			skillsRepo = new SkillsRepo();
			skillsRepo.updateCoursesSkills(coEntity, indusEntity);
		} else {
			indusEntity.setName(industryDataPojo.getName());
			coEntity.getIndustryList().add(indusEntity);
			skillsRepo = new SkillsRepo();
			skillsRepo.insertCoursesSkills(coEntity, indusEntity);
		}
		return industryDataPojo;
	}
	
//	public ResponseIntegerList getCourseSkillsIds(int id){
//		ResponseIntegerList list = new ResponseIntegerList();
//		List<Integer> ids = new ArrayList<Integer>();
//		
//		list.setList(ids);
//		return list;	
//	}
}
