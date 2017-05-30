/**
 * 
 */
package careers.nebula.ben.information;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import careers.nebula.ben.db.enitity.Answer;
import careers.nebula.ben.db.enitity.Assestment;
import careers.nebula.ben.db.enitity.AssestmentTaken;
import careers.nebula.ben.db.enitity.Locations;
import careers.nebula.ben.db.enitity.Question;
import careers.nebula.ben.db.enitity.Survey;
import careers.nebula.ben.db.enitity.SurveyTaken;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.db.repository.AnswerRepo;
import careers.nebula.ben.db.repository.AssestmentRepo;
import careers.nebula.ben.db.repository.AssestmentTakenRepo;
import careers.nebula.ben.db.repository.LocationRepo;
import careers.nebula.ben.db.repository.QuestionRepo;
import careers.nebula.ben.db.repository.SurveyRepo;
import careers.nebula.ben.db.repository.SurveyTakenRepo;
import careers.nebula.ben.db.repository.UserRepo;
import careers.nebula.ben.pojo.iws.AssestmentDataPojo;
import careers.nebula.ben.pojo.iws.QuestionDataPojo;
import careers.nebula.ben.pojo.iws.SurveyDataPojo;
import careers.nebula.ben.pojos.IntegerStringDataPojo;
import careers.nebula.ben.pojos.QuestionArrayDataPojo;
import careers.nebula.ben.pojos.SurveyTakenDataPojo;
import careers.nebula.ben.service.HelperMethods;

/**
 * @author Ankit Verma
 *
 */
public class AssestmentInformation {

	private Assestment assestmentEntity;
	private Locations locationEntity;
	private Question questionEntity;
	private HelperMethods methods;
	private AssestmentRepo assestmentRepo;
	private LocationRepo locationRepo;
	private QuestionRepo questionRepo;
	private AssestmentDataPojo assestmentPojo;
	private QuestionDataPojo questionPojo;
	private AssestmentTaken assestmentTakenEntity;
	private AssestmentTakenRepo assestmentTakenRepo;
	private UserRepo userRepo;
	private User userEntity;
	private Answer answerEntity;
	private AnswerRepo answerRepo;
	
	public Assestment addAssestment(AssestmentDataPojo assestmentData){	
		assestmentEntity = new Assestment();
		assestmentEntity.setTitle(assestmentData.getTitle());
		assestmentEntity.setDescription(assestmentData.getDescription());
		assestmentEntity.setSource(assestmentData.getSource());
		assestmentEntity.setTime_limit(assestmentData.getTime_limit());
		assestmentEntity.setExpected_time(assestmentData.getExpected_time());
		assestmentRepo = new AssestmentRepo();
		assestmentRepo.insertAssestment(assestmentEntity);
		return assestmentEntity;
	}

