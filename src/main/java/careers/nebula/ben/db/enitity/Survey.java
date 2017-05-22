/**
 * 
 */
package careers.nebula.ben.db.enitity;

import java.util.ArrayList;
import java.util.Collection;

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
@Table (name = "surveys")
public class Survey {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	private String title;
	private String description;
	private String source;
	private Double time_limit;
	private Double expected_time;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="survey_surveys_taken",
			joinColumns=@JoinColumn(name="survey_id"), 
			inverseJoinColumns=@JoinColumn(name="survey_taken_id")
	)
	private Collection<SurveyTaken> surveyTakenList = new ArrayList<SurveyTaken>();

	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="survey_questions",
			joinColumns=@JoinColumn(name="survey_id"), 
			inverseJoinColumns=@JoinColumn(name="question_id")
	)
	private Collection<Question> questionList = new ArrayList<Question>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public Double getTime_limit() {
		return time_limit;
	}

	public void setTime_limit(Double time_limit) {
		this.time_limit = time_limit;
	}

	public Double getExpected_time() {
		return expected_time;
	}

	public void setExpected_time(Double expected_time) {
		this.expected_time = expected_time;
	}


	public Collection<SurveyTaken> getSurveyTakenList() {
		return surveyTakenList;
	}

	public void setSurveyTakenList(Collection<SurveyTaken> surveyTakenList) {
		this.surveyTakenList = surveyTakenList;
	}

	public Collection<Question> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(Collection<Question> questionList) {
		this.questionList = questionList;
	}
	
	
}
