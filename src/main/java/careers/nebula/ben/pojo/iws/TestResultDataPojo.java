/**
 * 
 */
package careers.nebula.ben.pojo.iws;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class TestResultDataPojo {

	private Integer id; 
	private Integer highschool_SAT;
	private Integer highschool_ACT;
	private Integer college_CLEP;
	private Integer postgrad_GMAT;
	private Integer postgrad_MCAT;
	private Integer postgrad_LSAT;
	private Integer postgrad_GRE;
	private Collection<User> userList = new ArrayList<User>();
	
	public TestResultDataPojo(){
		
	}
	
	public TestResultDataPojo(Integer id, Integer highschool_SAT, Integer highschool_ACT, Integer college_CLEP, Integer postgrad_GMAT, Integer postgrad_MCAT, Integer postgrad_LSAT, Integer postgrad_GRE, Collection<User> userList){
		this.id = id;
		this.highschool_SAT = highschool_ACT;
		this.highschool_ACT = highschool_ACT;
		this.college_CLEP = college_CLEP;
		this.postgrad_GMAT = postgrad_GMAT;
		this.postgrad_GRE = postgrad_GRE;
		this.postgrad_LSAT = postgrad_LSAT;
		this.postgrad_MCAT = postgrad_MCAT;
		this.postgrad_GMAT = postgrad_GMAT;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getHighschool_SAT() {
		return highschool_SAT;
	}

	public void setHighschool_SAT(Integer highschool_SAT) {
		this.highschool_SAT = highschool_SAT;
	}

	public Integer getHighschool_ACT() {
		return highschool_ACT;
	}

	public void setHighschool_ACT(Integer highschool_ACT) {
		this.highschool_ACT = highschool_ACT;
	}

	public Integer getCollege_CLEP() {
		return college_CLEP;
	}

	public void setCollege_CLEP(Integer college_CLEP) {
		this.college_CLEP = college_CLEP;
	}

	public Integer getPostgrad_GMAT() {
		return postgrad_GMAT;
	}

	public void setPostgrad_GMAT(Integer postgrad_GMAT) {
		this.postgrad_GMAT = postgrad_GMAT;
	}

	public Integer getPostgrad_MCAT() {
		return postgrad_MCAT;
	}

	public void setPostgrad_MCAT(Integer postgrad_MCAT) {
		this.postgrad_MCAT = postgrad_MCAT;
	}

	public Integer getPostgrad_LSAT() {
		return postgrad_LSAT;
	}

	public void setPostgrad_LSAT(Integer postgrad_LSAT) {
		this.postgrad_LSAT = postgrad_LSAT;
	}

	public Integer getPostgrad_GRE() {
		return postgrad_GRE;
	}

	public void setPostgrad_GRE(Integer postgrad_GRE) {
		this.postgrad_GRE = postgrad_GRE;
	}

	public Collection<User> getUserList() {
		return userList;
	}

	public void setUserList(Collection<User> userList) {
		this.userList = userList;
	}
	
	
}
