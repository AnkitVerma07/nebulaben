/**
 * 
 */
package careers.nebula.ben.information;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import careers.nebula.ben.db.enitity.Companies;
import careers.nebula.ben.db.enitity.Experiences;
import careers.nebula.ben.db.enitity.Highschool;
import careers.nebula.ben.db.enitity.Locations;
import careers.nebula.ben.db.enitity.Qualification;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.db.repository.ExperienceRepo;
import careers.nebula.ben.db.repository.HighSchoolRepo;
import careers.nebula.ben.db.repository.LocationRepo;
import careers.nebula.ben.db.repository.QualificationRepo;
import careers.nebula.ben.db.repository.UserRepo;
import careers.nebula.ben.pojo.iws.LocationDataPojo;
import careers.nebula.ben.pojo.iws.UserDataPojo;
import careers.nebula.ben.pojos.HighSchoolLocationPojo;
import careers.nebula.ben.pojos.QualificationLocationPojo;
import careers.nebula.ben.pojos.ResponseIntegerList;
import careers.nebula.ben.pojos.UserLocationPojo;

/**
 * @author Ankit_Nebula
 *
 */
public class LocationInformation {

	private  LocationRepo locationRepo;
	private Locations locationEntity;
	private UserRepo userRepo;
	private User userEntity;
	private UserInformation userInfo;
	private LocationDataPojo locationPojo;
	private Highschool highschoolEntity;
	private HighSchoolRepo HSrepo;
	private Qualification qualEntity;
	private QualificationRepo qualrepo;
	private Experiences expEntity;
	private ExperienceRepo exprepo;
	private Companies compEntity;
	private UserDataPojo userdatapojo;
	
	public UserLocationPojo insertUserLocation(int id, LocationDataPojo locationData){	
		locationEntity = new Locations();
		userEntity = new User();
		userRepo = new UserRepo();
		userEntity = userRepo.getUserData(id);
		locationEntity.setStreet_address1(locationData.getStreet_address1());
		locationEntity.setStreet_address2(locationData.getStreet_address2());
		locationEntity.setCity(locationData.getCity());
		locationEntity.setState(locationData.getState());
		locationEntity.setZipcode(locationData.getZipcode());
		locationEntity.setCountry(locationData.getCountry());
		userEntity.getLocationList().add(locationEntity);
		locationRepo = new LocationRepo();
		UserLocationPojo combinedPojo = new UserLocationPojo(userEntity, locationEntity);
		locationRepo.InsertUserLocationData(combinedPojo);
		return combinedPojo;
	}

	public LocationDataPojo getUserLocation(int id) {
		locationEntity = new Locations();
		userRepo = new UserRepo();
		locationPojo = new LocationDataPojo();
		int location_id = 0;
		userEntity = userRepo.getUserData(id);
		Collection<Locations> locationList = userEntity.getLocationList();
		for (Locations obj : locationList) {
			     location_id = obj.getId();
			   }
		locationPojo = getLocationById(location_id);
		return locationPojo;
	}
	
	public UserDataPojo getUserByLocId(int id){
		int user_id = 0;
		locationRepo = new LocationRepo();
		locationEntity = new Locations();
		locationEntity = locationRepo.getLocationData(id);
		Collection<User> userList = new ArrayList<User>();
		userList = locationEntity.getUserList();
		for(User u : userList){
			user_id = u.getId();
		}
		userdatapojo = new UserDataPojo();
		userInfo = new UserInformation();
		userdatapojo = userInfo.getPrimaryUserInfo(user_id); 
		return userdatapojo;
	}
	
	public LocationDataPojo getLocationById(int id) {
		locationRepo = new LocationRepo();
		locationEntity = new Locations();
		locationPojo = new LocationDataPojo();
		locationEntity = locationRepo.getLocationData(id);
		locationPojo.setId(locationEntity.getId());
		locationPojo.setStreet_address1(locationEntity.getStreet_address1());
		locationPojo.setStreet_address2(locationEntity.getStreet_address2());
		locationPojo.setCity(locationEntity.getCity());
		locationPojo.setState(locationEntity.getState());
		locationPojo.setZipcode(locationEntity.getZipcode());
		locationPojo.setCountry(locationEntity.getCountry());
		return locationPojo;
	}
	
