/**
 * 
 */
package careers.nebula.ben.pojos;

import javax.xml.bind.annotation.XmlRootElement;
import careers.nebula.ben.db.enitity.Minors;
import careers.nebula.ben.db.enitity.Qualification;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class QualificationMinorPojo {

	private Qualification uni;
	private Minors minor;
	
	public QualificationMinorPojo(){
		
	}
	
	public QualificationMinorPojo(Qualification uni, Minors minor){
		this.uni = uni;
		this.minor = minor;
	}

	public Qualification getUni() {
		return uni;
	}

	public void setUni(Qualification uni) {
		this.uni = uni;
	}

	public Minors getMinor() {
		return minor;
	}

	public void setMinor(Minors minor) {
		this.minor = minor;
	}
	
	
}
