/**
 * 
 */
package careers.nebula.ben.pojos;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.Highschool;
import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class UserHighschoolPojo {

	private User user;
	private Highschool highschool;
	
	public UserHighschoolPojo(){
		
	}
	
	public UserHighschoolPojo(User user, Highschool highschool){
		this.user = user;
		this.highschool = highschool;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Highschool getHighschool() {
		return highschool;
	}

	public void setHighschool(Highschool highschool) {
		this.highschool = highschool;
	}
	
	
}
