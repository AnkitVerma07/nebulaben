/**
 * 
 */
package careers.nebula.ben.pojos;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Ankit_Nebula
 *
 */
@XmlRootElement
public class ResponseIntegerList {

    private List<Integer> list;

    public ResponseIntegerList(){
    	
    }
    public ResponseIntegerList(List<Integer> list){
    	this.list = list;
    }
	public List<Integer> getList() {
		return list;
	}

	public void setList(List<Integer> list) {
		this.list = list;
	}
    
    

}
