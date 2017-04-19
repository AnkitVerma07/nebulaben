 /**
 * 
 */
package careers.nebula.ben.information;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import careers.nebula.ben.db.enitity.Colleges;
import careers.nebula.ben.db.enitity.Majors;
import careers.nebula.ben.db.enitity.Minors;
import careers.nebula.ben.db.enitity.Qualification;
import careers.nebula.ben.db.enitity.Transfer;
import careers.nebula.ben.db.enitity.Universities;
import careers.nebula.ben.db.enitity.User;
import careers.nebula.ben.db.repository.QualificationRepo;
import careers.nebula.ben.db.repository.UserProfileRepo;
import careers.nebula.ben.db.repository.UserRepo;
import careers.nebula.ben.pojo.iws.CollegesDataPojo;
import careers.nebula.ben.pojo.iws.MajorsDataPojo;
import careers.nebula.ben.pojo.iws.MinorsDataPojo;
import careers.nebula.ben.pojo.iws.QualificationDataPojo;
import careers.nebula.ben.pojo.iws.TransferDataPojo;
import careers.nebula.ben.pojo.iws.UniversitiesDataPojo;
import careers.nebula.ben.pojo.iws.UserDataPojo;
import careers.nebula.ben.pojos.QualificationMajorPojo;
import careers.nebula.ben.pojos.QualificationMinorPojo;
import careers.nebula.ben.pojos.ResponseIntegerList;
import careers.nebula.ben.pojos.UserQualificationPojo;

/**
 * @author Ankit_Nebula
 *
 */
public class QualificationsInformation {

	private Qualification qualEntity;
	private User userEntity;
	private UserRepo userRepo;
	private QualificationRepo qualrepo;
	private QualificationDataPojo qualDataPojo;
	private Majors majorEntity;
	private Minors minorEntity;
	private MajorsDataPojo majordatapojo;
	private MinorsDataPojo minordatapojo;
	private Transfer transferEntity;
	private TransferDataPojo transferdatapojo;
	private UserDataPojo userdatapojo;
	private UserInformation userInfo;
	private UserProfileRepo userpro;
	private Universities uniEntity;
	private Colleges collegeEntity;
	private UniversitiesDataPojo uniDataPojo;
	private CollegesDataPojo collegeDataPojo;
	
	
	public UserQualificationPojo insertUserUniversity(int id, QualificationDataPojo qualificationData) {
		qualEntity = new Qualification();
		userEntity = new User();
		userRepo = new UserRepo();
		userEntity = userRepo.getUserData(id);
		qualEntity.setYear_started(qualificationData.getYear_started());
		qualEntity.setYear_gradauted(qualificationData.getYear_gradauted()); 
		qualEntity.setQualification_earned(qualificationData.getQualification_earned());
		qualEntity.setUniversity_rating(qualificationData.getUniversity_rating());
		qualEntity.setGpa(qualificationData.getGpa());
		qualEntity.setMost_recent(qualificationData.getMost_recent());
		qualEntity.setYear_standing(qualificationData.getYear_started());
		userEntity.getUniversityList().add(qualEntity);
		qualrepo = new QualificationRepo();
		UserQualificationPojo combinedPojo = new UserQualificationPojo(userEntity, qualEntity);
		qualrepo.InsertUserUniData(combinedPojo);
		return combinedPojo;
	}

	public QualificationDataPojo getUniversityById(int id) {
		qualrepo = new QualificationRepo();
		qualEntity = new Qualification();
		qualDataPojo = new QualificationDataPojo();
		qualEntity = qualrepo.getQualificationData(id);
		qualDataPojo.setId(qualEntity.getId());
		qualDataPojo.setYear_started(qualEntity.getYear_started());
		qualDataPojo.setYear_gradauted(qualEntity.getYear_gradauted());
		qualDataPojo.setQualification_earned(qualEntity.getQualification_earned());
		qualDataPojo.setGpa(qualEntity.getGpa());
		qualDataPojo.setMost_recent(qualEntity.getMost_recent());
		qualDataPojo.setUniversity_rating(qualEntity.getUniversity_rating());
		qualDataPojo.setYear_standing(qualEntity.getYear_standing());
		return qualDataPojo;
	}
	
	public ResponseIntegerList getUserUniversity(int id) {
		userRepo = new UserRepo();
		int uni_id = 0;
		userEntity = userRepo.getUserData(id);
		Collection<Qualification> qualList = new ArrayList<Qualification>();
		List<Integer> idlist = new ArrayList<Integer>();
		qualList = userEntity.getUniversityList();
		for (Qualification obj : qualList) {
			uni_id = obj.getId();
			idlist.add(uni_id);
			   }
		ResponseIntegerList list = new ResponseIntegerList();
		list.setList(idlist);
		return list;
	}

