/**
 * 
 */
package careers.nebula.ben.testing;

import java.util.Date;

import careers.nebula.ben.information.ExperienceInformation;
import careers.nebula.ben.pojo.iws.CompaniesDataPojo;
import careers.nebula.ben.pojo.iws.ExperiencesDataPojo;

/**
 * @author Ankit_Nebula
 *
 */
public class ExperienceTesting {

	/**
	 * @param args
	 */
	private static ExperienceInformation expinfo;
	private static ExperiencesDataPojo expdata;
	private static CompaniesDataPojo companydata;
	
//	public static void main(String[] args) {
//		//testInsertUserExperience(1);
//		//testUpdateUserExperience(2);
//		//testGetExperience(2);
//		//testInsertUserCompany(1);
//	}

	public static void testInsertUserExperience(int id){
		expdata = new ExperiencesDataPojo();
		expdata.setJob_title("Dopest Business Analyst");
		expdata.setJob_responsibilities("blah blah blah blah blah blah");
		expdata.setStart_date("10/10/1990");
		expdata.setEnd_date("10/10/2010");
		expinfo = new ExperienceInformation();
		expinfo.insertUserExperience(id, expdata);
	} 
	
	public static void testUpdateUserExperience(int id){
		expdata = new ExperiencesDataPojo();
		expdata.setId(id);
		expdata.setJob_title("Dopest Business Analyst");
		expdata.setJob_responsibilities("blah blah blah blah blah blah");
		expdata.setStart_date("10/10/1990");
		expdata.setEnd_date("10/10/2010");
		expinfo = new ExperienceInformation();
		expinfo.updateExperienceById(expdata);
	}
	
	public static void testGetExperience(int id){
		expinfo = new ExperienceInformation();
		System.out.println(expinfo.getExperienceById(id).getJob_title());
	}
	
	public static void testInsertUserCompany(int id){
		companydata = new CompaniesDataPojo();
		companydata.setCompany_name("Canon");
		expinfo = new ExperienceInformation();
		expinfo.insertUsrExpCompany(id, companydata);
	}
}
