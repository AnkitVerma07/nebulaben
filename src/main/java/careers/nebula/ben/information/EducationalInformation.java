/**
 * 
 */
package careers.nebula.ben.information;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import careers.nebula.ben.db.enitity.Coaches;
import careers.nebula.ben.db.enitity.Courses;
import careers.nebula.ben.db.enitity.Highschool;
import careers.nebula.ben.db.enitity.Qualification;
import careers.nebula.ben.db.enitity.Students;
import careers.nebula.ben.db.enitity.TestResult;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.db.repository.EducationalRepo;
import careers.nebula.ben.db.repository.HighSchoolRepo;
import careers.nebula.ben.db.repository.QualificationRepo;
import careers.nebula.ben.db.repository.UserRepo;
import careers.nebula.ben.pojo.iws.CoachesDataPojo;
import careers.nebula.ben.pojo.iws.CoursesDataPojo;
import careers.nebula.ben.pojo.iws.StudentsDataPojo;
import careers.nebula.ben.pojo.iws.TestResultDataPojo;
import careers.nebula.ben.pojos.ResponseIntegerList;

/**
 * @author Ankit_Nebula
 *
 */
public class EducationalInformation {

	private UserRepo userRepo;
	private User userEntity;
	private Coaches coEntity;
	private CoachesDataPojo coachesDataPojo;
	private EducationalRepo edurepo;
	private StudentsDataPojo studentsDataPojo;
	private Students stuEntity;
	private Courses courseEntity;
	private CoursesDataPojo coursesDataPojo;
	private HighSchoolRepo hsrepo;
	private QualificationRepo qualrepo;
	private Highschool hsEntity;
	private Qualification qualEntity;
	private TestResult testEntity;
	private TestResultDataPojo testDataPojo;
	
	 public Coaches insertUserCoach(int id, CoachesDataPojo coachesDataPojo) {
		 	userEntity = new User();
			userRepo = new UserRepo();
			coEntity = new Coaches();
			userEntity = userRepo.getUserData(id);
			coEntity.setCoach_hourlyrate(coachesDataPojo.getCoach_hourlyrate());
			coEntity.setCoach_rating(coachesDataPojo.getCoach_rating());
			userEntity.setCoach(true);
			userEntity.getCoachList().add(coEntity);
			edurepo = new EducationalRepo();
			edurepo.InsertUserCoach(userEntity, coEntity);
			return coEntity;
	 }
	 
		public CoachesDataPojo getCoachById(int id) {
			edurepo = new EducationalRepo();
			coEntity = new Coaches();
			coachesDataPojo = new CoachesDataPojo();
			coEntity = edurepo.getCoachData(id);
			coachesDataPojo.setId(coEntity.getId());
			coachesDataPojo.setCoach_hourlyrate(coEntity.getCoach_hourlyrate());
			coachesDataPojo.setCoach_rating(coEntity.getCoach_rating());
			return coachesDataPojo;
		}

		public CoachesDataPojo getUserCoach(int id){
			coEntity = new Coaches();
			userRepo = new UserRepo();
			coachesDataPojo = new CoachesDataPojo();
			int coach_id = 0;
			userEntity = userRepo.getUserData(id);
			Collection<Coaches> coachList = new ArrayList<Coaches>();
			coachList = userEntity.getCoachList();
			for (Coaches obj : coachList) {
				coach_id = obj.getId();
				   }
			coachesDataPojo = getCoachById(coach_id);
			return coachesDataPojo;
		}
		
		public Coaches updateUserCoach(int id, CoachesDataPojo coachesDataPojo){
			coEntity = new Coaches();
			userRepo = new UserRepo();
			userEntity = new User();
			userEntity = userRepo.getUserData(id);
			int coach_id = 0;
			Collection<Coaches> coachList = new ArrayList<Coaches>();
			coachList = userEntity.getCoachList();
			for (Coaches obj : coachList) {
				coach_id = obj.getId();
				   }
			edurepo = new EducationalRepo();
			coEntity = edurepo.getCoachData(coachesDataPojo.getId());
			coEntity.setId(coach_id);
			if(coachesDataPojo.getCoach_hourlyrate() == null){
				coEntity.setCoach_hourlyrate(coEntity.getCoach_hourlyrate());
			} else {
				coEntity.setCoach_hourlyrate(coachesDataPojo.getCoach_hourlyrate());
			}
			if(coachesDataPojo.getCoach_rating() == null){
				coEntity.setCoach_rating(coEntity.getCoach_rating());
			} else {
				coEntity.setCoach_rating(coachesDataPojo.getCoach_rating());
			}
			edurepo = new EducationalRepo();
			coEntity = edurepo.updateCoachData(coEntity);
			return coEntity;
		}
		