	public Locations updateUserLocation(LocationDataPojo locationData){
		locationRepo = new LocationRepo();
		locationEntity = new Locations();
		locationEntity = locationRepo.getLocationData(locationData.getId());
		locationEntity.setId(locationData.getId());
		if(locationData.getStreet_address1() == null){
			locationEntity.setStreet_address1(locationEntity.getStreet_address1());
		} else {
			locationEntity.setStreet_address1(locationData.getStreet_address1());
		}
		if(locationData.getStreet_address2() == null){
			locationEntity.setStreet_address2(locationEntity.getStreet_address2());
		} else {
			locationEntity.setStreet_address2(locationData.getStreet_address2());
		}
		if(locationData.getCity() == null){
			locationEntity.setCity(locationEntity.getCity());
		} else {
			locationEntity.setCity(locationData.getCity());
		}
		if(locationData.getState() == null){
			locationEntity.setState(locationEntity.getState());
		} else {
			locationEntity.setState(locationData.getState());
		}
		if(locationData.getZipcode() == null){
			locationEntity.setZipcode(locationEntity.getZipcode());
		} else {
			locationEntity.setZipcode(locationData.getZipcode());
		}
		if(locationData.getCountry() == null){
			locationEntity.setCountry(locationEntity.getCountry());
		} else {
			locationEntity.setCountry(locationData.getCountry());
		}
		locationRepo = new LocationRepo();
		locationRepo.updateLocationData(locationEntity);
		return locationEntity;
	}
	

	public HighSchoolLocationPojo insertUserHSLocation(int id, LocationDataPojo locationData){	
		locationEntity = new Locations();
		userEntity = new User();
		userRepo = new UserRepo();
		highschoolEntity = new Highschool();
		HSrepo = new HighSchoolRepo();
		int highschool_id = 0;
		userEntity = userRepo.getUserData(id);
		Collection<Highschool> highschoolList = new ArrayList<Highschool>();
		highschoolList = userEntity.getHighschoolList();
		for (Highschool obj : highschoolList) {
			highschool_id = obj.getId();
		}
		highschoolEntity = HSrepo.getHighschoolData(highschool_id);
		locationEntity.setStreet_address1(locationData.getStreet_address1());
		locationEntity.setStreet_address2(locationData.getStreet_address2());
		locationEntity.setCity(locationData.getCity());
		locationEntity.setState(locationData.getState());
		locationEntity.setZipcode(locationData.getZipcode());
		locationEntity.setCountry(locationData.getCountry());
		highschoolEntity.getLocationList().add(locationEntity);
		locationRepo = new LocationRepo();
		HighSchoolLocationPojo combinedPojo = new HighSchoolLocationPojo(highschoolEntity, locationEntity);
		locationRepo.InsertHSLocationData(combinedPojo);
		return combinedPojo;
	}
	
	public LocationDataPojo getUserHSLocation(int id) {
		userEntity = new User();
		userRepo = new UserRepo();
		highschoolEntity = new Highschool();
		HSrepo = new HighSchoolRepo();
		int highschool_id = 0;
		int location_id = 0;
		userEntity = userRepo.getUserData(id);
		Collection<Highschool> highschoolList = new ArrayList<Highschool>();
		highschoolList = userEntity.getHighschoolList();
		for (Highschool obj : highschoolList) {
			highschool_id = obj.getId();
		}
		highschoolEntity = HSrepo.getHighschoolData(highschool_id);
		Collection<Locations> locationList = highschoolEntity.getLocationList();
		for (Locations obj : locationList) {
			     location_id = obj.getId();
			   }
		locationPojo = getLocationById(location_id);
		return locationPojo;
	}
	
