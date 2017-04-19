/**
 * 
 */
package careers.nebula.ben.iws;

import java.util.ArrayList;
import java.util.Collection;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import careers.nebula.ben.db.enitity.Highschool;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.db.repository.UserRepo;
import careers.nebula.ben.information.HighSchoolInformation;
import careers.nebula.ben.pojo.iws.HighschoolDataPojo;

/**
 * @author Ankit_Nebula
 *
 */
@Path("/highschoolInfo")
public class HighSchoolIWS {

	private HighSchoolInformation highschoolInfo;
	private UserRepo userRepo;
	private User userEntity;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertUserHighschool/{userId}")
	public Response UserHighSchoolInformation (@PathParam("userId") int id, HighschoolDataPojo highschoolDataPojo){
		highschoolInfo = new HighSchoolInformation();
		highschoolInfo.insertUserHighschool(id, highschoolDataPojo);
		return Response.status(200).entity("User High School Added").build();
	}
	
	@GET
	@Path("/getUserHighschool/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupUserHighschool (@PathParam("userId") int id){ 
		highschoolInfo = new HighSchoolInformation();
		HighschoolDataPojo userHighschool = highschoolInfo.getUserHighschool(id);
		return Response.ok()
				.entity(userHighschool)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateUserHighschool/{userId}")
	public Response updateUserHighschoolInfo (@PathParam("userId") int id,HighschoolDataPojo highschoolDataPojo){
		highschoolInfo = new HighSchoolInformation();
		userRepo = new UserRepo();
		userEntity = new User();
		int highschool_id = 0;
		userEntity = userRepo.getUserData(id);
		Collection<Highschool> highschoolList = new ArrayList<Highschool>();
		highschoolList = userEntity.getHighschoolList();
		for (Highschool obj : highschoolList) {
			highschool_id = obj.getId();
			   }
		highschoolDataPojo.setId(highschool_id);
		highschoolInfo.updateUserHighschool(highschoolDataPojo);
		return Response.status(200).entity("High School by id:" + highschoolDataPojo.getId() + " of user id:" + id + " successfully updated").build();	
	}
}
