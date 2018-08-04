package Model;

public class Orderdetail {
	private int orderid;

	public int getOrderid() {
		return this.orderid;
	}

	public void setOrderid(int orderid) {
		this.orderid = orderid;
	}

	private String billamount;

	public String getBillamount() {
		return this.billamount;
	}

	public void setBillamount(String billamount) {
		this.billamount = billamount;
	}
	@Override
	public String toString(){
		return getOrderid() + ", "+getBillamount();
	}

}
