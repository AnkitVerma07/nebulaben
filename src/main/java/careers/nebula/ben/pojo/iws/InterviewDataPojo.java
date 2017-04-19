/**
 * 
 */
package careers.nebula.ben.pojo.iws;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.Jobs;
import careers.nebula.ben.db.enitity.Question;
import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class InterviewDataPojo {
	private Integer id;
	private Double difficulty;
	private Double rating;
	private Collection<Jobs> jobsList = new ArrayList<Jobs>();
	private Collection<User> userList = new ArrayList<User>();
	private Collection<Question> questionList = new ArrayList<Question>();
	
	public InterviewDataPojo(){
		
	}
	
	public InterviewDataPojo(Integer id, Double difficulty, Double rating, Collection<Jobs> jobsList , Collection<User> userList, Collection<Question> questionList){
		this.id = id;
		this.difficulty = difficulty;
		this.rating = rating;
		this.jobsList = jobsList;
		this.userList = userList;
		this.questionList = questionList;
	}

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
