/**
 * 
 */
package careers.nebula.ben.pojos;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.Majors;
import careers.nebula.ben.db.enitity.Qualification;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class QualificationMajorPojo {

	private Qualification uni;
	private Majors major;
	
	public QualificationMajorPojo(){
		
	}
	
	public QualificationMajorPojo(Qualification uni, Majors major){
		this.uni = uni;
		this.major = major;
	}

	public Qualification getUni() {
		return uni;
	}

	public void setUni(Qualification uni) {
		this.uni = uni;
	}

	public Majors getMajor() {
		return major;
	}

	public void setMajor(Majors major) {
		this.major = major;
	}
	
	
}
