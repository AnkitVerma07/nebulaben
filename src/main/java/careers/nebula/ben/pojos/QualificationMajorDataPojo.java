/**
 * 
 */
package careers.nebula.ben.pojos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class QualificationMajorDataPojo {

	private Integer qualification_id;
	private Integer major_id;
	
	public QualificationMajorDataPojo(){
		
	}
	
	public QualificationMajorDataPojo(Integer q_id, Integer m_id){
		this.qualification_id = q_id;
		this.major_id = m_id;
	}

	public Integer getQualification_id() {
		return qualification_id;
	}

	public void setQualification_id(Integer qualification_id) {
		this.qualification_id = qualification_id;
	}

	public Integer getMajor_id() {
		return major_id;
	}

	public void setMajor_id(Integer major_id) {
		this.major_id = major_id;
	}
	
	
}
