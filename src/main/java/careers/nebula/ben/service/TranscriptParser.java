/**
 * 
 */
package careers.nebula.ben.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import careers.nebula.ben.db.enitity.Keywords;
import careers.nebula.ben.db.repository.UserProfileRepo;
import careers.nebula.ben.information.DocumentInformation;
import careers.nebula.ben.pojos.StringArrayPojo;

/**
 * @author Ankit_Nebula
 *
 */
public class TranscriptParser {

	private DocumentInformation docuInfo;
	private CSVServicing key;
	private UserProfileRepo userpro;
	private String SCHOOLS_CSV = "/Users/pinky/Documents/Nebula_Documents/Files/schools.csv";
	private String COURSES_CSV = "/Users/pinky/Documents/Nebula_Documents/Files/courses.csv";
	 
	 public String userUniName(String fileName) throws IOException{
		 String search = null;
	     List<String> foundUniName = new ArrayList<>();
	     docuInfo = new DocumentInformation();
	     StringArrayPojo sa =  docuInfo.FileType(fileName);
	     String para = sa.getS();
	     userpro = new UserProfileRepo();
	     List<Keywords> keywordsData = new ArrayList<Keywords>();
	     keywordsData = userpro.getAllKeywordsData();
	     key = new CSVServicing();
	   String[] searchKeyword = key.csvReader(SCHOOLS_CSV);
	   for(int i =0; i<searchKeyword.length; i++){
	   search = searchKeyword[i];
	   int intIndex = para.indexOf(search);
	      if(intIndex != - 1){
	    	  foundUniName.add(search);
	      }else{
	    	   for(Keywords k : keywordsData){
	    		   if(para.contains(k.getName())){
	    			   foundUniName.add(k.getName());
	    		   }
	    	   }
	      }
	   }
	   String temp = " ";
	     for(String s : foundUniName){
	    	 temp = temp+s+",";
	     }
		 return temp;
	}
	 
	 public Integer userFirstYear(String fileName) throws IOException{
		 docuInfo = new DocumentInformation();
		 List<Integer> foundList = new ArrayList<Integer>();
	     StringArrayPojo sa =  docuInfo.FileType(fileName);
	     String para = sa.getS();
	     Pattern p = Pattern.compile("-?\\d+");
    	 Matcher m = p.matcher(para);
    	 while (m.find()) {
    		 String number = m.group();
    		 Integer year = Integer.valueOf(number);
    		 if(year <= 3000 && year >= 1500){
    			 foundList.add(year);
    		 }
    	 
    	 }
    	 int size = foundList.size();
         for (int i = 0; i < size - 1; i++) {
             for (int j = i + 1; j < size; j++) {
                 if (!foundList.get(j).equals(foundList.get(i)))
                     continue;
                 foundList.remove(j);
                 j--; 
                 size--;
             } 
         }
         Integer earliestYear = null;
         for (int i = 0; i < size - 1; i++) {
        	 earliestYear = foundList.get(0);
         }
	     return earliestYear;
	 }
	 
	 public Integer userLastYear(String fileName) throws IOException{
		 docuInfo = new DocumentInformation();
		 List<Integer> foundList = new ArrayList<Integer>();
	     StringArrayPojo sa =  docuInfo.FileType(fileName);
	     String para = sa.getS();
	     Pattern p = Pattern.compile("-?\\d+");
    	 Matcher m = p.matcher(para);
    	 while (m.find()) {
    		 String number = m.group();
    		 Integer year = Integer.valueOf(number);
    		 if(year <= 3000 && year >= 1500){
    			 foundList.add(year);
    		 }
    	 }
    	 int size = foundList.size();
         for (int i = 0; i < size - 1; i++) {
             for (int j = i + 1; j < size; j++) {
                 if (!foundList.get(j).equals(foundList.get(i)))
                     continue;
                 foundList.remove(j);
                 j--; 
                 size--;
             } 
         }
         Integer lastYear = null;
         for(int i : foundList){
        	 lastYear = i;
         }
	     return lastYear;
	 }
	 
