package careers.nebula.ben.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.Question;
import careers.nebula.ben.pojo.iws.QuestionDataPojo;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class QuestionArrayDataPojo {

	
	private List<QuestionDataPojo> questionList = new ArrayList<QuestionDataPojo>();
	
	public QuestionArrayDataPojo() {
		
	}
	
	public QuestionArrayDataPojo(List<QuestionDataPojo> questionList) {
		this.questionList = questionList;
	}

	public List<QuestionDataPojo> getQuestionList() {
		return questionList;
	}

	public void setQuestionList(List<QuestionDataPojo> questionList) {
		this.questionList = questionList;
	}
	
	
	
}
