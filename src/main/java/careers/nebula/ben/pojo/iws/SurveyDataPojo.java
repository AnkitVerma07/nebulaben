package careers.nebula.ben.pojo.iws;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.Question;
import careers.nebula.ben.db.enitity.SurveyTaken;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class SurveyDataPojo {
	
	private Integer id;
	private String title;
	private String description;
	private String source;
	private Double time_limit;
	private Double expected_time;
	//private Collection<SurveyTaken> surveyTakenList = new ArrayList<SurveyTaken>();
	private Collection<QuestionDataPojo> questionList = new ArrayList<QuestionDataPojo>();

	
	public SurveyDataPojo() {
		
	}
	
	public SurveyDataPojo(Integer id, String title, String description, String source, Double time_limit, Double expected_time, Collection<SurveyTaken> surveyTakenList, Collection<QuestionDataPojo> questionList) {
		this.id = id;
		this.title = title;
		this.description = description;
		this.source = source;
		this.time_limit = time_limit;
		this.expected_time = expected_time;
	//	this.surveyTakenList = surveyTakenList;
		this.questionList = questionList;
	}

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


//
//	public Collection<SurveyTaken> getSurveyTakenList() {
//		return surveyTakenList;
//	}
//
//	public void setSurveyTakenList(Collection<SurveyTaken> surveyTakenList) {
//		this.surveyTakenList = surveyTakenList;
//	}

	public Collection<QuestionDataPojo> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(Collection<QuestionDataPojo> questionList) {
		this.questionList = questionList;
	}
	
	
	
	
	
}
