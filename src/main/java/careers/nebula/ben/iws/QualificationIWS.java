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

import careers.nebula.ben.db.enitity.Colleges;
import careers.nebula.ben.db.enitity.Majors;
import careers.nebula.ben.db.enitity.Minors;
import careers.nebula.ben.db.enitity.Qualification;
import careers.nebula.ben.db.enitity.Transfer;
import careers.nebula.ben.db.enitity.Universities;
import careers.nebula.ben.information.QualificationsInformation;
import careers.nebula.ben.pojo.iws.CollegesDataPojo;
import careers.nebula.ben.pojo.iws.MajorsDataPojo;
import careers.nebula.ben.pojo.iws.MinorsDataPojo;
import careers.nebula.ben.pojo.iws.QualificationDataPojo;
import careers.nebula.ben.pojo.iws.TransferDataPojo;
import careers.nebula.ben.pojo.iws.UniversitiesDataPojo;
import careers.nebula.ben.pojos.ResponseIntegerList;

/**
 * @author Ankit_Nebula
 *
 */
@Path("/qualificationInfo")
public class QualificationIWS {

	private QualificationsInformation qualInfo;
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insertUserUniversity/{userId}")
	public Response UserUniversityInformation (@PathParam("userId") int id, QualificationDataPojo universityDataPojo){
		qualInfo = new QualificationsInformation();
		qualInfo.insertUserUniversity(id, universityDataPojo);
		return Response.status(200).entity("User University Added").build();
	}
	
	@GET
	@Path("/getUserUniversity/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupUserUniversity (@PathParam("userId") int id){ 
		qualInfo = new QualificationsInformation();
		ResponseIntegerList userUniversity = qualInfo.getUserUniversity(id);
		return Response.ok()
				.entity(userUniversity)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getUniversityById/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUniversityData (@PathParam("userId") int id){ 
		qualInfo = new QualificationsInformation();
		QualificationDataPojo universityData = qualInfo.getUniversityById(id);
		return Response.ok()
				.entity(universityData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateUniversity")
	public Response updateUniversityInfo (QualificationDataPojo uniDataPojo){
		qualInfo = new QualificationsInformation();
		qualInfo.updateUniversityById(uniDataPojo);
		return Response.status(200).entity("Qualification of id:"+ uniDataPojo.getId() + " has been updated").build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insertUniName/{qualId}")
	public Response QualificationUniNamePojo (@PathParam("qualId") int id, UniversitiesDataPojo uniDataPojo){
		qualInfo = new QualificationsInformation();
		qualInfo.insertUniName(id, uniDataPojo);
		return Response.status(200).entity("University Name Added").build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insertCollegeName/{qualId}")
	public Response QualificationCollegeNamePojo (@PathParam("qualId") int id, CollegesDataPojo collegeDataPojo){
		qualInfo = new QualificationsInformation();
		qualInfo.insertCollegeName(id, collegeDataPojo);
		return Response.status(200).entity("University College name Added").build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insertMajor/{uniId}")
	public Response QualificationMajorPojo (@PathParam("uniId") int id, MajorsDataPojo majorDataPojo){
		qualInfo = new QualificationsInformation();
		qualInfo.insertUniMajor(id, majorDataPojo);
		return Response.status(200).entity("University Major Added").build();
	}
	
	@GET
	@Path("/getUniName/{qualId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupQualificationUniName(@PathParam("qualId") int id){ 
		qualInfo = new QualificationsInformation();
		UniversitiesDataPojo uniData = qualInfo.getQualUniName(id);
		return Response.ok()
				.entity(uniData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getCollegeName/{qualId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupQualificationCollegeName(@PathParam("qualId") int id){ 
		qualInfo = new QualificationsInformation();
		CollegesDataPojo collegeData = qualInfo.getQualCollegeName(id);
		return Response.ok()
				.entity(collegeData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateUniById")
	public Response updateUniNameInfo (UniversitiesDataPojo uniDataPojo){
		qualInfo = new QualificationsInformation();
		qualInfo.updateUniNameById(uniDataPojo);
		return Response.status(200).entity("University Name By Id:" + uniDataPojo.getId() + " successfully updated").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateCollegeById")
	public Response updateCollegeInfo (CollegesDataPojo collegeDataPojo){
		qualInfo = new QualificationsInformation();
		qualInfo.updateCollegeNameById(collegeDataPojo);
		return Response.status(200).entity("University College Department Name By Id:" + collegeDataPojo.getId() + " successfully updated").build();	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insertMinor/{uniId}")
	public Response QualificationMinorPojo (@PathParam("uniId") int id, MinorsDataPojo minorDataPojo){
		qualInfo = new QualificationsInformation();
		qualInfo.insertUserUniMinor(id, minorDataPojo);
		return Response.status(200).entity("University Minor Added").build();
	}
	
	@GET
	@Path("/getUniMajors/{uniId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupUserMajors (@PathParam("uniId") int id){ 
		qualInfo = new QualificationsInformation();
		ResponseIntegerList majorList = qualInfo.getUniMajorlist(id);
		return Response.ok()
				.entity(majorList)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getMajorById/{majorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupMajorById (@PathParam("majorId") int id){ 
		qualInfo = new QualificationsInformation();
		MajorsDataPojo usermajors = qualInfo.getMajorById(id);
		return Response.ok()
				.entity(usermajors)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getUniMinors/{uniId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupUserMinor (@PathParam("uniId") int id){ 
		qualInfo = new QualificationsInformation();
		ResponseIntegerList minorList = qualInfo.getUniMinorlist(id);
		return Response.ok()
				.entity(minorList)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getMinorById/{minorId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupMinorById (@PathParam("minorId") int id){ 
		qualInfo = new QualificationsInformation();
		MinorsDataPojo userminors = qualInfo.getMinorById(id);
		return Response.ok()
				.entity(userminors)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateMajorById")
	public Response updateUserMajorInfo (MajorsDataPojo majordatapojo){
		qualInfo = new QualificationsInformation();
		qualInfo.updateMajorById(majordatapojo);
		return Response.status(200).entity("Major by id:" + majordatapojo.getId() + " successfully updated").build();	
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateMinorById")
	public Response updateUserMinorInfo (MinorsDataPojo minordatapojo){
		qualInfo = new QualificationsInformation();
		qualInfo.updateMinorsById(minordatapojo);
		return Response.status(200).entity("Minor by Id:" + minordatapojo.getId() + " successfully loaded").build();	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertTransferUni/{universityId}")
	public Response UniTransferInfo(@PathParam("universityId") int id, TransferDataPojo transferDataPojo){
		qualInfo = new QualificationsInformation();
		Transfer insertTransfer = qualInfo.insertTransferUni(id, transferDataPojo);
		return Response.ok()
				.entity(insertTransfer)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getUniTransfer/{universityId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupTransferUser (@PathParam("universityId") int id){ 
		qualInfo = new QualificationsInformation();
		ResponseIntegerList transferList = qualInfo.getTransferUnilist(id);
		return Response.ok()
				.entity(transferList)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getTransferById/{transferId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupTransferById (@PathParam("transferId") int id){ 
		qualInfo = new QualificationsInformation();
		TransferDataPojo transferuser = qualInfo.getTransferById(id);
		return Response.ok()
				.entity(transferuser)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateTransferById")
	public Response updateTransferUser(TransferDataPojo transferdatapojo){
		qualInfo = new QualificationsInformation();
		qualInfo.updateTransferById(transferdatapojo);
		return Response.status(200).entity("Transfer by Id:" + transferdatapojo.getId() + " successfully loaded").build();		
	}
	
	
}
