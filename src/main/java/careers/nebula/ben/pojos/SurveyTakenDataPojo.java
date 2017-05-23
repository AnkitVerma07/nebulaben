/**
 * 
 */
package careers.nebula.ben.pojos;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.pojo.iws.QuestionDataPojo;

/**
 * @author Ankit Verma
 *
 */
@XmlRootElement
public class SurveyTakenDataPojo {
		
	private Double time_taken;
	private String street_address1;
	private String street_address2;
	private String city;
	private String state;
	private String zipcode;
	private String country;
	
	private List<IntegerStringDataPojo> answersList = new ArrayList<IntegerStringDataPojo>();
	
	public SurveyTakenDataPojo() {
		
	}
	
	public SurveyTakenDataPojo( Double time_taken,String city, String state, String zipcode, String country, String street_address1, String street_address2, List<IntegerStringDataPojo> answersList) {
		this.time_taken = time_taken;
		this.street_address1 = street_address1;
		this.street_address2 = street_address2;
		this.city = city;
		this.state = state;
		this.country = country;
		this.zipcode = zipcode;
		this.answersList = answersList;
	}

	public Double getTime_taken() {
		return time_taken;
	}

	public void setTime_taken(Double time_taken) {
		this.time_taken = time_taken;
	}

	public String getStreet_address1() {
		return street_address1;
	}

	public void setStreet_address1(String street_address1) {
		this.street_address1 = street_address1;
	}

	public String getStreet_address2() {
		return street_address2;
	}

	public void setStreet_address2(String street_address2) {
		this.street_address2 = street_address2;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getZipcode() {
		return zipcode;
	}

	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public List<IntegerStringDataPojo> getAnswersList() {
		return answersList;
	}

	public void setAnswersList(List<IntegerStringDataPojo> answersList) {
		this.answersList = answersList;
	}
	
	

}
