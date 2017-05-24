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

import careers.nebula.ben.db.enitity.Assestment;
import careers.nebula.ben.db.enitity.AssestmentTaken;
import careers.nebula.ben.db.enitity.Survey;
import careers.nebula.ben.db.enitity.SurveyTaken;
import careers.nebula.ben.information.AssestmentInformation;
import careers.nebula.ben.information.SurveyInformation;
import careers.nebula.ben.pojo.iws.AssestmentDataPojo;
import careers.nebula.ben.pojo.iws.SurveyDataPojo;
import careers.nebula.ben.pojos.QuestionArrayDataPojo;
import careers.nebula.ben.pojos.SurveyTakenDataPojo;

/**
 * @author Ankit Verma
 *
 */
@Path("/assestmentInfo")
public class AssestmentIWS {

	private AssestmentInformation assestmentInformation;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertAssestment")
	public Response insertNewAssestment (AssestmentDataPojo assestData){
		assestmentInformation = new AssestmentInformation();
		Assestment assestment = assestmentInformation.addAssestment(assestData);
		return Response.ok()
				.entity(assestment)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getAssestment/{assestmentId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response fetchAssestmentById (@PathParam("assestmentId") int id){
		assestmentInformation = new AssestmentInformation();
		AssestmentDataPojo assestmentData = assestmentInformation.grabAssestmentById(id);
		return Response.ok()
				.entity(assestmentData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateAssestment")
	public Response updateAssestmentByObject (AssestmentDataPojo assestmentData){
		assestmentInformation = new AssestmentInformation();
		Assestment assestment = assestmentInformation.changeAssestment(assestmentData);
		return Response.ok()
				.entity(assestment)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertQuestions/{surveyId}")
	public Response insertSurveyQuestions (@PathParam("surveyId") int id, QuestionArrayDataPojo questionsArray){
		assestmentInformation = new AssestmentInformation();
		QuestionArrayDataPojo questionsAdded = assestmentInformation.addAssestmentQuestions(id, questionsArray);
		return Response.ok()
				.entity(questionsAdded)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{userId}/assestmentTaken/{assestmentId}")
	public Response insertSurveyQuestions (@PathParam("userId") int userId, @PathParam("assestmentId") int assestmentId, SurveyTakenDataPojo surveyTakenData){
		assestmentInformation = new AssestmentInformation();
		AssestmentTaken assestmentTaken = assestmentInformation.addAssestmentTaken(userId, assestmentId, surveyTakenData);
		return Response.ok()
				.entity(assestmentTaken)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}

		
	
	
}
