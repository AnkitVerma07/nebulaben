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
 * @author medlclouddev
 *
 */
@Entity
@Table (name = "surveys_taken")
public class AssestmentTaken {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	private Double score;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "assestmentTaken", cascade = CascadeType.ALL)
	private Assestment assestment;
	
	@OneToOne(fetch = FetchType.LAZY, mappedBy = "assestmentTaken", cascade = CascadeType.ALL)
	private User user;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="assestment_taken_answers",
			joinColumns=@JoinColumn(name="assestment_taken_id"), 
			inverseJoinColumns=@JoinColumn(name="answer_id")
	)
	private Collection<Answer> answersList = new ArrayList<Answer>();

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Double getScore() {
		return score;
	}

	public void setScore(Double score) {
		this.score = score;
	}

	public Assestment getAssestment() {
		return assestment;
	}

	public void setAssestment(Assestment assestment) {
		this.assestment = assestment;
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