	 public Double userGpa(String fileName) throws IOException{
		 docuInfo = new DocumentInformation();
	     StringArrayPojo sa =  docuInfo.FileType(fileName);
	     String para = sa.getS();
	     int i = para.lastIndexOf("GPA");
	     String gpa = para.substring(i+5, i+10);
	     Double result = null;
	     result = null;
	     result = Double.valueOf(gpa);
		 return result;
	 }
	 
	 public Double userUnitsAttempted(String fileName) throws IOException{
		 docuInfo = new DocumentInformation();
	     StringArrayPojo sa =  docuInfo.FileType(fileName);
	     String para = sa.getS();
	     int i = para.lastIndexOf("UNITS ATTEMPTED");
	     String units = para.substring(i+16, i+22);
	     Double result = null;
	     result = Double.valueOf(units);
		 return result;
	 }
	 
	 public Double userUnitsPassed(String fileName) throws IOException{
		 docuInfo = new DocumentInformation();
	     StringArrayPojo sa =  docuInfo.FileType(fileName);
	     String para = sa.getS();
	     int i = para.lastIndexOf("UNITS PASSED");
	     String units = para.substring(i+16, i+20);
	     Double result = null;
	     result = Double.valueOf(units);
		 return result;
	 }
	 
	 public Double userUnitsCompleted(String fileName) throws IOException{
		 docuInfo = new DocumentInformation();
	     StringArrayPojo sa =  docuInfo.FileType(fileName);
	     String para = sa.getS();
	     int i = para.lastIndexOf("UNITS COMPLETED");
	     String units = para.substring(i+17, i+22);
	     Double result = null;
	     result = Double.valueOf(units);
		 return result;
	 }

	 public Integer userIncompleteGrades(String fileName) throws IOException{
		 docuInfo = new DocumentInformation();
	     StringArrayPojo sa =  docuInfo.FileType(fileName);
	     String para = sa.getS();
	     int i = para.lastIndexOf("INCOMPLETE GRADES");
	     String units = para.substring(i+19, i+20);
	     Integer result = Integer.valueOf(units);
		 return result;
	 }
	 
	 public Integer userNRgrades(String fileName) throws IOException{
		 docuInfo = new DocumentInformation();
	     StringArrayPojo sa =  docuInfo.FileType(fileName);
	     String para = sa.getS();
	     int i = para.lastIndexOf("NR GRADES");
	     String units = para.substring(i+11, i+12);
	     Integer result = Integer.valueOf(units);
		 return result;
	 }
	 
	 public Integer userPNPgrades(String fileName) throws IOException{
		 docuInfo = new DocumentInformation();
	     StringArrayPojo sa =  docuInfo.FileType(fileName);
	     String para = sa.getS();
	     int i = para.lastIndexOf("P/NP GRADES");
	     String units = para.substring(i+13, i+14);
	     Integer result = Integer.valueOf(units);
		 return result;
	 }
	 
	 public Integer userSUgrades(String fileName) throws IOException{
		 docuInfo = new DocumentInformation();
	     StringArrayPojo sa =  docuInfo.FileType(fileName);
	     String para = sa.getS();
	     int i = para.lastIndexOf("S/U GRADES");
	     String units = para.substring(i+12, i+13);
	     Integer result = Integer.valueOf(units);
		 return result;
	 }
	 
	 public Integer userWgrades(String fileName) throws IOException{
		 docuInfo = new DocumentInformation();
	     StringArrayPojo sa =  docuInfo.FileType(fileName);
	     String para = sa.getS();
	     int i = para.lastIndexOf("W GRADES");
	     String units = para.substring(i+10, i+11);
	     System.out.println(units);
	     Integer result = Integer.valueOf(units);
		 return result;
	 }
	 
