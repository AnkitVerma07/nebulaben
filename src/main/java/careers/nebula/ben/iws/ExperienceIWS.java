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
import careers.nebula.ben.db.enitity.Companies;
import careers.nebula.ben.db.enitity.Experiences;
import careers.nebula.ben.information.ExperienceInformation;
import careers.nebula.ben.pojo.iws.CompaniesDataPojo;
import careers.nebula.ben.pojo.iws.ExperiencesDataPojo;
import careers.nebula.ben.pojos.ResponseIntegerList;

/**
 * @author Ankit_Nebula
 *
 */
@Path("/experienceInfo")
public class ExperienceIWS {

	private ExperienceInformation expInfo;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertUserExperience/{userId}")
	public Response UserExperienceInformation (@PathParam("userId") int id, ExperiencesDataPojo experienceDataPojo){
		expInfo = new ExperienceInformation();
		Experiences insertExperience = expInfo.insertUserExperience(id, experienceDataPojo);
		return Response.ok()
				.entity(insertExperience)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getExperienceById/{experienceId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupExperienceById(@PathParam("experienceId") int id){ 
		expInfo = new ExperienceInformation();
		ExperiencesDataPojo userExperience = expInfo.getExperienceById(id);
		return Response.ok()
				.entity(userExperience)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getUserExperience/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupExperience(@PathParam("userId") int id){ 
		expInfo = new ExperienceInformation();
		ResponseIntegerList experienceList = expInfo.getUserExperienceList(id);
		return Response.ok()
				.entity(experienceList)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateUserExperience")
	public Response updateUserExperienceInfo (ExperiencesDataPojo experienceDataPojo){
		expInfo = new ExperienceInformation();
		expInfo.updateExperienceById(experienceDataPojo);
		return Response.status(200).entity("User Experience by id:" + experienceDataPojo.getId()+" successfully updated").build();	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertUsrExpCompany/{userId}")
	public Response insertUsrExpCompanyInfo(@PathParam("userId") int id, CompaniesDataPojo companiesDataPojo){
		expInfo = new ExperienceInformation();
		Companies insertCompany = expInfo.insertUsrExpCompany(id, companiesDataPojo);
		return Response.ok()
				.entity(insertCompany)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getCompanyById/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupCompanyById(@PathParam("companyId") int id){ 
		expInfo = new ExperienceInformation();
		CompaniesDataPojo getcompany = expInfo.getCompanyById(id);
		return Response.ok()
				.entity(getcompany)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getCompByExp/{experienceId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupCompanyByExp(@PathParam("experienceId") int id){ 
		expInfo = new ExperienceInformation();
		CompaniesDataPojo getcompany = expInfo.getExperienceCompany(id);
		return Response.ok()
				.entity(getcompany)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateCompany")
	public Response updateUserCompanyInfo (CompaniesDataPojo companiesDataPojo){
		expInfo = new ExperienceInformation();
		expInfo.updateCompanyById(companiesDataPojo);
		return Response.status(200).entity("Experience Company Updated").build();	
	}
}
