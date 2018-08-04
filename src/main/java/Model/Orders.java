package Model;

import java.util.ArrayList;
import java.util.Arrays;

public class Orders {
	private ArrayList<Orderdetail> orderdetail;

	public ArrayList<Orderdetail> getOrderdetail() {
		return this.orderdetail;
	}

	public void setOrderdetail(ArrayList<Orderdetail> orderdetail) {
		this.orderdetail = orderdetail;
	}
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("***** Order Details *****\n");
		sb.append("OrderDetail="+Arrays.toString(getOrderdetail().toArray())+"\n");
		sb.append("*****************************");
		
		return sb.toString();
	}
	
}