		 public Students insertUserStudent(int id, StudentsDataPojo studentsDataPojo) {
			 	userEntity = new User();
				userRepo = new UserRepo();
				stuEntity = new Students();
				userEntity = userRepo.getUserData(id);
				stuEntity.setStudent_rating(studentsDataPojo.getStudent_rating());
				userEntity.setStudent(true);
				userEntity.getStudentsList().add(stuEntity);
				edurepo = new EducationalRepo();
				edurepo.InsertUserStudent(userEntity, stuEntity);
				return stuEntity;
		 }
		 
			public StudentsDataPojo getStudentById(int id) {
				edurepo = new EducationalRepo();
				stuEntity = new Students();
				studentsDataPojo = new StudentsDataPojo();
				stuEntity = edurepo.getStudentData(id);
				studentsDataPojo.setId(stuEntity.getId());
				studentsDataPojo.setStudent_rating(stuEntity.getStudent_rating());
				return studentsDataPojo;
			}
			
			public StudentsDataPojo getUserStudent(int id){
				stuEntity = new Students();
				userRepo = new UserRepo();
				studentsDataPojo = new StudentsDataPojo();
				int student_id = 0;
				userEntity = userRepo.getUserData(id);
				Collection<Students> studentList = new ArrayList<Students>();
				studentList = userEntity.getStudentsList();
				for (Students obj : studentList) {
					student_id = obj.getId();
					   }
				studentsDataPojo = getStudentById(student_id);
				return studentsDataPojo;
			}
			
			public Students updateUserStudent(int id, StudentsDataPojo studentsDataPojo){
				stuEntity = new Students();
				userRepo = new UserRepo();
				userEntity = new User();
				userEntity = userRepo.getUserData(id);
				int student_id = 0;
				Collection<Students> studentList = new ArrayList<Students>();
				studentList = userEntity.getStudentsList();
				for (Students obj : studentList) {
					student_id = obj.getId();
					   }
				stuEntity.setId(student_id);
				if(studentsDataPojo.getStudent_rating() == 0){
					stuEntity.setStudent_rating(stuEntity.getStudent_rating());
				} else {
					stuEntity.setStudent_rating(studentsDataPojo.getStudent_rating());
				}
				edurepo = new EducationalRepo();
				stuEntity = edurepo.updateStudentData(stuEntity);
				return stuEntity;
			}
			
			public CoursesDataPojo getCourseById(int id) {
				edurepo = new EducationalRepo();
				courseEntity = new Courses();
				coursesDataPojo = new CoursesDataPojo();
				courseEntity = edurepo.getCourseData(id);
				coursesDataPojo.setId(courseEntity.getId());
				coursesDataPojo.setCourse_name(courseEntity.getCourse_name());
				coursesDataPojo.setCourse_grade(courseEntity.getCourse_grade());
				coursesDataPojo.setCourse_rating(courseEntity.getCourse_rating());
				return coursesDataPojo;
			}
			
			public Courses updateCourserById(CoursesDataPojo coursesDataPojo){
				edurepo = new EducationalRepo();
				courseEntity = new Courses();
				courseEntity = edurepo.getCourseData(coursesDataPojo.getId());
				courseEntity.setId(coursesDataPojo.getId());
				if(coursesDataPojo.getCourse_name() == null){
					courseEntity.setCourse_name(courseEntity.getCourse_name());
				} else {
					courseEntity.setCourse_name(coursesDataPojo.getCourse_name());
				}
				if(coursesDataPojo.getCourse_grade() == null){
					courseEntity.setCourse_grade(courseEntity.getCourse_grade());
				} else {
					courseEntity.setCourse_grade(coursesDataPojo.getCourse_grade());
				}
				if(coursesDataPojo.getCourse_rating() == 0){
					courseEntity.setCourse_rating(courseEntity.getCourse_rating());
				} else {
					courseEntity.setCourse_rating(coursesDataPojo.getCourse_rating());
				}
				edurepo = new EducationalRepo();
				edurepo.updateCourseData(courseEntity);
				return courseEntity;
			}
			
