/**
 * 
 */
package careers.nebula.ben.testing;

import careers.nebula.ben.information.UserInformation;
import careers.nebula.ben.iws.UserInformationIWS;
import careers.nebula.ben.pojo.iws.UserDataPojo;
import careers.nebula.ben.pojos.ResponseIntegerList;
import careers.nebula.ben.service.HelperMethods;

/**
 * @author Ankit_Nebula
 *
 */
public class UserTesting {
	
	private static UserInformationIWS userInformationIws;
	private static UserDataPojo userEntity;
	private static UserInformation userInfo;
	private static HelperMethods helpers;

	public static void main(String[] args) {
	//testInsert();
	testGet(1);
		//testUpdate(2);
		//testGetUserIdByEmail("aakriti@usc.edu");
		//testGetUserAnalyticsList(1);
		//testHelperMethodsTimeSpendCalculator("01/01/2015","07/01/2016");
	}
	
	public static void testInsert(){
		userEntity = new UserDataPojo();
		userEntity.setFirstName("ankit");
		userEntity.setLastName("verma");
		userEntity.setPreferredName("ankibunkers");
		userEntity.setPhoneNumber("9097172039");
		userEntity.setEmail("ankitv@uci.edu");
		userEntity.setCurrentlyInSchool(false);
		userEntity.setCurrentlyEmployeed(true);
		userEntity.setGoals("become app developer");
		userEntity.setAboutMe("super duper cool");
		userEntity.setPhotoUrl("www.photo.url.com");
		userEntity.setVideoUrl("www.video.url.com");
		userEntity.setUser_rating(5.0);
		userEntity.setCoach(true);
		userEntity.setStudent(false);
		userEntity.setGender("male");
		userEntity.setHighestQualification("BS");
		userEntity.setActive(true);
		userEntity.setDob("10/21/1992");
		userEntity.setAboutMe("ki ke sakde ae, guru da das ae");
		userInformationIws = new UserInformationIWS();
		userInformationIws.userInformationPojo(userEntity);
		
	}
	
	public static void testGet(int id){
		userInfo = new UserInformation();
		System.out.println(userInfo.getPrimaryUserInfo(id).getFirstName());	
	}
	
	public static void testUpdate(int id){
		userEntity = new UserDataPojo();
		userEntity.setHighestQualification("BS");
		userEntity.setActive(true);
		userInformationIws = new UserInformationIWS();
		userInformationIws.updateUserInfo(userEntity);
	}
	
	public static void testGetUserIdByEmail(String email){
		userInfo = new UserInformation();
		System.out.println(userInfo.getUserIdByEmail(email));
	}
	
	public static void testGetUserAnalyticsList(int id){
		userInfo = new UserInformation();
		ResponseIntegerList list = new ResponseIntegerList();
		list=userInfo.getUserAnalyticsList(id);
		for(Integer i : list.getList()){
			System.out.println(i);
		}
		}
	
	public static void testHelperMethodsTimeSpendCalculator(String start, String end){
		helpers = new HelperMethods();
		System.out.println(helpers.timeSpentCalculator(start, end));		
	}
}