	public UserDataPojo getUserByQualId(int id){
		int user_id = 0;
		qualrepo = new QualificationRepo();
		qualEntity = new Qualification();
		qualEntity = qualrepo.getQualificationData(id);
		Collection<User> userList = new ArrayList<User>();
		userList = qualEntity.getUserList();
		for(User u : userList){
			user_id = u.getId();
		}
		userdatapojo = new UserDataPojo();
		userInfo = new UserInformation();
		userdatapojo = userInfo.getPrimaryUserInfo(user_id); 
		return userdatapojo;
	}
	
	public List<Integer> getQualByMajorId(int id){
		List<Integer> qualIds = new ArrayList<Integer>();
		qualrepo = new QualificationRepo();
		majorEntity = new Majors();
		majorEntity = qualrepo.getMajorData(id);
		Collection<Qualification> qualList = new ArrayList<Qualification>();
		qualList = majorEntity.getQualificationList();
		for(Qualification q : qualList){
			qualIds.add(q.getId());
		}
		return qualIds;
	}
	
	public List<Integer> getQualByUniId(int id){
		List<Integer> qualIds = new ArrayList<Integer>();
		qualrepo = new QualificationRepo();
		uniEntity = new Universities();
		uniEntity = qualrepo.getUniData(id);
		Collection<Qualification> qualList = new ArrayList<Qualification>();
		qualList = uniEntity.getQualificationList();
		for(Qualification q : qualList){
			qualIds.add(q.getId());
		}
		return qualIds;
	}
	
	public Qualification updateUniversityById(QualificationDataPojo qualDataPojo){
		qualEntity = new Qualification();
		qualrepo = new QualificationRepo();
		qualEntity = qualrepo.getQualificationData(qualDataPojo.getId());
		qualEntity.setId(qualDataPojo.getId());
		if(qualDataPojo.getYear_started() == null){
			qualEntity.setYear_started(qualEntity.getYear_started());
		} else {
			qualEntity.setYear_started(qualDataPojo.getYear_started());
		} 
		if(qualDataPojo.getYear_gradauted() == null){
			qualEntity.setYear_gradauted(qualEntity.getYear_gradauted());
		} else {
			qualEntity.setYear_gradauted(qualDataPojo.getYear_gradauted());
		}
		if(qualDataPojo.getQualification_earned() == null){
			qualEntity.setQualification_earned(qualEntity.getQualification_earned());
		} else {
			qualEntity.setQualification_earned(qualDataPojo.getQualification_earned());
		}
		if(qualDataPojo.getUniversity_rating() == null){
			qualEntity.setUniversity_rating(qualEntity.getUniversity_rating());
		} else {
			qualEntity.setUniversity_rating(qualDataPojo.getUniversity_rating());
		}
		if(qualDataPojo.getGpa() == null){
			qualEntity.setGpa(qualEntity.getGpa());
		} else {
			qualEntity.setGpa(qualDataPojo.getGpa());
		}
		if(qualDataPojo.getMost_recent() == null){
			qualEntity.setMost_recent(qualEntity.getMost_recent());
		} else {
			qualEntity.setMost_recent(qualDataPojo.getMost_recent());
		}
		if(qualDataPojo.getYear_standing() == null){
			qualEntity.setYear_standing(qualEntity.getYear_standing());
		} else {
			qualEntity.setYear_standing(qualDataPojo.getYear_standing());
		}
		qualrepo = new QualificationRepo();
		qualrepo.updateQualificationData(qualEntity);
		return qualEntity;
	}
	
	public void insertUniName(int id, UniversitiesDataPojo uniDataPojo){
		qualEntity = new Qualification();
		qualrepo = new QualificationRepo();
		uniEntity = new Universities();
		userpro = new UserProfileRepo();
		qualEntity = qualrepo.getQualificationData(id);
		List<Universities> uniList = new ArrayList<Universities>();
		uniList = userpro.SameUniName(uniDataPojo.getUni_name());
		if(uniList.size() != 0){
			for(Universities u : uniList){
				uniEntity = u;
			}
			qualEntity.getUniNameList().add(uniEntity);
			qualrepo = new QualificationRepo();
			qualrepo.updateQualificationData(qualEntity);
		} else {
			uniEntity.setUni_name(uniDataPojo.getUni_name());
			qualEntity.getUniNameList().add(uniEntity);
			qualrepo = new QualificationRepo();
			qualrepo.InsertUniNameData(qualEntity, uniEntity);
		}
	}
	
