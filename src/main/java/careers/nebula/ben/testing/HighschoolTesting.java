/**
 * 
 */
package careers.nebula.ben.testing;

import careers.nebula.ben.information.HighSchoolInformation;
import careers.nebula.ben.information.LocationInformation;
import careers.nebula.ben.iws.HighSchoolIWS;
import careers.nebula.ben.iws.LocationInformationIWS;
import careers.nebula.ben.pojo.iws.HighschoolDataPojo;
import careers.nebula.ben.pojo.iws.LocationDataPojo;

/**
 * @author Ankit_Nebula
 *
 */
public class HighschoolTesting {
	
	private static HighSchoolInformation highschoolInfo;
	private static HighSchoolIWS highschooliws;
	private static HighschoolDataPojo highschoolPojo;
	
//	public static void main(String[] args) {
//		//testInsert(1);
//		//testGetById(3); 
//		//testUpdate(1);
//		//testGetUserHighschool(4);
//		//testUpdateUserHighschool(4);
//	}

	public static void testInsert(int id){
		highschoolPojo = new HighschoolDataPojo();
		highschoolPojo.setHighschool_name("colony high school");
		highschoolPojo.setGpa(3.9);
		highschoolPojo.setYear_graduated("00/12/2010");
		highschoolPojo.setYear_started("00/12/2015");
		highschoolInfo = new HighSchoolInformation();
		highschoolInfo.insertUserHighschool(id,highschoolPojo);
	}
	
	public static void testGetById(int id){
		highschoolInfo = new HighSchoolInformation();
		System.out.println(highschoolInfo.getHighschoolById(id).getHighschool_name());
	}
	
	public static void testGetUserHighschool(int id){
		highschoolInfo = new HighSchoolInformation();
		System.out.println(highschoolInfo.getUserHighschool(id).getHighschool_name()) ;
	}
	
	private static void testUpdateUserHighschool(int id) {
		highschoolPojo = new HighschoolDataPojo();
		highschoolPojo.setGpa(4.2);
		highschooliws = new HighSchoolIWS();
		highschooliws.updateUserHighschoolInfo(id, highschoolPojo);
		
	}
}
