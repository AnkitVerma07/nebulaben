/**
 * 
 */
package careers.nebula.ben.testing;

import java.io.IOException;

import careers.nebula.ben.db.enitity.Resume;
import careers.nebula.ben.db.enitity.Transcript;
import careers.nebula.ben.information.DocumentInformation;
import careers.nebula.ben.information.ResumeInformation;
import careers.nebula.ben.information.TranscriptInformation;
import careers.nebula.ben.service.ResumeParser;
import careers.nebula.ben.service.TranscriptParser;

/**
 * @author Ankit_Nebula
 *
 */
public class DocumentTesting {

	private static String filepath = "C://Users/Ankit_Nebula/Documents/Nebula_Documents/Resumes/";
	private static String fileName = filepath + "test.docx";
	private static DocumentInformation docInfo;
	private static ResumeParser resumeparser;
	private static ResumeInformation reinfo;
	private static Resume reEntity;
	private static TranscriptInformation traninfo;
	private static TranscriptParser tranparser;
	private static Transcript tranEntity;
	
	public static void main(String[] args) throws IOException {
//		tranparser = new TranscriptParser();
//		tranEntity = new Transcript();
//		String temp = tranparser.userUniName(fileName);
		
		resumeparser = new ResumeParser();
		String temp = resumeparser.userKeywordsNotMatched(fileName);
		System.out.println(temp);
	}
	
}
