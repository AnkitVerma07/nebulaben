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
public class MajorsDataPojo {
	private Integer id;
	private String name;
	private Collection<Qualification> qualificationList = new ArrayList<Qualification>();

	public MajorsDataPojo(){
		
	}
	
	public MajorsDataPojo(Integer id, String name, Collection<Qualification> qulificationList){
		this.id = id;
		this.name = name;
		this.qualificationList = qulificationList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Collection<Qualification> getQualificationList() {
		return qualificationList;
	}

	public void setQualificationList(Collection<Qualification> qualificationList) {
		this.qualificationList = qualificationList;
	}

	
	
}

