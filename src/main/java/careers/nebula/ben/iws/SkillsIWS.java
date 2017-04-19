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
import careers.nebula.ben.db.enitity.Extracurricular;
import careers.nebula.ben.db.enitity.Industry;
import careers.nebula.ben.db.enitity.Interests;
import careers.nebula.ben.db.enitity.Keywords;
import careers.nebula.ben.db.enitity.Languages;
import careers.nebula.ben.information.SkillsInformation;
import careers.nebula.ben.pojo.iws.ExtracurricularDataPojo;
import careers.nebula.ben.pojo.iws.IndustryDataPojo;
import careers.nebula.ben.pojo.iws.InterestsDataPojo;
import careers.nebula.ben.pojo.iws.KeywordsDataPojo;
import careers.nebula.ben.pojo.iws.LanguagesDataPojo;
import careers.nebula.ben.pojos.ResponseIntegerList;

/**
 * @author Ankit_Nebula
 *
 */
@Path("/skillsInfo")
public class SkillsIWS {

	private SkillsInformation skillInfo;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertExtracurricular/{userId}")
	public Response UserExtracurricularInformation (@PathParam("userId") int id, ExtracurricularDataPojo extracurricularDataPojo){
		skillInfo = new SkillsInformation();
		ExtracurricularDataPojo insertExtracurricular = skillInfo.insertExtracurricularInfo(id, extracurricularDataPojo);
		return Response.ok()
				.entity(insertExtracurricular)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getUserExtrcurricular/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupUserExtracurriculars (@PathParam("userId") int id){ 
		skillInfo = new SkillsInformation();
		ResponseIntegerList Extracurricularlist = skillInfo.getUserExtracurricularList(id);
		return Response.ok()
				.entity(Extracurricularlist)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getExtracurricularById/{extracurricularId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getExtracurricularById (@PathParam("extracurricularId") int id){ 
		skillInfo = new SkillsInformation();
		ExtracurricularDataPojo getExtracurricular = skillInfo.getExtracurricularById(id);
		return Response.ok()
				.entity(getExtracurricular)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateExtrcurricularById")
	public Response updateExtrcurricularById (ExtracurricularDataPojo extracurricularDataPojo){
		skillInfo = new SkillsInformation();
		Extracurricular updateExtracurricular = skillInfo.updateExtracurricularById(extracurricularDataPojo);
		return Response.ok()
				.entity(updateExtracurricular)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertLanguage/{userId}")
	public Response UserLanguageInformation (@PathParam("userId") int id, LanguagesDataPojo languageDataPojo){
		skillInfo = new SkillsInformation();
		LanguagesDataPojo insertExtracurricular = skillInfo.insertLanguageInfo(id, languageDataPojo);
		return Response.ok()
				.entity(insertExtracurricular)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getUserLanguage/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupUserLanguage (@PathParam("userId") int id){ 
		skillInfo = new SkillsInformation();
		ResponseIntegerList getLanguageList = skillInfo.getUserLanguageList(id);
		return Response.ok()
				.entity(getLanguageList)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getLanguageById/{languageId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getLanguageById (@PathParam("languageId") int id){ 
		skillInfo = new SkillsInformation();
		LanguagesDataPojo getLanguage = skillInfo.getLanguageById(id);
		return Response.ok()
				.entity(getLanguage)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateLanguagesById")
	public Response updateLanguageById (LanguagesDataPojo languageDataPojo){
		skillInfo = new SkillsInformation();
		Languages updateLanguage = skillInfo.updateLanguageById(languageDataPojo);
		return Response.ok()
				.entity(updateLanguage)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertInterest/{userId}")
	public Response UserInterestInformation (@PathParam("userId") int id, InterestsDataPojo interestDataPojo){
		skillInfo = new SkillsInformation();
		InterestsDataPojo insertInterest = skillInfo.insertInterestInfo(id, interestDataPojo);
		return Response.ok()
				.entity(insertInterest)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getUserInterest/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getUserInterestList(@PathParam("userId") int id){ 
		skillInfo = new SkillsInformation();
		ResponseIntegerList interestlist = skillInfo.getUserInterestList(id);
		return Response.ok()
				.entity(interestlist)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getInterestById/{interestId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupInterestById(@PathParam("interestId") int id){ 
		skillInfo = new SkillsInformation();
		InterestsDataPojo getInterest = skillInfo.getInterestById(id);
		return Response.ok()
				.entity(getInterest)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateInterestById")
	public Response updateInterestById (InterestsDataPojo interestDataPojo){
		skillInfo = new SkillsInformation();
		Interests updateInterest = skillInfo.updateInterestById(interestDataPojo);
		return Response.ok()
				.entity(updateInterest)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertIndustry/{userId}")
	public Response UserIndustryInformation (@PathParam("userId") int id,IndustryDataPojo industryDataPojo){
		skillInfo = new SkillsInformation();
		IndustryDataPojo insertIndustry = skillInfo.insertIndustryInfo(id, industryDataPojo);
		return Response.ok()
				.entity(insertIndustry)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getUserIndustry/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupUserIndustry(@PathParam("userId") int id){ 
		skillInfo = new SkillsInformation();
		ResponseIntegerList industryList = skillInfo.getUserIndustryList(id);
		return Response.ok()
				.entity(industryList)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getIndustryById/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getIndustryById(@PathParam("userId") int id){ 
		skillInfo = new SkillsInformation();
		IndustryDataPojo getIndustry = skillInfo.getIndustryById(id);
		return Response.ok()
				.entity(getIndustry)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateIndustryById")
	public Response updateUserIndustryInfo (IndustryDataPojo industryDataPojo){
		skillInfo = new SkillsInformation();
		Industry updateIndustry = skillInfo.updateIndustryById(industryDataPojo);
		return Response.ok()
				.entity(updateIndustry)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertKeyword/{userId}")
	public Response UserKeywordInformation (@PathParam("userId") int id,KeywordsDataPojo keywordsDataPojo){
		skillInfo = new SkillsInformation();
		KeywordsDataPojo insertKeyword = skillInfo.insertKeywordInfo(id, keywordsDataPojo);
		return Response.ok()
				.entity(insertKeyword)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getUserKeyword/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupUserKeyword(@PathParam("userId") int id){ 
		skillInfo = new SkillsInformation();
		ResponseIntegerList keywordList = skillInfo.getUserKeywordList(id);
		return Response.ok()
				.entity(keywordList)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getKeywordById/{keywordId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getKeywordById(@PathParam("keywordId") int id){ 
		skillInfo = new SkillsInformation();
		KeywordsDataPojo getKeyword = skillInfo.getKeywordById(id);
		return Response.ok()
				.entity(getKeyword)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateKeywordById")
	public Response updateKeywordById(KeywordsDataPojo keywordsDataPojo){
		skillInfo = new SkillsInformation();
		Keywords updateKeyword = skillInfo.updateKeywordById(keywordsDataPojo);
		return Response.ok()
				.entity(updateKeyword)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();	
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertCourseSkills/{courseId}")
	public Response UserCourseSkillsInformation (@PathParam("courseId") int id,IndustryDataPojo industryDataPojo){
		skillInfo = new SkillsInformation();
		IndustryDataPojo insertCourseSkills = skillInfo.insertCourseSkills(id, industryDataPojo);
		return Response.ok()
				.entity(insertCourseSkills)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
}
