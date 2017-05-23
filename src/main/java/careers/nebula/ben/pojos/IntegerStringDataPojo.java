/**
 * 
 */
package careers.nebula.ben.pojos;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ankit Verma
 *
 */
@XmlRootElement
public class IntegerStringDataPojo {
		
		private Integer i;
		private String s;
		
		public IntegerStringDataPojo() {
			
		}
		
		public IntegerStringDataPojo(int i, String s) {
			this.i = i;
			this.s = s;
		}

		public Integer getI() {
			return i;
		}

		public void setI(Integer i) {
			this.i = i;
		}

		public String getS() {
			return s;
		}

		public void setS(String s) {
			this.s = s;
		}

		
		
		
		
}
