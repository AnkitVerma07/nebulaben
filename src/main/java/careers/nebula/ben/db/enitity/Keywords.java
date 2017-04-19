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
@Table (name = "keywords")
public class Keywords {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	private String name;
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "keywordList", cascade = CascadeType.ALL)
	private Collection<User> userList = new ArrayList<User>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "keywordList", cascade = CascadeType.ALL)
	private Collection<Jobs> jobsList = new ArrayList<Jobs>();
	
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
	public Collection<Jobs> getJobsList() {
		return jobsList;
	}
	public void setJobsList(Collection<Jobs> jobsList) {
		this.jobsList = jobsList;
	}
	
	
}
