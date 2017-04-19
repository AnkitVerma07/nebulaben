/**
 * 
 */
package careers.nebula.ben.pojo.iws;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class TranscriptDataPojo {

	private Integer id;
	private Collection<User> userList = new ArrayList<User>();
	private String fileName;
	private Integer earliestYear;
	private Integer lastYear;
	private Double gpa;
	private String coursesMatch; 
	private String coursesGrades; 
	private Double unitsAttempted;
	private Double unitsPassed;
	private Double unitsCompleted;
	private String uniName;
	private Integer incompleteGrades;
	private Integer pnpGrades;
	private Integer suGrades;
	private Integer wGrades;
	private Integer failedCourses;
	private Integer accedCourses;
	private Boolean updated;
	
	public TranscriptDataPojo(){
		
	}
	
	public TranscriptDataPojo(Integer id, Collection<User> userList, String fileName, Integer earliestYear, Integer lastYear, Double gpa, String coursesMatch, String coursesGrades, Double unitsAttempted, Double unitsPassed, Double unitsCompleted, String uniName, Integer incompleteGrades, Integer pnpGrades, Integer suGrades, Integer wGrades, Integer failedCourses, Integer accedCourses, Boolean updated){
		this.id = id;
		this.userList = userList;
		this.fileName = fileName;
		this.earliestYear = earliestYear;
		this.lastYear = lastYear;
		this.gpa = gpa;
		this.coursesMatch = coursesMatch;
		this.coursesGrades = coursesGrades;
		this.unitsAttempted = unitsAttempted;
		this.unitsPassed = unitsPassed;
		this.unitsCompleted = unitsCompleted;
		this.uniName = uniName;	
		this.incompleteGrades = incompleteGrades;
		this.pnpGrades = pnpGrades;
		this.suGrades = suGrades;
		this.wGrades = wGrades;
		this.failedCourses = failedCourses;
		this.accedCourses = accedCourses;
		this.updated = updated;
	}
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Collection<User> getUserList() {
		return userList;
	}
	public void setUserList(Collection<User> userList) {
		this.userList = userList;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public Integer getEarliestYear() {
		return earliestYear;
	}
	public void setEarliestYear(Integer earliestYear) {
		this.earliestYear = earliestYear;
	}
	public Integer getLastYear() {
		return lastYear;
	}
	public void setLastYear(Integer lastYear) {
		this.lastYear = lastYear;
	}
	public Double getGpa() {
		return gpa;
	}
	public void setGpa(Double gpa) {
		this.gpa = gpa;
	}
	public String getCoursesMatch() {
		return coursesMatch;
	}
	public void setCoursesMatch(String coursesMatch) {
		this.coursesMatch = coursesMatch;
	}
	public String getCoursesGrades() {
		return coursesGrades;
	}
	public void setCoursesGrades(String coursesGrades) {
		this.coursesGrades = coursesGrades;
	}
	public Double getUnitsAttempted() {
		return unitsAttempted;
	}
	public void setUnitsAttempted(Double unitsAttempted) {
		this.unitsAttempted = unitsAttempted;
	}
	public Double getUnitsPassed() {
		return unitsPassed;
	}
	public void setUnitsPassed(Double unitsPassed) {
		this.unitsPassed = unitsPassed;
	}
	public Double getUnitsCompleted() {
		return unitsCompleted;
	}
	public void setUnitsCompleted(Double unitsCompleted) {
		this.unitsCompleted = unitsCompleted;
	}
	public String getUniName() {
		return uniName;
	}
	public void setUniName(String uniName) {
		this.uniName = uniName;
	}

	public Integer getIncompleteGrades() {
		return incompleteGrades;
	}

	public void setIncompleteGrades(Integer incompleteGrades) {
		this.incompleteGrades = incompleteGrades;
	}

	public Integer getPnpGrades() {
		return pnpGrades;
	}

	public void setPnpGrades(Integer pnpGrades) {
		this.pnpGrades = pnpGrades;
	}

	public Integer getSuGrades() {
		return suGrades;
	}

	public void setSuGrades(Integer suGrades) {
		this.suGrades = suGrades;
	}

	public Integer getwGrades() {
		return wGrades;
	}

	public void setwGrades(Integer wGrades) {
		this.wGrades = wGrades;
	}

	public Integer getFailedCourses() {
		return failedCourses;
	}

	public void setFailedCourses(Integer failedCourses) {
		this.failedCourses = failedCourses;
	}

	public Integer getAccedCourses() {
		return accedCourses;
	}

	public void setAccedCourses(Integer accedCourses) {
		this.accedCourses = accedCourses;
	}

	public Boolean getUpdated() {
		return updated;
	}

	public void setUpdated(Boolean updated) {
		this.updated = updated;
	} 
	
	
}
