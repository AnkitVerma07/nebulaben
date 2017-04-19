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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * @author Ankit_Nebula
 *
 */
@Entity
@Table (name = "courses")
public class Courses {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	private String course_name;
	private String course_grade;
	private Double course_rating;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "coursesList", cascade = CascadeType.ALL)
	private Collection<Highschool> highSchoolList = new ArrayList<Highschool>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "coursesList", cascade = CascadeType.ALL)
	private Collection<Qualification> qualificationList = new ArrayList<Qualification>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "coursesList", cascade = CascadeType.ALL)
	private Collection<Coaches> coachList = new ArrayList<Coaches>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "coursesList", cascade = CascadeType.ALL)
	private Collection<Students> studentsList = new ArrayList<Students>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="course_industry",
			joinColumns=@JoinColumn(name="course_id"), 
			inverseJoinColumns=@JoinColumn(name="industry_id")
	)
	private Collection<Industry> industryList = new ArrayList<Industry>(); 
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_grade() {
		return course_grade;
	}
	public void setCourse_grade(String course_grade) {
		this.course_grade = course_grade;
	}
	public Double getCourse_rating() {
		return course_rating;
	}
	public void setCourse_rating(Double course_rating) {
		this.course_rating = course_rating;
	}
	public Collection<Highschool> getHighSchoolList() {
		return highSchoolList;
	}
	public void setHighSchoolList(Collection<Highschool> highSchoolList) {
		this.highSchoolList = highSchoolList;
	}
	public Collection<Coaches> getCoachList() {
		return coachList;
	}
	public void setCoachList(Collection<Coaches> coachList) {
		this.coachList = coachList;
	}
	public Collection<Students> getStudentsList() {
		return studentsList;
	}
	public void setStudentsList(Collection<Students> studentsList) {
		this.studentsList = studentsList;
	}
	public Collection<Qualification> getQualificationList() {
		return qualificationList;
	}
	public void setQualificationList(Collection<Qualification> qualificationList) {
		this.qualificationList = qualificationList;
	}
	public Collection<Industry> getIndustryList() {
		return industryList;
	}	
}
