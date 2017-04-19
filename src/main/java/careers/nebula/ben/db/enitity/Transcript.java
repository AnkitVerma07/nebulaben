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
@Table (name = "transcript")
public class Transcript {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "transcriptList", cascade = CascadeType.ALL)
	private Collection<User> userList = new ArrayList<User>();
	private String fileName;
	private Integer earliestYear;
	private Integer lastYear;
	private Double gpa;
	@Column(length = 100000)
	private String coursesMatch; 
	@Column(length = 100000)
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
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
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
