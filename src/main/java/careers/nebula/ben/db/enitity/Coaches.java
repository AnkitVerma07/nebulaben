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
@Table (name = "coaches")
public class Coaches {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id; 
	private Double coach_hourlyrate;
	private Double coach_rating;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "coachList", cascade = CascadeType.ALL)
	private Collection<User> userList = new ArrayList<User>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="coach_teaches",
			joinColumns=@JoinColumn(name="coach_id"), 
			inverseJoinColumns=@JoinColumn(name="course_id")
	)
	private Collection<Courses> coursesList = new ArrayList<Courses>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="coach_student",
			joinColumns=@JoinColumn(name="coach_id"), 
			inverseJoinColumns=@JoinColumn(name="student_id")
	)
	private Collection<Students> studentsList = new ArrayList<Students>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Double getCoach_hourlyrate() {
		return coach_hourlyrate;
	}
	public void setCoach_hourlyrate(Double coach_hourlyrate) {
		this.coach_hourlyrate = coach_hourlyrate;
	}
	public Double getCoach_rating() {
		return coach_rating;
	}
	public void setCoach_rating(Double coach_rating) {
		this.coach_rating = coach_rating;
	}
	public Collection<User> getUserList() {
		return userList;
	}
	public void setUserList(Collection<User> userList) {
		this.userList = userList;
	}
	public Collection<Courses> getCoursesList() {
		return coursesList;
	}
	public void setCoursesList(Collection<Courses> coursesList) {
		this.coursesList = coursesList;
	}
	public Collection<Students> getStudentsList() {
		return studentsList;
	}
	public void setStudentsList(Collection<Students> studentsList) {
		this.studentsList = studentsList;
	}
	
	
}
