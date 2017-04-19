/**
 * 
 */
package careers.nebula.ben.pojo.iws;

import java.util.ArrayList;
import java.util.Collection;
import javax.xml.bind.annotation.XmlRootElement;
import careers.nebula.ben.db.enitity.Coaches;
import careers.nebula.ben.db.enitity.Extracurricular;
import careers.nebula.ben.db.enitity.Highschool;
import careers.nebula.ben.db.enitity.Industry;
import careers.nebula.ben.db.enitity.Interests;
import careers.nebula.ben.db.enitity.Keywords;
import careers.nebula.ben.db.enitity.Languages;
import careers.nebula.ben.db.enitity.Qualification;
import careers.nebula.ben.db.enitity.Students;
/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class CoursesDataPojo {
	private Integer id;
	private String course_name;
	private String course_grade;
	private Double course_rating;
	private Collection<Highschool> highSchoolList = new ArrayList<Highschool>();
	private Collection<Qualification> qualificationList = new ArrayList<Qualification>();
	private Collection<Coaches> coachList = new ArrayList<Coaches>();
	private Collection<Students> studentsList = new ArrayList<Students>();
	private Collection<Industry> industryList = new ArrayList<Industry>();
	
	
	public CoursesDataPojo(){
		
	}
	
	public CoursesDataPojo(Integer id, String course_name, String course_grade, Double course_rating, Collection<Highschool> highschoolList, Collection<Qualification> qualificationList,  Collection<Students> studentList,Collection<Coaches> coachList, Collection<Industry> industryList){
		this.id = id;
		this.course_grade = course_grade;
		this.coachList = coachList;
		this.course_name = course_name;
		this.course_rating = course_rating;
		this.highSchoolList = highschoolList;
		this.qualificationList = qualificationList;
		this.studentsList = studentList;
		this.industryList = industryList;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCourse_name() {
		return course_name;
	}

	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}

	public String getCourse_grade() {
		return course_grade;
	}

	public void setCourse_grade(String course_grade) {
		this.course_grade = course_grade;
	}

	public Double getCourse_rating() {
		return course_rating;
	}

	public void setCourse_rating(Double course_rating) {
		this.course_rating = course_rating;
	}

	public Collection<Highschool> getHighSchoolList() {
		return highSchoolList;
	}

	public void setHighSchoolList(Collection<Highschool> highSchoolList) {
		this.highSchoolList = highSchoolList;
	}

	public Collection<Coaches> getCoachList() {
		return coachList;
	}

	public void setCoachList(Collection<Coaches> coachList) {
		this.coachList = coachList;
	}

	public Collection<Students> getStudentsList() {
		return studentsList;
	}

	public void setStudentsList(Collection<Students> studentsList) {
		this.studentsList = studentsList;
	}

	public Collection<Qualification> getQualificationList() {
		return qualificationList;
	}

	public void setQualificationList(Collection<Qualification> qualificationList) {
		this.qualificationList = qualificationList;
	}

	public Collection<Industry> getIndustryList() {
		return industryList;
	}

	public void setIndustryList(Collection<Industry> industryList) {
		this.industryList = industryList;
	}

}
