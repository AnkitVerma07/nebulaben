/**
 * 
 */
package careers.nebula.ben.pojo.iws;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.Qualification;
import careers.nebula.ben.db.enitity.Universities;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class UniversitiesDataPojo {
	private Integer id;
	private String uni_name;
	private Collection<Qualification> qualificationList = new ArrayList<Qualification>();
	
	public UniversitiesDataPojo(){
		
	}
	
	public UniversitiesDataPojo(Integer id, String uni_name, Collection<Qualification> qualificationList){
		this.id = id;
		this.uni_name = uni_name;
		this.qualificationList = qualificationList;
	}

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
