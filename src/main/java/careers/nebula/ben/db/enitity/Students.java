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
@Table (name = "students")
public class Students {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="student_courses",
			joinColumns=@JoinColumn(name="student_id"), 
			inverseJoinColumns=@JoinColumn(name="course_id")
	)
	private Collection<Courses> coursesList = new ArrayList<Courses>(); 
	private Double student_rating;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "studentsList", cascade = CascadeType.ALL)
	private Collection<Coaches> coachesList = new ArrayList<Coaches>();
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "studentsList", cascade = CascadeType.ALL)
	private Collection<User> userList = new ArrayList<User>();
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Collection<Courses> getCoursesList() {
		return coursesList;
	}
	public void setCoursesList(Collection<Courses> coursesList) {
		this.coursesList = coursesList;
	}
	public Double getStudent_rating() {
		return student_rating;
	}
	public void setStudent_rating(Double student_rating) {
		this.student_rating = student_rating;
	}
	public Collection<Coaches> getCoachesList() {
		return coachesList;
	}
	public void setCoachesList(Collection<Coaches> coachesList) {
		this.coachesList = coachesList;
	}
	public Collection<User> getUserList() {
		return userList;
	}
	public void setUserList(Collection<User> userList) {
		this.userList = userList;
	}
	
	
}
