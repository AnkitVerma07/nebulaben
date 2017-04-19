/**
 * 
 */
package careers.nebula.ben.iws;

import java.io.IOException;
import java.io.InputStream;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

import careers.nebula.ben.db.enitity.Resume;
import careers.nebula.ben.db.enitity.Transcript;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.information.DocumentInformation;
import careers.nebula.ben.information.ResumeInformation;
//import careers.nebula.ben.information.TranscriptInformation;
import careers.nebula.ben.information.UserInformation;
import careers.nebula.ben.pojo.iws.ResumeDataPojo;
import careers.nebula.ben.pojo.iws.TranscriptDataPojo;
import careers.nebula.ben.pojo.iws.UserDataPojo;


/**
 * @author Ankit_Nebula
 *
 */
@Path("/userDocuments")
public class DocumentIWS {

	private DocumentInformation docinfo;
	private ResumeInformation resumeinfo;
	//private TranscriptInformation traninfo;
	
	
	@POST
	@Path("/uploadFile/{userId}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response uploadFile(		
			@PathParam("userId") int id,
	        @FormDataParam("file") InputStream uploadedInputStream,
	        @FormDataParam("file") FormDataContentDisposition fileDetail) throws IOException {
	    docinfo = new DocumentInformation();
		if (uploadedInputStream == null || fileDetail == null){
			return Response.status(400).entity("Invalid form data").build();
		}
		docinfo.writeToFile(id ,uploadedInputStream, fileDetail);
	    return Response.status(200).entity("File successfully Loaded").build();

	}
	
	@POST
	@Path("/saveResumeInfo/{userId}")
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	public Response ResumeInformationPojo (
	        @FormDataParam("file") InputStream uploadedInputStream,
	        @FormDataParam("file") FormDataContentDisposition fileDetail,
	        @PathParam("userId") int id) throws IOException{
		docinfo = new DocumentInformation();
		if (uploadedInputStream == null || fileDetail == null){
			return Response.status(400).entity("Invalid form data").build();
		}
		docinfo.writeResumeToDisk(id ,uploadedInputStream, fileDetail);
		return Response.status(200).entity("File successfully Loaded").build();
	}
	
	@POST
	@Consumes(MediaType.MULTIPART_FORM_DATA)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/saveTranscriptInfo/{userId}")
	public Response TranscriptInformationPojo (
			@PathParam("userId") int id,
	        @FormDataParam("file") InputStream uploadedInputStream,
	        @FormDataParam("file") FormDataContentDisposition fileDetail) throws IOException{
		docinfo = new DocumentInformation();
		Transcript transcriptdata = docinfo.writeTranscriptToDisk(id ,uploadedInputStream, fileDetail);
		return Response.ok()
				.entity(transcriptdata)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getUserResume/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response locateUserResumeById (@PathParam("userId") int id){
		resumeinfo = new ResumeInformation();
		ResumeDataPojo resumeData = resumeinfo.getUserResume(id);
		return Response.ok()
				.entity(resumeData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
//	@GET
//	@Path("/getUserTranscript/{userId}")
//	@Produces(MediaType.APPLICATION_JSON)
//	public Response locateUserTranscriptById (@PathParam("userId") int id){
//		traninfo = new TranscriptInformation();
//		TranscriptDataPojo tranData = traninfo.getUserTranscript(id);
//		return Response.ok()
//				.entity(tranData)
//				.header("Access-Control-Allow-Origin", "*")
//				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
//				.allow("OPTIONS").build();
//	}
}
