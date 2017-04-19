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
@Table (name = "industry")
public class Industry {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "industryList", cascade = CascadeType.ALL)
	private Collection<User> userList = new ArrayList<User>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "industryList", cascade = CascadeType.ALL)
	private Collection<Courses> courseList = new ArrayList<Courses>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "industryList", cascade = CascadeType.ALL)
	private Collection<Jobs> jobsList = new ArrayList<Jobs>();
	
	private String name;

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
	public Collection<User> getUserList() {
		return userList;
	}
	public void setUserList(Collection<User> userList) {
		this.userList = userList;
	}
	public Collection<Courses> getCourseList() {
		return courseList;
	}
	public void setCourseList(Collection<Courses> courseList) {
		this.courseList = courseList;
	}
	public Collection<Jobs> getJobsList() {
		return jobsList;
	}
	public void setJobsList(Collection<Jobs> jobsList) {
		this.jobsList = jobsList;
	}

	
	
}
