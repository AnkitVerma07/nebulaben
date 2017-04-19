/**
 * 
 */
package careers.nebula.ben.testing;

import careers.nebula.ben.information.QualificationsInformation;
import careers.nebula.ben.iws.QualificationIWS;
import careers.nebula.ben.pojo.iws.MajorsDataPojo;
import careers.nebula.ben.pojo.iws.MinorsDataPojo;
import careers.nebula.ben.pojo.iws.QualificationDataPojo;
import careers.nebula.ben.pojo.iws.TransferDataPojo;

/**
 * @author Ankit_Nebula
 *
 */
public class QualificationTesting {
	private static QualificationsInformation qualInfo;
	private static QualificationIWS qualiws;
	private static QualificationDataPojo qualData;
	private static MajorsDataPojo majordata;
	private static MinorsDataPojo minordata;
	private static TransferDataPojo transferdata;
	
	public static void main(String[] args) {
		//testInsert(3);
		//testGetById(1); 
		//testUpdate(1);
		//testGetUserUni(1);
		//testUpdateUserUniversity(4);
		//testInsertMajor(3);
		//testInsertUserMinor(1);
		//testGetUserMajor(1);
		//testUpdateUserUniMajor(1);
		//testUpdateUserUniMinor(1);
		//testInsertTransferUser(1);
		//testUpdateTransferUser(1);
		//testGetUniByMajor(5);
		//testGetUserByUni(5);
	}

	public static void testInsert(int id){
		qualData = new QualificationDataPojo();
		qualData.setQualification_earned("AS");
		qualData.setYear_started("00/00/2009");
		qualData.setYear_gradauted("00/00/2009");
		qualData.setGpa(3.7);
		qualInfo = new QualificationsInformation();
		qualInfo.insertUserUniversity(id,qualData);
	}
	
	public static void testGetById(int id){
		qualInfo = new QualificationsInformation();
		System.out.println(qualInfo.getUniversityById(id).getMajorList());
	}
	
//	public static void testGetUserUni(int id){
//		qualInfo = new QualificationsInformation();
//		List<Integer> qualData = new ArrayList<Integer>();
//		 qualData = qualInfo.getUserUniversity(id);
//		for(int uni : qualData){
//			System.out.println(uni);
//		}
//	}
	
//	private static void testUpdateUserUni(int id) {
//		qualData = new UniversityDataPojo();
//		qualData.setGpa(4.2);
//		qualiws = new QualificationIWS();
//		qualiws.updateUserUniversityInfo(id, qualData);
//	}
	
	private static void testInsertMajor(int id){
		majordata = new MajorsDataPojo();
		majordata.setName("Management");
		qualiws = new QualificationIWS();
		qualiws.QualificationMajorPojo(id, majordata);
	}
	
	private static void testInsertUserMinor(int id){
		minordata = new MinorsDataPojo();
		minordata.setName("pysch");
		qualiws = new QualificationIWS();
		qualiws.QualificationMinorPojo(id, minordata);
	}
	
	public static void testGetUserMajor(int id){
		qualInfo = new QualificationsInformation();
		System.out.println(qualInfo.getUserUniversity(id));
	}
	
//	public static void testUpdateUserUniMajor(int id){
//		majordata = new MajorsDataPojo();
//		majordata.setName("physics");
//		qualiws = new QualificationIWS();
//		qualiws.updateUserMajorInfo(id, majordata);
//	}
	
//	public static void testUpdateUserUniMinor(int id){
//		minordata = new MinorsDataPojo();
//		minordata.setName("computer science");
//		qualiws = new QualificationIWS();
//		qualiws.updateUserMinorInfo(id, minordata);
//	}
	
	public static void testInsertTransferUser(int id){
		transferdata = new TransferDataPojo();
		transferdata.setYear_started(2009);
		transferdata.setYear_transfered(2010);
		transferdata.setQualifications_earned("Associate of designing");
		qualiws = new QualificationIWS();
		qualiws.UniTransferInfo(id, transferdata);
	}

//	public static void testUpdateTransferUser(int id){
//		transferdata = new TransferDataPojo();
//		transferdata.setYear_started(2009);
//		transferdata.setYear_transfered(2010);
//		transferdata.setQualifications_earned("Associate of finance");
//		transferdata.setCollege_transfered_from("chaffey community college");
//		qualiws = new QualificationIWS();
//		qualiws.updateTransferUser(id, transferdata);
//	}

	public static void testGetUniByMajor(int id){
		qualInfo = new QualificationsInformation();
		qualInfo.getUniByMajorId(id);
	}
	
	public static void testGetUserByUni(int id){
		qualInfo = new QualificationsInformation();
		qualInfo.getUserByQualId(id);
	}
}
