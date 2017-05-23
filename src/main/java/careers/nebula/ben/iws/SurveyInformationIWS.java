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

import careers.nebula.ben.db.enitity.Survey;
import careers.nebula.ben.db.enitity.SurveyTaken;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.information.SurveyInformation;
import careers.nebula.ben.information.UserInformation;
import careers.nebula.ben.pojo.iws.SurveyDataPojo;
import careers.nebula.ben.pojo.iws.UserDataPojo;
import careers.nebula.ben.pojos.QuestionArrayDataPojo;
import careers.nebula.ben.pojos.SurveyTakenDataPojo;

/**
 * @author Ankit Verma
 *
 */
@Path("/surveyInfo")
public class SurveyInformationIWS {
	
	private SurveyInformation surveyInformation;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertSurvey")
	public Response insertNewSurvey (SurveyDataPojo surveyData){
		surveyInformation = new SurveyInformation();
		Survey survey = surveyInformation.addSurvey(surveyData);
		return Response.ok()
				.entity(survey)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getSurvey/{surveyId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response fetchSurveyById (@PathParam("surveyId") int id){
		surveyInformation = new SurveyInformation();
		SurveyDataPojo surveyData = surveyInformation.grabSurveyById(id);
		return Response.ok()
				.entity(surveyData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateSurvey")
	public Response updateSurveyByObject (SurveyDataPojo surveyData){
		surveyInformation = new SurveyInformation();
		Survey survey = surveyInformation.changeSurvey(surveyData);
		return Response.ok()
				.entity(survey)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertQuestions/{surveyId}")
	public Response insertSurveyQuestions (@PathParam("surveyId") int id, QuestionArrayDataPojo questionsArray){
		surveyInformation = new SurveyInformation();
		QuestionArrayDataPojo questionsAdded = surveyInformation.addSurveyQuestions(id, questionsArray);
		return Response.ok()
				.entity(questionsAdded)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}

	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/{userId}/surveyTaken/{surveyId}")
	public Response insertSurveyQuestions (@PathParam("userId") int userId, @PathParam("surveyId") int surveyId, SurveyTakenDataPojo surveyTakenData){
		surveyInformation = new SurveyInformation();
		SurveyTaken surveyTaken = surveyInformation.addSurveyTaken(userId, surveyId, surveyTakenData);
		return Response.ok()
				.entity(surveyTaken)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}

	
	
	
	
}
