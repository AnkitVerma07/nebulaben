
package careers.nebula.ben.service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author Ankit_Nebula
 */
public class CSVServicing {
    //this class will read a csv file and store the content in a data structure and return it.  
     
     
    public String[] csvReader(String fileName) throws FileNotFoundException, IOException{
	BufferedReader br = null;
	String line = "";
        String[] k = null;
	try {
		br = new BufferedReader(new FileReader(fileName));
		while ((line = br.readLine()) != null) {
			k = line.split(",");
                        
		}
    }catch(FileNotFoundException e){
        
    }
        return k;
    }
    
}
