/**
 * 
 */
package careers.nebula.ben.pojos;

import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import careers.nebula.ben.db.enitity.Jobs;

/**
 * @author medlclouddev
 *
 */
@XmlRootElement
public class RespondJobsCombinedList {

	private List<Jobs> listone;
	private List<Jobs> listtwo;
	private List<Jobs> listthree;
	private List<Jobs> listfour;
	private Integer int1;
	private Integer int2;
	private Integer int3;
	private Integer int4;
	private Double double1;
	private Double double2;
	private Double double3;
	private Double double4;
	
	public RespondJobsCombinedList(){
		
	}
	public RespondJobsCombinedList(List<Jobs> listone, List<Jobs> listtwo, List<Jobs> listthree, List<Jobs> listfour, Integer int1, Integer int2, Integer int3, Integer int4, Double double1, Double double2, Double double3, Double double4){
		this.double1 = double1;
		this.double2 = double2;
		this.double3 = double3;
		this.double4 = double4;
		this.int1 = int1; 
		this.int2 = int2;
		this.int3 = int3;
		this.int4 = int4;
		this.listone = listone;
		this.listtwo = listtwo;
		this.listthree = listthree;
		this.listfour = listfour;
	}
	public List<Jobs> getListone() {
		return listone;
	}
	public void setListone(List<Jobs> listone) {
		this.listone = listone;
	}
	public List<Jobs> getListtwo() {
		return listtwo;
	}
	public void setListtwo(List<Jobs> listtwo) {
		this.listtwo = listtwo;
	}
	public List<Jobs> getListthree() {
		return listthree;
	}
	public void setListthree(List<Jobs> listthree) {
		this.listthree = listthree;
	}
	public List<Jobs> getListfour() {
		return listfour;
	}
	public void setListfour(List<Jobs> listfour) {
		this.listfour = listfour;
	}
	public Integer getInt1() {
		return int1;
	}
	public void setInt1(Integer int1) {
		this.int1 = int1;
	}
	public Integer getInt2() {
		return int2;
	}
	public void setInt2(Integer int2) {
		this.int2 = int2;
	}
	public Integer getInt3() {
		return int3;
	}
	public void setInt3(Integer int3) {
		this.int3 = int3;
	}
	public Integer getInt4() {
		return int4;
	}
	public void setInt4(Integer int4) {
		this.int4 = int4;
	}
	public Double getDouble1() {
		return double1;
	}
	public void setDouble1(Double double1) {
		this.double1 = double1;
	}
	public Double getDouble2() {
		return double2;
	}
	public void setDouble2(Double double2) {
		this.double2 = double2;
	}
	public Double getDouble3() {
		return double3;
	}
	public void setDouble3(Double double3) {
		this.double3 = double3;
	}
	public Double getDouble4() {
		return double4;
	}
	public void setDouble4(Double double4) {
		this.double4 = double4;
	}
	
	
}
