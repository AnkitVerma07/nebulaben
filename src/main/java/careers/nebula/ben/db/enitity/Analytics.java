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
 * @author Ankit_Nebul
 *
 */
@Entity
@Table (name = "analytics")
public class Analytics {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	private Integer user_profile_viewed;
	private Integer user_comparePeers_used;
	private Integer user_SuggestCourse_used;
	private Integer user_login_count;

	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "analyticsList", cascade = CascadeType.ALL)
	private Collection<User> userList = new ArrayList<User>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getUser_profile_viewed() {
		return user_profile_viewed;
	}

	public void setUser_profile_viewed(Integer user_profile_viewed) {
		this.user_profile_viewed = user_profile_viewed;
	}

	public Integer getUser_comparePeers_used() {
		return user_comparePeers_used;
	}

	public void setUser_comparePeers_used(Integer user_comparePeers_used) {
		this.user_comparePeers_used = user_comparePeers_used;
	}

	public Integer getUser_SuggestCourse_used() {
		return user_SuggestCourse_used;
	}

	public void setUser_SuggestCourse_used(Integer user_SuggestCourse_used) {
		this.user_SuggestCourse_used = user_SuggestCourse_used;
	}

	public Integer getUser_login_count() {
		return user_login_count;
	}

	public void setUser_login_count(Integer user_login_count) {
		this.user_login_count = user_login_count;
	}

	public Collection<User> getUserList() {
		return userList;
	}

	public void setUserList(Collection<User> userList) {
		this.userList = userList;
	}	
	
}
