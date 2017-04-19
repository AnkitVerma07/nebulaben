/**
 * 
 */
package careers.nebula.ben.information;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import careers.nebula.ben.db.enitity.Resume;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.db.repository.DocumentRepo;
import careers.nebula.ben.db.repository.UserRepo;
import careers.nebula.ben.pojo.iws.ResumeDataPojo;
import careers.nebula.ben.service.ResumeParser;
/**
 * @author Ankit_Nebula
 *
 */
public class ResumeInformation {
	private User userEntity;
	private UserRepo userRepo;
	private Resume resumeEntity;
	private ResumeParser resumeparser;
	private DocumentRepo docurepo;
	private ResumeDataPojo resumeDataPojo;
	
	public Resume InsertResumeUserInfo(int id, String fileName) throws IOException{	
		resumeEntity = new Resume();
		resumeparser = new ResumeParser();
		userEntity = new User();
		userRepo = new UserRepo();
		userEntity = userRepo.getUserData(id);
		resumeparser.userParseData(fileName);
//		if(fileName == null){ resumeEntity.setFileName(" "); } else {
//		resumeEntity.setFileName(fileName);}
//		if(resumeparser.userName(fileName) == null){ resumeEntity.setUserName(" "); } else {
//		resumeEntity.setUserName(resumeparser.userName(fileName));}
//		if(resumeparser.userEmail(fileName) == null){ resumeEntity.setUserEmail(" "); } else {
//		resumeEntity.setUserEmail(resumeparser.userEmail(fileName));}
//		if(resumeparser.userPhoneNumber(fileName) == null){ resumeEntity.setUserPhone(" "); } else {
//		resumeEntity.setUserPhone(resumeparser.userPhoneNumber(fileName));}
//		if(resumeparser.userAddress(fileName) == null){ resumeEntity.setUserAddress(" "); } else {
//		resumeEntity.setUserAddress(resumeparser.userAddress(fileName));}
//		if(resumeparser.userLinks(fileName) == null){ resumeEntity.setUserLinks(" "); } else {
//		resumeEntity.setUserLinks(resumeparser.userLinks(fileName));}
//		if(resumeparser.userExperience(fileName) == null){ resumeEntity.setUserExperience(" "); } else {
//		resumeEntity.setUserExperience(resumeparser.userExperience(fileName));}
//		if(resumeparser.userEducation(fileName) == null){ resumeEntity.setUserEducation(" "); } else {
//		resumeEntity.setUserEducation(resumeparser.userEducation(fileName));}
//		if(resumeparser.userAboutme(fileName) == null){ resumeEntity.setUserAboutme(" "); } else {
//		resumeEntity.setUserAboutme(resumeparser.userAboutme(fileName));}
//		if(resumeparser.userGoals(fileName) == null){ resumeEntity.setUserGoals(" "); } else {
//		resumeEntity.setUserGoals(resumeparser.userGoals(fileName));}
//		if(resumeparser.userSkills(fileName) == null){ resumeEntity.setUserSkills(" "); } else {
//		resumeEntity.setUserSkills(resumeparser.userSkills(fileName));}
//		if(resumeparser.userResearch(fileName) == null){ resumeEntity.setUserResearch(" "); } else {
//		resumeEntity.setUserResearch(resumeparser.userResearch(fileName));}
//		if(resumeparser.userCourses(fileName) == null){ resumeEntity.setUserCourses(" "); } else {
//		resumeEntity.setUserCourses(resumeparser.userCourses(fileName));}	
//		if(resumeparser.userKeywordsMatched(fileName) == null){ resumeEntity.setKeywordsMatched(" ");} else {
//		resumeEntity.setKeywordsMatched(resumeparser.userKeywordsMatched(fileName));}
//		if(resumeparser.userKeywordsNotMatched(fileName) == null){ resumeEntity.setKeywordsNotMatched(" ");} else {
//		resumeEntity.setKeywordsNotMatched(resumeparser.userKeywordsNotMatched(fileName));}
//		userEntity.getResumeList().add(resumeEntity);
//		docurepo = new DocumentRepo();
//		docurepo.InsertResumeData(userEntity, resumeEntity);
		return resumeEntity;
	}

	public ResumeDataPojo getUserResume(int id) {
		userRepo = new UserRepo();
		resumeDataPojo = new ResumeDataPojo();
		int resume_id = 0;
		userEntity = userRepo.getUserData(id);
		Collection<Resume> resumeList = userEntity.getResumeList();
		for (Resume obj : resumeList) {
			resume_id = obj.getId();
			   }
		resumeDataPojo = getResumeById(resume_id);
		return resumeDataPojo;
	}
	
