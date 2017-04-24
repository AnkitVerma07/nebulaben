/**
 * 
 */
package careers.nebula.ben.information;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;

import org.apache.pdfbox.cos.COSDocument;
import org.apache.pdfbox.io.RandomAccessFile;
import org.apache.pdfbox.pdfparser.PDFParser;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.extractor.WordExtractor;
import org.apache.poi.xwpf.usermodel.XWPFDocument;
import org.apache.poi.xwpf.usermodel.XWPFParagraph;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;

import careers.nebula.ben.db.enitity.Resume;
import careers.nebula.ben.db.enitity.Transcript;
import careers.nebula.ben.pojos.StringArrayPojo;

/**
 * @author Ankit_Nebula
 *
 */
public class DocumentInformation {

	private String uploadFolder = "/Users/pinky/Documents/Nebula_Documents/Files/";
	private String uploadResume = "/Users/pinky/Documents/Nebula_Documents/Resumes/";
	private String uploadTranscript = "/Users/medlclouddev/Documents/Nebula_Documents/Transcript/";
	private String filename = null;
	private PDFParser parser;
	private PDFTextStripper pdfStripper;
	private PDDocument pdDoc ;
	private COSDocument cosDoc;
	private ResumeInformation resumeInfo;          
	private Resume resumeEntity;
	private TranscriptInformation tranInfo;
	private Transcript tranEntity;
	
	public String writeToFile(int id, InputStream uploadedInputStream,  FormDataContentDisposition fileDetail) {
		filename = id+"_"+fileDetail.getFileName();
	    String uploadedFileLocation = uploadFolder + filename;
	    try {
	        OutputStream out = new FileOutputStream(new File(uploadedFileLocation));
	        int read = 0;
	        byte[] bytes = new byte[1024];
	        out = new FileOutputStream(new File(uploadedFileLocation));
	        while ((read = uploadedInputStream.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        out.flush();
	        out.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
		return uploadedFileLocation;
	   }
	
	public Resume writeResumeToDisk(int id, InputStream uploadedInputStream,  FormDataContentDisposition fileDetail) throws IOException {
		filename = id+"_"+fileDetail.getFileName();
	    String uploadedFileLocation = uploadResume  + filename;
	    try {
	        OutputStream out = new FileOutputStream(new File(uploadedFileLocation)); 
	        int read = 0;
	        byte[] bytes = new byte[1024];
	        out = new FileOutputStream(new File(uploadedFileLocation));
	        while ((read = uploadedInputStream.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        out.flush();
	        out.close();
	    } catch (IOException e) {
	        e.printStackTrace();
	    }
	    resumeEntity = new Resume();
	    resumeInfo = new ResumeInformation();
	    resumeEntity = resumeInfo.InsertResumeUserInfo(id, uploadedFileLocation);
		return resumeEntity;
	   }
	
	public Transcript writeTranscriptToDisk(int id, InputStream uploadedInputStream,  FormDataContentDisposition fileDetail) throws IOException {	
		filename = id+"_"+fileDetail.getFileName();
	    String uploadedFileLocation = uploadTranscript + filename;
	    try {
	        OutputStream out = new FileOutputStream(new File(uploadedFileLocation)); 
	        int read = 0;
	        byte[] bytes = new byte[1024];
	        out = new FileOutputStream(new File(uploadedFileLocation));
	        while ((read = uploadedInputStream.read(bytes)) != -1) {
	            out.write(bytes, 0, read);
	        }
	        out.flush();
	        out.close();
	    } catch (IOException e) {

	        e.printStackTrace();
	    }
	    tranEntity = new Transcript();
	    tranInfo = new TranscriptInformation();
	    tranEntity = tranInfo.InsertTranscriptUserInfo(id, uploadedFileLocation);
		return tranEntity;
	   }
	
	public StringArrayPojo FileType(String fileName) throws IOException{
		
		String fileType = fileName.substring(fileName.lastIndexOf(".")+ 1);
		if(fileType.equals("docx")){
			return readDocxFile(fileName); 
		} else if(fileType.equals("doc")){
			return readDocFile(fileName);
		} else if(fileType.equals("pdf")){
			return readPdfFile(fileName);
		}
		return null; 
	}
	
	 public StringArrayPojo readDocxFile(String fileName) {
         List<XWPFParagraph> paragraphs = null;
         StringArrayPojo stringPojo = new StringArrayPojo();
         String temp = "";
	try {
		File file = new File(fileName);
		FileInputStream fis = new FileInputStream(file.getAbsolutePath());

		XWPFDocument document = new XWPFDocument(fis);
		paragraphs = document.getParagraphs();
		for (XWPFParagraph para : paragraphs) {
			temp = temp+para.getText();
			
		}
		String[] paras = new String[paragraphs.size()];
		for( int i =0; i < paragraphs.size(); i++){
			String s = paragraphs.get(i).getText();
			paras[i] = s;
		}
		
		stringPojo.setA(paras);
		stringPojo.setS(temp);
		fis.close();
	} catch (Exception e) {
		e.printStackTrace();
	}
	
	return stringPojo;
	//return paras;
         //return temp;
}
	 
	 public StringArrayPojo readDocFile(String fileName) {
		 String temp = "";
		 String[] paragraphs = null;
			try {
				File file = new File(fileName);
				FileInputStream fis = new FileInputStream(file.getAbsolutePath());

				HWPFDocument doc = new HWPFDocument(fis);

				WordExtractor we = new WordExtractor(doc);

				paragraphs = we.getParagraphText();
				for (String para : paragraphs) {
					temp = temp+para;
				}
				fis.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			StringArrayPojo stringPojo = new StringArrayPojo();
			stringPojo.setA(paragraphs);
			stringPojo.setS(temp);
			return stringPojo;
			//return paragraphs;
			//return temp;

		}
	 
	 public StringArrayPojo readPdfFile(String fileName) throws IOException
	   {
	       this.pdfStripper = null;
	       this.pdDoc = null;
	       this.cosDoc = null;
	       
	       File file = new File(fileName);
	       parser = new PDFParser(new RandomAccessFile(file,"r"));
	       
	       parser.parse();
	       cosDoc = parser.getDocument();
	       pdfStripper = new PDFTextStripper();
	       pdDoc = new PDDocument(cosDoc);
	       pdDoc.getNumberOfPages();
	       pdfStripper.setStartPage(1);
	       pdfStripper.setEndPage(10);
  //TODO find a way to send back paragraphs from pdf files also..
	       // reading text from page 1 to 10
	       // if you want to get text from full pdf file use this code
	       // pdfStripper.setEndPage(pdDoc.getNumberOfPages());
	       String text = "";
	       text = pdfStripper.getText(pdDoc);
	       //System.out.println(text);
	       String[] paras = null;
	   	StringArrayPojo stringPojo = new StringArrayPojo();
		stringPojo.setA(paras);
		stringPojo.setS(text);
		return stringPojo;
	      // return text;
	   }
}