	 public Integer userFailedCourses(String fileName) throws IOException{
		 docuInfo = new DocumentInformation();
	     StringArrayPojo sa =  docuInfo.FileType(fileName);
	     String para = sa.getS();
	     int count = 0;
	     List<String> foundList = new ArrayList<String>();
	        String[] split = para.split("\\s+");
	        for(int j =0; j <= split.length-1; j++){
	            Pattern pattern = Pattern.compile("[A+|A|A-|B+|B|B-|C+|C|C-|D+|D|D-|F|P|NP]");
	            Matcher matcher = pattern.matcher(split[j]);
	                if(matcher.matches()){
	                	foundList.add(split[j]);
	           }
	      }  
	      for(String s : foundList){
	    	  if(s.equals("F")){
	    		  count++;
	    	  }
	      }
		 return count;
	 }
	 
	 public Integer userAccedCourses(String fileName) throws IOException{
		 docuInfo = new DocumentInformation();
	     StringArrayPojo sa =  docuInfo.FileType(fileName);
	     String para = sa.getS();
	     int count = 0;
	     List<String> foundList = new ArrayList<String>();
	        String[] split = para.split("\\s+");
	        for(int j =0; j <= split.length-1; j++){
	            Pattern pattern = Pattern.compile("[A+|A|A-|B+|B|B-|C+|C|C-|D+|D|D-|F|P|NP]");
	            Matcher matcher = pattern.matcher(split[j]);
	                if(matcher.matches()){
	                	foundList.add(split[j]);
	           }
	      }  
	      for(String s : foundList){
	    	  if(s.equals("A")){
	    		  count++;
	    	  }
	      }
		 return count;
	 }
	 
	 public String userGrades(String fileName) throws IOException{
		 docuInfo = new DocumentInformation();
	     StringArrayPojo sa =  docuInfo.FileType(fileName);
	     String para = sa.getS();
	     List<String> foundList = new ArrayList<String>();
	        String[] split = para.split("\\s+");
	        for(int j =0; j <= split.length-1; j++){
	            Pattern pattern = Pattern.compile("[A+|A|A-|B+|B|B-|C+|C|C-|D+|D|D-|F|P|NP]");
	            Matcher matcher = pattern.matcher(split[j]);
	                if(matcher.matches()){
	                	foundList.add(split[j]);
	           }
	      } 
	     String temp = " ";
	     for(String s : foundList){
	    	 temp = temp+s+",";
	     }
		 return temp;
	 }
	 
	 public String userCoursesMatched(String fileName) throws IOException{
	     String search = null;
	     List<Integer> indexes = new ArrayList<>();
	     docuInfo = new DocumentInformation();
	     StringArrayPojo sa =  docuInfo.FileType(fileName);
	     String para = sa.getS();
	     String paratemp = "";
	     key = new CSVServicing();
	   String[] searchKeyword = key.csvReader(COURSES_CSV);
	   for(int i =0; i<searchKeyword.length; i++){
	   search = searchKeyword[i];
	   Pattern p = Pattern.compile(search);
	   Matcher m = p.matcher(para);
	   while(m.find()){
		   int index = para.indexOf(search);
		   while (index >= 0) {
		       indexes.add(index);
		       index = para.indexOf(search, index + 1);
		   }
	   }
	   Collections.sort(indexes);
	 }
	   int size = indexes.size();
	     for (int i = 0; i < size - 1; i++) {
	         for (int j = i + 1; j < size; j++) {
	             if (!indexes.get(j).equals(indexes.get(i)))
	                 continue;
	             indexes.remove(j);
	             j--; 
	             size--;
	         } 
	     }   
	     String temp = " ";
	     for(int i : indexes){
	    	 paratemp = para.substring(i, i+30);
	    	 for(String s : searchKeyword){
	    		 if(paratemp.contains(s)){
	    			 temp = temp+s+",";
	    		 }    		 
	    	 }	 
	     }
		 return temp;
	 }
}
