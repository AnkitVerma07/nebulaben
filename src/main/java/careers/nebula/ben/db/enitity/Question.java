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
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Ankit_Nebula
 *
 */
@Entity
@Table (name = "questions")
public class Question {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	private String question;
	private String type;  
	private ArrayList<String> choices;
	private String cluster;
	private Boolean charge;//positive or negative
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "questionList", cascade = CascadeType.ALL)
	private Collection<Answer> answersList = new ArrayList<Answer>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "questionList", cascade = CascadeType.ALL)
	private Collection<Interview> interviewList = new ArrayList<Interview>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "questionList", cascade = CascadeType.ALL)
	private Collection<Survey> surveyList = new ArrayList<Survey>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "questionList", cascade = CascadeType.ALL)
	private Collection<Assestment> assestmentList = new ArrayList<Assestment>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public Collection<Interview> getInterviewList() {
		return interviewList;
	}

	public void setInterviewList(Collection<Interview> interviewList) {
		this.interviewList = interviewList;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public ArrayList<String> getChoices() {
		return choices;
	}

	public void setChoices(ArrayList<String> choices) {
		this.choices = choices;
	}

	public Collection<Answer> getAnswersList() {
		return answersList;
	}

	public void setAnswersList(Collection<Answer> answersList) {
		this.answersList = answersList;
	}

	public Collection<Survey> getSurveyList() {
		return surveyList;
	}

	public void setSurveyList(Collection<Survey> surveyList) {
		this.surveyList = surveyList;
	}

	public Collection<Assestment> getAssestmentList() {
		return assestmentList;
	}

	public void setAssestmentList(Collection<Assestment> assestmentList) {
		this.assestmentList = assestmentList;
	}

	public String getCluster() {
		return cluster;
	}

	public void setCluster(String cluster) {
		this.cluster = cluster;
	}

	public Boolean getCharge() {
		return charge;
	}

	public void setCharge(Boolean charge) {
		this.charge = charge;
	}

	
}