	public UniversitiesDataPojo getQualUniName(int id){
		qualrepo = new QualificationRepo();
		uniEntity = new Universities();
		qualEntity = new Qualification();
		uniDataPojo = new UniversitiesDataPojo();
		qualEntity = qualrepo.getQualificationData(id);
		int uni_id = 0;
		Collection<Universities> uniList = new ArrayList<Universities>();
		uniList = qualEntity.getUniNameList();
		for(Universities u : uniList){
			uni_id = u.getId();
		}
		qualrepo = new QualificationRepo();
		uniEntity = qualrepo.getUniData(uni_id);
		uniDataPojo.setId(uniEntity.getId());
		uniDataPojo.setUni_name(uniEntity.getUni_name());
		return uniDataPojo;
	}
	
	public Universities updateUniNameById( UniversitiesDataPojo uniDataPojo){
		uniEntity = new Universities();
		qualrepo = new QualificationRepo();
		uniEntity = qualrepo.getUniData(uniDataPojo.getId());
		uniEntity.setId(uniDataPojo.getId());
		if(uniDataPojo.getUni_name() == null){
			uniEntity.setUni_name(uniEntity.getUni_name());
		} else {
			uniEntity.setUni_name(uniDataPojo.getUni_name());
		}
		qualrepo = new QualificationRepo();
		qualrepo.updateUniData(uniEntity);
		return uniEntity;
	}
	
	public void insertCollegeName(int id, CollegesDataPojo collegeDataPojo){
		qualEntity = new Qualification();
		qualrepo = new QualificationRepo();
		collegeEntity = new Colleges();
		userpro = new UserProfileRepo();
		qualEntity = qualrepo.getQualificationData(id);
		List<Colleges> collegeList = new ArrayList<Colleges>();
		collegeList = userpro.SameCollegeName(collegeDataPojo.getCollege_name());
		if(collegeList.size() != 0){
			for(Colleges c : collegeList){
				collegeEntity = c;
			}
			qualEntity.getCollegeNameList().add(collegeEntity);
			qualrepo = new QualificationRepo();
			qualrepo.updateQualificationData(qualEntity);
		} else {
			collegeEntity.setCollege_name(collegeDataPojo.getCollege_name());
			qualEntity.getCollegeNameList().add(collegeEntity);
			qualrepo = new QualificationRepo();
			qualrepo.InsertCollegeNameData(qualEntity, collegeEntity);
		}
	}
	
	public CollegesDataPojo getQualCollegeName(int id){
		collegeEntity = new Colleges();
		qualEntity = new Qualification();
		collegeDataPojo = new CollegesDataPojo();
		qualrepo = new QualificationRepo();
		qualEntity = qualrepo.getQualificationData(id);
		int college_id = 0;
		Collection<Colleges> collegelist = new ArrayList<Colleges>();
		collegelist = qualEntity.getCollegeNameList();
		for(Colleges c : collegelist){
			college_id = c.getId();
		}
		qualrepo = new QualificationRepo();
		collegeEntity = qualrepo.getCollegeData(college_id);
		collegeDataPojo.setId(collegeEntity.getId());
		collegeDataPojo.setCollege_name(collegeEntity.getCollege_name());
		return collegeDataPojo;
	}
	
	public Colleges updateCollegeNameById(CollegesDataPojo collegeDataPojo){
		collegeEntity = new Colleges();
		qualrepo = new QualificationRepo();
		collegeEntity = qualrepo.getCollegeData(collegeDataPojo.getId());
		collegeEntity.setId(collegeDataPojo.getId());
		if(collegeDataPojo.getCollege_name() == null){
			collegeEntity.setCollege_name(collegeEntity.getCollege_name());
		} else {
			collegeEntity.setCollege_name(collegeDataPojo.getCollege_name());
		}
		qualrepo = new QualificationRepo();
		qualrepo.updateCollegeData(collegeEntity);
		return collegeEntity;
	}
	
