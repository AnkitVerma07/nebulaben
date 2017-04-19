/**
 * 
 */
package careers.nebula.ben.information;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import careers.nebula.ben.db.enitity.Experiences;
import careers.nebula.ben.db.enitity.Extracurricular;
import careers.nebula.ben.db.enitity.Highschool;
import careers.nebula.ben.db.enitity.Industry;
import careers.nebula.ben.db.enitity.Interests;
import careers.nebula.ben.db.enitity.Keywords;
import careers.nebula.ben.db.enitity.Languages;
import careers.nebula.ben.db.enitity.Qualification;
import careers.nebula.ben.db.enitity.TestResult;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.db.repository.UserRepo;
import careers.nebula.ben.pojos.ResponseCombinedList;
import careers.nebula.ben.pojos.TwoTestResultDataPojo;
import careers.nebula.ben.service.ComparePeersServicing;
import careers.nebula.ben.service.HelperMethods;

/**
 * @author Ankit_Nebula
 *
 */
public class ComparePeer2PeerInformation {

	private ComparePeersServicing comparePeers;
	private UserRepo userrepo;
	private ResponseCombinedList ResponseCombinedList;
	private TwoTestResultDataPojo responseTestResultList;
	private HelperMethods methods;
	private TestResult testEntity;
	
