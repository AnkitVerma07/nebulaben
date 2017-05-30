/**
 * 
 */
package careers.nebula.ben.pojo.iws;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.Answer;
import careers.nebula.ben.db.enitity.Assestment;
import careers.nebula.ben.db.enitity.Interview;
import careers.nebula.ben.db.enitity.Survey;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class QuestionDataPojo {
	private Integer id;
	private String question;
	private String type;
	private ArrayList<String> choices;
	private Collection<Interview> interviewList = new ArrayList<Interview>();
	private Collection<Answer> answersList = new ArrayList<Answer>();
	private Collection<Survey> surveyList = new ArrayList<Survey>();
	private Collection<Assestment> assestmentList = new ArrayList<Assestment>();
	private String cluster;
	private Boolean charge;//positive or negative

	
	public QuestionDataPojo(){
		
	}
	
	public QuestionDataPojo(Integer id, String question, String cluster, Boolean charge, String type, Collection<Interview> interviewList, ArrayList<String> choices, Collection<Answer> answersList, Collection<Survey> surveyList, Collection<Assestment> assestmentList){
		this.id = id;
		this.question = question;
		this.cluster = cluster;
		this.charge = charge;
		this.type = type;
		this.interviewList = interviewList;
		this.choices = choices;
		this.answersList = answersList;
		this.surveyList = surveyList;
		this.assestmentList = assestmentList;
	}

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

	public Collection<Interview> getInterviewList() {
		return interviewList;
	}

	public void setInterviewList(Collection<Interview> interviewList) {
		this.interviewList = interviewList;
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