	public AssestmentDataPojo grabAssestmentById(int id) {
		assestmentRepo = new AssestmentRepo();
		assestmentEntity = new Assestment();
		assestmentPojo = new AssestmentDataPojo();
		assestmentEntity = assestmentRepo.getassestmentById(id);
		assestmentPojo.setId(assestmentEntity.getId());
		assestmentPojo.setTitle(assestmentEntity.getTitle());
		assestmentPojo.setDescription(assestmentEntity.getDescription());
		assestmentPojo.setSource(assestmentEntity.getSource());
		assestmentPojo.setTime_limit(assestmentEntity.getTime_limit());
		assestmentPojo.setExpected_time(assestmentEntity.getExpected_time());
		Collection<Question> questionList = assestmentEntity.getQuestionList();
		Collection<QuestionDataPojo> questionPojoList = new ArrayList<QuestionDataPojo>();
		for( Question q : questionList){
			questionPojo = new QuestionDataPojo();
			questionPojo.setId(q.getId());
			questionPojo.setQuestion(q.getQuestion());
			questionPojo.setType(q.getType());
			questionPojoList.add(questionPojo);
		}
		assestmentPojo.setQuestionList(questionPojoList);
		return assestmentPojo;
	}
	
	
	public Assestment changeAssestment(AssestmentDataPojo assestmentData){
		assestmentRepo = new AssestmentRepo();
		assestmentEntity = new Assestment();
		assestmentPojo = new AssestmentDataPojo();
		int id = assestmentData.getId();	
		assestmentEntity = assestmentRepo.getassestmentById(id);	
		if(assestmentData.getTitle() == null){
			assestmentEntity.setTitle(assestmentEntity.getTitle());
		} else {
			assestmentEntity.setTitle(assestmentData.getTitle());
		}
		if(assestmentData.getDescription() == null){
			assestmentEntity.setDescription(assestmentEntity.getDescription());
		} else {
			assestmentEntity.setDescription(assestmentData.getDescription());
		}
		if(assestmentData.getSource() == null){
			assestmentEntity.setSource(assestmentEntity.getSource());
		} else {
			assestmentEntity.setSource(assestmentData.getSource());
		}
		if(assestmentData.getExpected_time() == null){
			assestmentEntity.setExpected_time(assestmentEntity.getExpected_time());
		} else {
			assestmentEntity.setExpected_time(assestmentData.getExpected_time());
		}
		if(assestmentData.getTime_limit() == null){
			assestmentEntity.setTime_limit(assestmentEntity.getTime_limit());
		} else {
			assestmentEntity.setTime_limit(assestmentData.getTime_limit());
		}
		assestmentRepo = new AssestmentRepo();
		assestmentRepo.updateAssestmentById(assestmentEntity);
		return assestmentEntity;
	}
	
	
	public QuestionArrayDataPojo addAssestmentQuestions(int assestmentId, QuestionArrayDataPojo questionsArray){	
		assestmentRepo = new AssestmentRepo();
		assestmentEntity = new Assestment();
		assestmentEntity = assestmentRepo.getassestmentById(assestmentId);
		List<QuestionDataPojo> questionsList = questionsArray.getQuestionList();
		QuestionArrayDataPojo returnObject = new QuestionArrayDataPojo();
		for(QuestionDataPojo questionPojo: questionsList){
			questionEntity = new Question();
			questionEntity.setQuestion(questionPojo.getQuestion());
			questionEntity.setType(questionPojo.getType());
			questionEntity.setChoices(questionPojo.getChoices());
			assestmentEntity.getQuestionList().add(questionEntity);
			questionRepo = new QuestionRepo();
			questionRepo.insertQuestion(assestmentEntity, questionEntity);
		}
		return returnObject;
	}
	
	public AssestmentTaken addAssestmentTaken(int userId, int assestmentId, SurveyTakenDataPojo surveyTakenData){	
		assestmentRepo = new AssestmentRepo();
		assestmentEntity = new Assestment();
		assestmentEntity = assestmentRepo.getassestmentById(assestmentId);
		userRepo = new UserRepo();
		userEntity = new User();
		userEntity = userRepo.getUserData(userId);
		assestmentTakenEntity = new AssestmentTaken();
		assestmentTakenEntity.setTime_taken(surveyTakenData.getTime_taken());
		userEntity.getAssestmentTakenList().add(assestmentTakenEntity);
		assestmentEntity.getAssestmentTakenList().add(assestmentTakenEntity);
		assestmentTakenRepo = new AssestmentTakenRepo();
		assestmentTakenRepo.insertAssestmentTaken(assestmentTakenEntity,userEntity, assestmentEntity);
		locationEntity = new Locations();
		locationEntity.setStreet_address1(surveyTakenData.getStreet_address1());
		locationEntity.setStreet_address2(surveyTakenData.getStreet_address2());
		locationEntity.setCity(surveyTakenData.getCity());
		locationEntity.setCountry(surveyTakenData.getCountry());
		locationEntity.setState(surveyTakenData.getState());
		locationEntity.setZipcode(surveyTakenData.getZipcode());
		assestmentTakenEntity.getLocationList().add(locationEntity);
		locationRepo = new LocationRepo();
		locationRepo.insertAssestmentTakenLocation(assestmentTakenEntity, locationEntity);
		for(IntegerStringDataPojo twoStringPojo: surveyTakenData.getAnswersList()){
			questionEntity = new Question();
			questionRepo = new QuestionRepo();
			questionEntity = questionRepo.getQuestionById(twoStringPojo.getI());
			answerEntity = new Answer();
			answerEntity.setText(twoStringPojo.getS());
			answerEntity.getQuestionList().add(questionEntity);
			assestmentTakenEntity.getAnswersList().add(answerEntity);
			answerRepo = new AnswerRepo();
			answerRepo.insertAnswer(answerEntity, assestmentTakenEntity);
		}
		assestmentTakenEntity = new AssestmentTaken();
		assestmentTakenRepo = new AssestmentTakenRepo();
		assestmentTakenEntity = assestmentTakenRepo.getAssestmentTakenById(assestmentId);
		return assestmentTakenEntity;
	}
	

}