			 public Courses insertUserHSCourses(int id, CoursesDataPojo coursesDataPojo) {
				 	userEntity = new User();
					userRepo = new UserRepo();
					courseEntity = new Courses();
					hsEntity = new Highschool();
					userEntity = userRepo.getUserData(id);
					int hs_id = 0;
					Collection<Highschool> hsList = new ArrayList<Highschool>();
					hsList = userEntity.getHighschoolList();
					for (Highschool obj : hsList) {
						hs_id = obj.getId();
						   }
					hsrepo = new HighSchoolRepo();
					hsEntity = hsrepo.getHighschoolData(hs_id);
					courseEntity.setCourse_name(coursesDataPojo.getCourse_name());
					courseEntity.setCourse_grade(coursesDataPojo.getCourse_grade());
					courseEntity.setCourse_rating(coursesDataPojo.getCourse_rating());
					hsEntity.getCoursesList().add(courseEntity);
					edurepo = new EducationalRepo();
					edurepo.InsertHSCourse(hsEntity, courseEntity);
					return courseEntity;
			 }
			 
			 public Courses insertUserUniCourses(int id, CoursesDataPojo coursesDataPojo) {
					courseEntity = new Courses();
					qualEntity = new Qualification();
					qualrepo = new QualificationRepo();
					qualEntity = qualrepo.getQualificationData(id);
					courseEntity.setCourse_name(coursesDataPojo.getCourse_name());
					courseEntity.setCourse_grade(coursesDataPojo.getCourse_grade());
					courseEntity.setCourse_rating(coursesDataPojo.getCourse_rating());
					qualEntity.getCoursesList().add(courseEntity);
					edurepo = new EducationalRepo();
					edurepo.InsertUniCourse(qualEntity, courseEntity);
					return courseEntity;
			 }
			 
			 public Courses insertUserCoachCourses(int id, CoursesDataPojo coursesDataPojo) {
				 	userEntity = new User();
					userRepo = new UserRepo();
					courseEntity = new Courses();
					coEntity = new Coaches();
					userEntity = userRepo.getUserData(id);
					int coach_id = 0;
					Collection<Coaches> coList = new ArrayList<Coaches>();
					coList = userEntity.getCoachList();
					for (Coaches obj : coList) {
						coach_id = obj.getId();
						   }
					edurepo = new EducationalRepo();
					coEntity = edurepo.getCoachData(coach_id);
					courseEntity.setCourse_name(coursesDataPojo.getCourse_name());
					courseEntity.setCourse_grade(coursesDataPojo.getCourse_grade());
					courseEntity.setCourse_rating(coursesDataPojo.getCourse_rating());
					coEntity.getCoursesList().add(courseEntity);
					edurepo = new EducationalRepo();
					edurepo.InserCoachCourse(coEntity, courseEntity);
					return courseEntity;
			 }
			 
			 public Courses insertUserStudentCourses(int id, CoursesDataPojo coursesDataPojo) {
				 	userEntity = new User();
					userRepo = new UserRepo();
					courseEntity = new Courses();
					stuEntity = new Students();
					userEntity = userRepo.getUserData(id);
					int stu_id = 0;
					Collection<Students> stuList = new ArrayList<Students>();
					stuList = userEntity.getStudentsList();
					for (Students obj : stuList) {
						stu_id = obj.getId();
						   }
					edurepo = new EducationalRepo();
					stuEntity = edurepo.getStudentData(stu_id);
					courseEntity.setCourse_name(coursesDataPojo.getCourse_name());
					courseEntity.setCourse_grade(coursesDataPojo.getCourse_grade());
					courseEntity.setCourse_rating(coursesDataPojo.getCourse_rating());
					stuEntity.getCoursesList().add(courseEntity);
					edurepo = new EducationalRepo();
					edurepo.InserStudentCourse(stuEntity, courseEntity);
					return courseEntity;
			 }
			 
