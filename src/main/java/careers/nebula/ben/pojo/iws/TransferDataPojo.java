/**
 * 
 */
package careers.nebula.ben.pojo.iws;

import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;
import careers.nebula.ben.db.enitity.Qualification;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class TransferDataPojo {
	private Integer id;   
	private Integer year_started;
	private Integer year_transfered;
	private String qualifications_earned;
	private Collection<Qualification> qualificationList = new ArrayList<Qualification>();
	
	public TransferDataPojo(){
		
	}
	
	public TransferDataPojo(Integer id, Integer year_started, Integer year_transfered, String qualifications_earned, Collection<Qualification> qualificationList){
		this.id = id;
		this.year_started = year_started;
		this.year_transfered = year_transfered;
		this.qualificationList = qualificationList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getYear_started() {
		return year_started;
	}

	public void setYear_started(Integer year_started) {
		this.year_started = year_started;
	}

	public Integer getYear_transfered() {
		return year_transfered;
	}

	public void setYear_transfered(Integer year_transfered) {
		this.year_transfered = year_transfered;
	}

	public String getQualifications_earned() {
		return qualifications_earned;
	}

	public void setQualifications_earned(String qualifications_earned) {
		this.qualifications_earned = qualifications_earned;
	}

	public Collection<Qualification> getQualificationList() {
		return qualificationList;
	}

	public void setQualificationList(Collection<Qualification> qualificationList) {
		this.qualificationList = qualificationList;
	}


	
	
}