	public ResumeDataPojo getResumeById(int id) {
		docurepo = new DocumentRepo();
		resumeEntity = new Resume();
		resumeDataPojo = new ResumeDataPojo();
		resumeEntity = docurepo.getResumeById(id);
		resumeDataPojo.setId(resumeEntity.getId());
		resumeDataPojo.setFileName(resumeEntity.getFileName());
		resumeDataPojo.setUserName(resumeEntity.getUserName());
		resumeDataPojo.setUserEmail(resumeEntity.getUserEmail());
		resumeDataPojo.setUserPhone(resumeEntity.getUserPhone());
		resumeDataPojo.setUserAddress(resumeEntity.getUserAddress());
		resumeDataPojo.setUserLinks(resumeEntity.getUserLinks());
		resumeDataPojo.setUserExperience(resumeEntity.getUserExperience());
		resumeDataPojo.setUserEducation(resumeEntity.getUserEducation());
		resumeDataPojo.setUserAboutme(resumeEntity.getUserAboutme());
		resumeDataPojo.setUserGoals(resumeEntity.getUserGoals());
		resumeDataPojo.setUserSkills(resumeEntity.getUserSkills());
		resumeDataPojo.setUserResearch(resumeEntity.getUserResearch());
		resumeDataPojo.setUserCourses(resumeEntity.getUserCourses());
		resumeDataPojo.setKeywordsMatched(resumeEntity.getKeywordsMatched());
		resumeDataPojo.setKeywordsNotMatched(resumeEntity.getKeywordsNotMatched());
		resumeDataPojo.setUpdated(resumeEntity.getUpdated());
		return resumeDataPojo;
	}
	
	public Resume updateUserResume(int id, ResumeDataPojo resumeDataPojo){
		userEntity = new User();
		userRepo = new UserRepo();
		int resume_id = 0;
		userEntity = userRepo.getUserData(id);
		Collection<Resume> resumeList = new ArrayList<Resume>();
		resumeList = userEntity.getResumeList();
		for(Resume obj : resumeList){
			resume_id = obj.getId();
		}
		resumeEntity = new Resume();
		docurepo = new DocumentRepo();
		resumeEntity = docurepo.getResumeById(resumeDataPojo.getId());
		resumeDataPojo.setId(resume_id);
		resumeEntity.setId(resumeDataPojo.getId());
		if(resumeDataPojo.getFileName() == null){
			resumeEntity.setFileName(resumeEntity.getFileName());
		} else {
			resumeEntity.setFileName(resumeDataPojo.getFileName());
		}
		if(resumeDataPojo.getUserName() == null){
			resumeEntity.setUserName(resumeEntity.getUserName());
		} else {
			resumeEntity.setUserName(resumeDataPojo.getUserName());
		}
		if(resumeDataPojo.getUserEmail() == null){
			resumeEntity.setUserEmail(resumeEntity.getUserEmail());
		} else {
			resumeEntity.setUserEmail(resumeDataPojo.getUserEmail());
		}
		if(resumeDataPojo.getUserPhone() == null){
			resumeEntity.setUserPhone(resumeEntity.getUserPhone());
		} else {
			resumeEntity.setUserPhone(resumeDataPojo.getUserPhone());
		}
		if(resumeDataPojo.getUserAddress() == null){
			resumeEntity.setUserAddress(resumeEntity.getUserAddress());
		} else {
			resumeEntity.setUserAddress(resumeDataPojo.getUserAddress());
		}
		if(resumeDataPojo.getUserLinks() == null){
			resumeEntity.setUserLinks(resumeEntity.getUserLinks());
		} else {
			resumeEntity.setUserLinks(resumeDataPojo.getUserLinks());
		}
		if(resumeDataPojo.getUserExperience() == null){
			resumeEntity.setUserExperience(resumeEntity.getUserExperience());
		} else {
			resumeEntity.setUserExperience(resumeDataPojo.getUserExperience());
		}
		if(resumeDataPojo.getUserEducation() == null){
			resumeEntity.setUserEducation(resumeEntity.getUserEducation());
		} else {
			resumeEntity.setUserEducation(resumeDataPojo.getUserEducation());
		}
		if(resumeDataPojo.getUserAboutme() == null){
			resumeEntity.setUserAboutme(resumeEntity.getUserAboutme());
		} else {
			resumeEntity.setUserAboutme(resumeDataPojo.getUserAboutme());
		}
		if(resumeDataPojo.getUserGoals() == null){
			resumeEntity.setUserGoals(resumeEntity.getUserGoals());
		} else {
			resumeEntity.setUserGoals(resumeDataPojo.getUserGoals());
		}
		if(resumeDataPojo.getUserSkills() == null){
			resumeEntity.setUserSkills(resumeEntity.getUserSkills());
		} else {
			resumeEntity.setUserSkills(resumeDataPojo.getUserSkills());
		}
		if(resumeDataPojo.getUserResearch() == null){
			resumeEntity.setUserResearch(resumeEntity.getUserResearch());
		} else {
			resumeEntity.setUserResearch(resumeDataPojo.getUserResearch());
		}
		if(resumeDataPojo.getUserCourses() == null){
			resumeEntity.setUserCourses(resumeEntity.getUserCourses());
		} else {
			resumeEntity.setUserCourses(resumeDataPojo.getUserCourses());
		}
		if(resumeDataPojo.getKeywordsMatched() == null){
			resumeEntity.setKeywordsMatched(resumeEntity.getKeywordsMatched());
		} else {
			resumeEntity.setKeywordsMatched(resumeDataPojo.getKeywordsMatched());
		}
		if(resumeDataPojo.getKeywordsNotMatched() == null){
			resumeEntity.setKeywordsNotMatched(resumeEntity.getKeywordsNotMatched());
		} else {
			resumeEntity.setKeywordsNotMatched(resumeDataPojo.getKeywordsNotMatched());
		}
		if(resumeDataPojo.getUpdated() == null){
			resumeEntity.setUpdated(resumeEntity.getUpdated());
		} else {
			resumeEntity.setUpdated(resumeDataPojo.getUpdated());
		}
		docurepo = new DocumentRepo();
		docurepo.updateResumedata(resumeEntity);
		return resumeEntity;
	}

}