				public ResponseIntegerList getHSCourseList(int id) {
					hsEntity = new Highschool();
					hsrepo = new HighSchoolRepo();
					int course_id = 0;
					hsEntity = hsrepo.getHighschoolData(id);
					Collection<Courses> courseList = new ArrayList<Courses>();
					List<Integer> idlist = new ArrayList<Integer>();
					courseList = hsEntity.getCoursesList();
					for (Courses obj : courseList) {
						course_id = obj.getId();
						idlist.add(course_id);
						   }
					ResponseIntegerList list = new ResponseIntegerList();
					list.setList(idlist);
					return list;
				}
				
				public ResponseIntegerList getUniCourseList(int id) {
					qualEntity = new Qualification();
					qualrepo = new QualificationRepo();
					int course_id = 0;
					qualEntity = qualrepo.getQualificationData(id);
					Collection<Courses> courseList = new ArrayList<Courses>();
					List<Integer> idlist = new ArrayList<Integer>();
					courseList = qualEntity.getCoursesList();
					for (Courses obj : courseList) {
						course_id = obj.getId();
						idlist.add(course_id);
						   }
					ResponseIntegerList list = new ResponseIntegerList();
					list.setList(idlist);
					return list;
				}
				
				public ResponseIntegerList getStudentCourseList(int id) {
					stuEntity = new Students();
					edurepo = new EducationalRepo();
					int course_id = 0;
					stuEntity = edurepo.getStudentData(id);
					Collection<Courses> courseList = new ArrayList<Courses>();
					List<Integer> idlist = new ArrayList<Integer>();
					courseList = stuEntity.getCoursesList();
					for (Courses obj : courseList) {
						course_id = obj.getId();
						idlist.add(course_id);
						   }
					ResponseIntegerList list = new ResponseIntegerList();
					list.setList(idlist);
					return list;
				}
				
				public ResponseIntegerList getCoachCourseList(int id) {
					coEntity = new Coaches();
					edurepo = new EducationalRepo();
					int course_id = 0;
					coEntity = edurepo.getCoachData(id);
					Collection<Courses> courseList = new ArrayList<Courses>();
					List<Integer> idlist = new ArrayList<Integer>();
					courseList = coEntity.getCoursesList();
					for (Courses obj : courseList) {
						course_id = obj.getId();
						idlist.add(course_id);
						   }
					ResponseIntegerList list = new ResponseIntegerList();
					list.setList(idlist);
					return list;
				}
				
				 public void insertCoachStudent(int coachId, int studentId) {
						coEntity = new Coaches();
						stuEntity = new Students();
						edurepo = new EducationalRepo();
						studentsDataPojo = new StudentsDataPojo();
						coachesDataPojo = new CoachesDataPojo();
						coachesDataPojo = getCoachById(coachId);
						coEntity.setCoach_hourlyrate(coachesDataPojo.getCoach_hourlyrate());
						coEntity.setCoach_rating(coachesDataPojo.getCoach_rating());
						studentsDataPojo = getStudentById(studentId);
						stuEntity.setStudent_rating(studentsDataPojo.getStudent_rating());
						coEntity.getStudentsList().add(stuEntity);
						edurepo = new EducationalRepo();
						edurepo.InsertCoachStudent(coEntity);
				 }
				 
				public ResponseIntegerList getCoachStudentsList(int id) {
						coEntity = new Coaches();
						edurepo = new EducationalRepo();
						int student_id = 0;
						coEntity = edurepo.getCoachData(id);
						Collection<Students> stuList = new ArrayList<Students>();
						List<Integer> idlist = new ArrayList<Integer>();
						stuList = coEntity.getStudentsList();
						for (Students obj : stuList) {
							student_id = obj.getId();
							idlist.add(student_id);
							   }
						ResponseIntegerList list = new ResponseIntegerList();
						list.setList(idlist);
						return list;
					}
					
				public TestResult insertUserTestResults(int id, TestResultDataPojo testDataPojo) {
						 	userEntity = new User();
							userRepo = new UserRepo();
							testEntity = new TestResult();
							userEntity = userRepo.getUserData(id);
							testEntity.setHighschool_SAT(testDataPojo.getHighschool_SAT());
							testEntity.setHighschool_ACT(testDataPojo.getHighschool_ACT());
							testEntity.setCollege_CLEP(testDataPojo.getCollege_CLEP());
							testEntity.setPostgrad_GMAT(testDataPojo.getPostgrad_GMAT());
							testEntity.setPostgrad_MCAT(testDataPojo.getPostgrad_MCAT());
							testEntity.setPostgrad_LSAT(testDataPojo.getPostgrad_LSAT());
							testEntity.setPostgrad_GRE(testDataPojo.getPostgrad_GRE());
							userEntity.getTestList().add(testEntity);
							edurepo = new EducationalRepo();
							edurepo.InsertUserTests(userEntity, testEntity);
							return testEntity;
					 }
			
