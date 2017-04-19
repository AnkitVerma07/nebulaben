/**
 * 
 */
package careers.nebula.ben.testing;

import careers.nebula.ben.information.SkillsInformation;
import careers.nebula.ben.pojo.iws.ExtracurricularDataPojo;
import careers.nebula.ben.pojo.iws.LanguagesDataPojo;

/**
 * @author Ankit_Nebula
 *
 */
public class SkillTesting {

	/**
	 * @param args
	 */
	private static ExtracurricularDataPojo extradata;
	private static SkillsInformation skillinfo;
	private static LanguagesDataPojo languagedata;
	
//	public static void main(String[] args) {
//		//testInsertExtracurricular(1);
//		//testUpdateExtracurricular(1);
//		//testInsertLanguage(1);
//	}

	public static void testInsertExtracurricular(int id){
		extradata = new ExtracurricularDataPojo();
		extradata.setName("key club");
		skillinfo = new SkillsInformation();
		skillinfo.insertExtracurricularInfo(id, extradata);	
	}
	
	public static void testUpdateExtracurricular(int id){
		extradata = new ExtracurricularDataPojo();
		extradata.setId(id);
		extradata.setName("UCI cricket team captain");
		skillinfo = new SkillsInformation();
		skillinfo.updateExtracurricularById(extradata);	
	}
	
	public static void testInsertLanguage(int id){
		languagedata = new LanguagesDataPojo();
		languagedata.setName("hindi");
		skillinfo = new SkillsInformation();
		skillinfo.insertLanguageInfo(id, languagedata);	
	}
}
