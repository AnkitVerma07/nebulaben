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
@Table (name = "universities")
public class Universities {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	private String uni_name;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "uniNameList", cascade = CascadeType.ALL)
	private Collection<Qualification> qualificationList = new ArrayList<Qualification>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUni_name() {
		return uni_name;
	}
	public void setUni_name(String uni_name) {
		this.uni_name = uni_name;
	}
	public Collection<Qualification> getQualificationList() {
		return qualificationList;
	}
	public void setQualificationList(Collection<Qualification> qualificationList) {
		this.qualificationList = qualificationList;
	}
	
	
}
