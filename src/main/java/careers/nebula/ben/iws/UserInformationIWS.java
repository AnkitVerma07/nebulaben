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

import careers.nebula.ben.db.enitity.Analytics;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.information.UserInformation;
import careers.nebula.ben.pojo.iws.AnalyticsDataPojo;
import careers.nebula.ben.pojo.iws.UserDataPojo;
import careers.nebula.ben.pojos.ResponseIntegerList;
import careers.nebula.ben.pojos.TimelinePojo;

/**
 * @author Ankit_Nebula
 * restful services connection layer
 */
@Path("/userInfo")
public class UserInformationIWS {
	
	private UserInformation userInformation;

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertUser")
	public Response userInformationPojo (UserDataPojo userData){
		userInformation = new UserInformation();
		User insertUser = userInformation.InsertPrimaryUserInfo(userData);
		return Response.ok()
				.entity(insertUser)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getUser/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response locateUserById (@PathParam("userId") int id){
		userInformation = new UserInformation();
		UserDataPojo userById = userInformation.getPrimaryUserInfo(id);
		return Response.ok()
				.entity(userById)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/validateLogin/{email}/{password}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response validateLogin (@PathParam("email") String email, @PathParam("password") String password){
		userInformation = new UserInformation();
		User userById = userInformation.checkUserLogin(email, password);
		return Response.ok()
				.entity(userById)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getUserTimeline/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response buildUserTimeline (@PathParam("userId") int id){
		userInformation = new UserInformation();
		TimelinePojo userById = userInformation.getPrimaryUserTimelineInfo(id);
		return Response.ok()
				.entity(userById)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateUser")
	public Response updateUserInfo (UserDataPojo userData){
		userInformation = new UserInformation();
		userInformation.UpdateUserInformation(userData);
		return Response.status(200).entity("User Updated Successful").build();	
	}
	
	@GET
	@Path("/ifUserExists/{email}")
	@Produces(MediaType.TEXT_PLAIN)
	public Response LookUpUserIdByEmail (@PathParam("email") String email){
		userInformation = new UserInformation();
		Integer userId = userInformation.getUserIdByEmail(email);
		return Response.ok()
				.entity(userId)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertUserAnalytics/{userId}")
	public Response analyticsInformationPojo (@PathParam("userId") int id, AnalyticsDataPojo analyticsData){
		userInformation = new UserInformation();
		Analytics insertAnalytics = userInformation.InsertUserAnalytics(id, analyticsData);
		return Response.ok()
				.entity(insertAnalytics)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getAnalyticsById/{analyticsId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response locateAnalyticsById (@PathParam("analyticsId") int id){
		userInformation = new UserInformation();
		AnalyticsDataPojo userById = userInformation.getAnalyticsById(id);
		return Response.ok()
				.entity(userById)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getUserAnalyticsList/{userID}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response locateUserAnalyticsList(@PathParam("userID") int id){
		userInformation = new UserInformation();
		ResponseIntegerList analyticsList = userInformation.getUserAnalyticsList(id);
		return Response.ok()
				.entity(analyticsList)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateAnalytics")
	public Response updateAnalyticsInfo (AnalyticsDataPojo analyticsData){
		userInformation = new UserInformation();
		Analytics updateUser = userInformation.UpdateAnalyticsInformation(analyticsData);
		return Response.ok()
				.entity(updateUser)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();	
	}
	
}