	public void insertUniMajor(int id, MajorsDataPojo majorDataPojo) {
		qualEntity = new Qualification();
		qualrepo = new QualificationRepo();
		majorEntity = new Majors();
		userpro = new UserProfileRepo();
		qualEntity = qualrepo.getQualificationData(id);
		List<Majors> majorList = new ArrayList<Majors>();
		majorList = userpro.SameMajor(majorDataPojo.getName());
		if(majorList.size() != 0){
			for(Majors m : majorList){
				majorEntity = m;
			}
			qualEntity.getMajorList().add(majorEntity);
			qualrepo = new QualificationRepo();
			qualrepo.updateQualificationData(qualEntity);
		} else {
			majorEntity.setName(majorDataPojo.getName());
			qualEntity.getMajorList().add(majorEntity);
			qualrepo = new QualificationRepo();
			QualificationMajorPojo combinedPojo = new QualificationMajorPojo(qualEntity, majorEntity);
			qualrepo.InsertUniMajorData(combinedPojo);
		}	
	}
	
	public void insertUserUniMinor(int id, MinorsDataPojo minorDataPojo) {
		qualEntity = new Qualification();
		qualrepo = new QualificationRepo();
		minorEntity = new Minors();
		userpro = new UserProfileRepo();
		qualEntity = qualrepo.getQualificationData(id);
		List<Minors> minorList = new ArrayList<Minors>();
		minorList = userpro.SameMinor(minorDataPojo.getName());
		if(minorList.size() != 0){
			for(Minors m : minorList){
				minorEntity = m;
			}
			qualEntity.getMinorList().add(minorEntity);
			qualrepo = new QualificationRepo();
			qualrepo.updateQualificationData(qualEntity);
		} else {
			minorEntity.setName(minorDataPojo.getName());
			qualEntity.getMinorList().add(minorEntity);
			qualrepo = new QualificationRepo();
			QualificationMinorPojo combinedPojo = new QualificationMinorPojo(qualEntity, minorEntity);
			qualrepo.InsertUniMinorData(combinedPojo);
		}	
	}
	
	public MajorsDataPojo getMajorById(int id) {
		qualrepo = new QualificationRepo();
		majorEntity = new Majors();
		majordatapojo = new MajorsDataPojo();
		majorEntity = qualrepo.getMajorData(id);
		majordatapojo.setId(majorEntity.getId());
		majordatapojo.setName(majorEntity.getName());
		return majordatapojo;
	}
	
	public MinorsDataPojo getMinorById(int id) {
		qualrepo = new QualificationRepo();
		minorEntity = new Minors();
		minordatapojo = new MinorsDataPojo();
		minorEntity = qualrepo.getMinorData(id);
		minordatapojo.setName(minorEntity.getName());
		return minordatapojo;
	}
	
	public ResponseIntegerList getUniMajorlist(int id) {
		qualEntity = new Qualification();
		qualrepo = new QualificationRepo();
		majordatapojo = new MajorsDataPojo();
		int major_id = 0; 
		qualEntity = qualrepo.getQualificationData(id);
		Collection<Majors> majorList = new ArrayList<Majors>();
		List<Integer> idList = new ArrayList<Integer>();
		majorList = qualEntity.getMajorList();
		for (Majors obj : majorList) {
			major_id = obj.getId();
			idList.add(major_id);
		}
		ResponseIntegerList list = new ResponseIntegerList();
		list.setList(idList);
		return list;
	}
	
	public ResponseIntegerList getUniMinorlist(int id) {
		qualEntity = new Qualification();
		qualrepo = new QualificationRepo();
		minorEntity = new Minors();
		minordatapojo = new MinorsDataPojo();
		int minor_id = 0; 
		qualEntity = qualrepo.getQualificationData(id);
		Collection<Majors> majorList = new ArrayList<Majors>();
		List<Integer> idList = new ArrayList<Integer>();
		majorList = qualEntity.getMajorList();
		for (Majors obj : majorList) {
			minor_id = obj.getId();
			idList.add(minor_id);
		}
		ResponseIntegerList list = new ResponseIntegerList();
		list.setList(idList);
		return list;
	}
	
	public QualificationDataPojo getUniByMajorId(int id){
		int uni_id = 0;
		qualrepo = new QualificationRepo();
		majorEntity = new Majors();
		majorEntity = qualrepo.getMajorData(id);
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		uniList = majorEntity.getQualificationList();
		for(Qualification u : uniList){
			uni_id = u.getId();
		}
		qualDataPojo = new QualificationDataPojo();
		qualDataPojo = getUniversityById(uni_id);
		return qualDataPojo;
	}
	
	public QualificationDataPojo getUniByMinorId(int id){
		int uni_id = 0;
		qualrepo = new QualificationRepo();
		minorEntity = new Minors();
		minorEntity = qualrepo.getMinorData(id);
		Collection<Qualification> uniList = new ArrayList<Qualification>();
		uniList = minorEntity.getQualificationList();
		for(Qualification u : uniList){
			uni_id = u.getId();
		}
		qualDataPojo = new QualificationDataPojo();
		qualDataPojo = getUniversityById(uni_id);
		return qualDataPojo;
	}
	
