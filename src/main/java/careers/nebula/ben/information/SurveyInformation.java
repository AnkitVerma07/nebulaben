/**
 * 
 */
package careers.nebula.ben.information;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import careers.nebula.ben.db.enitity.Answer;
import careers.nebula.ben.db.enitity.Locations;
import careers.nebula.ben.db.enitity.Question;
import careers.nebula.ben.db.enitity.Survey;
import careers.nebula.ben.db.enitity.SurveyTaken;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.db.repository.AnswerRepo;
import careers.nebula.ben.db.repository.AssestmentRepo;
import careers.nebula.ben.db.repository.LocationRepo;
import careers.nebula.ben.db.repository.QuestionRepo;
import careers.nebula.ben.db.repository.SurveyRepo;
import careers.nebula.ben.db.repository.SurveyTakenRepo;
import careers.nebula.ben.db.repository.UserRepo;
import careers.nebula.ben.pojo.iws.QuestionDataPojo;
import careers.nebula.ben.pojo.iws.SurveyDataPojo;
import careers.nebula.ben.pojo.iws.UserDataPojo;
import careers.nebula.ben.pojos.IntegerStringDataPojo;
import careers.nebula.ben.pojos.QuestionArrayDataPojo;
import careers.nebula.ben.pojos.SurveyTakenDataPojo;
import careers.nebula.ben.service.HelperMethods;

/**
 * @author Ankit Verma
 *
 */
public class SurveyInformation {

	private Survey surveyEntity;
	private Locations locationEntity;
	private Question questionEntity;
	private HelperMethods methods;
	private SurveyRepo surveyRepo;
	private LocationRepo locationRepo;
	private QuestionRepo questionRepo;
	private SurveyDataPojo surveyPojo;
	private SurveyTaken surveyTakenEntity;
	private SurveyTakenRepo surveyTakenRepo;
	private UserRepo userRepo;
	private User userEntity;
	private Answer answerEntity;
	private AnswerRepo answerRepo;
	private QuestionDataPojo questionPojo;
	
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
		List<Question> questionList = (List<Question>) surveyEntity.getQuestionList();
		List<QuestionDataPojo> questionPojoList = new ArrayList<QuestionDataPojo>();		
		List<String> questionClusterList = new ArrayList<String>();
		questionClusterList.add("demographic");
		questionClusterList.add("NPS");
		questionClusterList.add("careerProgression");
		questionClusterList.add("resourcesNtraining");
		questionClusterList.add("team");
		questionClusterList.add("culture");
		questionClusterList.add("ethicsNvaluesNdiversity");
		questionClusterList.add("recognitionNsenseOfInfluence");
		questionClusterList.add("communication");
		questionClusterList.add("tenure");
		questionClusterList.add("clarity");
		questionClusterList.add("work");
		questionClusterList.add("process");
		questionClusterList.add("organization");
		questionClusterList.add("department");
		questionClusterList.add("job");
		questionClusterList.add("rapport");
		questionClusterList.add("overall");
		for( Question q : questionList){
			questionPojo = new QuestionDataPojo();
			questionPojo.setId(q.getId());
			questionPojo.setQuestion(q.getQuestion());
			questionPojo.setType(q.getType());
			questionPojo.setCharge(q.getCharge());
			questionPojo.setCluster(q.getCluster());
			questionPojo.setChoices(q.getChoices());
			questionPojoList.add(questionPojo);
		}
		Collections.sort(questionPojoList, new Comparator<QuestionDataPojo>(){
		       public int compare(QuestionDataPojo q1, QuestionDataPojo q2){
		          return questionClusterList.indexOf(q1.getCluster()) - questionClusterList.indexOf(q2.getCluster());
		       }
		    });
		Collections.sort(questionPojoList, new Comparator<QuestionDataPojo>(){
		       public int compare(QuestionDataPojo q1, QuestionDataPojo q2){
		          return q1.getId().compareTo(q2.getId());
		       }
		    });
		surveyPojo.setQuestionList(questionPojoList);
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
			questionEntity.setCharge(questionPojo.getCharge());
			questionEntity.setCluster(questionPojo.getCluster());
			questionEntity.setChoices(questionPojo.getChoices());
			questionRepo = new QuestionRepo();
			questionRepo.insertQuestion(questionEntity);
			surveyEntity.getQuestionList().add(questionEntity);
		}
		surveyRepo = new SurveyRepo();
		surveyRepo.updateSurveyById(surveyEntity);
		return returnObject;
	}
	
	public SurveyTaken addSurveyTaken(int userId, int surveyId, SurveyTakenDataPojo surveyTakenData){	
		surveyRepo = new SurveyRepo();
		surveyEntity = new Survey();
		surveyEntity = surveyRepo.getSurveyById(surveyId);
		userRepo = new UserRepo();
		userEntity = new User();
		userEntity = userRepo.getUserData(userId);
		surveyTakenEntity = new SurveyTaken();
		surveyTakenEntity.setTime_taken(surveyTakenData.getTime_taken());
		userEntity.getSurveyTakenList().add(surveyTakenEntity);
		surveyEntity.getSurveyTakenList().add(surveyTakenEntity);
		surveyTakenRepo = new SurveyTakenRepo();
		surveyTakenRepo.insertSurveyTaken(surveyTakenEntity,userEntity, surveyEntity);
		locationEntity = new Locations();
		locationEntity.setStreet_address1(surveyTakenData.getStreet_address1());
		locationEntity.setStreet_address2(surveyTakenData.getStreet_address2());
		locationEntity.setCity(surveyTakenData.getCity());
		locationEntity.setCountry(surveyTakenData.getCountry());
		locationEntity.setState(surveyTakenData.getState());
		locationEntity.setZipcode(surveyTakenData.getZipcode());
		surveyTakenEntity.getLocationList().add(locationEntity);
		locationRepo = new LocationRepo();
		locationRepo.insertSurveyTakenLocation(surveyTakenEntity, locationEntity);
		for(IntegerStringDataPojo twoStringPojo: surveyTakenData.getAnswersList()){
			questionEntity = new Question();
			questionRepo = new QuestionRepo();
			questionEntity = questionRepo.getQuestionById(twoStringPojo.getI());
			answerEntity.setText(twoStringPojo.getS());
			answerEntity.getQuestionList().add(questionEntity);
			surveyTakenEntity.getAnswersList().add(answerEntity);
			answerRepo = new AnswerRepo();
			answerRepo.insertAnswer(answerEntity, surveyTakenEntity);
		}
		surveyTakenEntity = new SurveyTaken();
		surveyTakenRepo = new SurveyTakenRepo();
		surveyTakenEntity = surveyTakenRepo.getSurveyTakenById(surveyId);
		return surveyTakenEntity;
	}
	

	
	
}
