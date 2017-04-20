/**
 * 
 */
package careers.nebula.ben.pojos;

import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.Experiences;
import careers.nebula.ben.db.enitity.Highschool;
import careers.nebula.ben.db.enitity.Qualification;

/**
 * @author medlclouddev
 *
 */
@XmlRootElement
public class TimelinePojo {

	Map<String, Highschool> hsMap;
	Map<String, Experiences> expMap;
	Map<String, Qualification> qualMap;
	
	public TimelinePojo(){
		
	}
	
	public TimelinePojo(Map<String, Highschool> hsMap, Map<String, Experiences> expMap, Map<String, Qualification> qualMap){
		this.hsMap = hsMap;
		this.qualMap = qualMap;
		this.expMap = expMap;
	}

	public Map<String, Highschool> getHsMap() {
		return hsMap;
	}

	public void setHsMap(Map<String, Highschool> hsMap) {
		this.hsMap = hsMap;
	}

	public Map<String, Experiences> getExpMap() {
		return expMap;
	}

	public void setExpMap(Map<String, Experiences> expMap) {
		this.expMap = expMap;
	}

	public Map<String, Qualification> getQualMap() {
		return qualMap;
	}

	public void setQualMap(Map<String, Qualification> qualMap) {
		this.qualMap = qualMap;
	}
	
	
}
