/**
 * 
 */
package careers.nebula.ben.iws;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import careers.nebula.ben.information.ComparePeer2PeerInformation;
import careers.nebula.ben.information.CourseSuggestionInformation;
import careers.nebula.ben.information.JobSuggestionInformation;
import careers.nebula.ben.pojos.RespondJobsCombinedList;
import careers.nebula.ben.pojos.ResponseCombinedList;
import careers.nebula.ben.pojos.TwoTestResultDataPojo;

/**
 * @author Ankit_Nebula
 *
 */
@Path("/userProfile")
public class UserProfileIWS {
	
	private ComparePeer2PeerInformation compareInfo;
	private CourseSuggestionInformation courseSuggestion;
	private JobSuggestionInformation jobSuggestion;
	
	@GET
	@Path("/qualificationMajorExtra/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExtraByQualificationMajor (@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationMajorExtraComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationMajorIndustry/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareIndustryByQualificationMajor (@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationMajorIndustryComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationMajorInterest/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareInterestByQualificationMajor (@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationMajorInterestComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}

	@GET
	@Path("/qualificationMajorLanguage/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareLanguageByQualificationMajor (@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationMajorLanguagesComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationMajorKeyword/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareKeywordByQualificationMajor (@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationMajorKeywordsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationMinorExtra/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExtraByQualificationMinor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationMinorExtraComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationMinorIndustry/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareIndustryByQualificationMinor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationMinorIndustryComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationMinorInterest/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareInterestByQualificationMinor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationMinorInterestsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationMinorLanguage/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareLanguageByQualificationMinor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationMinorLanguagesComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationMinorKeyword/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareKeywordByQualificationMinor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationMinorKeywordsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationSchoolExtra/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExtraByQualificationSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationSchoolExtraComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationSchoolIndustry/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareIndustryByQualificationSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationSchoolIndustryComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationSchoolLanguage/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareLanguageByQualificationSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationSchoolLanguagesComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationSchoolKeyword/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareKeywordByQualificationSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationSchoolKeywordsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorMinorExtra/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExtraByMajorMinor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserMajorMinorExtraComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorMinorIndustry/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareIndustryByMajorMinor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserMajorMinorIndustryComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorMinorInterest/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareInterestByMajorMinor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserMajorMinorInterestsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorMinorLanguage/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareLanguageByMajorMinor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserMajorMinorLanguagesComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorMinorKeyword/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareKeywordByMajorMinor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserMajorMinorKeywordsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorSchoolExtra/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExtraByMajorSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserSchoolMajorExtraComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorSchoolIndustry/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareIndustryByMajorSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserSchoolMajorIndustryComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorSchoolInterest/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareInterestByMajorSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserSchoolMajorInterestsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorSchoolLanguage/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareLanguageByMajorSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserSchoolMajorLanguagesComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorSchoolKeyword/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareKeywordByMajorSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserSchoolMajorKeywordsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/minorSchoolExtra/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExtraByMinorSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserSchoolMinorExtraComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/minorSchoolIndustry/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareIndustryByMinorSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserSchoolMinorIndustryComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/minorSchoolInterest/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareInterestByMinorSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserSchoolMinorInterestsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/minorSchoolLanguage/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareLanguageByMinorSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserSchoolMinorLanguagesComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/minorSchoolKeyword/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareKeywordByMinorSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserSchoolMinorKeywordsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationLocationExtra/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExtraByQualificationLocation(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationLocationExtraComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationLocationIndustry/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareIndustryByQualificationLocation(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationLocationIndustryComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationLocationInterest/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareInterestByQualificationLocation(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationLocationInterestsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationLocationLanguage/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareLanguageByQualificationLocation(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationLocationLanguagesComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationLocationKeyword/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareKeywordByQualificationLocation(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationLocationKeywordsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorLocationExtra/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExtraByLocationMajor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserLocationMajorExtraComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorLocationIndustry/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareIndustryByLocationMajor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserLocationMajorIndustryComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorLocationInterest/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareInterestByLocationMajor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserLocationMajorInterestsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorLocationLanguage/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareLanguageByLocationMajor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserLocationMajorLanguagesComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorLocationKeyword/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareKeywordByLocationMajor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserLocationMajorKeywordsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/jobTitleLocationExtra/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExtraByJobTitleLocation(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserJobTitleLocationExtraComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/jobTitleLocationIndustry/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareIndustryByJobTitleLocation(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserJobTitleLocationIndustryComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/jobTitleLocationInterest/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareInterestByJobTitleLocation(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserJobTitleLocationInterestsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/jobTitleLocationLanguage/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareLanguageByJobTitleLocation(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserJobTitleLocationLanguagesComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}

	@GET
	@Path("/jobTitleAgeIndustry/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareIndustryByJobTitleAge(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserJobTitleAgeIndustryComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/jobTitleAgeInterest/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareInterestByJobTitleAge(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserJobTitleAgeInterestsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/jobTitleAgeLanguage/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareLanguageByJobTitleAge(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserJobTitleAgeLanguagesComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/jobTitleAgeKeyword/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareKeywordByJobTitleAge(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserJobTitleAgeKeywordsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/ageExtra/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExtraByAge(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserAgeExtraComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/ageIndustry/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareIndustryByAge(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserAgeIndustryComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/ageLanguage/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareLanguageByAge(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserAgeLanguagesComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/ageKeyword/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareKeywordByAge(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserAgeKeywordsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/goalsExtra/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExtraByGoals(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserGoalsExtraComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/goalsIndustry/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareIndustryByGoals(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserGoalsIndustryComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/goalsInterest/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareInterestByGoals(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserGoalsInterestComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/goalsLanguage/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareLanguageByGoals(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserGoalsLanguagesComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorExtra/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExtraByMajor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserMajorExtraComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorIndustry/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareIndustryByMajor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserMajorIndustryComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorInterest/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareInterestByMajor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserMajorInterestsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorLanguage/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareLanguageByMajor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserMajorLanguagesComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorKeyword/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareKeywordByMajor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserMajorKeywordsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/minorExtra/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExtraByMinor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserMinorExtraComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/minorInterest/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareInterestByMinor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserMinorInterestsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/minorLanguage/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareLanguageByMinor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserMinorLanguagesComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/minorKeyword/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareKeywordByMinor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserMinorKeywordsComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationMajorExpereince/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExperienceByQualificationMajor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationMajorExpComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationMinorExpereince/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExperienceByQualificationMinor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationMinorExpComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationSchoolExpereince/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExperienceByQualificationSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationSchoolExpComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorMinorExpereince/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExperienceByMajorMinor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserMajorMinorExpComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/schoolMinorExpereince/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExperienceBySchoolMinor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserSchoolMinorExpComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/schoolMajorExpereince/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExperienceBySchoolMajor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserSchoolMajorExpComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationLocationExpereince/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExperienceByQualificationLocation(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationLocationExpComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/locationMajorExpereince/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExperienceByLocationMajor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserLocationMajorExpComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/jobTitleLocationExpereince/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExperienceByJobTitleLocation(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserJobTitleLocationExpComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/jobTitleAgeExpereince/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExperienceByJobTitleAge(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserJobTitleAgeExpComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/ageExpereince/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExperienceByAge(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserAgeExpComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/goalsExpereince/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareExperienceByGoals(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserGoalsExpComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationMajorHS/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareHSByQualificationMajor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationMajorHSComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/minorMajorHS/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareHSByMinorMajor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserMinorMajorHSComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/minorSchoolHS/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareHSByMinorSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserMinorSchoolHSComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationLocationHS/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareHSByQualificationLocation(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationLocationHSComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorLocationHS/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareHSByLocationMajor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserLocationMajorHSComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/jobTitleLocationHS/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareHSByrJobTitleLocation(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserJobTitleLocationHSComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/jobTitleAgeHS/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareHSByJobTitleAge(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserJobTitleAgeHSComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/ageHS/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareHSByAge(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserAgeHSComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/goalsHS/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareHSBygoals(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserGoalsHSComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationMajorUni/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareUniByQualificationMajor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationMajorUniComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationMinorUni/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareUniByQualificationMinor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationMinorUniComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationSchoolUni/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareUniByQualificationSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationSchoolUniComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/minorMajorUni/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareUniByMinorMajor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserMinorMajorUniComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/minorSchoolUni/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareUniByMinorSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserMinorSchoolUniComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorSchoolUni/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareUniByMajorSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserMajorSchoolUniComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationLocationUni/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareUniByQualificationLocation(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserQualificationLocationUniComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/locationMajorUni/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareUniByLocationMajor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserLocationMajorUniComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/jobTitleLocationUni/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareUniByJobTitleLocation(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserJobTitleLocationUniComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/jobTitleAgeUni/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareUniByJobTitleAges(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserJobTitleAgeUniComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/ageUni/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareUniByAges(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserAgeUniComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/goalsUni/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareUniByGoals(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		ResponseCombinedList usersData = compareInfo.getUserGoalsUniComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationMajorTestResult/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareTestResultByQualificationMajor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		TwoTestResultDataPojo usersData = compareInfo.getUserQualificationMajorTestResultComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationMinorTestResult/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareTestResultByQualificationMinor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		TwoTestResultDataPojo usersData = compareInfo.getUserQualificationMinorTestResultComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationSchoolTestResult/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareTestResultByQualificationSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		TwoTestResultDataPojo usersData = compareInfo.getUserQualificationSchoolTestResultComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/minorMajorTestResult/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareTestResultByMinorMajor(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		TwoTestResultDataPojo usersData = compareInfo.getUserMinorMajorTestResultComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/minorSchoolTestResult/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareTestResultByMinorSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		TwoTestResultDataPojo usersData = compareInfo.getUserMinorSchoolTestResultComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorSchoolTestResult/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareTestResultByMajorSchool(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		TwoTestResultDataPojo usersData = compareInfo.getUserMajorSchoolTestResultComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/qualificationLocationTestResult/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareTestResultByQualificationLocation(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		TwoTestResultDataPojo usersData = compareInfo.getUserQualificationLocationTestResultComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/majorLocationTestResult/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareTestResultByMajorLocation(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		TwoTestResultDataPojo usersData = compareInfo.getUserMajorLocationTestResultComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/jobTitleLocationTestResult/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareTestResultByJobTitleLocation(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		TwoTestResultDataPojo usersData = compareInfo.getUserJobTitleLocationTestResultComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/jobTitleAgeTestResult/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareTestResultByJobTitleAge(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		TwoTestResultDataPojo usersData = compareInfo.getUserJobTitleAgeTestResultComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/ageTestResult/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareTestResultByAge(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		TwoTestResultDataPojo usersData = compareInfo.getUserAgeTestResultComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}

	@GET
	@Path("/goalsTestResult/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCompareTestResultByGoals(@PathParam("userId") int id){
		compareInfo = new ComparePeer2PeerInformation();
		TwoTestResultDataPojo usersData = compareInfo.getUserGoalsTestResultComparison(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/courseSuggestion/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getCourseSuggestions(@PathParam("userId") int id){
		courseSuggestion = new CourseSuggestionInformation();
		ResponseCombinedList usersData = courseSuggestion.getGoalsType(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/jobSuggestion/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response getJobSuggestions(@PathParam("userId") int id){
		jobSuggestion = new JobSuggestionInformation();
		RespondJobsCombinedList usersData = jobSuggestion.getGoalsType(id);
		return Response.ok()
				.entity(usersData)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
}
