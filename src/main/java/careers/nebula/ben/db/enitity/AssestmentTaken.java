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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Ankit Verma
 *
 */
@Entity
@Table (name = "assestments_taken")
public class AssestmentTaken {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	private Double score;
	private Double time_taken;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "assestmentTakenList", cascade = CascadeType.ALL)
	private Collection<Assestment> assestmentList = new ArrayList<Assestment>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "assestmentTakenList", cascade = CascadeType.ALL)
	private Collection<User> usersList = new ArrayList<User>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="assestment_taken_answers",
			joinColumns=@JoinColumn(name="assestment_taken_id"), 
			inverseJoinColumns=@JoinColumn(name="answer_id")
	)
	private Collection<Answer> answersList = new ArrayList<Answer>();
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="assestment_taken_location",
			joinColumns=@JoinColumn(name="assestment_taken_id"), 
			inverseJoinColumns=@JoinColumn(name="location_id")
	)
	private Collection<Locations> locationList = new ArrayList<Locations>();
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}



	public Collection<Assestment> getAssestmentList() {
		return assestmentList;
	}

	public void setAssestmentList(Collection<Assestment> assestmentList) {
		this.assestmentList = assestmentList;
	}

	public Collection<User> getUsersList() {
		return usersList;
	}

	public void setUsersList(Collection<User> usersList) {
		this.usersList = usersList;
	}

	public Collection<Answer> getAnswersList() {
		return answersList;
	}

	public void setAnswersList(Collection<Answer> answersList) {
		this.answersList = answersList;
	}

	public Double getTime_taken() {
		return time_taken;
	}

	public void setTime_taken(Double time_taken) {
		this.time_taken = time_taken;
	}

	public Collection<Locations> getLocationList() {
		return locationList;
	}

	public void setLocationList(Collection<Locations> locationList) {
		this.locationList = locationList;
	}
	
}
