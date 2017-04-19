/**
 * 
 */
package careers.nebula.ben.pojos;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.Locations;
import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class UserLocationPojo {

	private User user;
	private Locations location;
	
	public UserLocationPojo(){
		
	}
	
	public UserLocationPojo(User user, Locations location){
		this.user = user;
		this.location = location;
	}

	public User getUser() {
		return user;
	}

	public Locations getLocation() {
		return location;
	}
	
	
}
