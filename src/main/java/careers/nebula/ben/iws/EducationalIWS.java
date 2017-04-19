/**
 * 
 */
package careers.nebula.ben.iws;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import careers.nebula.ben.db.enitity.Coaches;
import careers.nebula.ben.db.enitity.Courses;
import careers.nebula.ben.db.enitity.Students;
import careers.nebula.ben.db.enitity.TestResult;
import careers.nebula.ben.information.EducationalInformation;
import careers.nebula.ben.pojo.iws.CoachesDataPojo;
import careers.nebula.ben.pojo.iws.CoursesDataPojo;
import careers.nebula.ben.pojo.iws.StudentsDataPojo;
import careers.nebula.ben.pojo.iws.TestResultDataPojo;
import careers.nebula.ben.pojos.CoachStudentIdPojo;
import careers.nebula.ben.pojos.ResponseIntegerList;

/**
 * @author Ankit_Nebula
 *
 */
@Path("/educationalInfo")
public class EducationalIWS {
	
	private EducationalInformation eduInfo;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertUserCoach/{userId}")
	public Response UserCoachInformation (@PathParam("userId") int id, CoachesDataPojo coachesDataPojo){
		eduInfo = new EducationalInformation();
		Coaches insertCoach = eduInfo.insertUserCoach(id, coachesDataPojo);
		return Response.ok()
				.entity(insertCoach)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}

