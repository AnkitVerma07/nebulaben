/**
 * 
 */
package careers.nebula.ben.pojo.iws;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.Courses;
import careers.nebula.ben.db.enitity.Jobs;
import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class IndustryDataPojo {
	private Integer id;
	private String name;
	private Collection<User> userList = new ArrayList<User>();
	private Collection<Courses> courseList = new ArrayList<Courses>();
	private Collection<Jobs> jobsList = new ArrayList<Jobs>();

	public IndustryDataPojo(){
		
	}
	
	public IndustryDataPojo(Integer id, String name, Collection<User> userList, Collection<Courses> courseList, Collection<Jobs> jobsList){
		this.id = id;
		this.name = name;
		this.userList = userList;
		this.courseList = courseList;
		this.jobsList = jobsList;
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
