/**
 * 
 */
package careers.nebula.ben.testing;

import careers.nebula.ben.db.repository.LocationRepo;
import careers.nebula.ben.information.LocationInformation;
import careers.nebula.ben.iws.LocationInformationIWS;
import careers.nebula.ben.pojo.iws.LocationDataPojo;
import careers.nebula.ben.pojos.UserLocationPojo;

/**
 * @author Ankit_Nebula
 *
 */
public class LocationTesting {

	private static LocationInformation locationInformation;
	private static LocationDataPojo locationPojo;
	private static LocationRepo locationRepo;
	private static UserLocationPojo pojo;
	private static LocationInformationIWS locationInformationiws;

	public static void main(String[] args) {
		//testInsertUserLocation(1);
		//testGetById(3); 
		//testUpdate(1);
		//testGetUserLocation(4);
		//testUpdateUserLocation(1);
		//testInsertUserHSLocation(1);
		//testUpdateUserHSLocation(1);
		//testInsertUserUniLocation(1);
		//testUpdateUserUniLocation(1);
		//testInsertCompanyLocation(1);
	}

	public static void testInsertUserLocation(int id){
		locationPojo = new LocationDataPojo();
		locationPojo.setCity("downtown la");
		locationPojo.setState("california");
		locationPojo.setZipcode("90012");
		locationInformation = new LocationInformation();
		locationInformation.insertUserLocation(id,locationPojo);
	}
	
	public static void testGetById(int id){
		locationInformation = new LocationInformation();
		System.out.println(locationInformation.getLocationById(id).getCity());
	}
	
	public static void testGetUserLocation(int id){
		locationInformation = new LocationInformation();
		System.out.println(locationInformation.getUserLocation(id).getCity()) ;
	}
	
	private static void testUpdateUserLocation(int id) {
		locationPojo = new LocationDataPojo();
		locationPojo.setStreet_address1("124 downtown ave");
		locationPojo.setCity("la");
		locationInformationiws = new LocationInformationIWS();
		locationInformationiws.updateUserLocationInfo(id, locationPojo);	
	}
	
	private static void testInsertUserHSLocation(int id){
		locationPojo = new LocationDataPojo();
		locationPojo.setStreet_address1("124 downtown ave");
		locationPojo.setCity("la");
		locationInformationiws = new LocationInformationIWS();
		locationInformationiws.HighschoolLocationInformation(id, locationPojo);
	}
	
	private static void testUpdateUserHSLocation(int id) {
		locationPojo = new LocationDataPojo();
		locationPojo.setStreet_address1("wow downtown ave");
		locationPojo.setState("CA");
		locationInformationiws = new LocationInformationIWS();
		locationInformationiws.updateUserHSLocationInfo(id, locationPojo);	
	}
	
	private static void testInsertUserUniLocation(int id){
		locationPojo = new LocationDataPojo();
		locationPojo.setStreet_address1("124 downtown ave");
		locationPojo.setCity("la");
		locationInformationiws = new LocationInformationIWS();
		locationInformationiws.UniversityLocationInformation(id, locationPojo);
	}
	
	private static void testUpdateUserUniLocation(int id) {
		locationPojo = new LocationDataPojo();
		locationPojo.setStreet_address1("this is right downtown ave");
		locationPojo.setState("CA");
		locationInformationiws = new LocationInformationIWS();
		locationInformationiws.updateUserUniLocationInfo(id, locationPojo);	
	}
	
	public static void testInsertCompanyLocation(int id){
		locationPojo = new LocationDataPojo();
		locationPojo.setStreet_address1("this is right downtown ave");
		locationPojo.setState("CA");
		locationInformationiws = new LocationInformationIWS();
		locationInformationiws.companyLocationInformation(id, locationPojo);	
	}
}
