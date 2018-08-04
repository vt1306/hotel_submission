package Model;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Cmfoodchain {
	private Branch branch;

	public Branch getBranch() {
		return this.branch;
	}

	public void setBranch(Branch branch) {
		this.branch = branch;
	}

	private Orders orders;

	public Orders getOrders() {
		return this.orders;
	}

	public void setOrders(Orders orders) {
		this.orders = orders;
	}
	
	@Override
	public String toString(){
		StringBuilder sb = new StringBuilder();
		sb.append("***** CMP  Details *****\n");
		sb.append("Branch="+getBranch()+"\n");
		sb.append("Orers="+getOrders()+"\n");
		sb.append("*****************************");
		
		return sb.toString();
	}
}
