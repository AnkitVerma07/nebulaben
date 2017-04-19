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
	private String answer;
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "questionList", cascade = CascadeType.ALL)
	private Collection<Interview> interviewList = new ArrayList<Interview>();

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
