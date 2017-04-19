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
import javax.persistence.Table;

/**
 * @author Ankit_Nebula
 *
 */
@Entity
@Table (name = "companies")
public class Companies {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id", columnDefinition = "serial")
	private Integer id;
	private String company_name;
	private Double company_rating;
	private String company_industry;
	private String company_worth;
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="company_jobs",
			joinColumns=@JoinColumn(name="company_id"), 
			inverseJoinColumns=@JoinColumn(name="job_id")
	)
	private Collection<Jobs> jobsList = new ArrayList<Jobs>();
	
	@ManyToMany(fetch=FetchType.EAGER)
	@JoinTable(name="company_location",
			joinColumns=@JoinColumn(name="company_id"), 
			inverseJoinColumns=@JoinColumn(name="location_id")
	)
	private Collection<Locations> locationList = new ArrayList<Locations>();
	
	@ManyToMany(fetch = FetchType.EAGER, mappedBy = "companyList", cascade = CascadeType.ALL)
	private Collection<Experiences> experienceList = new ArrayList<Experiences>();
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getCompany_name() {
		return company_name;
	}
	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}
	public Double getCompany_rating() {
		return company_rating;
	}
	public void setCompany_rating(Double company_rating) {
		this.company_rating = company_rating;
	}
	public String getCompany_industry() {
		return company_industry;
	}
	public void setCompany_industry(String company_industry) {
		this.company_industry = company_industry;
	}
	public String getCompany_worth() {
		return company_worth;
	}
	public void setCompany_worth(String company_worth) {
		this.company_worth = company_worth;
	}
	public Collection<Locations> getLocationList() {
		return locationList;
	}
	public void setLocationList(Collection<Locations> locationList) {
		this.locationList = locationList;
	}
	public Collection<Experiences> getExperienceList() {
		return experienceList;
	}
	public void setExperienceList(Collection<Experiences> experienceList) {
		this.experienceList = experienceList;
	}
	public Collection<Jobs> getJobsList() {
		return jobsList;
	}
	public void setJobsList(Collection<Jobs> jobsList) {
		this.jobsList = jobsList;
	}
	
	
	
	
}