	public Locations updateUserHSLocation(int id, LocationDataPojo locationData){
		userEntity = new User();
		userRepo = new UserRepo();
		highschoolEntity = new Highschool();
		HSrepo = new HighSchoolRepo();
		int highschool_id = 0;
		int location_id = 0;
		userEntity = userRepo.getUserData(id);
		Collection<Highschool> highschoolList = new ArrayList<Highschool>();
		highschoolList = userEntity.getHighschoolList();
		for (Highschool obj : highschoolList) {
			highschool_id = obj.getId();
		}
		highschoolEntity = HSrepo.getHighschoolData(highschool_id);
		Collection<Locations> locationList = highschoolEntity.getLocationList();
		for (Locations obj : locationList) {
			     location_id = obj.getId();
			   }
		locationData.setId(location_id);
		locationEntity = new Locations();
		locationRepo = new LocationRepo();
		locationEntity = locationRepo.getLocationData(location_id);
		locationEntity.setId(locationData.getId());
		if(locationData.getStreet_address1() == null){
			locationEntity.setStreet_address1(locationEntity.getStreet_address1());
		} else {
			locationEntity.setStreet_address1(locationData.getStreet_address1());
		}
		if(locationData.getStreet_address2() == null){
			locationEntity.setStreet_address2(locationEntity.getStreet_address2());
		} else {
			locationEntity.setStreet_address2(locationData.getStreet_address2());
		}
		if(locationData.getCity() == null){
			locationEntity.setCity(locationEntity.getCity());
		} else {
			locationEntity.setCity(locationData.getCity());
		}
		if(locationData.getState() == null){
			locationEntity.setState(locationEntity.getState());
		} else {
			locationEntity.setState(locationData.getState());
		}
		if(locationData.getZipcode() == null){
			locationEntity.setZipcode(locationEntity.getZipcode());
		} else {
			locationEntity.setZipcode(locationData.getZipcode());
		}
		if(locationData.getCountry() == null){
			locationEntity.setCountry(locationEntity.getCountry());
		} else {
			locationEntity.setCountry(locationData.getCountry());
		}
		locationRepo = new LocationRepo();
		locationRepo.updateLocationData(locationEntity);
		return locationEntity;
	} 
	
	public QualificationLocationPojo insertUserUniLocation(int id, LocationDataPojo locationData){	
		locationEntity = new Locations();
		qualEntity = new Qualification();
		qualrepo = new QualificationRepo();
		qualEntity = qualrepo.getQualificationData(id);
		locationEntity.setStreet_address1(locationData.getStreet_address1());
		locationEntity.setStreet_address2(locationData.getStreet_address2());
		locationEntity.setCity(locationData.getCity());
		locationEntity.setState(locationData.getState());
		locationEntity.setZipcode(locationData.getZipcode());
		locationEntity.setCountry(locationData.getCountry());
		qualEntity.getLocationList().add(locationEntity);
		locationRepo = new LocationRepo();
		QualificationLocationPojo combinedPojo = new QualificationLocationPojo(qualEntity, locationEntity);
		locationRepo.InsertUniLocationData(combinedPojo);
		return combinedPojo;
	}
	
	public LocationDataPojo getUniLocation(int id) {
		qualEntity = new Qualification();
		qualrepo = new QualificationRepo();
		int location_id = 0;
		qualEntity = qualrepo.getQualificationData(id);
		Collection<Locations> locationList = qualEntity.getLocationList();
		for (Locations obj : locationList) {
			     location_id = obj.getId();
			   }
		locationPojo = getLocationById(location_id);
		return locationPojo;
	}
	
	public Locations updateUniLocation(int id, LocationDataPojo locationData){
		qualEntity = new Qualification();
		qualrepo = new QualificationRepo();
		qualEntity = qualrepo.getQualificationData(id);
		int location_id = 0;
		Collection<Locations> locationList = qualEntity.getLocationList();
		for (Locations obj : locationList) {
			     location_id = obj.getId();
			   }
		locationData.setId(location_id);
		locationEntity = new Locations();
		locationRepo = new LocationRepo();
		locationEntity = locationRepo.getLocationData(location_id);
		locationEntity.setId(locationData.getId());
		if(locationData.getStreet_address1() == null){
			locationEntity.setStreet_address1(locationEntity.getStreet_address1());
		} else {
			locationEntity.setStreet_address1(locationData.getStreet_address1());
		}
		if(locationData.getStreet_address2() == null){
			locationEntity.setStreet_address2(locationEntity.getStreet_address2());
		} else {
			locationEntity.setStreet_address2(locationData.getStreet_address2());
		}
		if(locationData.getCity() == null){
			locationEntity.setCity(locationEntity.getCity());
		} else {
			locationEntity.setCity(locationData.getCity());
		}
		if(locationData.getState() == null){
			locationEntity.setState(locationEntity.getState());
		} else {
			locationEntity.setState(locationData.getState());
		}
		if(locationData.getZipcode() == null){
			locationEntity.setZipcode(locationEntity.getZipcode());
		} else {
			locationEntity.setZipcode(locationData.getZipcode());
		}
		if(locationData.getCountry() == null){
			locationEntity.setCountry(locationEntity.getCountry());
		} else {
			locationEntity.setCountry(locationData.getCountry());
		}
		locationRepo = new LocationRepo();
		locationRepo.updateLocationData(locationEntity);
		return locationEntity;
	}
	
