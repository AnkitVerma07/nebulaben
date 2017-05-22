/**
 * 
 */
package careers.nebula.ben.information;

import java.util.List;

import careers.nebula.ben.db.enitity.Question;
import careers.nebula.ben.db.enitity.Survey;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.db.repository.QuestionRepo;
import careers.nebula.ben.db.repository.SurveyRepo;
import careers.nebula.ben.db.repository.UserRepo;
import careers.nebula.ben.pojo.iws.QuestionDataPojo;
import careers.nebula.ben.pojo.iws.SurveyDataPojo;
import careers.nebula.ben.pojo.iws.UserDataPojo;
import careers.nebula.ben.pojos.QuestionArrayDataPojo;
import careers.nebula.ben.service.HelperMethods;

/**
 * @author Ankit Verma
 *
 */
public class SurveyInformation {

	private Survey surveyEntity;
	private Question questionEntity;
	private HelperMethods methods;
	private SurveyRepo surveyRepo;
	private QuestionRepo questionRepo;
	private SurveyDataPojo surveyPojo;
	
	
	public Survey addSurvey(SurveyDataPojo surveyData){	
		surveyEntity = new Survey();
		surveyEntity.setTitle(surveyData.getTitle());
		surveyEntity.setDescription(surveyData.getDescription());
		surveyEntity.setSource(surveyData.getSource());
		surveyEntity.setTime_limit(surveyData.getTime_limit());
		surveyEntity.setExpected_time(surveyData.getExpected_time());
		surveyRepo = new SurveyRepo();
		surveyRepo.insertSurvey(surveyEntity);
		return surveyEntity;
	}

	public SurveyDataPojo grabSurveyById(int id) {
		surveyRepo = new SurveyRepo();
		surveyEntity = new Survey();
		surveyPojo = new SurveyDataPojo();
		surveyEntity = surveyRepo.getSurveyById(id);
		surveyPojo.setId(surveyEntity.getId());
		surveyPojo.setTitle(surveyEntity.getTitle());
		surveyPojo.setDescription(surveyEntity.getDescription());
		surveyPojo.setSource(surveyEntity.getSource());
		surveyPojo.setTime_limit(surveyEntity.getTime_limit());
		surveyPojo.setExpected_time(surveyEntity.getExpected_time());
		surveyPojo.setQuestionList(surveyEntity.getQuestionList());
		return surveyPojo;
	}
	
	
	public Survey changeSurvey(SurveyDataPojo surveyData){
		surveyRepo = new SurveyRepo();
		surveyEntity = new Survey();
		surveyPojo = new SurveyDataPojo();
		int id = surveyData.getId();	
		surveyEntity = surveyRepo.getSurveyById(id);	
		if(surveyData.getTitle() == null){
			surveyEntity.setTitle(surveyEntity.getTitle());
		} else {
			surveyEntity.setTitle(surveyData.getTitle());
		}
		if(surveyData.getDescription() == null){
			surveyEntity.setDescription(surveyEntity.getDescription());
		} else {
			surveyEntity.setDescription(surveyData.getDescription());
		}
		if(surveyData.getSource() == null){
			surveyEntity.setSource(surveyEntity.getSource());
		} else {
			surveyEntity.setSource(surveyData.getSource());
		}
		if(surveyData.getExpected_time() == null){
			surveyEntity.setExpected_time(surveyEntity.getExpected_time());
		} else {
			surveyEntity.setExpected_time(surveyData.getExpected_time());
		}
		if(surveyData.getTime_limit() == null){
			surveyEntity.setTime_limit(surveyEntity.getTime_limit());
		} else {
			surveyEntity.setTime_limit(surveyData.getTime_limit());
		}
		surveyRepo = new SurveyRepo();
		surveyRepo.updateSurveyById(surveyEntity);
		return surveyEntity;
	}
	
	
	public QuestionArrayDataPojo addSurveyQuestions(int surveyId, QuestionArrayDataPojo questionsArray){	
		surveyRepo = new SurveyRepo();
		surveyEntity = new Survey();
		surveyPojo = new SurveyDataPojo();
		surveyEntity = surveyRepo.getSurveyById(surveyId);
		List<QuestionDataPojo> questionsList = questionsArray.getQuestionList();
		QuestionArrayDataPojo returnObject = new QuestionArrayDataPojo();
		for(QuestionDataPojo questionPojo: questionsList){
			questionEntity = new Question();
			questionEntity.setQuestion(questionPojo.getQuestion());
			questionEntity.setType(questionPojo.getType());
			questionEntity.setChoices(questionPojo.getChoices());
			surveyEntity.getQuestionList().add(questionEntity);
			questionRepo = new QuestionRepo();
			questionRepo.insertQuestion(surveyEntity, questionEntity);
		}
		return returnObject;
	}
	

	
	
}
