/**
 * 
 */
package careers.nebula.ben.pojos;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.TestResult;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class TwoTestResultDataPojo {

	private TestResult test1;
	private TestResult test2;
	
	public TwoTestResultDataPojo(){
		
	}
	public TwoTestResultDataPojo(TestResult test1, TestResult test2){
		this.test1 = test1;
		this.test2 = test2;
	}
	public TestResult getTest1() {
		return test1;
	}
	public void setTest1(TestResult test1) {
		this.test1 = test1;
	}
	public TestResult getTest2() {
		return test2;
	}
	public void setTest2(TestResult test2) {
		this.test2 = test2;
	}
	
	
}