	public LocationDataPojo insertUsrExpCompanyLocation(int id,LocationDataPojo locationData){	
		locationEntity = new Locations();
		userEntity = new User();
		userRepo = new UserRepo();
		expEntity = new Experiences();
		int experience_id = 0;
		userEntity = userRepo.getUserData(id);
		Collection<Experiences> expList = new ArrayList<Experiences>();
		expList = userEntity.getExperienceList();
		for (Experiences obj : expList) {
			experience_id = obj.getId();
		}
		exprepo = new ExperienceRepo();
		expEntity = exprepo.getExperienceData(experience_id);
		int comp_id = 0;
		Collection<Companies> compList = new ArrayList<Companies>();
		compList = expEntity.getCompanyList();
		for (Companies obj : compList) {
			comp_id = obj.getId();
		}
		exprepo = new ExperienceRepo();
		compEntity = exprepo.getCompanyData(comp_id);
		locationEntity.setStreet_address1(locationData.getStreet_address1());
		locationEntity.setStreet_address2(locationData.getStreet_address2());
		locationEntity.setCity(locationData.getCity());
		locationEntity.setState(locationData.getState());
		locationEntity.setZipcode(locationData.getZipcode());
		locationEntity.setCountry(locationData.getCountry());
		compEntity.getLocationList().add(locationEntity);
		locationRepo = new LocationRepo();
		locationRepo.InsertCompanyLocationData(compEntity,locationEntity);
		return locationData;
	}
	
	public ResponseIntegerList getCompanyLocation(int id) {
		compEntity = new Companies();
		exprepo = new ExperienceRepo();
		compEntity = exprepo.getCompanyData(id);
		Collection<Locations> locationList = new ArrayList<Locations>();
		List<Integer> idList = new ArrayList<Integer>();
		locationList = compEntity.getLocationList();
		int location_id = 0;
		for (Locations obj : locationList) {
			     location_id = obj.getId();
			     idList.add(location_id);
			   }
		ResponseIntegerList list = new ResponseIntegerList();
		list.setList(idList);
		return list;
	}
	
	public Locations updateLocation(LocationDataPojo locationData){
		locationEntity = new Locations();
		locationRepo = new LocationRepo();
		locationEntity = locationRepo.getLocationData(locationData.getId());
		locationEntity.setId(locationData.getId());
		if(locationData.getStreet_address1() == null){
			locationEntity.setStreet_address1(locationEntity.getStreet_address1());
		} else {
			locationEntity.setStreet_address1(locationData.getStreet_address1());
		}
		if(locationData.getStreet_address2() == null){
			locationEntity.setStreet_address2(locationEntity.getStreet_address2());
		} else {
			locationEntity.setStreet_address2(locationData.getStreet_address2());
		}
		if(locationData.getCity() == null){
			locationEntity.setCity(locationEntity.getCity());
		} else {
			locationEntity.setCity(locationData.getCity());
		}
		if(locationData.getState() == null){
			locationEntity.setState(locationEntity.getState());
		} else {
			locationEntity.setState(locationData.getState());
		}
		if(locationData.getZipcode() == null){
			locationEntity.setZipcode(locationEntity.getZipcode());
		} else {
			locationEntity.setZipcode(locationData.getZipcode());
		}
		if(locationData.getCountry() == null){
			locationEntity.setCountry(locationEntity.getCountry());
		} else {
			locationEntity.setCountry(locationData.getCountry());
		}
		locationRepo = new LocationRepo();
		locationRepo.updateLocationData(locationEntity);
		return locationEntity;
	}
}
