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
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Ankit Verma
 *
 */
@Entity
@Table (name = "questions")
public class Answer {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	private String text;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="answered_questions",
			joinColumns=@JoinColumn(name="answer_id"), 
			inverseJoinColumns=@JoinColumn(name="question_id")
	)
	private Collection<Question> questionList = new ArrayList<Question>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "answersList", cascade = CascadeType.ALL)
	private Collection<SurveyTaken> surveyTakenList = new ArrayList<SurveyTaken>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "answersList", cascade = CascadeType.ALL)
	private Collection<AssestmentTaken> assestmentTakenList = new ArrayList<AssestmentTaken>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Collection<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(Collection<Question> questionList) {
		this.questionList = questionList;
	}

	public Collection<SurveyTaken> getSurveyTakenList() {
		return surveyTakenList;
	}

	public void setSurveyTakenList(Collection<SurveyTaken> surveyTakenList) {
		this.surveyTakenList = surveyTakenList;
	}

	public Collection<AssestmentTaken> getAssestmentTakenList() {
		return assestmentTakenList;
	}

	public void setAssestmentTakenList(Collection<AssestmentTaken> assestmentTakenList) {
		this.assestmentTakenList = assestmentTakenList;
	}
	
	
}
