/**
 * 
 */
package careers.nebula.ben.pojos;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.Qualification;
import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class UserQualificationPojo {

	private User user;
	private Qualification university;
	
	public UserQualificationPojo(){
		
	}
	
	public UserQualificationPojo(User user, Qualification university){
		this.user = user;
		this.university = university;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Qualification getUniversity() {
		return university;
	}

	public void setUniversity(Qualification university) {
		this.university = university;
	}
	
	
}
