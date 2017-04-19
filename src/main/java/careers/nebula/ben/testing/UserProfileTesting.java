/**
 * 
 */
package careers.nebula.ben.testing;

import java.util.ArrayList;
import java.util.List;

import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.db.repository.UserProfileRepo;
import careers.nebula.ben.information.ComparePeer2PeerInformation;
import careers.nebula.ben.information.CourseSuggestionInformation;
import careers.nebula.ben.iws.UserProfileIWS;
import careers.nebula.ben.pojos.ResponseCombinedList;
import careers.nebula.ben.service.ComparePeersServicing;
import careers.nebula.ben.service.CourseSuggestionServicing;

/**
 * @author Ankit_Nebula
 *
 */
public class UserProfileTesting {

	/**
	 * @param args
	 */
	private static ComparePeersServicing comparepeerservicing;
	private static ComparePeer2PeerInformation userproinfo;
	private static UserProfileRepo userpro;
	private static CourseSuggestionServicing coursesuggest;
	private static UserProfileIWS userproiws;
	private static CourseSuggestionInformation courseSuggestion;
	
	public static void main(String[] args) {
		//testGetCourseSuggesstion(2);
		//testUserMajors(1);
		//testUserQualificationExtraSkills(1);
		//testgetUserQualificationExtraComparison(1);
		//testSameMajorsinUserProfileRepo(1);
		//testGoalsJobTitleMatching(1);
		//testgoalsJobTitleCourses();
		testmatchedUserUniCoursesByJobTitle(4);
	}

	private static void testmatchedUserUniCoursesByJobTitle(int i) {
		coursesuggest = new CourseSuggestionServicing();
		List<String> list = new ArrayList<String>();
		list = coursesuggest.matchedUserUniCoursesByJobTitle(i);
		for(String s : list){
			System.out.println("s:" + s);
		}
	}

	private static void testgoalsJobTitleCourses() {
		courseSuggestion = new CourseSuggestionInformation();
		User userEntity = new User();
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
		courseSuggestion.goalsJobTitleCourses(userEntity);
		
	}

	private static void testGetCourseSuggesstion(int i) {
		ResponseCombinedList list = new ResponseCombinedList();
		userproiws = new UserProfileIWS();
		userproiws.getCourseSuggestions(i);
	}

	public static void testUserMajors(int id){
		comparepeerservicing = new ComparePeersServicing();
		comparepeerservicing.userWithsameMajors(id);
	}
	
	public static void testUserQualificationExtraSkills(int id){
		comparepeerservicing = new ComparePeersServicing();
		comparepeerservicing.qualificationMajorUserExtracurricular(id);
	}
	
	public static void testgetUserQualificationExtraComparison(int id){
		userproinfo = new ComparePeer2PeerInformation();
		userproinfo.getUserQualificationMajorExtraComparison(id);
	}
	
	public static void testSameMajorsinUserProfileRepo(int id){
		userpro = new UserProfileRepo();
		userpro.getAllCompanyData();
	}
	
	public static void testGoalsJobTitleMatching(int id){
		coursesuggest = new CourseSuggestionServicing();
		coursesuggest.userGoalsJobTitleMatching(id);
	}
}
