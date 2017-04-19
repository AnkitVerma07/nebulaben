/**
 * 
 */
package careers.nebula.ben.pojo.iws;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.Interview;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class QuestionDataPojo {
	private Integer id;
	private String question;
	private String answer;
	private Collection<Interview> interviewList = new ArrayList<Interview>();
	
	public QuestionDataPojo(){
		
	}
	
	public QuestionDataPojo(Integer id, String question, String answer, Collection<Interview> interviewList){
		this.id = id;
		this.question = question;
		this.answer = answer;
		this.interviewList = interviewList;
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

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public Collection<Interview> getInterviewList() {
		return interviewList;
	}

	public void setInterviewList(Collection<Interview> interviewList) {
		this.interviewList = interviewList;
	}
	
	
}
