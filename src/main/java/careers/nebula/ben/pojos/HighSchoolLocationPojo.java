/**
 * 
 */
package careers.nebula.ben.pojos;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.Highschool;
import careers.nebula.ben.db.enitity.Locations;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class HighSchoolLocationPojo {

	private Highschool hs;
	private Locations location;
	
	public HighSchoolLocationPojo(){
		
	}
	
	public HighSchoolLocationPojo(Highschool hs, Locations location){
		this.hs = hs;
		this.location = location;
	}

	public Highschool getHs() {
		return hs;
	}

	public void setHs(Highschool hs) {
		this.hs = hs;
	}

	public Locations getLocation() {
		return location;
	}

	public void setLocation(Locations location) {
		this.location = location;
	}
	
	
}
