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
@Table (name = "interviews")
public class Interview {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	private Double difficulty;
	private Double rating;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "interviewList", cascade = CascadeType.ALL)
	private Collection<Jobs> jobsList = new ArrayList<Jobs>();
	
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "userInterviews", cascade = CascadeType.ALL)
	private Collection<User> userList = new ArrayList<User>();
	
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="interview_questions",
			joinColumns=@JoinColumn(name="interview_id"), 
			inverseJoinColumns=@JoinColumn(name="questions_id")
	)
	private Collection<Question> questionList = new ArrayList<Question>();


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Double getDifficulty() {
		return difficulty;
	}


	public void setDifficulty(Double difficulty) {
		this.difficulty = difficulty;
	}


	public Double getRating() {
		return rating;
	}


	public void setRating(Double rating) {
		this.rating = rating;
	}


	public Collection<Jobs> getJobsList() {
		return jobsList;
	}


	public void setJobsList(Collection<Jobs> jobsList) {
		this.jobsList = jobsList;
	}


	public Collection<User> getUserList() {
		return userList;
	}


	public void setUserList(Collection<User> userList) {
		this.userList = userList;
	}


	public Collection<Question> getQuestionList() {
		return questionList;
	}


	public void setQuestionList(Collection<Question> questionList) {
		this.questionList = questionList;
	}
	
	
	
}
