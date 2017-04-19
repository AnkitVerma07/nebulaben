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
public class CoachStudentIdPojo {

	private int studentId;
	private int coachId;
	
	public CoachStudentIdPojo(){
		
	}
	
	public CoachStudentIdPojo(int studentId, int coachId){
		this.studentId = studentId;
		this.coachId = coachId;
	}

	public int getStudentId() {
		return studentId;
	}

	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}

	public int getCoachId() {
		return coachId;
	}

	public void setCoachId(int coachId) {
		this.coachId = coachId;
	}
	
	
}
