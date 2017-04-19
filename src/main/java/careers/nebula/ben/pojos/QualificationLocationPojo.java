/**
 * 
 */
package careers.nebula.ben.pojos;

import javax.xml.bind.annotation.XmlRootElement;
import careers.nebula.ben.db.enitity.Locations;
import careers.nebula.ben.db.enitity.Qualification;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class QualificationLocationPojo {

	private Qualification uni;
	private Locations location;
	
	public QualificationLocationPojo(){
		
	}
	
	public QualificationLocationPojo(Qualification uni, Locations location){
		this.uni = uni;
		this.location = location;
	}

	public Qualification getUni() {
		return uni;
	}

	public void setUni(Qualification uni) {
		this.uni = uni;
	}

	public Locations getLocation() {
		return location;
	}

	public void setLocation(Locations location) {
		this.location = location;
	}
	
	
}