				public TestResultDataPojo getTestResultById(int id) {
					edurepo = new EducationalRepo();
					testEntity = new TestResult();
					testDataPojo = new TestResultDataPojo();
					testEntity = edurepo.getTestResultData(id);
					testDataPojo.setId(testEntity.getId());
					testDataPojo.setHighschool_SAT(testEntity.getHighschool_SAT());
					testDataPojo.setHighschool_ACT(testEntity.getHighschool_ACT());
					testDataPojo.setCollege_CLEP(testEntity.getCollege_CLEP());
					testDataPojo.setPostgrad_GMAT(testEntity.getPostgrad_GMAT());
					testDataPojo.setPostgrad_GRE(testEntity.getPostgrad_GRE());
					testDataPojo.setPostgrad_LSAT(testEntity.getPostgrad_LSAT());
					testDataPojo.setPostgrad_MCAT(testEntity.getPostgrad_MCAT());
					return testDataPojo;
				}

				public ResponseIntegerList getUserTestResults(int id){
					testEntity = new TestResult();
					userRepo = new UserRepo();
					testDataPojo = new TestResultDataPojo();
					int coach_id = 0;
					userEntity = userRepo.getUserData(id);
					Collection<TestResult> testList = new ArrayList<TestResult>();
					List<Integer> idList = new ArrayList<Integer>();
					testList = userEntity.getTestList();
					for (TestResult obj : testList) {
						coach_id = obj.getId();
						idList.add(coach_id);
						   }
					ResponseIntegerList list = new ResponseIntegerList();
					list.setList(idList);
					return list;
				}
				
				public TestResult updateUserTestResult(TestResultDataPojo testDataPojo){
					edurepo = new EducationalRepo();
					testEntity = new TestResult();
					testEntity = edurepo.getTestResultData(testDataPojo.getId());
					testEntity.setId(testDataPojo.getId());
					if(testDataPojo.getHighschool_SAT() == null){
						testEntity.setHighschool_SAT(testEntity.getHighschool_SAT());
					} else {
						testEntity.setHighschool_SAT(testDataPojo.getHighschool_SAT());
					}
					if(testDataPojo.getHighschool_ACT() == null){
						testEntity.setHighschool_ACT(testEntity.getHighschool_ACT());
					} else {
						testEntity.setHighschool_ACT(testDataPojo.getHighschool_ACT());
					}
					if(testDataPojo.getCollege_CLEP() == null){
						testEntity.setCollege_CLEP(testEntity.getCollege_CLEP());
					} else {
						testEntity.setCollege_CLEP(testDataPojo.getCollege_CLEP());
					}
					if(testDataPojo.getPostgrad_GMAT() == null){
						testEntity.setPostgrad_GMAT(testEntity.getPostgrad_GMAT());
					} else {
						testEntity.setPostgrad_GMAT(testDataPojo.getPostgrad_GMAT());
					}
					if(testDataPojo.getPostgrad_GRE() == null){
						testEntity.setPostgrad_GRE(testEntity.getPostgrad_GRE());
					} else {
						testEntity.setPostgrad_GRE(testDataPojo.getPostgrad_GRE());
					}
					if(testDataPojo.getPostgrad_LSAT() == null){
						testEntity.setPostgrad_LSAT(testEntity.getPostgrad_LSAT());
					} else {
						testEntity.setPostgrad_LSAT(testDataPojo.getPostgrad_LSAT());
					}
					if(testDataPojo.getPostgrad_MCAT() == null){
						testEntity.setPostgrad_MCAT(testEntity.getPostgrad_MCAT());
					} else {
						testEntity.setPostgrad_MCAT(testDataPojo.getPostgrad_MCAT());
					}
					edurepo = new EducationalRepo();
					testEntity = edurepo.updateTestResultData(testEntity);
					return testEntity;
				}
					
}