	@GET
	@Path("/getUserCoach/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupUserCoach(@PathParam("userId") int id){ 
		eduInfo = new EducationalInformation();
		CoachesDataPojo getCoach = eduInfo.getUserCoach(id);
		return Response.ok()
				.entity(getCoach)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateUserCoach/{userId}")
	public Response updateUserCoachInfo (@PathParam("userId") int id, CoachesDataPojo coachesDataPojo){
		eduInfo = new EducationalInformation();
		eduInfo.updateUserCoach(id, coachesDataPojo);
		return Response.status(200).entity("User Coach by id:" + id + " successfully updated").build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertUserStudent/{userId}")
	public Response UserStudentInformation (@PathParam("userId") int id, StudentsDataPojo studentsDataPojo){
		eduInfo = new EducationalInformation();
		Students insertStudent = eduInfo.insertUserStudent(id, studentsDataPojo);
		return Response.ok()
				.entity(insertStudent)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getUserStudent/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupUserStudent(@PathParam("userId") int id){ 
		eduInfo = new EducationalInformation();
		StudentsDataPojo getStudent = eduInfo.getUserStudent(id);
		return Response.ok()
				.entity(getStudent)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateUserStudent/{userId}")
	public Response updateUserStudentInfo (@PathParam("userId") int id, StudentsDataPojo studentsDataPojo){
		eduInfo = new EducationalInformation();
		Students updateUserStudent = eduInfo.updateUserStudent(id, studentsDataPojo);
		return Response.ok()
				.entity(updateUserStudent)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();	
	}
	
	@GET
	@Path("/getCourseById/{courseId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupCourseInfo(@PathParam("courseId") int id){ 
		eduInfo = new EducationalInformation();
		CoursesDataPojo getCourse = eduInfo.getCourseById(id);
		return Response.ok()
				.entity(getCourse)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateCourseById")
	public Response updateCourseInfo (CoursesDataPojo coursesDataPojo){
		eduInfo = new EducationalInformation();
		eduInfo.updateCourserById(coursesDataPojo);
		return Response.status(200).entity("File successfully Loaded").build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertUserHSCourse/{userId}")
	public Response UserHSCoursesInfo (@PathParam("userId") int id, CoursesDataPojo coursesDataPojo){
		eduInfo = new EducationalInformation();
		Courses insertHSCourse = eduInfo.insertUserHSCourses(id, coursesDataPojo);
		return Response.ok()
				.entity(insertHSCourse)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertUserUniCourse/{qualId}")
	public Response UserUniCoursesInfo (@PathParam("qualId") int id, CoursesDataPojo coursesDataPojo){
		eduInfo = new EducationalInformation();
		Courses insertUniCourse = eduInfo.insertUserUniCourses(id, coursesDataPojo);
		return Response.ok()
				.entity(insertUniCourse)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertCoachTeaches/{userId}")
	public Response UserCoachCoursesInfo (@PathParam("userId") int id, CoursesDataPojo coursesDataPojo){
		eduInfo = new EducationalInformation();
		Courses insertCoachCourse = eduInfo.insertUserCoachCourses(id, coursesDataPojo);
		return Response.ok()
				.entity(insertCoachCourse)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertStudentCourse/{userId}")
	public Response UserStudentCoursesInfo (@PathParam("userId") int id, CoursesDataPojo coursesDataPojo){
		eduInfo = new EducationalInformation();
		Courses insertStudentCourse = eduInfo.insertUserStudentCourses(id, coursesDataPojo);
		return Response.ok()
				.entity(insertStudentCourse)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getHSCourse/{highschoolId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupHSCourseInfo(@PathParam("highschoolId") int id){ 
		eduInfo = new EducationalInformation();
		ResponseIntegerList courseList = eduInfo.getHSCourseList(id);
		return Response.ok()
				.entity(courseList)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getUniCourse/{universityId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupUniCourseInfo(@PathParam("universityId") int id){ 
		eduInfo = new EducationalInformation();
		ResponseIntegerList courseList = eduInfo.getUniCourseList(id);
		return Response.ok()
				.entity(courseList)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getStudentCourse/{studentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupStudentCourseInfo(@PathParam("studentId") int id){ 
		eduInfo = new EducationalInformation();
		ResponseIntegerList courseList = eduInfo.getStudentCourseList(id);
		return Response.ok()
				.entity(courseList)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getCoachCourse/{coachId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupCoachCourseInfo(@PathParam("coachId") int id){ 
		eduInfo = new EducationalInformation();
		ResponseIntegerList courseList = eduInfo.getCoachCourseList(id);
		return Response.ok()
				.entity(courseList)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insertCoachStudent")
	public Response CoachStudentInfo (CoachStudentIdPojo coachStudentIdPojo){
		eduInfo = new EducationalInformation();
		int coachId = coachStudentIdPojo.getCoachId();
		int studentId = coachStudentIdPojo.getStudentId();
		eduInfo.insertCoachStudent(coachId, studentId);
		return Response.status(200).entity("Student Added to a Coach").build();
	}
	
	@GET
	@Path("/getCoachStudents/{coachId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupCoachStudentInfo(@PathParam("coachId") int id){ 
		eduInfo = new EducationalInformation();
		ResponseIntegerList studentList = eduInfo.getCoachStudentsList(id);
		return Response.ok()
				.entity(studentList)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertUserTests/{userId}")
	public Response UserTestResultInformation (@PathParam("userId") int id, TestResultDataPojo testDataPojo){
		eduInfo = new EducationalInformation();
		TestResult insertCoach = eduInfo.insertUserTestResults(id, testDataPojo);
		return Response.ok()
				.entity(insertCoach)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getUserTestList/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupUserTestResults(@PathParam("userId") int id){ 
		eduInfo = new EducationalInformation();
		ResponseIntegerList getCoach = eduInfo.getUserTestResults(id);
		return Response.ok()
				.entity(getCoach)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getTestResultById/{testId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupTestResultById(@PathParam("testId") int id){ 
		eduInfo = new EducationalInformation();
		TestResultDataPojo getCoach = eduInfo.getTestResultById(id);
		return Response.ok()
				.entity(getCoach)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateUserTestResult")
	public Response updateUserTestResultInfo (TestResultDataPojo testDataPojo){
		eduInfo = new EducationalInformation();
		eduInfo.updateUserTestResult(testDataPojo);
		return Response.status(200).entity("User Test Result by id:" + testDataPojo.getId() + " successfully updated").build();
	}
}
