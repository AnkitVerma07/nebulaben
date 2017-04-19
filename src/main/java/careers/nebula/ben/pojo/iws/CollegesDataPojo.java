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
public class CollegesDataPojo {

	private Integer id;
	private String college_name;
	private Collection<Qualification> qualificationList = new ArrayList<Qualification>();
	
	public CollegesDataPojo(){
		
	}
	
	public CollegesDataPojo(Integer id, String college_name, Collection<Qualification> qualificationList ){
		this.id = id;
		this.college_name = college_name;
		this.qualificationList = qualificationList;
	}

	public Collection<Qualification> getQualificationList() {
		return qualificationList;
	}

	public void setQualificationList(Collection<Qualification> qualificationList) {
		this.qualificationList = qualificationList;
	}

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
	
	
}
