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
@Table (name = "colleges")
public class Colleges {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	private String college_name;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "collegeNameList", cascade = CascadeType.ALL)
	private Collection<Qualification> qualificationList = new ArrayList<Qualification>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCollege_name() {
		return college_name;
	}
	public void setCollege_name(String college_name) {
		this.college_name = college_name;
	}
	public Collection<Qualification> getQualificationList() {
		return qualificationList;
	}
	public void setQualificationList(Collection<Qualification> qualificationList) {
		this.qualificationList = qualificationList;
	}
	
	
}
