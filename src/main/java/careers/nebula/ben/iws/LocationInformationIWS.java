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
import careers.nebula.ben.db.enitity.Locations;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.db.repository.UserRepo;
import careers.nebula.ben.information.LocationInformation;
import careers.nebula.ben.pojo.iws.LocationDataPojo;
import careers.nebula.ben.pojos.ResponseIntegerList;

/**
 * @author Ankit_Nebula
 * restful services connection layer
 */
@Path("/locationInfo")
public class LocationInformationIWS {
	
	private LocationInformation locationInformation;
	private UserRepo userRepo;
	private User userEntity;
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insertUserLocation/{userId}")
	public Response UserLocationInformation (@PathParam("userId") int id, LocationDataPojo locationData){
		locationInformation = new LocationInformation();
		locationInformation.insertUserLocation(id, locationData);
		return Response.status(200).entity("User Location Added").build();
	}
	
	@GET
	@Path("/getLocation/{locationId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response locationById (@PathParam("locationId") int id){
		locationInformation = new LocationInformation();
		LocationDataPojo location = locationInformation.getLocationById(id);
		return Response.ok()
				.entity(location)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getUserLocation/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupUserLocation (@PathParam("userId") int id){ 
		locationInformation = new LocationInformation();
		LocationDataPojo userLocation = locationInformation.getUserLocation(id);
		return Response.ok()
				.entity(userLocation)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}

	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/updateUserLocation/{userId}")
	public Response updateUserLocationInfo (@PathParam("userId") int id,LocationDataPojo locationData){
		locationInformation = new LocationInformation();
		userRepo = new UserRepo();
		userEntity = new User();
		int location_id = 0;
		userEntity = userRepo.getUserData(id);
		Collection<Locations> locationList = new ArrayList<Locations>();
		locationList = userEntity.getLocationList();
		for (Locations obj : locationList) {
			     location_id = obj.getId();
			   }
		locationData.setId(location_id);
		Locations updateUserLocation = locationInformation.updateUserLocation(locationData);
		return Response.ok()
				.entity(updateUserLocation)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();	
	}
	

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insertUserHSLocation/{userId}")
	public Response HighschoolLocationInformation (@PathParam("userId") int id, LocationDataPojo locationData){
		locationInformation = new LocationInformation();
		locationInformation.insertUserHSLocation(id, locationData);
		return Response.status(200).entity("High School Location Added").build();
	}
	
	@GET
	@Path("/getUserHSLocation/{userId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupUserHSLocation (@PathParam("userId") int id){ 
		locationInformation = new LocationInformation();
		LocationDataPojo userHSLocation = locationInformation.getUserHSLocation(id);
		return Response.ok()
				.entity(userHSLocation)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateUserHSLocation/{userId}")
	public Response updateUserHSLocationInfo (@PathParam("userId") int id,LocationDataPojo locationData){
		locationInformation = new LocationInformation();
		locationInformation.updateUserHSLocation(id, locationData);
		return Response.status(200).entity("High School location upated for user id:" + id).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/insertUniLocation/{universityId}")
	public Response UniversityLocationInformation (@PathParam("universityId") int id, LocationDataPojo locationData){
		locationInformation = new LocationInformation();
		locationInformation.insertUserUniLocation(id, locationData);
		return Response.status(200).entity("University Location Added").build();
	}
	
	@GET
	@Path("/getUniLocation/{universityId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupUserUniLocation (@PathParam("universityId") int id){ 
		locationInformation = new LocationInformation();
		LocationDataPojo userUniLocation = locationInformation.getUniLocation(id);
		return Response.ok()
				.entity(userUniLocation)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateUniLocation/{universityId}")
	public Response updateUserUniLocationInfo (@PathParam("universityId") int id,LocationDataPojo locationData){
		locationInformation = new LocationInformation();
		locationInformation.updateUniLocation(id, locationData);
		return Response.status(200).entity("University location updated for uni_id:"+ id).build();
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	@Path("/insertUserExpCompanyLocation/{userId}")
	public Response companyLocationInformation (@PathParam("userId") int id, LocationDataPojo locationData){
		locationInformation = new LocationInformation();
		LocationDataPojo insertCompanyLocation = locationInformation.insertUsrExpCompanyLocation(id, locationData);
		return Response.ok()
				.entity(insertCompanyLocation)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@GET
	@Path("/getCompanyLocation/{companyId}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response lookupCompanyLocation(@PathParam("companyId") int id){ 
		locationInformation = new LocationInformation();
		ResponseIntegerList companyLocation = locationInformation.getCompanyLocation(id);
		return Response.ok()
				.entity(companyLocation)
				.header("Access-Control-Allow-Origin", "*")
				.header("Access-Control-Allow-Methods", "GET, POST, DELETE, PUT")
				.allow("OPTIONS").build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("/updateLocation")
	public Response updateCompanyLocationInfo (LocationDataPojo locationData){
		locationInformation = new LocationInformation();
		locationInformation.updateLocation(locationData);
		return Response.status(200).entity("location successfully updated for id:" + locationData.getId()).build();
	}
}