	public ResponseCombinedList getUserQualificationMajorExtraComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExtracurricularList();
		for(Extracurricular e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.qualificationMajorUserExtracurricular(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}
	
	public ResponseCombinedList getUserQualificationMajorIndustryComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Industry> industryList = new ArrayList<Industry>();
		List<String> userindustryrSkills = new ArrayList<String>();
		List<String> usersindustrySkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		industryList = userData.getIndustryList();
		for(Industry e : industryList){
			userindustryrSkills.add(e.getName());
		}
		usersindustrySkills = comparePeers.qualificationMajorUserIndustry(id);
		intersection =  methods.intersection(usersindustrySkills, userindustryrSkills);
		union = methods.union(usersindustrySkills, userindustryrSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersindustrySkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersindustrySkills, temp));
		}
		ResponseCombinedList.setListone(userindustryrSkills);
		ResponseCombinedList.setListtwo(usersindustrySkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}
	
	public ResponseCombinedList getUserQualificationMajorInterestComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Interests> interestList = new ArrayList<Interests>();
		List<String> userinterestSkills = new ArrayList<String>();
		List<String> usersinterestSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		interestList = userData.getInterestList();
		for(Interests e : interestList){
			userinterestSkills.add(e.getName());
		}
		usersinterestSkills = comparePeers.qualificationMajorUserInterests(id);
		intersection =  methods.intersection(usersinterestSkills, userinterestSkills);
		union = methods.union(usersinterestSkills, userinterestSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersinterestSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersinterestSkills, temp));
		}
		ResponseCombinedList.setListone(userinterestSkills);
		ResponseCombinedList.setListtwo(usersinterestSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}
	
	public ResponseCombinedList getUserQualificationMajorLanguagesComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Languages> languagesList = new ArrayList<Languages>();
		List<String> userlanguageSkills = new ArrayList<String>();
		List<String> userslanguageSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		languagesList = userData.getLanguageList();
		for(Languages e : languagesList){
			userlanguageSkills.add(e.getName());
		}
		userslanguageSkills = comparePeers.qualificationMajorUserLanguages(id);
		intersection =  methods.intersection(userslanguageSkills, userlanguageSkills);
		union = methods.union(userslanguageSkills, userlanguageSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(userslanguageSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(userslanguageSkills, temp));
		}
		ResponseCombinedList.setListone(userlanguageSkills);
		ResponseCombinedList.setListtwo(userslanguageSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}
	
	public ResponseCombinedList getUserQualificationMajorKeywordsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Keywords> keywordsList = new ArrayList<Keywords>();
		List<String> userKeywordSkills = new ArrayList<String>();
		List<String> usersKeywordsSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		keywordsList = userData.getKeywordList();
		for(Keywords e : keywordsList){
			userKeywordSkills.add(e.getName());
		}
		usersKeywordsSkills = comparePeers.qualificationMajorUserKeywords(id);
		intersection =  methods.intersection(usersKeywordsSkills, userKeywordSkills);
		union = methods.union(usersKeywordsSkills, userKeywordSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersKeywordsSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersKeywordsSkills, temp));
		}
		ResponseCombinedList.setListone(userKeywordSkills);
		ResponseCombinedList.setListtwo(usersKeywordsSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}
	
	public ResponseCombinedList getUserQualificationMinorExtraComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExtracurricularList();
		for(Extracurricular e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.qualificationMinorsUserExtracurricular(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}
	
	public ResponseCombinedList getUserQualificationMinorIndustryComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Industry> extraList = new ArrayList<Industry>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getIndustryList();
		for(Industry e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.qualificationMinorsUserIndustry(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserQualificationMinorInterestsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Interests> extraList = new ArrayList<Interests>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getInterestList();
		for(Interests e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.qualificationMinorsUserIndustry(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserQualificationMinorLanguagesComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Languages> extraList = new ArrayList<Languages>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getLanguageList();
		for(Languages e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.qualificationMinorsUserIndustry(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserQualificationMinorKeywordsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Keywords> extraList = new ArrayList<Keywords>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getKeywordList();
		for(Keywords e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.qualificationMinorsUserKeywords(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserQualificationSchoolExtraComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExtracurricularList();
		for(Extracurricular e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.qualificationSchoolUserExtracurricular(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserQualificationSchoolIndustryComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Industry> extraList = new ArrayList<Industry>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getIndustryList();
		for(Industry e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.qualificationSchoolUserIndustry(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserQualificationSchoolLanguagesComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Languages> extraList = new ArrayList<Languages>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getLanguageList();
		for(Languages e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.qualificationSchoolUserLanguages(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserQualificationSchoolKeywordsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Keywords> extraList = new ArrayList<Keywords>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getKeywordList();
		for(Keywords e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.qualificationSchoolUserKeywords(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMajorMinorExtraComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExtracurricularList();
		for(Extracurricular e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.majorMinorUserExtracurricular(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMajorMinorIndustryComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Industry> extraList = new ArrayList<Industry>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getIndustryList();
		for(Industry e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.majorMinorUserIndustry(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMajorMinorInterestsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Interests> extraList = new ArrayList<Interests>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getInterestList();
		for(Interests e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.majorMinorUserInterests(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMajorMinorLanguagesComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Languages> extraList = new ArrayList<Languages>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getLanguageList();
		for(Languages e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.majorMinorUserLanguages(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMajorMinorKeywordsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Keywords> extraList = new ArrayList<Keywords>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getKeywordList();
		for(Keywords e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.majorMinorUserKeywords(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserSchoolMajorExtraComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExtracurricularList();
		for(Extracurricular e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.schoolMajorUserExtracurricular(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserSchoolMajorIndustryComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Industry> extraList = new ArrayList<Industry>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getIndustryList();
		for(Industry e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.schoolMajorUserIndustry(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserSchoolMajorInterestsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Interests> extraList = new ArrayList<Interests>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getInterestList();
		for(Interests e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.schoolMajorUserInterests(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserSchoolMajorLanguagesComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Languages> extraList = new ArrayList<Languages>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getLanguageList();
		for(Languages e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.schoolMajorUserLanguages(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserSchoolMajorKeywordsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Keywords> extraList = new ArrayList<Keywords>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getKeywordList();
		for(Keywords e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.schoolMajorUserKeywords(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserSchoolMinorExtraComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExtracurricularList();
		for(Extracurricular e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.schoolMinorUserExtracurricular(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserSchoolMinorIndustryComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Industry> extraList = new ArrayList<Industry>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getIndustryList();
		for(Industry e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.schoolMinorUserIndustry(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserSchoolMinorInterestsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Interests> extraList = new ArrayList<Interests>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getInterestList();
		for(Interests e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.schoolMinorUserInterests(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserSchoolMinorLanguagesComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Languages> extraList = new ArrayList<Languages>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getLanguageList();
		for(Languages e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.schoolMinorUserLanguages(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}
	
	public ResponseCombinedList getUserSchoolMinorKeywordsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Keywords> extraList = new ArrayList<Keywords>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getKeywordList();
		for(Keywords e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.schoolMinorUserKeywords(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserQualificationLocationExtraComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExtracurricularList();
		for(Extracurricular e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.qualificationLocationUserExtracurricular(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserQualificationLocationIndustryComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Industry> extraList = new ArrayList<Industry>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getIndustryList();
		for(Industry e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.qualificationLocationUserIndustry(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserQualificationLocationInterestsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Interests> extraList = new ArrayList<Interests>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getInterestList();
		for(Interests e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.qualificationLocationUserInterests(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserQualificationLocationLanguagesComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Languages> extraList = new ArrayList<Languages>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getLanguageList();
		for(Languages e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.qualificationLocationUserLanguages(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserQualificationLocationKeywordsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Keywords> extraList = new ArrayList<Keywords>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getKeywordList();
		for(Keywords e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.qualificationLocationUserKeywords(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserLocationMajorExtraComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExtracurricularList();
		for(Extracurricular e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.locationMajorUserExtracurricular(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserLocationMajorIndustryComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Industry> extraList = new ArrayList<Industry>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>(); 
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getIndustryList();
		for(Industry e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.locationMajorUserIndustry(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserLocationMajorInterestsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Interests> extraList = new ArrayList<Interests>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>(); 
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getInterestList();
		for(Interests e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.locationMajorUserInterests(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserLocationMajorLanguagesComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Languages> extraList = new ArrayList<Languages>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>(); 
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getLanguageList();
		for(Languages e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.locationMajorUserLanguages(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserLocationMajorKeywordsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Keywords> extraList = new ArrayList<Keywords>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>(); 
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getKeywordList();
		for(Keywords e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.locationMajorUserKeywords(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserJobTitleLocationExtraComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>(); 
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExtracurricularList();
		for(Extracurricular e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.jobTitleLocationUserExtracurricular(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserJobTitleLocationIndustryComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Industry> extraList = new ArrayList<Industry>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>(); 
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getIndustryList();
		for(Industry e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.jobTitleLocationUserIndustry(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserJobTitleLocationInterestsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Interests> extraList = new ArrayList<Interests>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>(); 
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getInterestList();
		for(Interests e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.jobTitleLocationUserInterests(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserJobTitleLocationLanguagesComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Languages> extraList = new ArrayList<Languages>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>(); 
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getLanguageList();
		for(Languages e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.jobTitleLocationUserLanguages(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserJobTitleLocationKeywordsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Keywords> extraList = new ArrayList<Keywords>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>(); 
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getKeywordList();
		for(Keywords e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.jobTitleLocationUserKeywords(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserJobTitleAgeExtraComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>(); 
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExtracurricularList();
		for(Extracurricular e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.jobTitleAgeUserExtracurricular(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserJobTitleAgeIndustryComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Industry> extraList = new ArrayList<Industry>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>(); 
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getIndustryList();
		for(Industry e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.jobTitleAgeUserIndustry(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserJobTitleAgeInterestsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Interests> extraList = new ArrayList<Interests>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>(); 
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getInterestList();
		for(Interests e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.jobTitleAgeUserInterests(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserJobTitleAgeLanguagesComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Languages> extraList = new ArrayList<Languages>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>(); 
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getLanguageList();
		for(Languages e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.jobTitleAgeUserLanguages(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}
	
	public ResponseCombinedList getUserJobTitleAgeKeywordsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Keywords> extraList = new ArrayList<Keywords>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>(); 
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getKeywordList();
		for(Keywords e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.jobTitleAgeUserKeywords(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserAgeExtraComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>(); 
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExtracurricularList();
		for(Extracurricular e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.ageUserExtracurricular(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserAgeIndustryComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Industry> extraList = new ArrayList<Industry>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>(); 
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getIndustryList();
		for(Industry e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.ageUserIndustry(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserAgeLanguagesComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Languages> extraList = new ArrayList<Languages>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>(); 
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getLanguageList();
		for(Languages e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.ageUserLanguages(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserAgeKeywordsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Keywords> extraList = new ArrayList<Keywords>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>(); 
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getKeywordList();
		for(Keywords e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.ageUserKeywords(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}
	
	public ResponseCombinedList getUserGoalsExtraComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExtracurricularList();
		for(Extracurricular e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.goalsUserExtracurricular(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}
	
	public ResponseCombinedList getUserGoalsIndustryComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Industry> industryList = new ArrayList<Industry>();
		List<String> userindustryrSkills = new ArrayList<String>();
		List<String> usersindustrySkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		industryList = userData.getIndustryList();
		for(Industry e : industryList){
			userindustryrSkills.add(e.getName());
		}
		usersindustrySkills = comparePeers.goalsUserIndustry(id);
		intersection =  methods.intersection(usersindustrySkills, userindustryrSkills);
		union = methods.union(usersindustrySkills, userindustryrSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersindustrySkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersindustrySkills, temp));
		}
		ResponseCombinedList.setListone(userindustryrSkills);
		ResponseCombinedList.setListtwo(usersindustrySkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}
	
	public ResponseCombinedList getUserGoalsInterestComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Interests> interestList = new ArrayList<Interests>();
		List<String> userinterestSkills = new ArrayList<String>();
		List<String> usersinterestSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		interestList = userData.getInterestList();
		for(Interests e : interestList){
			userinterestSkills.add(e.getName());
		}
		usersinterestSkills = comparePeers.goalsUserInterests(id);
		intersection =  methods.intersection(usersinterestSkills, userinterestSkills);
		union = methods.union(usersinterestSkills, userinterestSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersinterestSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersinterestSkills, temp));
		}
		ResponseCombinedList.setListone(userinterestSkills);
		ResponseCombinedList.setListtwo(usersinterestSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}
	
	public ResponseCombinedList getUserGoalsLanguagesComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Languages> languagesList = new ArrayList<Languages>();
		List<String> userlanguageSkills = new ArrayList<String>();
		List<String> userslanguageSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		languagesList = userData.getLanguageList();
		for(Languages e : languagesList){
			userlanguageSkills.add(e.getName());
		}
		userslanguageSkills = comparePeers.goalsUserLanguages(id);
		intersection =  methods.intersection(userslanguageSkills, userlanguageSkills);
		union = methods.union(userslanguageSkills, userlanguageSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(userslanguageSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(userslanguageSkills, temp));
		}
		ResponseCombinedList.setListone(userlanguageSkills);
		ResponseCombinedList.setListtwo(userslanguageSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}
	
	public ResponseCombinedList getUserGoalsKeywordsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Keywords> keywordsList = new ArrayList<Keywords>();
		List<String> userKeywordSkills = new ArrayList<String>();
		List<String> usersKeywordsSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		keywordsList = userData.getKeywordList();
		for(Keywords e : keywordsList){
			userKeywordSkills.add(e.getName());
		}
		usersKeywordsSkills = comparePeers.goalsUserKeywords(id);
		intersection =  methods.intersection(usersKeywordsSkills, userKeywordSkills);
		union = methods.union(usersKeywordsSkills, userKeywordSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersKeywordsSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersKeywordsSkills, temp));
		}
		ResponseCombinedList.setListone(userKeywordSkills);
		ResponseCombinedList.setListtwo(usersKeywordsSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMajorExtraComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExtracurricularList();
		for(Extracurricular e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.majorUserExtracurricular(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMajorIndustryComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Industry> extraList = new ArrayList<Industry>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getIndustryList();
		for(Industry e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.majorUserIndustry(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMajorInterestsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Interests> extraList = new ArrayList<Interests>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getInterestList();
		for(Interests e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.majorUserInterests(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMajorLanguagesComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Languages> extraList = new ArrayList<Languages>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getLanguageList();
		for(Languages e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.majorUserLanguages(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMajorKeywordsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Keywords> extraList = new ArrayList<Keywords>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getKeywordList();
		for(Keywords e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.majorUserKeywords(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMinorExtraComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExtracurricularList();
		for(Extracurricular e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.minorUserExtracurricular(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMinorIndustryComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Industry> extraList = new ArrayList<Industry>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getIndustryList();
		for(Industry e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.minorUserIndustry(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMinorInterestsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Interests> extraList = new ArrayList<Interests>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getInterestList();
		for(Interests e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.minorUserInterests(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMinorLanguagesComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Languages> extraList = new ArrayList<Languages>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getLanguageList();
		for(Languages e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.minorUserLanguages(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMinorKeywordsComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Extracurricular> extraList = new ArrayList<Extracurricular>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExtracurricularList();
		for(Extracurricular e : extraList){
			userextraSkills.add(e.getName());
		}
		usersextraSkills = comparePeers.minorUserKeywords(id);
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserQualificationMajorExpComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Experiences> extraList = new ArrayList<Experiences>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExperienceList();
		for(Experiences e : extraList){
			userextraSkills.add(e.getJob_title());
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.qualificationMajorUserExperience(id);
		usersextraSkills = incominglist.getListone();
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
		ResponseCombinedList.setInt1(incominglist.getInt1());
		ResponseCombinedList.setInt2(incominglist.getInt2());
		ResponseCombinedList.setDouble1(incominglist.getDouble1());		
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserQualificationMinorExpComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Experiences> extraList = new ArrayList<Experiences>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExperienceList();
		for(Experiences e : extraList){
			userextraSkills.add(e.getJob_title());
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.qualificationMinorUserExperience(id);
		usersextraSkills = incominglist.getListone();
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
		ResponseCombinedList.setInt1(incominglist.getInt1());
		ResponseCombinedList.setInt2(incominglist.getInt2());
		ResponseCombinedList.setDouble1(incominglist.getDouble1());		
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}
	
	public ResponseCombinedList getUserQualificationSchoolExpComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Experiences> extraList = new ArrayList<Experiences>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExperienceList();
		for(Experiences e : extraList){
			userextraSkills.add(e.getJob_title());
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.qualificationSchoolsUserExperience(id);
		usersextraSkills = incominglist.getListone();
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
		ResponseCombinedList.setInt1(incominglist.getInt1());
		ResponseCombinedList.setInt2(incominglist.getInt2());
		ResponseCombinedList.setDouble1(incominglist.getDouble1());		
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMajorMinorExpComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Experiences> extraList = new ArrayList<Experiences>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExperienceList();
		for(Experiences e : extraList){
			userextraSkills.add(e.getJob_title());
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.majorMinorUserExperience(id);
		usersextraSkills = incominglist.getListone();
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
		ResponseCombinedList.setInt1(incominglist.getInt1());
		ResponseCombinedList.setInt2(incominglist.getInt2());
		ResponseCombinedList.setDouble1(incominglist.getDouble1());		
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserSchoolMinorExpComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Experiences> extraList = new ArrayList<Experiences>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExperienceList();
		for(Experiences e : extraList){
			userextraSkills.add(e.getJob_title());
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.schoolMinorUserExperience(id);
		usersextraSkills = incominglist.getListone();
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
		ResponseCombinedList.setInt1(incominglist.getInt1());
		ResponseCombinedList.setInt2(incominglist.getInt2());
		ResponseCombinedList.setDouble1(incominglist.getDouble1());		
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserSchoolMajorExpComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Experiences> extraList = new ArrayList<Experiences>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExperienceList();
		for(Experiences e : extraList){
			userextraSkills.add(e.getJob_title());
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.schoolMajorsUserExperience(id);
		usersextraSkills = incominglist.getListone();
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
		ResponseCombinedList.setInt1(incominglist.getInt1());
		ResponseCombinedList.setInt2(incominglist.getInt2());
		ResponseCombinedList.setDouble1(incominglist.getDouble1());		
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserQualificationLocationExpComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Experiences> extraList = new ArrayList<Experiences>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExperienceList();
		for(Experiences e : extraList){
			userextraSkills.add(e.getJob_title());
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.qualificationLocationUserExperience(id);
		usersextraSkills = incominglist.getListone();
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
		ResponseCombinedList.setInt1(incominglist.getInt1());
		ResponseCombinedList.setInt2(incominglist.getInt2());
		ResponseCombinedList.setDouble1(incominglist.getDouble1());		
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}
	
	public ResponseCombinedList getUserLocationMajorExpComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Experiences> extraList = new ArrayList<Experiences>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExperienceList();
		for(Experiences e : extraList){
			userextraSkills.add(e.getJob_title());
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.locationMajorsUserExperience(id);
		usersextraSkills = incominglist.getListone();
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
		ResponseCombinedList.setInt1(incominglist.getInt1());
		ResponseCombinedList.setInt2(incominglist.getInt2());
		ResponseCombinedList.setDouble1(incominglist.getDouble1());		
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserJobTitleLocationExpComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Experiences> extraList = new ArrayList<Experiences>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExperienceList();
		for(Experiences e : extraList){
			userextraSkills.add(e.getJob_title());
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.jobTitleAndLocationUserExperience(id);
		usersextraSkills = incominglist.getListone();
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
		ResponseCombinedList.setInt1(incominglist.getInt1());
		ResponseCombinedList.setInt2(incominglist.getInt2());
		ResponseCombinedList.setDouble1(incominglist.getDouble1());		
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}
	
	public ResponseCombinedList getUserJobTitleAgeExpComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Experiences> extraList = new ArrayList<Experiences>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExperienceList();
		for(Experiences e : extraList){
			userextraSkills.add(e.getJob_title());
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.ageJobTitleUserExperience(id);
		usersextraSkills = incominglist.getListone();
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
		ResponseCombinedList.setInt1(incominglist.getInt1());
		ResponseCombinedList.setInt2(incominglist.getInt2());
		ResponseCombinedList.setDouble1(incominglist.getDouble1());		
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserAgeExpComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Experiences> extraList = new ArrayList<Experiences>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExperienceList();
		for(Experiences e : extraList){
			userextraSkills.add(e.getJob_title());
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.ageUserExperience(id);
		usersextraSkills = incominglist.getListone();
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
		ResponseCombinedList.setInt1(incominglist.getInt1());
		ResponseCombinedList.setInt2(incominglist.getInt2());
		ResponseCombinedList.setDouble1(incominglist.getDouble1());		
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserGoalsExpComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Collection<Experiences> extraList = new ArrayList<Experiences>();
		List<String> userextraSkills = new ArrayList<String>();
		List<String> usersextraSkills = new ArrayList<String>();
		List<String> intersection = new ArrayList<String>();
		List<String> union = new ArrayList<String>();
		List<String> matchedData = new ArrayList<String>();
		List<String> unmatchedSkills = new ArrayList<String>();
		extraList = userData.getExperienceList();
		for(Experiences e : extraList){
			userextraSkills.add(e.getJob_title());
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.goalsUserExperience(id);
		usersextraSkills = incominglist.getListone();
		intersection =  methods.intersection(usersextraSkills, userextraSkills);
		union = methods.union(usersextraSkills, userextraSkills);
		union.removeAll(intersection);
		unmatchedSkills = union;
		Set<String> uniqueSet = new HashSet<String>(usersextraSkills);
		for (String temp : uniqueSet) {
			//System.out.println(temp + ": " + Collections.frequency(usersextraSkills, temp));
			matchedData.add(temp + ": " + Collections.frequency(usersextraSkills, temp));
		}
		ResponseCombinedList.setListone(userextraSkills);
		ResponseCombinedList.setListtwo(usersextraSkills);
		ResponseCombinedList.setListthree(matchedData);
		ResponseCombinedList.setListfour(unmatchedSkills);
		ResponseCombinedList.setInt1(incominglist.getInt1());
		ResponseCombinedList.setInt2(incominglist.getInt2());
		ResponseCombinedList.setDouble1(incominglist.getDouble1());		
//		for(String s : ResponseCombinedList.getListthree()){
//			System.out.println(s);
//		}
		return ResponseCombinedList;
	}
	
	public ResponseCombinedList getUserQualificationMajorHSComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Double userGpa = 0.0;
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		hsList = userData.getHighschoolList();
		for(Highschool hs : hsList){
			userGpa = hs.getGpa();
		}
		Double usersGpa = comparePeers.qualificationMajorUserHS(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(usersGpa);
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserQualificationMinorHSComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Double userGpa = 0.0;
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		hsList = userData.getHighschoolList();
		for(Highschool hs : hsList){
			userGpa = hs.getGpa();
		}
		Double usersGpa = comparePeers.qualificationMinorUserHS(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(usersGpa);
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserQualificationSchoolHSComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Double userGpa = 0.0;
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		hsList = userData.getHighschoolList();
		for(Highschool hs : hsList){
			userGpa = hs.getGpa();
		}
		Double usersGpa = comparePeers.qualificationSchoolUserHS(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(usersGpa);
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMinorMajorHSComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Double userGpa = 0.0;
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		hsList = userData.getHighschoolList();
		for(Highschool hs : hsList){
			userGpa = hs.getGpa();
		}
		Double usersGpa = comparePeers.minorMajorUserHS(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(usersGpa);
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMinorSchoolHSComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Double userGpa = 0.0;
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		hsList = userData.getHighschoolList();
		for(Highschool hs : hsList){
			userGpa = hs.getGpa();
		}
		Double usersGpa = comparePeers.minorSchoolUserHS(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(usersGpa);
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMajorSchoolHSComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Double userGpa = 0.0;
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		hsList = userData.getHighschoolList();
		for(Highschool hs : hsList){
			userGpa = hs.getGpa();
		}
		Double usersGpa = comparePeers.majorSchoolUserHS(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(usersGpa);
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserQualificationLocationHSComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Double userGpa = 0.0;
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		hsList = userData.getHighschoolList();
		for(Highschool hs : hsList){
			userGpa = hs.getGpa();
		}
		Double usersGpa = comparePeers.qualificationLocationUserHS(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(usersGpa);
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserLocationMajorHSComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Double userGpa = 0.0;
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		hsList = userData.getHighschoolList();
		for(Highschool hs : hsList){
			userGpa = hs.getGpa();
		}
		Double usersGpa = comparePeers.LocationMajorUserHS(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(usersGpa);
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserJobTitleLocationHSComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Double userGpa = 0.0;
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		hsList = userData.getHighschoolList();
		for(Highschool hs : hsList){
			userGpa = hs.getGpa();
		}
		Double usersGpa = comparePeers.jobTitleLocationUserHS(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(usersGpa);
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserJobTitleAgeHSComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Double userGpa = 0.0;
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		hsList = userData.getHighschoolList();
		for(Highschool hs : hsList){
			userGpa = hs.getGpa();
		}
		Double usersGpa = comparePeers.jobTitleAgeUserHS(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(usersGpa);
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserAgeHSComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Double userGpa = 0.0;
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		hsList = userData.getHighschoolList();
		for(Highschool hs : hsList){
			userGpa = hs.getGpa();
		}
		Double usersGpa = comparePeers.ageUserHS(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(usersGpa);
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserGoalsHSComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		methods = new HelperMethods();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Double userGpa = 0.0;
		Collection<Highschool> hsList = new ArrayList<Highschool>();
		hsList = userData.getHighschoolList();
		for(Highschool hs : hsList){
			userGpa = hs.getGpa();
		}
		Double usersGpa = comparePeers.goalsUserHS(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(usersGpa);
		return ResponseCombinedList;
	}
	
	public ResponseCombinedList getUserQualificationMajorUniComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Integer yearsSpend = 0;
		Double userGpa = 0.0;
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		uniList = userData.getUniversityList();
		for(Qualification q : uniList){
			if(q.getMost_recent() == true){
				String startdate =  q.getYear_started();
				String enddate =  q.getYear_gradauted();
				methods = new HelperMethods();
				int start = methods.yearCalculator(startdate);
				int end = methods.yearCalculator(enddate);
				yearsSpend = end-start;
				userGpa = q.getGpa();
			}
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.qualificationMajorUserUni(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(incominglist.getDouble1());
		ResponseCombinedList.setDouble3((double) uniList.size());
		ResponseCombinedList.setDouble4(incominglist.getDouble4());
		ResponseCombinedList.setInt1(yearsSpend);
		ResponseCombinedList.setInt2(incominglist.getInt1());		
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserQualificationMinorUniComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Integer yearsSpend = 0;
		Double userGpa = 0.0;
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		uniList = userData.getUniversityList();
		for(Qualification q : uniList){
			if(q.getMost_recent() == true){
				String startdate =  q.getYear_started();
				String enddate =  q.getYear_gradauted();
				methods = new HelperMethods();
				int start = methods.yearCalculator(startdate);
				int end = methods.yearCalculator(enddate);
				yearsSpend = end-start;
				userGpa = q.getGpa();
			}
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.qualificationMinorUserUni(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(incominglist.getDouble1());
		ResponseCombinedList.setDouble3((double) uniList.size());
		ResponseCombinedList.setDouble4(incominglist.getDouble4());
		ResponseCombinedList.setInt1(yearsSpend);
		ResponseCombinedList.setInt2(incominglist.getInt1());		
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserQualificationSchoolUniComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Integer yearsSpend = 0;
		Double userGpa = 0.0;
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		uniList = userData.getUniversityList();
		for(Qualification q : uniList){
			if(q.getMost_recent() == true){
				String startdate =  q.getYear_started();
				String enddate =  q.getYear_gradauted();
				methods = new HelperMethods();
				int start = methods.yearCalculator(startdate);
				int end = methods.yearCalculator(enddate);
				yearsSpend = end-start;
				userGpa = q.getGpa();
			}
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.qualificationSchoolUserUni(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(incominglist.getDouble1());
		ResponseCombinedList.setDouble3((double) uniList.size());
		ResponseCombinedList.setDouble4(incominglist.getDouble4());
		ResponseCombinedList.setInt1(yearsSpend);
		ResponseCombinedList.setInt2(incominglist.getInt1());		
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMinorMajorUniComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Integer yearsSpend = 0;
		Double userGpa = 0.0;
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		uniList = userData.getUniversityList();
		for(Qualification q : uniList){
			if(q.getMost_recent() == true){
				String startdate =  q.getYear_started();
				String enddate =  q.getYear_gradauted();
				methods = new HelperMethods();
				int start = methods.yearCalculator(startdate);
				int end = methods.yearCalculator(enddate);
				yearsSpend = end-start;
				userGpa = q.getGpa();
			}
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.minorMajorUserUni(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(incominglist.getDouble1());
		ResponseCombinedList.setDouble3((double) uniList.size());
		ResponseCombinedList.setDouble4(incominglist.getDouble4());
		ResponseCombinedList.setInt1(yearsSpend);
		ResponseCombinedList.setInt2(incominglist.getInt1());		
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMinorSchoolUniComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Integer yearsSpend = 0;
		Double userGpa = 0.0;
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		uniList = userData.getUniversityList();
		for(Qualification q : uniList){
			if(q.getMost_recent() == true){
				String startdate =  q.getYear_started();
				String enddate =  q.getYear_gradauted();
				methods = new HelperMethods();
				int start = methods.yearCalculator(startdate);
				int end = methods.yearCalculator(enddate);
				yearsSpend = end-start;
				userGpa = q.getGpa();
			}
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.minorSchoolUserUni(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(incominglist.getDouble1());
		ResponseCombinedList.setDouble3((double) uniList.size());
		ResponseCombinedList.setDouble4(incominglist.getDouble4());
		ResponseCombinedList.setInt1(yearsSpend);
		ResponseCombinedList.setInt2(incominglist.getInt1());		
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserMajorSchoolUniComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Integer yearsSpend = 0;
		Double userGpa = 0.0;
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		uniList = userData.getUniversityList();
		for(Qualification q : uniList){
			if(q.getMost_recent() == true){
				String startdate =  q.getYear_started();
				String enddate =  q.getYear_gradauted();
				methods = new HelperMethods();
				int start = methods.yearCalculator(startdate);
				int end = methods.yearCalculator(enddate);
				yearsSpend = end-start;
				userGpa = q.getGpa();
			}
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.majorSchoolUserUni(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(incominglist.getDouble1());
		ResponseCombinedList.setDouble3((double) uniList.size());
		ResponseCombinedList.setDouble4(incominglist.getDouble4());
		ResponseCombinedList.setInt1(yearsSpend);
		ResponseCombinedList.setInt2(incominglist.getInt1());		
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserQualificationLocationUniComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Integer yearsSpend = 0;
		Double userGpa = 0.0;
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		uniList = userData.getUniversityList();
		for(Qualification q : uniList){
			if(q.getMost_recent() == true){
				String startdate =  q.getYear_started();
				String enddate =  q.getYear_gradauted();
				methods = new HelperMethods();
				int start = methods.yearCalculator(startdate);
				int end = methods.yearCalculator(enddate);
				yearsSpend = end-start;
				userGpa = q.getGpa();
			}
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.qualificationLocationUserUni(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(incominglist.getDouble1());
		ResponseCombinedList.setDouble3((double) uniList.size());
		ResponseCombinedList.setDouble4(incominglist.getDouble4());
		ResponseCombinedList.setInt1(yearsSpend);
		ResponseCombinedList.setInt2(incominglist.getInt1());		
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserLocationMajorUniComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Integer yearsSpend = 0;
		Double userGpa = 0.0;
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		uniList = userData.getUniversityList();
		for(Qualification q : uniList){
			if(q.getMost_recent() == true){
				String startdate =  q.getYear_started();
				String enddate =  q.getYear_gradauted();
				methods = new HelperMethods();
				int start = methods.yearCalculator(startdate);
				int end = methods.yearCalculator(enddate);
				yearsSpend = end-start;
				userGpa = q.getGpa();
			}
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.locationMajorUserUni(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(incominglist.getDouble1());
		ResponseCombinedList.setDouble3((double) uniList.size());
		ResponseCombinedList.setDouble4(incominglist.getDouble4());
		ResponseCombinedList.setInt1(yearsSpend);
		ResponseCombinedList.setInt2(incominglist.getInt1());		
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserJobTitleLocationUniComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Integer yearsSpend = 0;
		Double userGpa = 0.0;
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		uniList = userData.getUniversityList();
		for(Qualification q : uniList){
			if(q.getMost_recent() == true){
				String startdate =  q.getYear_started();
				String enddate =  q.getYear_gradauted();
				methods = new HelperMethods();
				int start = methods.yearCalculator(startdate);
				int end = methods.yearCalculator(enddate);
				yearsSpend = end-start;
				userGpa = q.getGpa();
			}
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.jobTitleLocationUserUni(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(incominglist.getDouble1());
		ResponseCombinedList.setDouble3((double) uniList.size());
		ResponseCombinedList.setDouble4(incominglist.getDouble4());
		ResponseCombinedList.setInt1(yearsSpend);
		ResponseCombinedList.setInt2(incominglist.getInt1());		
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserJobTitleAgeUniComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Integer yearsSpend = 0;
		Double userGpa = 0.0;
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		uniList = userData.getUniversityList();
		for(Qualification q : uniList){
			if(q.getMost_recent() == true){
				String startdate =  q.getYear_started();
				String enddate =  q.getYear_gradauted();
				methods = new HelperMethods();
				int start = methods.yearCalculator(startdate);
				int end = methods.yearCalculator(enddate);
				yearsSpend = end-start;
				userGpa = q.getGpa();
			}
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.jobTitleAgeUserUni(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(incominglist.getDouble1());
		ResponseCombinedList.setDouble3((double) uniList.size());
		ResponseCombinedList.setDouble4(incominglist.getDouble4());
		ResponseCombinedList.setInt1(yearsSpend);
		ResponseCombinedList.setInt2(incominglist.getInt1());		
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserAgeUniComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Integer yearsSpend = 0;
		Double userGpa = 0.0;
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		uniList = userData.getUniversityList();
		for(Qualification q : uniList){
			if(q.getMost_recent() == true){
				String startdate =  q.getYear_started();
				String enddate =  q.getYear_gradauted();
				methods = new HelperMethods();
				int start = methods.yearCalculator(startdate);
				int end = methods.yearCalculator(enddate);
				yearsSpend = end-start;
				userGpa = q.getGpa();
			}
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.ageUserUni(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(incominglist.getDouble1());
		ResponseCombinedList.setDouble3((double) uniList.size());
		ResponseCombinedList.setDouble4(incominglist.getDouble4());
		ResponseCombinedList.setInt1(yearsSpend);
		ResponseCombinedList.setInt2(incominglist.getInt1());		
		return ResponseCombinedList;
	}

	public ResponseCombinedList getUserGoalsUniComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		ResponseCombinedList = new ResponseCombinedList();
		User userData = new User();
		userData = userrepo.getUserData(id);
		Integer yearsSpend = 0;
		Double userGpa = 0.0;
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		uniList = userData.getUniversityList();
		for(Qualification q : uniList){
			if(q.getMost_recent() == true){
				String startdate =  q.getYear_started();
				String enddate =  q.getYear_gradauted();
				methods = new HelperMethods();
				int start = methods.yearCalculator(startdate);
				int end = methods.yearCalculator(enddate);
				yearsSpend = end-start;
				userGpa = q.getGpa();
			}
		}
		ResponseCombinedList incominglist = new ResponseCombinedList();
		incominglist = comparePeers.goalsUserUni(id);
		ResponseCombinedList.setDouble1(userGpa);
		ResponseCombinedList.setDouble2(incominglist.getDouble1());
		ResponseCombinedList.setDouble3((double) uniList.size());
		ResponseCombinedList.setDouble4(incominglist.getDouble4());
		ResponseCombinedList.setInt1(yearsSpend);
		ResponseCombinedList.setInt2(incominglist.getInt1());		
		return ResponseCombinedList;
	}
	
	public TwoTestResultDataPojo getUserQualificationMajorTestResultComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		responseTestResultList = new TwoTestResultDataPojo();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		testEntity = new TestResult();
		User userData = new User();
		userData = userrepo.getUserData(id);
		testList = userData.getTestList();
		for(TestResult tr : testList){
			testEntity = tr;
		}
		TestResult userstests = new TestResult();
		userstests = comparePeers.qualificationMajorUserTestResult(id);
		responseTestResultList.setTest1(testEntity);
		responseTestResultList.setTest2(userstests);
		return responseTestResultList;
	}
	
	public TwoTestResultDataPojo getUserQualificationMinorTestResultComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		responseTestResultList = new TwoTestResultDataPojo();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		testEntity = new TestResult();
		User userData = new User();
		userData = userrepo.getUserData(id);
		testList = userData.getTestList();
		for(TestResult tr : testList){
			testEntity = tr;
		}
		TestResult userstests = new TestResult();
		userstests = comparePeers.qualificationMinorUserTestResult(id);
		responseTestResultList.setTest1(testEntity);
		responseTestResultList.setTest2(userstests);
		return responseTestResultList;
	}
	
	public TwoTestResultDataPojo getUserQualificationSchoolTestResultComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		responseTestResultList = new TwoTestResultDataPojo();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		testEntity = new TestResult();
		User userData = new User();
		userData = userrepo.getUserData(id);
		testList = userData.getTestList();
		for(TestResult tr : testList){
			testEntity = tr;
		}
		TestResult userstests = new TestResult();
		userstests = comparePeers.qualificationSchoolUserTestResult(id);
		responseTestResultList.setTest1(testEntity);
		responseTestResultList.setTest2(userstests);
		return responseTestResultList;
	}

	public TwoTestResultDataPojo getUserMinorMajorTestResultComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		responseTestResultList = new TwoTestResultDataPojo();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		testEntity = new TestResult();
		User userData = new User();
		userData = userrepo.getUserData(id);
		testList = userData.getTestList();
		for(TestResult tr : testList){
			testEntity = tr;
		}
		TestResult userstests = new TestResult();
		userstests = comparePeers.minorMajorUserTestResult(id);
		responseTestResultList.setTest1(testEntity);
		responseTestResultList.setTest2(userstests);
		return responseTestResultList;
	}

	public TwoTestResultDataPojo getUserMinorSchoolTestResultComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		responseTestResultList = new TwoTestResultDataPojo();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		testEntity = new TestResult();
		User userData = new User();
		userData = userrepo.getUserData(id);
		testList = userData.getTestList();
		for(TestResult tr : testList){
			testEntity = tr;
		}
		TestResult userstests = new TestResult();
		userstests = comparePeers.minorSchoolUserTestResult(id);
		responseTestResultList.setTest1(testEntity);
		responseTestResultList.setTest2(userstests);
		return responseTestResultList;
	}

	public TwoTestResultDataPojo getUserMajorSchoolTestResultComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		responseTestResultList = new TwoTestResultDataPojo();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		testEntity = new TestResult();
		User userData = new User();
		userData = userrepo.getUserData(id);
		testList = userData.getTestList();
		for(TestResult tr : testList){
			testEntity = tr;
		}
		TestResult userstests = new TestResult();
		userstests = comparePeers.majorSchoolUserTestResult(id);
		responseTestResultList.setTest1(testEntity);
		responseTestResultList.setTest2(userstests);
		return responseTestResultList;
	}

	public TwoTestResultDataPojo getUserQualificationLocationTestResultComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		responseTestResultList = new TwoTestResultDataPojo();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		testEntity = new TestResult();
		User userData = new User();
		userData = userrepo.getUserData(id);
		testList = userData.getTestList();
		for(TestResult tr : testList){
			testEntity = tr;
		}
		TestResult userstests = new TestResult();
		userstests = comparePeers.qualificationLocationUserTestResult(id);
		responseTestResultList.setTest1(testEntity);
		responseTestResultList.setTest2(userstests);
		return responseTestResultList;
	}

	public TwoTestResultDataPojo getUserMajorLocationTestResultComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		responseTestResultList = new TwoTestResultDataPojo();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		testEntity = new TestResult();
		User userData = new User();
		userData = userrepo.getUserData(id);
		testList = userData.getTestList();
		for(TestResult tr : testList){
			testEntity = tr;
		}
		TestResult userstests = new TestResult();
		userstests = comparePeers.locationMajorUserTestResult(id);
		responseTestResultList.setTest1(testEntity);
		responseTestResultList.setTest2(userstests);
		return responseTestResultList;
	}

	public TwoTestResultDataPojo getUserJobTitleLocationTestResultComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		responseTestResultList = new TwoTestResultDataPojo();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		testEntity = new TestResult();
		User userData = new User();
		userData = userrepo.getUserData(id);
		testList = userData.getTestList();
		for(TestResult tr : testList){
			testEntity = tr;
		}
		TestResult userstests = new TestResult();
		userstests = comparePeers.jobTitleLocationUserTestResult(id);
		responseTestResultList.setTest1(testEntity);
		responseTestResultList.setTest2(userstests);
		return responseTestResultList;
	}

	public TwoTestResultDataPojo getUserJobTitleAgeTestResultComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		responseTestResultList = new TwoTestResultDataPojo();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		testEntity = new TestResult();
		User userData = new User();
		userData = userrepo.getUserData(id);
		testList = userData.getTestList();
		for(TestResult tr : testList){
			testEntity = tr;
		}
		TestResult userstests = new TestResult();
		userstests = comparePeers.jobTitleAgeUserTestResult(id);
		responseTestResultList.setTest1(testEntity);
		responseTestResultList.setTest2(userstests);
		return responseTestResultList;
	}
	
	public TwoTestResultDataPojo getUserAgeTestResultComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		responseTestResultList = new TwoTestResultDataPojo();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		testEntity = new TestResult();
		User userData = new User();
		userData = userrepo.getUserData(id);
		testList = userData.getTestList();
		for(TestResult tr : testList){
			testEntity = tr;
		}
		TestResult userstests = new TestResult();
		userstests = comparePeers.ageUserTestResult(id);
		responseTestResultList.setTest1(testEntity);
		responseTestResultList.setTest2(userstests);
		return responseTestResultList;
	}
	
	public TwoTestResultDataPojo getUserGoalsTestResultComparison(int id){
		userrepo = new UserRepo();
		comparePeers = new ComparePeersServicing();
		responseTestResultList = new TwoTestResultDataPojo();
		Collection<TestResult> testList = new ArrayList<TestResult>();
		testEntity = new TestResult();
		User userData = new User();
		userData = userrepo.getUserData(id);
		testList = userData.getTestList();
		for(TestResult tr : testList){
			testEntity = tr;
		}
		TestResult userstests = new TestResult();
		userstests = comparePeers.goalsUserTestResult(id);
		responseTestResultList.setTest1(testEntity);
		responseTestResultList.setTest2(userstests);
		return responseTestResultList;
	}
	
}
