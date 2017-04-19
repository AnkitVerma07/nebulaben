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

import careers.nebula.ben.db.enitity.Jobs;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.information.JobPostingProfileInformation;
import careers.nebula.ben.information.UserInformation;
import careers.nebula.ben.pojo.iws.IndustryDataPojo;
import careers.nebula.ben.pojo.iws.JobsDataPojo;
import careers.nebula.ben.pojo.iws.KeywordsDataPojo;
import careers.nebula.ben.pojo.iws.LocationDataPojo;
import careers.nebula.ben.pojo.iws.UserDataPojo;

/**
 * @author Ankit_Nebula
 * restful services connection layer
 */
@Path("/jobProfileInfo")
public class JobPostingProfileIWS {

	private JobPostingProfileInformation jobInfo = new JobPostingProfileInformation();
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	@Path("/insertJob/{companyId}")
	public Response insertJobInformation (@PathParam("companyId") int id, JobsDataPojo jobdata){
		jobInfo = new JobPostingProfileInformation();
		Jobs jobEntity = jobInfo.InsertPrimaryJobInfo(id, jobdata);
		int jobId = jobEntity.getId();
		return Response.ok()
				.entity(jobId)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insertJobKeywords/{jobsId}")
	public Response insertJobKeywordInformation (@PathParam("jobsId") int id, KeywordsDataPojo keyworddata){
		jobInfo = new JobPostingProfileInformation();
		jobInfo.InsertPrimaryJobKeywordInfo(id, keyworddata);
		return Response.status(200).entity("Jobs Keywords Added Successful").build();	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insertJobIndustry/{jobsId}")
	public Response insertJobKeywordInformation (@PathParam("jobsId") int id, IndustryDataPojo industryData){
		jobInfo = new JobPostingProfileInformation();
		jobInfo.InsertPrimaryJobIndustryInfo(id, industryData);
		return Response.status(200).entity("Jobs Keywords Added Successful").build();	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insertJobLocation/{jobsId}")
	public Response insertJobKeywordInformation (@PathParam("jobsId") int id, LocationDataPojo locationData){
		jobInfo = new JobPostingProfileInformation();
		jobInfo.InsertPrimaryJobLocationInfo(id, locationData);
		return Response.status(200).entity("Jobs Keywords Added Successful").build();	
	}
	
//	@POST
//	@Consumes(MediaType.APPLICATION_JSON)
//	@Path("/insertJobUserApplied/{jobsId}")
//	public Response insertJobUserAppliedInformation (@PathParam("jobsId") int id, LocationDataPojo locationData){
//		jobInfo = new JobPostingProfileInformation();
//		jobInfo.InsertPrimaryJobUserAppliedInfo(id, locationData);
//		return Response.status(200).entity("Jobs Keywords Added Successful").build();	
//	}
	
	@GET
	@Path("/getJob/{jobsId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response locateJobById (@PathParam("jobsId") int id){
		jobInfo = new JobPostingProfileInformation();
		JobsDataPojo jobsData = jobInfo.getPrimaryJobInfo(id);
		return Response.ok()
				.entity(jobsData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateJobs")
	public Response updateUserInfo (JobsDataPojo jobsData){
		jobInfo = new JobPostingProfileInformation();
		jobInfo.UpdateJobsInformation(jobsData);
		return Response.status(200).entity("Jobs Updated Successful").build();	
	}
	
	
}
