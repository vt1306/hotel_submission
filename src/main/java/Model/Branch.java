
package Model;

import java.io.Serializable;

public class Branch implements Serializable {

	String location;
	Double totalcollection;
	Double sumOrder;
	String locationid;

	public Branch(String location, Double totalcollection, Double sumOrder, String locationid) {
		this.location = location;
		this.totalcollection = totalcollection;
		this.sumOrder = sumOrder;
		this.locationid = locationid;
	}
	public Branch() {};
	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public Double getTotalcollection() {
		return totalcollection;
	}

	public void setTotalcollection(Double totalcollection) {
		this.totalcollection = totalcollection;
	}

	public Double getSumOrder() {
		return sumOrder;
	}

	public void setSumOrder(Double sumOrder) {
		this.sumOrder = sumOrder;
	}

	public String getLocationid() {
		return locationid;
	}

	public void setLocationid(String locationid) {
		this.locationid = locationid;
	}

}