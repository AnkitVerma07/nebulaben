/**
 * 
 */
package careers.nebula.ben.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Ankit_Nebula
 *
 */
public class HelperMethods {

    public <T> List<T> union(List<T> list1, List<T> list2) {
        Set<T> set = new HashSet<T>();
        set.addAll(list1);
        set.addAll(list2);
        return new ArrayList<T>(set);
    }

    public <T> List<T> intersection(List<T> list1, List<T> list2) {
        List<T> list = new ArrayList<T>();
        for (T t : list1) {
            if(list2.contains(t)) {
                list.add(t);
            }
        }
        return list;
    }
    
    public List<String> removeDuplicates(List<String> list) {

	// Store unique items in result.
	List<String> result = new ArrayList<>();

	// Record encountered Strings in HashSet.
	HashSet<String> set = new HashSet<>();

	// Loop over argument list.
	for (String item : list) {

	    // If String is not in set, add it to the list and the set.
	    if (!set.contains(item)) {
		result.add(item);
		set.add(item);
	    }
	}
	return result;
    }
    
    public Integer yearCalculator(String dob){
    	//parse dob from 10/21/1992 format to days month and year
    	String[] splitted = dob.split("/");
    	String year = splitted[2];
    	return Integer.parseInt(year);
    }
    
    public Integer ageCalculator(String dob){
    	//parse dob from 10/21/1992 format to days month and year
    	String[] splitted = dob.split("/");
    	String year = splitted[2];
    	String month = splitted[0];
    	String day = splitted[1];
    	LocalDate today = LocalDate.now();
    	LocalDate birthday = LocalDate.of(Integer.parseInt(year), Integer.parseInt(month), Integer.parseInt(day));
    	Period p = Period.between(birthday, today);
    	int temp = p.getYears();
    	return temp;   	
    }
    
    public Double timeSpentCalculator(String start, String end){
    	//parse dob from 10/21/1992 format to days month and year
    	String[] splitted = start.split("/");
    	String yearS = splitted[2];
    	String monthS = splitted[0];
    	String dayS = splitted[1];
    	String[] splittedE = end.split("/");
    	String yearE = splittedE[2];
    	String monthE = splittedE[0];
    	String dayE = splittedE[1];
    	LocalDate endDate = LocalDate.of(Integer.parseInt(yearE), Integer.parseInt(monthE), Integer.parseInt(dayE));
    	LocalDate startDate = LocalDate.of(Integer.parseInt(yearS), Integer.parseInt(monthS), Integer.parseInt(dayS));
    	Period p = Period.between(startDate, endDate);
    	int years = p.getYears();
    	double months = (double)p.getMonths()/12;
    	double temp = years+months;
    	return temp;   	
    }
}
