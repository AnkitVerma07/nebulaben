/**
 * 
 */
package careers.nebula.ben.testing;

import careers.nebula.ben.information.EducationalInformation;
import careers.nebula.ben.pojo.iws.CoachesDataPojo;

/**
 * @author Ankit_Nebula
 *
 */
public class EducationalTesting {

	/**
	 * @param args
	 */
	
	private static EducationalInformation eduinfo;
	private static CoachesDataPojo coachesDataPojo;
	
	public static void main(String[] args) {
		//insertCoach(2);
		//insertCoachStudent();
		//getStudentData(1);
	}

	public static void insertCoach(int id){
		eduinfo = new EducationalInformation();
		coachesDataPojo = new CoachesDataPojo();
		coachesDataPojo.setCoach_hourlyrate(50.0);
		coachesDataPojo.setCoach_rating(4.0);
		eduinfo.insertUserCoach(id, coachesDataPojo);
	}
	
	public static void insertCoachStudent(){
		eduinfo = new EducationalInformation();
		eduinfo.insertCoachStudent(2, 1);
	}
	
	public static void getStudentData(int id){
		eduinfo = new EducationalInformation();
		System.out.println(eduinfo.getStudentById(id).getStudent_rating());
	}
}
