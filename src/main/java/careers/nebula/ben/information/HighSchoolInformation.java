/**
 * 
 */
package careers.nebula.ben.information;

import java.util.Collection;

import careers.nebula.ben.db.enitity.Highschool;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.db.repository.HighSchoolRepo;
import careers.nebula.ben.db.repository.UserRepo;
import careers.nebula.ben.pojo.iws.HighschoolDataPojo;
import careers.nebula.ben.pojos.UserHighschoolPojo;

/**
 * @author Ankit_Nebula
 *
 */
public class HighSchoolInformation {

	private Highschool highschoolEntity;
	private User userEntity;
	private UserRepo userRepo;
	private HighSchoolRepo highschoolRepo;
	private HighschoolDataPojo highschoolPojo;
	
	public UserHighschoolPojo insertUserHighschool(int id, HighschoolDataPojo highschoolData) {
		highschoolEntity = new Highschool();
		userEntity = new User();
		userRepo = new UserRepo();
		userEntity = userRepo.getUserData(id);
		highschoolEntity.setHighschool_name(highschoolData.getHighschool_name());
		highschoolEntity.setHighschool_rating(highschoolData.getHighschool_rating());
		highschoolEntity.setGpa(highschoolData.getGpa());
		highschoolEntity.setYear_graduated(highschoolData.getYear_graduated());
		highschoolEntity.setYear_started(highschoolData.getYear_started());
		highschoolEntity.setYear_standing(highschoolData.getYear_standing());
		userEntity.getHighschoolList().add(highschoolEntity);
		highschoolRepo = new HighSchoolRepo();
		UserHighschoolPojo combinedPojo = new UserHighschoolPojo(userEntity, highschoolEntity);
		highschoolRepo.InsertHighschoolData(combinedPojo);
		return combinedPojo;
	}
	
	public HighschoolDataPojo getHighschoolById(int id) {
		highschoolRepo = new HighSchoolRepo();
		highschoolEntity = new Highschool();
		highschoolPojo = new HighschoolDataPojo();
		highschoolEntity = highschoolRepo.getHighschoolData(id);
		highschoolPojo.setHighschool_name(highschoolEntity.getHighschool_name());
		highschoolPojo.setHighschool_rating(highschoolEntity.getHighschool_rating());
		highschoolPojo.setGpa(highschoolEntity.getGpa());
		highschoolPojo.setYear_graduated(highschoolEntity.getYear_graduated());
		highschoolPojo.setYear_started(highschoolEntity.getYear_started());
		highschoolPojo.setYear_standing(highschoolEntity.getYear_standing());
		return highschoolPojo;
	}
	
	public HighschoolDataPojo getUserHighschool(int id) {
		highschoolEntity = new Highschool();
		userRepo = new UserRepo();
		highschoolPojo = new HighschoolDataPojo();
		int highschool_id = 0;
		userEntity = userRepo.getUserData(id);
		Collection<Highschool> highschoolList = userEntity.getHighschoolList();
		for (Highschool obj : highschoolList) {
			highschool_id = obj.getId();
			   }
		highschoolPojo = getHighschoolById(highschool_id);
		return highschoolPojo;
	}

	public Highschool updateUserHighschool(HighschoolDataPojo highschoolData){
		highschoolEntity = new Highschool();
		highschoolRepo = new HighSchoolRepo();
		highschoolEntity = highschoolRepo.getHighschoolData(highschoolData.getId());
		highschoolEntity.setId(highschoolData.getId());
		if(highschoolData.getHighschool_name() == null){
			highschoolEntity.setHighschool_name(highschoolEntity.getHighschool_name());
		} else {
			highschoolEntity.setHighschool_name(highschoolData.getHighschool_name());
		}
		if(highschoolData.getHighschool_rating() == null){
			highschoolEntity.setHighschool_rating(highschoolEntity.getHighschool_rating());
		} else {
			highschoolEntity.setHighschool_rating(highschoolData.getHighschool_rating());
		}
		if(highschoolData.getGpa() == null){
			highschoolEntity.setGpa(highschoolEntity.getGpa());
		} else {
			highschoolEntity.setGpa(highschoolData.getGpa());
		}
		if(highschoolData.getYear_graduated() == null){
			highschoolEntity.setYear_graduated(highschoolEntity.getYear_graduated());
		} else {
			highschoolEntity.setYear_graduated(highschoolData.getYear_graduated());
		}
		if(highschoolData.getYear_started() == null){
			highschoolEntity.setYear_started(highschoolEntity.getYear_started());
		} else {
			highschoolEntity.setYear_started(highschoolData.getYear_started());
		}
		if(highschoolData.getYear_standing() == null){
			highschoolEntity.setYear_standing(highschoolEntity.getYear_standing());
		} else {
			highschoolEntity.setYear_standing(highschoolData.getYear_standing());
		}
		highschoolRepo = new HighSchoolRepo();
		highschoolRepo.updateHighschoolData(highschoolEntity);
		return highschoolEntity;
	}
	
}
