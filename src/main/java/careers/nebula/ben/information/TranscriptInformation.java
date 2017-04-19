/**
 * 
 */
package careers.nebula.ben.information;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import careers.nebula.ben.db.enitity.Transcript;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.db.repository.DocumentRepo;
import careers.nebula.ben.db.repository.UserRepo;
import careers.nebula.ben.pojo.iws.TranscriptDataPojo;
import careers.nebula.ben.service.TranscriptParser;

/**
 * @author Ankit_Nebula
 *
 */
public class TranscriptInformation {
	private User userEntity;
	private UserRepo userRepo;
	private Transcript tranEntity;
	private TranscriptDataPojo tranDataPojo;
	private TranscriptParser tranparser;
	private DocumentRepo docurepo;
	
	public Transcript InsertTranscriptUserInfo(int id, String fileName) throws IOException{	
		tranEntity = new Transcript();
		tranparser = new TranscriptParser();
		userEntity = new User();
		userRepo = new UserRepo();
		userEntity = userRepo.getUserData(id);
		if(fileName == null){ tranEntity.setFileName(" "); } else {
			tranEntity.setFileName(fileName);}
		if(tranparser.userFirstYear(fileName) == null){ tranEntity.setEarliestYear(0); } else {
			tranEntity.setEarliestYear(tranparser.userFirstYear(fileName));}
		if(tranparser.userLastYear(fileName) == null){ tranEntity.setLastYear(0);} else {
			tranEntity.setLastYear(tranparser.userLastYear(fileName));}
		if(tranparser.userGpa(fileName) == null){ tranEntity.setGpa(0.0);} else {
			tranEntity.setGpa(tranparser.userGpa(fileName));}
		if(tranparser.userUnitsAttempted(fileName) == null){ tranEntity.setUnitsAttempted(0.0); } else {
			tranEntity.setUnitsAttempted(tranparser.userUnitsAttempted(fileName));}
		if(tranparser.userUnitsPassed(fileName) == null){ tranEntity.setUnitsPassed(0.0); } else {
			tranEntity.setUnitsPassed(tranparser.userUnitsPassed(fileName));}
		if(tranparser.userUnitsCompleted(fileName) == null){ tranEntity.setUnitsCompleted(0.0);} else {
			tranEntity.setUnitsCompleted(tranparser.userUnitsCompleted(fileName));}
		if(tranparser.userUniName(fileName) == null){ tranEntity.setUniName(" ");} else {
			tranEntity.setUniName(tranparser.userUniName(fileName));}
		if(tranparser.userGrades(fileName) == null){ tranEntity.setCoursesGrades(" ");} else {
			tranEntity.setCoursesGrades(tranparser.userGrades(fileName));}
		if(tranparser.userCoursesMatched(fileName) == null){ tranEntity.setCoursesMatch(" ");} else {
			tranEntity.setCoursesMatch(tranparser.userCoursesMatched(fileName));}
		if(tranparser.userIncompleteGrades(fileName) == null){ tranEntity.setIncompleteGrades(0);} else {
			tranEntity.setIncompleteGrades(tranparser.userIncompleteGrades(fileName));}
		if(tranparser.userPNPgrades(fileName) == null){ tranEntity.setPnpGrades(0);} else {
			tranEntity.setPnpGrades(tranparser.userPNPgrades(fileName));}
		if(tranparser.userSUgrades(fileName) == null){ tranEntity.setSuGrades(0);} else {
			tranEntity.setSuGrades(tranparser.userSUgrades(fileName));}
		if(tranparser.userWgrades(fileName) == null){ tranEntity.setwGrades(0);} else {
			tranEntity.setwGrades(tranparser.userWgrades(fileName));}
		if(tranparser.userFirstYear(fileName) == null){ tranEntity.setFailedCourses(0);} else {
			tranEntity.setFailedCourses(tranparser.userFailedCourses(fileName));}
		if(tranparser.userAccedCourses(fileName) == null){ tranEntity.setAccedCourses(0);} else {
			tranEntity.setAccedCourses(tranparser.userAccedCourses(fileName));}
		userEntity.getTranscriptList().add(tranEntity);
		docurepo = new DocumentRepo();
		docurepo.InsertTranscriptData(userEntity, tranEntity);
		return tranEntity;
	}
	
	public TranscriptDataPojo getUserTranscript(int id) {
		userRepo = new UserRepo();
		tranDataPojo = new TranscriptDataPojo();
		int tran_id = 0;
		userEntity = userRepo.getUserData(id);
		Collection<Transcript> tranList = userEntity.getTranscriptList();
		for (Transcript obj : tranList) {
			tran_id = obj.getId();
			   }
		tranDataPojo = getTranscriptById(tran_id);
		return tranDataPojo;
	}
	
	public TranscriptDataPojo getTranscriptById(int id) {
		docurepo = new DocumentRepo();
		tranEntity = new Transcript();
		tranDataPojo = new TranscriptDataPojo();
		tranEntity = docurepo.getTranscriptById(id);
		tranDataPojo.setId(tranEntity.getId());
		tranDataPojo.setFileName(tranEntity.getFileName());
		tranDataPojo.setEarliestYear(tranEntity.getEarliestYear());
		tranDataPojo.setLastYear(tranEntity.getLastYear());
		tranDataPojo.setGpa(tranEntity.getGpa());
		tranDataPojo.setCoursesMatch(tranEntity.getCoursesMatch());
		tranDataPojo.setCoursesGrades(tranEntity.getCoursesGrades());
		tranDataPojo.setUnitsAttempted(tranEntity.getUnitsAttempted());
		tranDataPojo.setUnitsPassed(tranEntity.getUnitsPassed());
		tranDataPojo.setUnitsCompleted(tranEntity.getUnitsCompleted());
		tranDataPojo.setUniName(tranEntity.getUniName());
		tranDataPojo.setIncompleteGrades(tranEntity.getIncompleteGrades());
		tranDataPojo.setPnpGrades(tranEntity.getPnpGrades());
		tranDataPojo.setSuGrades(tranEntity.getSuGrades());
		tranDataPojo.setwGrades(tranEntity.getwGrades());
		tranDataPojo.setFailedCourses(tranEntity.getFailedCourses());
		tranDataPojo.setAccedCourses(tranEntity.getAccedCourses());
		tranDataPojo.setUpdated(tranEntity.getUpdated());
		return tranDataPojo;
	}
	
