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
@Table (name = "surveys_taken")
public class SurveyTaken {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	private Double time_taken;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "surveyTaken", cascade = CascadeType.ALL)
	private Survey survey;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "surveyTaken", cascade = CascadeType.ALL)
	private User user;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="survey_taken_answers",
			joinColumns=@JoinColumn(name="survey_taken_id"), 
			inverseJoinColumns=@JoinColumn(name="answer_id")
	)
	private Collection<Answer> answersList = new ArrayList<Answer>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getTime_taken() {
		return time_taken;
	}

	public void setTime_taken(Double time_taken) {
		this.time_taken = time_taken;
	}

	public Survey getSurvey() {
		return survey;
	}

	public void setSurvey(Survey survey) {
		this.survey = survey;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Collection<Answer> getAnswersList() {
		return answersList;
	}

	public void setAnswersList(Collection<Answer> answersList) {
		this.answersList = answersList;
	}

	
}
