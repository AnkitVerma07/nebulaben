/**
 * 
 */
package careers.nebula.ben.db.enitity;

import java.util.ArrayList;
import java.util.Collection;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Ankit_Nebula
 *
 */
@Entity
@Table (name = "transfers")
public class Transfer {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial") 
	private Integer id;   
	private Integer year_started;
	private Integer year_transfered;
	private String qualifications_earned;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "transferList", cascade = CascadeType.ALL)
	private Collection<Qualification> qualificationList = new ArrayList<Qualification>();
	
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
	public Collection<Qualification> getUserList() {
		return qualificationList;
	}
	public void setUserList(Collection<Qualification> qualificationList) {
		this.qualificationList = qualificationList;
	}
	
	
}