	public Transcript updateUserTranscript(int id, TranscriptDataPojo transcriptDataPojo){
		userEntity = new User();
		userRepo = new UserRepo();
		int tran_id = 0;
		userEntity = userRepo.getUserData(id);
		Collection<Transcript> tranList = new ArrayList<Transcript>();
		tranList = userEntity.getTranscriptList();
		for(Transcript obj : tranList){
			tran_id = obj.getId();
		}
		tranEntity = new Transcript();
		docurepo = new DocumentRepo();
		tranEntity = docurepo.getTranscriptById(transcriptDataPojo.getId());
		transcriptDataPojo.setId(tran_id);
		tranEntity.setId(transcriptDataPojo.getId());
		if(transcriptDataPojo.getFileName() == null){
			tranEntity.setFileName(tranEntity.getFileName());
		} else {
			tranEntity.setFileName(transcriptDataPojo.getFileName());
		}
		if(transcriptDataPojo.getEarliestYear() == null){
			tranEntity.setEarliestYear(tranEntity.getEarliestYear());
		} else {
			tranEntity.setEarliestYear(transcriptDataPojo.getEarliestYear());
		}
		if(transcriptDataPojo.getLastYear() == null){
			tranEntity.setLastYear(tranEntity.getLastYear());
		} else {
			tranEntity.setLastYear(transcriptDataPojo.getLastYear());
		}
		if(transcriptDataPojo.getGpa() == null){
			tranEntity.setGpa(tranEntity.getGpa());
		} else {
			tranEntity.setGpa(transcriptDataPojo.getGpa());
		}
		if(transcriptDataPojo.getCoursesMatch() == null){
			tranEntity.setCoursesMatch(tranEntity.getCoursesMatch());
		} else {
			tranEntity.setCoursesMatch(transcriptDataPojo.getCoursesMatch());
		}
		if(transcriptDataPojo.getCoursesGrades() == null){
			tranEntity.setCoursesGrades(tranEntity.getCoursesGrades());
		} else {
			tranEntity.setCoursesGrades(transcriptDataPojo.getCoursesGrades());
		}
		if(transcriptDataPojo.getUnitsAttempted() == null){
			tranEntity.setUnitsAttempted(tranEntity.getUnitsAttempted());
		} else {
			tranEntity.setUnitsAttempted(transcriptDataPojo.getUnitsAttempted());
		}
		if(transcriptDataPojo.getUnitsPassed() == null){
			tranEntity.setUnitsPassed(tranEntity.getUnitsPassed());
		} else {
			tranEntity.setUnitsPassed(transcriptDataPojo.getUnitsPassed());
		}
		if(transcriptDataPojo.getUnitsCompleted() == null){
			tranEntity.setUnitsCompleted(tranEntity.getUnitsCompleted());
		} else {
			tranEntity.setUnitsCompleted(transcriptDataPojo.getUnitsCompleted());
		}
		if(transcriptDataPojo.getUniName() == null){
			tranEntity.setUniName(tranEntity.getUniName());
		} else {
			tranEntity.setUniName(transcriptDataPojo.getUniName());
		}
		if(transcriptDataPojo.getIncompleteGrades() == null){
			tranEntity.setIncompleteGrades(tranEntity.getIncompleteGrades());
		} else {
			tranEntity.setIncompleteGrades(transcriptDataPojo.getIncompleteGrades());
		}
		if(transcriptDataPojo.getPnpGrades() == null){
			tranEntity.setPnpGrades(tranEntity.getPnpGrades());
		} else {
			tranEntity.setPnpGrades(transcriptDataPojo.getPnpGrades());
		}
		if(transcriptDataPojo.getSuGrades() == null){
			tranEntity.setSuGrades(tranEntity.getSuGrades());
		} else {
			tranEntity.setSuGrades(transcriptDataPojo.getSuGrades());
		}
		if(transcriptDataPojo.getwGrades() == null){
			tranEntity.setwGrades(tranEntity.getwGrades());
		} else {
			tranEntity.setwGrades(transcriptDataPojo.getwGrades());
		}
		if(transcriptDataPojo.getFailedCourses() == null){
			tranEntity.setFailedCourses(tranEntity.getFailedCourses());
		} else {
			tranEntity.setFailedCourses(transcriptDataPojo.getFailedCourses());
		}
		if(transcriptDataPojo.getAccedCourses() == null){
			tranEntity.setAccedCourses(tranEntity.getAccedCourses());
		} else {
			tranEntity.setAccedCourses(transcriptDataPojo.getAccedCourses());
		}
		if(transcriptDataPojo.getUpdated() == null){
			tranEntity.setUpdated(tranEntity.getUpdated());
		} else {
			tranEntity.setUpdated(transcriptDataPojo.getUpdated());
		}
		docurepo = new DocumentRepo();
		docurepo.updateTranscriptdata(tranEntity);
		return tranEntity;
	}
}