	public Majors updateMajorById(MajorsDataPojo majordatapojo){
		qualEntity = new Qualification();
		qualrepo = new QualificationRepo();
		majorEntity = new Majors();
		majorEntity = qualrepo.getMajorData(majordatapojo.getId());
		majorEntity.setId(majordatapojo.getId());
		if(majordatapojo.getName() == null){
			majorEntity.setName(majorEntity.getName());
		} else {
			majorEntity.setName(majordatapojo.getName());
		}
		qualrepo = new QualificationRepo();
		qualrepo.updateMajorData(majorEntity);
		return majorEntity;
	}
	
	public Minors updateMinorsById(MinorsDataPojo minordatapojo){
		qualrepo = new QualificationRepo();
		minorEntity = new Minors();
		minorEntity = qualrepo.getMinorData(minordatapojo.getId());
		minorEntity.setId(minordatapojo.getId());
		if(minordatapojo.getName() == null){
			minorEntity.setName(minorEntity.getName());
		} else {
			minorEntity.setName(minordatapojo.getName());
		}
		qualrepo = new QualificationRepo();
		qualrepo.updateMinorData(minorEntity);
		return minorEntity;
	}
	
	public Transfer insertTransferUni(int id, TransferDataPojo transferDataPojo) {
		transferEntity = new Transfer();
		qualEntity = new Qualification();
		qualrepo = new QualificationRepo();
		qualEntity = qualrepo.getQualificationData(id);
		transferEntity.setYear_started(transferDataPojo.getYear_started());
		transferEntity.setYear_transfered(transferDataPojo.getYear_transfered());
		transferEntity.setQualifications_earned(transferDataPojo.getQualifications_earned());
		qualEntity.getTransferList().add(transferEntity);
		qualrepo = new QualificationRepo();
		qualrepo.InsertTransferUser(transferEntity, qualEntity);
		return transferEntity;
	}
	
	public TransferDataPojo getTransferById(int id) {
		qualrepo = new QualificationRepo();
		transferEntity = new Transfer();
		transferdatapojo = new TransferDataPojo();
		transferEntity = qualrepo.getTransferData(id);
		transferdatapojo.setId(transferEntity.getId());
		transferdatapojo.setYear_started(transferEntity.getYear_started());
		transferdatapojo.setYear_transfered(transferEntity.getYear_transfered());
		transferdatapojo.setQualifications_earned(transferEntity.getQualifications_earned());
		return transferdatapojo;
	}
	
	public ResponseIntegerList getTransferUnilist(int id){
		qualrepo = new QualificationRepo();
		transferEntity = new Transfer();
		qualEntity = new Qualification();
		transferdatapojo = new TransferDataPojo();
		qualEntity = qualrepo.getQualificationData(id);
		int transfer_id = 0;
		Collection<Transfer> transferList = new ArrayList<Transfer>();
		List<Integer> idList = new ArrayList<Integer>();
		transferList = qualEntity.getTransferList();
		for (Transfer obj : transferList) {
			transfer_id = obj.getId();
			idList.add(transfer_id);
		}
		ResponseIntegerList list = new ResponseIntegerList();
		list.setList(idList);
		return list;
	}
	
	public Transfer updateTransferById(TransferDataPojo transferdatapojo){
		transferEntity = new Transfer();
		qualrepo = new QualificationRepo();
		transferEntity = qualrepo.getTransferData(transferdatapojo.getId());
		transferEntity.setId(transferdatapojo.getId());
		if(transferdatapojo.getYear_started() == null){
			transferEntity.setYear_started(transferEntity.getYear_started());
		} else {
			transferEntity.setYear_started(transferdatapojo.getYear_started());
		}	
		if(transferdatapojo.getYear_transfered() == null){
			transferEntity.setYear_transfered(transferEntity.getYear_transfered());
		} else {
			transferEntity.setYear_transfered(transferdatapojo.getYear_transfered());
		}	
		if(transferdatapojo.getQualifications_earned() == null){
			transferEntity.setQualifications_earned(transferEntity.getQualifications_earned());
		} else {
			transferEntity.setQualifications_earned(transferdatapojo.getQualifications_earned());
		}	
		qualrepo = new QualificationRepo();
		qualrepo.updateTransfer(transferEntity);
		return transferEntity;
	}
	
}
