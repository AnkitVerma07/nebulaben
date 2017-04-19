/**
 * 
 */
package careers.nebula.ben.pojo.iws;

import java.util.ArrayList;
import java.util.Collection;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.Experiences;
import careers.nebula.ben.db.enitity.Jobs;
import careers.nebula.ben.db.enitity.Locations;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class CompaniesDataPojo {
	private Integer id;
	private String company_name;
	private Double company_rating;
	private String company_industry;
	private String company_worth;
	private Collection<Locations> locationList = new ArrayList<Locations>();
	private Collection<Experiences> experienceList = new ArrayList<Experiences>();
	private Collection<Jobs> jobsList = new ArrayList<Jobs>();
	
	public CompaniesDataPojo(){
		
	}
	
	public CompaniesDataPojo(Integer id, String company_name, Double company_rating, String company_industry, String company_worth, Collection<Locations> locationList, Collection<Experiences> experienceList, Collection<Jobs> jobsList ){
		this.id = id;
		this.company_name = company_name;
		this.company_industry = company_industry;
		this.company_rating = company_rating;
		this.company_worth = company_worth;
		this.locationList = locationList;
		this.experienceList = experienceList;
		this.jobsList = jobsList;
	}

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
