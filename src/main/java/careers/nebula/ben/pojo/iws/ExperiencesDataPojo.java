/**
 * 
 */
package careers.nebula.ben.pojo.iws;

import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;
import careers.nebula.ben.db.enitity.Companies;
import careers.nebula.ben.db.enitity.User;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class ExperiencesDataPojo {
	private Integer id;
	private String job_title;
	private String job_responsibilities;
	private Double time_spent;
	private Double manager_rating;
	private Double experience_rating;
	private String start_date;
	private String end_date;
	private Double hourly_rate;
	private Boolean most_recent;
	private Collection<Companies> companyList = new ArrayList<Companies>();
	private Collection<User> userList = new ArrayList<User>();
	
	public ExperiencesDataPojo(){
		
	}
	
	public ExperiencesDataPojo(Integer id, String job_title, Boolean most_recent, String job_responsibilities, Double time_spent, Double hourly_rate, Double manager_rating, Double experience_rating, String start_date, String end_date, Collection<Companies> companyList, Collection<User> userList){
		this.id = id;
		this.job_responsibilities = job_responsibilities;
		this.most_recent = most_recent;
		this.job_title = job_title;
		this.hourly_rate = hourly_rate;
		this.time_spent = time_spent;
		this.start_date = start_date;
		this.end_date = end_date;
		this.companyList = companyList;
		this.userList = userList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getJob_responsibilities() {
		return job_responsibilities;
	}

	public void setJob_responsibilities(String job_responsibilities) {
		this.job_responsibilities = job_responsibilities;
	}

	public Double getTime_spent() {
		return time_spent;
	}

	public void setTime_spent(Double time_spent) {
		this.time_spent = time_spent;
	}

	public Double getManager_rating() {
		return manager_rating;
	}

	public void setManager_rating(Double manager_rating) {
		this.manager_rating = manager_rating;
	}

	public Double getExperience_rating() {
		return experience_rating;
	}

	public void setExperience_rating(Double experience_rating) {
		this.experience_rating = experience_rating;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public Collection<Companies> getCompanyList() {
		return companyList;
	}

	public void setCompanyList(Collection<Companies> companyList) {
		this.companyList = companyList;
	}

	public Collection<User> getUserList() {
		return userList;
	}

	public void setUserList(Collection<User> userList) {
		this.userList = userList;
	}

	public Double getHourly_rate() {
		return hourly_rate;
	}

	public void setHourly_rate(Double hourly_rate) {
		this.hourly_rate = hourly_rate;
	}

	public Boolean getMost_recent() {
		return most_recent;
	}

	public void setMost_recent(Boolean most_recent) {
		this.most_recent = most_recent;
	}
	
	
}
